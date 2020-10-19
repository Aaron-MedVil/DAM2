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

            int i = 0;

            Uri uri = new Uri(@Environment.CurrentDirectory + "/media/hojas.jpg", UriKind.RelativeOrAbsolute);

            BitmapImage bi = new BitmapImage();
            bi.BeginInit();
            bi.UriSource = new Uri(uri.ToString());
            bi.EndInit();

            for (int col = 0; col < 7; col++) {

                for (int row = 0; row < 5; row++) {

                    Mybutton btn = new Mybutton();
                    Image img = new Image {
                        Width = 250,
                        Height = 250,
                        Source = bi
                    };

                    btn.Content = img;

                    Grid.SetRow(btn, row);
                    Grid.SetColumn(btn, col);
                    miRejilla.Children.Add(btn);

                    i++;
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