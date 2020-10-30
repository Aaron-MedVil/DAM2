using System.Windows;
using System.IO;
using System;
using Microsoft.Win32;

namespace _19_wr_ficheros {
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window {

        public MainWindow() => InitializeComponent();

        // Graba el contenido del cuadro de texto en un fichero
        private void grabarClick(object sender, RoutedEventArgs e) {

            Microsoft.Win32.SaveFileDialog dlg = new Microsoft.Win32.SaveFileDialog {
                DefaultExt = "*.txt",
                Filter = "Text File|*.txt|All Files|*.*"
            };

            Nullable<bool> result = dlg.ShowDialog();

            if (result == true) {

                String nombreFichero = dlg.FileName;
                File.WriteAllText(nombreFichero, cajaTexto.Text);
            } else { MessageBox.Show("Error al crear el fichero"); }
        }

        // Lee el contenido de un fichero seleccionado y lo muestra en el cuadro de texto
        private void leerArchivo(object sender, RoutedEventArgs e) {

            OpenFileDialog ofd = new OpenFileDialog {
                Filter = "All Files|*.*|Text Files|*.txt",
                Multiselect = false
            };

            Nullable<bool> result = ofd.ShowDialog();

            if (result == true) {

                String nombreFichero = ofd.FileName;
                cajaTexto.Text = File.ReadAllText(nombreFichero);
            } else { MessageBox.Show("Error al leer el fichero"); }
        }
        
        // Borra el fichero seleccionado
        private void borrarArchivo(object sender, RoutedEventArgs e) {

            OpenFileDialog ofd = new OpenFileDialog {
                Filter = "All Files|*.*|Text Files|*.txt"
            };

            Nullable<bool> result = ofd.ShowDialog();

            if (result == true) {

                String nombreFichero = ofd.FileName;
                File.Delete(nombreFichero);
            } else { MessageBox.Show("Error al eliminar el fichero"); }
        }
    }
}
