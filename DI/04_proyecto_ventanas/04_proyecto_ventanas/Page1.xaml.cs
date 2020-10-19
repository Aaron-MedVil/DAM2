using System;
using System.Collections.Generic;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

using System.Diagnostics;

namespace _04_proyecto_ventanas
{
    /// <summary>
    /// Lógica de interacción para Page1.xaml
    /// </summary>
    public partial class Page1 : Page {
        public Page1() {
            InitializeComponent();
        }

        private void cambiar_pagina(object sender, RoutedEventArgs e) {
            Page2 p2 = new Page2();

            // Abrimos la página 2
            this.NavigationService.Navigate(p2);
        }

        private void cambioVentana(object sender, RoutedEventArgs e) {

            MainWindow mw = new MainWindow();
            mw.Show();
        }

        private void Creacion_ventana(object sender, RoutedEventArgs e) {

            Window ventana = new Window {
                MinHeight = 100,
                MaxHeight = 300,
                Title = "Ventana nueva",
                MaxWidth = 300,
                Left = 500,
                Top = 500
            };

            ventana.Show();
        }
    }
}
