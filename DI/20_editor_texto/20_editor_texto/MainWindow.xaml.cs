using System.Diagnostics;
using System.Windows;
using System.Windows.Input;
using System.Windows.Media;

namespace _20_editor_texto {

    public partial class MainWindow : Window {

        GestDoc gestDoc;

        private string theme = "light";
        public string? nomDocumento;

        // Funcion para cargar los componentes de la ventana
        public MainWindow() => InitializeComponent();

        // Funcion que se ejecuta cuando se carga la ventana
        private void mainWindowOnLoad(object sender, RoutedEventArgs e) {

            gestDoc = new GestDoc(this);
            fillMenuComboBox();
            theme = gestDoc.setTheme(theme);
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

        // Ejecuta un documento que seleccionemos
        private void ejecutarAyuda(object sender, RoutedEventArgs e) {

            string ruta = @"D:\Github\DAM2\DI\20_editor_texto\20_editor_texto\bin\Debug\netcoreapp3.1\resources\ago_doc.pdf";

            var p = new Process();
            p.StartInfo = new ProcessStartInfo($"{ruta}") { UseShellExecute = true };
            p.Start();
        }

        // Llama al metodo para cambiar el tema
        private void changeTheme(object sender, RoutedEventArgs e) => theme = gestDoc.setTheme(theme);

        // Evento que llama a la funcion para crear un evento nuevo
        private void nuevoDocumento(object sender, ExecutedRoutedEventArgs e) {

            if (gestDoc.generarnuevoFichero(nomDocumento)) {

                MessageBox.Show("Fichero guardado correctamente");
                gestDoc.vaciarCajaTexto();
                nomDocumento = null;
            } else { MessageBox.Show("Error al guardar el fichero"); }
        }

        // Guarda un documento
        private void guardarDocumento(object sender, ExecutedRoutedEventArgs e) {

            if (gestDoc.generarnuevoFichero(nomDocumento)) { MessageBox.Show("Fichero guardado correctamente"); }
            else { MessageBox.Show("Error al guardar el fichero"); }
        }

        // Funcion para cerrar la aplicacion con el boton escape
        private void salirPrograma(object sender, ExecutedRoutedEventArgs e) => Close();

        // Evento que controla que se imprima correctamente el documento
        private void imprimirDocumento(object sender, ExecutedRoutedEventArgs e) {

            if (gestDoc.printDoc() == true) { MessageBox.Show("Documento impreso correctamente"); } else { MessageBox.Show("Error al imprimir el documento"); }
        }

        // Evento que controla que se abra correctamente un documento
        private void abrirDocumento(object sender, ExecutedRoutedEventArgs e) {

            if (gestDoc.openDoc(nomDocumento) == true) {

                MessageBox.Show("Fichero abierto correctamente");
                gestDoc.vaciarCajaTexto();
            } else { MessageBox.Show("Error al abrir el documento"); }
        }
    }
}