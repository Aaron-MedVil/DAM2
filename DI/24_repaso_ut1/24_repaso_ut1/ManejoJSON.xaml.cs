using Microsoft.Win32;
using System.Collections.Generic;
using System.IO;
using System.Windows;
using Newtonsoft.Json;
using System;
using System.Reflection.Metadata;
using System.Windows.Input;
using System.Windows.Controls;

namespace _24_repaso_ut1 {

    public partial class ManejoJSON : Window {

        List<Pokemones> ListaPokemones = new List<Pokemones>();

        public ManejoJSON() => InitializeComponent();

        // Abrir un fichero JSON y mostrarlo en un DataGrid
        private void Window_Loaded(object sender, RoutedEventArgs e) {

            string filemone = Environment.CurrentDirectory + "/res/pokemones.json";
            string json = File.ReadAllText(filemone);

            ListaPokemones = JsonConvert.DeserializeObject<List<Pokemones>>(json);
            dgJson.ItemsSource = ListaPokemones;
        }

        private void mostrarDatosPokemon(object sender, MouseButtonEventArgs e) {}
    }
}