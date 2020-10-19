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

namespace _16_puzzle {

    public partial class MainWindow : Window {

        // Clase inicial
        public MainWindow() {

            InitializeComponent();
            arrancarJuego();
        }

        // Crea los elementos de la ventana de juego
        public void arrancarJuego() {

            // Aqui se crean los botones del grid

            MessageBox.Show("Arrancar juego");

            for (int col = 0; col < 3; col++) {

                for (int row = 0; row < 3; row++) {

                }
            }
        }

        // Carga las imagenes del puzle
        private void cargarImagenes(object sender, RoutedEventArgs e) {

            MessageBox.Show("Carga imagenes");

            // Aqui se cargan las imagenes del puzzle en el contenedor con scroll
        }
    }
}