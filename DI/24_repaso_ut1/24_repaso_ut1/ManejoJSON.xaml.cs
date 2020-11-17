using System.Collections.Generic;
using System.IO;
using System.Windows;
using Newtonsoft.Json;
using System;
using System.Windows.Input;
using System.Windows.Controls;
using System.Windows.Media.Imaging;
using System.Windows.Media;

namespace _24_repaso_ut1 {

    public partial class ManejoJSON : Window {

        List<Pokemones> ListaPokemones = new List<Pokemones>();
        String urlImg = Environment.CurrentDirectory + "/res/Pokemons/";

        public ManejoJSON() => InitializeComponent();

        /// <summary>Abrir un fichero JSON y mostrarlo en un DataGrid</summary>
        /// <param name="sender">Objeto que ejecuta la accion</param>
        /// <param name="e">Objeto evento</param>
        private void Window_Loaded(object sender, RoutedEventArgs e) {

            string filemone = Environment.CurrentDirectory + "/res/pokemones.json";
            string json = File.ReadAllText(filemone);

            ListaPokemones = JsonConvert.DeserializeObject<List<Pokemones>>(json);
            dgJson.ItemsSource = ListaPokemones;
        }

        /// <summary>Muestra los datos de la fila seleccionada</summary>
        /// <param name="sender">Objeto que ejecuta la accion</param>
        /// <param name="e">Objeto evento</param>
        private void mostrarDatosPokemon(object sender, MouseButtonEventArgs e) {

            clearDataGridRegistros();

            // Obtiene los datos de la columna que hemos seleccionado
            DataGrid dg = sender as DataGrid;
            Pokemones registro = (Pokemones)dgJson.SelectedItems[0];

            // Crea un bitmap con la imagen del registro seleccionado
            BitmapImage bi = new BitmapImage();
            bi.BeginInit();
            bi.UriSource = new Uri(urlImg + registro.Imagen);
            bi.EndInit();

            // Crea la imagen y la agrega al grid de la imagen
            imgRegistro.Children.Add(new Image { Source = bi, Stretch = Stretch.Fill });

            // Obtiene los valores del registro seleccionado y los muestra
            nPokedexRegistro.Text = registro.NPokedex;
            nombreRegistro.Text = registro.Nombre;
            tipo1Registro.Text = registro.Tipo1;
            tipo2Registro.Text = registro.Tipo2;

            // Muestra el grid
            gridDatosRegistro.Visibility = Visibility.Visible;
        }

        /// <summary>Limpia los datos de los registros</summary>
        private void clearDataGridRegistros() {

            imgRegistro.Children.Clear();
            nPokedexRegistro.Text = "";
            nombreRegistro.Text = "";
            tipo1Registro.Text = "";
            tipo2Registro.Text = "";
        }

        /// <summary>Cierra los datos del registro</summary>
        /// <param name="sender">Objeto que ejecuta la accion</param>
        /// <param name="e">Objeto evento</param>
        private void cerrarRegistro(object sender, RoutedEventArgs e) {

            clearDataGridRegistros();
            gridDatosRegistro.Visibility = Visibility.Hidden;
        }
    }
}