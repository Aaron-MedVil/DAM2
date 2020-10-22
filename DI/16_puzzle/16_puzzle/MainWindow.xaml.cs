using System;
using System.IO;
using System.Linq;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;

namespace _16_puzzle {

    public partial class MainWindow : Window {

        private String imgSelected = "";
        Uri uri = new Uri(@Environment.CurrentDirectory + "/media/hojas.png", UriKind.RelativeOrAbsolute);

        // Clase inicial
        public MainWindow() {

            InitializeComponent();
            arrancarJuego();
        }

        // Crea los elementos de la ventana de juego
        public void arrancarJuego() {

            // Aqui se crean los botones del grid

            int i = 0;

            BitmapImage bi = new BitmapImage();
            bi.BeginInit();
            bi.UriSource = new Uri(uri.ToString());
            bi.EndInit();

            for (int col = 0; col < 7; col++) {

                for (int row = 0; row < 5; row++) {

                    Image img = new Image {
                        Stretch = Stretch.Fill,
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

            if (!imgSelected.Any()) {

                Image img = new Image();
                img = (Image)sender;
                imgSelected = img.ToolTip.ToString();

                wpImagenes.Children.Remove(img);
            } else { MessageBox.Show("Ya hay una imagen seleccionada"); } 
        }

        // Coloca la imagen seleccionada en un boton del puzzle 
        private void colocarImg(object sender, RoutedEventArgs e) {

            Button btn = new Button();
            btn = (Button)sender;

            // Obtengo la fila y la columna del boton seleccionado
            int col = Grid.GetColumn((UIElement)btn), row = Grid.GetRow((UIElement)btn);

            if (imgSelected.Any()) {

                // Elimina el boton que ha hecho click
                miRejilla.Children.Remove(btn);

                String selectedFileName = imgSelected;
                imgSelected = "";

                BitmapImage bi = new BitmapImage();
                bi.BeginInit();
                bi.UriSource = new Uri(selectedFileName);
                bi.EndInit();

                Image img = new Image {
                    Stretch = Stretch.Fill,
                    Source = bi
                };

                Button btn2 = new Button {
                    ToolTip = selectedFileName,
                    Content = img
                };

                btn2.Click += new RoutedEventHandler(resetImagen);

                Grid.SetRow(btn2, row);
                Grid.SetColumn(btn2, col);
                miRejilla.Children.Add(btn2);
            }
        }

        // Devuelve una imagen del puzzle a la zona de piezas
        private void resetImagen(object sender, RoutedEventArgs e) {

            if (!imgSelected.Any()) {

                Button btn = new Button();
                btn = (Button)sender;
                imgSelected = btn.ToolTip.ToString();

                int col = Grid.GetColumn((UIElement)btn), row = Grid.GetRow((UIElement)btn);
                miRejilla.Children.Remove(btn);

                BitmapImage bi = new BitmapImage();
                bi.BeginInit();
                bi.UriSource = new Uri(uri.ToString());
                bi.EndInit();

                Image img = new Image {
                    Stretch = Stretch.Fill,
                    Source = bi
                };

                Button btn2 = new Button {
                    Content = img
                };
                btn2.Click += new RoutedEventHandler(colocarImg);

                Grid.SetRow(btn2, row);
                Grid.SetColumn(btn2, col);
                miRejilla.Children.Add(btn2);

                // Devolver la imagen seleccionada a la zona de piezas
                BitmapImage bi2 = new BitmapImage();
                bi2.BeginInit();
                bi2.UriSource = new Uri(imgSelected);
                bi2.EndInit();

                Image img2 = new Image {
                    Source = bi2,
                    Height = 100,
                    Width = 100,
                    VerticalAlignment = VerticalAlignment.Top,
                    HorizontalAlignment = HorizontalAlignment.Left,
                    Margin = new Thickness(0.5),
                    ToolTip = imgSelected
                };
                img2.MouseDown += new System.Windows.Input.MouseButtonEventHandler(imgMouseDown);
                wpImagenes.Children.Add(img2);

                imgSelected = "";
            } else { MessageBox.Show("Ya hay una imagen seleccionada"); }
        }
    }
}