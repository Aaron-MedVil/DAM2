using System.Diagnostics;
using System.Diagnostics.Tracing;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Media3D;

namespace _20_editor_texto {

    public partial class MainWindow : Window {

        Colors c = new Colors();
        BrushConverter bc = new BrushConverter();
        string theme = "light";

        public MainWindow() {

            InitializeComponent();
            fillMenuComboBox();
            setTheme();

            // Asigna un evento cuando se pulsa una tecla
            this.PreviewKeyDown += new KeyEventHandler(HandleEsc);
        }

        // Rellena la informacion de lo ComboBox del menu
        private void fillMenuComboBox() {

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
    }
}