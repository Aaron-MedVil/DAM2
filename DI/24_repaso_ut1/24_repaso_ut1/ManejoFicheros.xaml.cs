using Microsoft.Win32;
using System.IO;
using System.Windows;

namespace _24_repaso_ut1 {

    public partial class ManejoFicheros : Window {

        private string fileName;

        /// <summary>Funcion que carga los componentes de la pagina</summary>
        public ManejoFicheros() => InitializeComponent();

        /// <summary>Funcion quese ejecuta cuando se carga la ventana</summary>
        /// <param name="sender">Objeto que ejecuta la accion</param>
        /// <param name="e">Objeto evento</param>
        private void Window_Loaded(object sender, RoutedEventArgs e) {

            // Vacia el editor de texto
            // textEditor.Text = "";

            // Open file dialog para seleccionar un fichero
            OpenFileDialog dg = new OpenFileDialog {
                InitialDirectory = "D:\\Github\\DAM2\\DI\\24_repaso_ut1\\24_repaso_ut1\\bin\\Debug\\netcoreapp3.1\\res",
                Filter = "Fichero de texto|*.txt|Fichero JSON|*.json|Todos los ficheros|*.*",
                DefaultExt = "Fichero JSON|*.json",
                Multiselect = false,
                Title = "Seleccione un fichero"
            };

            // Comprueba si se producen errores con el dialog
            if (dg.ShowDialog() == true) {

                fileName = dg.FileName;
                // textEditor.Text = File.ReadAllText(fileName);
            } else { this.Close(); }
        }
    }
}
