using System;
using System.Collections.Generic;
using System.IO;
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

        private String imgSelected = "";

        // Clase inicial
        public MainWindow() {

            InitializeComponent();
            arrancarJuego();
        }

        // Crea los elementos de la ventana de juego
        public void arrancarJuego() {

            // Aqui se crean los botones del grid

            int i = 0;

            Uri uri = new Uri(@Environment.CurrentDirectory + "/media/hojas.png", UriKind.RelativeOrAbsolute);

            BitmapImage bi = new BitmapImage();
            bi.BeginInit();
            bi.UriSource = new Uri(uri.ToString());
            bi.EndInit();

            for (int col = 0; col < 7; col++) {

                for (int row = 0; row < 5; row++) {

                    Image img = new Image {
                        Width = 250,
                        Height = 250,
                        Source = bi
                    };

                    Button btn = new Button {
                        Content = img
                    };
                    btn.Click += new RoutedEventHandler(colocarImg);

                    Grid.SetRow(btn, row);
                    Grid.SetColumn(btn, col);
                    miRejilla.Children.Add(btn);

                    i++;
                }
            }
        }

        // Carga las imagenes del puzle
        private void cargarImagenes(object sender, RoutedEventArgs e) {

            // Aqui se cargan las imagenes del puzzle en el contenedor con scroll
            Microsoft.Win32.OpenFileDialog fileDialog = new Microsoft.Win32.OpenFileDialog() {
                CheckFileExists = true,
                CheckPathExists = true,
                Multiselect = true,
                Filter = "All files (*.*)|*.*|Archivos JPG(*.jpg)|*.jpg|Archivos JPEG (*.jpeg) |*.jpeg|Archivos PNG (*.png)|*.png "
            };

            try {

                // Abre un cuadro de texto para seleccionar las imagenes y guarda su ruta
                fileDialog.ShowDialog();
                Stream[] files = fileDialog.OpenFiles();

                foreach (var item in fileDialog.FileNames) {

                    // Conversion del nombre de los ficheros a objetos bitmap
                    BitmapImage bi = new BitmapImage();
                    bi.BeginInit();
                    bi.UriSource = new Uri(item);
                    bi.EndInit();

                    // Creacion de la imagen
                    Image img = new Image {
                        Source = bi,
                        Height = 100,
                        Width = 100,
                        VerticalAlignment = VerticalAlignment.Top,
                        HorizontalAlignment = HorizontalAlignment.Left,
                        Margin = new Thickness(0.5),
                        ToolTip = item
                    };
                    img.MouseDown += new System.Windows.Input.MouseButtonEventHandler(imgMouseDown);

                    // Inserta las imagenes en el WrapPanel
                    wpImagenes.Children.Add(img);
                }
            } catch { MessageBox.Show("Error"); }
        }

        // Asigna el nombre de la imagen seleccionada a una variable y la elimina del WrapPanel
        private void imgMouseDown(object sender, MouseButtonEventArgs e) {

            Image img = new Image();
            img = (Image)sender;
            imgSelected = img.ToolTip.ToString();

            wpImagenes.Children.Remove(img);
        }

        // Coloca la imagen seleccionada en un boton del puzzle 
        private void colocarImg(object sender, RoutedEventArgs e) {

            Button btn = new Button();
            btn = (Button)sender;

            // Obtengo la fila y la columna del boton seleccionado
            int col = Grid.GetColumn((UIElement)btn), row = Grid.GetRow((UIElement)btn);

            // Elimina el boton que ha hecho click
            miRejilla.Children.Remove(this);

            if (imgSelected.Any()) {

                // Crea un boton nuevo con la imagen seleccionada

                String selectedFileName = imgSelected;
                imgSelected = "";

                BitmapImage bi = new BitmapImage();
                bi.BeginInit();
                bi.UriSource = new Uri(selectedFileName);
                bi.EndInit();

                Image img = new Image {
                    Width = 250,
                    Height = 250,
                    Source = bi
                };

                Button btn2 = new Button {
                    Content = img
                };

                Grid.SetRow(btn2, row);
                Grid.SetColumn(btn2, col);
                miRejilla.Children.Add(btn2);
            }
            else {

                // Si el tooltip esta vacio que no haga nada
                // sino que ponga la imagen por defecto y guarde en imgSelected la ruta de la imagen y cargue la imagen en el cuadro de imagenes
                MessageBox.Show("Sin seleccionar imagen");
            }
        }
    }
}