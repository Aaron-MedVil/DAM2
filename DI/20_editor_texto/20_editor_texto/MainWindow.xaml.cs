using Microsoft.Win32;
using System;
using System.Diagnostics;
using System.IO;
using System.Windows;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;

namespace _20_editor_texto {

    public partial class MainWindow : Window {

        Colors c = new Colors();
        BrushConverter bc = new BrushConverter();
        private string theme = "light";
        private string? nomDocumento;

        public MainWindow() {

            InitializeComponent();
            fillMenuComboBox();
            setTheme();

            // Asigna un evento cuando se pulsa una tecla
            this.PreviewKeyDown += new KeyEventHandler(HandleEsc);
        }

        // Rellena la informacion de lo ComboBox del menu
        private void fillMenuComboBox() {

            // Habilita el corrector ortografico
            cajaTexto.SpellCheck.IsEnabled = true;

            // Rellena el ComboBox del tamaño de letra
            for (int i = 4; i < 72; i = i + 4) { cbFontSize.Items.Add(i); }
            cbFontSize.Text = "20";
            cambiarPropiedadesTexto();
        }

        // Funcion para poner la ventana en FullScreen
        private void pantallaCompleta(object sender, RoutedEventArgs e) {

            // Cambia el texto del MenuItem de cambiar a pantalla completa
            miFullScreen.Header = (WindowStyle.ToString() != "None") ? "Salir de pantalla completa" : "Pantalla completa";

            // Si la ventana esta en pantalla completa lo pone en ventana con marcos y viceversa
            WindowStyle = (WindowStyle.ToString() != "None") ? WindowStyle.None : WindowStyle.SingleBorderWindow;
            Hide(); Show();
        }

        // Cambia las propiedades del texto
        private void cambiarPropiedadesTexto() {
            cajaTexto.FontSize = (int)cbFontSize.SelectedItem;
            cajaTexto.FontFamily = new FontFamily("Comic Sans MS");
        }

        // Funcion para cerrar la aplicacion con el boton escape
        private void HandleEsc(object sender, KeyEventArgs e) { if (e.Key == Key.Escape) { Close(); } }

        // Ejecuta un documento que seleccionemos
        private void ejecutarAyuda(object sender, RoutedEventArgs e) {

            string ruta = @"D:\Github\DAM2\DI\20_editor_texto\20_editor_texto\bin\Debug\netcoreapp3.1\resources\ago_doc.pdf";

            var p = new Process();
            p.StartInfo = new ProcessStartInfo($"{ruta}") { UseShellExecute = true };
            p.Start();
        }

        // Llama al metodo para cambiar el tema
        private void changeTheme(object sender, RoutedEventArgs e) => setTheme();

        // Cambia el tema de la aplicacion
        private void setTheme() {

            switch (theme) {
                case "light":
                    miChangeEditorBackground.Header = "Modo noche";
                    this.Background = (Brush)bc.ConvertFrom(c.light());
                    theme = "dark";
                    break;
                default:
                    miChangeEditorBackground.Header = "Modo día";
                    this.Background = (Brush)bc.ConvertFrom(c.dark());
                    theme = "light";
                    break;
            }
        }

        // Crea un documento nuevo
        private void nuevoDocumento(object sender, ExecutedRoutedEventArgs e) {

            if (generarnuevoFichero(nomDocumento)) {

                MessageBox.Show("Fichero guardado correctamente");
                vaciarCajaTexto();
                nomDocumento = null;
            }
            else { MessageBox.Show("Error al guardar el fichero"); }
        }

        // Guarda un documento
        private void guardarDocumento(object sender, ExecutedRoutedEventArgs e) {

            if (generarnuevoFichero(nomDocumento)) { MessageBox.Show("Fichero guardado correctamente"); }
            else { MessageBox.Show("Error al guardar el fichero"); }
        }

        // Guarda un fichero nuevo
        private bool generarnuevoFichero(string? nomdoc) {

            if (nomdoc == "" || nomdoc == null) {

                SaveFileDialog dlg = new SaveFileDialog {
                    DefaultExt = ".rtf",
                    Filter = "rtf (*.rtf)|*.rtf|txt (*.txt)|*.txt"
                };

                bool? result = dlg.ShowDialog();

                if (result == true) {

                    nomDocumento = dlg.FileName;
                    File.WriteAllText(nomDocumento, new TextRange(cajaTexto.Document.ContentStart, cajaTexto.Document.ContentEnd).Text);

                    return true;
                } else { return false; }
            }
            else {

                File.WriteAllText(nomdoc, new TextRange(cajaTexto.Document.ContentStart, cajaTexto.Document.ContentEnd).Text);
                return true;
            }
        }

        // Vacia el cajon de texto
        private void vaciarCajaTexto() => cajaTexto.Document.Blocks.Clear();
    }
}