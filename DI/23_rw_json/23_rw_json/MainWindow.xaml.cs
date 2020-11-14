using System.Collections.Generic;
using System.IO;
using System.Windows;
using Microsoft.Win32;
using Newtonsoft.Json;

namespace _23_rw_json {
    
    public partial class MainWindow : Window {

        List<Productos> listaProducto = new List<Productos>();

        // Funcion que carga los componentes
        public MainWindow() => InitializeComponent();

        // Abre el fichero JSON
        private void Abrir_Json(object sender, RoutedEventArgs e) {

            // Abre el dialogo para seleccionar un fichero JSON
            OpenFileDialog dlg = new OpenFileDialog {
                DefaultExt = ".json",
                Filter = "JSON (*.json)|*.json|TXT (*.txt)|*.xaml"
            };

            if (dlg.ShowDialog() == true) {

                // Obtiene el nombre del fichero
                string filename = dlg.FileName;

                // Abre un archivo de texto, lee todo el texto del archivo en una cadena y, a continuación, cierra el archivo.
                string json = File.ReadAllText(filename);

                // Metodo que lee el JSON y lo guarda en un array
                listaProducto = JsonConvert.DeserializeObject<List<Productos>>(json);

                // Busca un valor del array y devuelve los datos de la posicion que indicamos
                // var RegistroP = listaProducto.Find(x => x.Id_Articulo == 1);

                // Asigna el array al DataGrid
                dataGrid.ItemsSource = listaProducto;
            } else { MessageBox.Show("Error al abrir el archivo"); }
        }
    }
}