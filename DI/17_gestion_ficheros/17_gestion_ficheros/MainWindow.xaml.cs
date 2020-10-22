using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace _17_gestion_ficheros {

    public partial class MainWindow : Window {

        public MainWindow() => InitializeComponent();

        // Funcion para abrir un solo fichero y mostrarlo en pantalla
        private void abrirFicheroClick(object sender, RoutedEventArgs e) {

            // Creamos un cuadro que nos permita seleccionar un fichero del tipo que queramos
            Microsoft.Win32.OpenFileDialog fileDialog = new Microsoft.Win32.OpenFileDialog {
                Multiselect = false,
                Filter = "All files (*.*)|*.*|Archivos JPG|*.jpg|Archivos JPEG|*.jpeg|Archivos PNG|*.png"
            };

            try {

                MessageBox.Show("Fichero Unico");

                fileDialog.ShowDialog();
            } catch (Exception) { MessageBox.Show("Error"); }
        }

        // Funcion para abrir varios ficheros y mostrarlos en pantalla
        private void abrirFicherosClick(object sender, RoutedEventArgs e) {

            // Creamos un cuadro que nos permita seleccionar varios ficheros del tipo que queramos
            Microsoft.Win32.OpenFileDialog fileDialog = new Microsoft.Win32.OpenFileDialog {
                Multiselect = true,
                Filter = "All files (*.*)|*.*|Archivos JPG|*.jpg|Archivos JPEG|*.jpeg|Archivos PNG|*.png"
            };

            try {

                MessageBox.Show("Varios Ficheros");

                fileDialog.ShowDialog();
            } catch (Exception) { MessageBox.Show("Error"); }
        }
    }
}
