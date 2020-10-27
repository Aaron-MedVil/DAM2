using System;
using System.IO;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;
using System.Windows.Media.Imaging;

namespace _18_crop_an_image {

    public partial class MainWindow : Window {

        public MainWindow() => InitializeComponent();

        // Carga una imagen definida
        private void autoLoadImage(object sender, RoutedEventArgs e) {

            limpiarContenedoresImagenes();

            BitmapImage bi = new BitmapImage();
            bi.BeginInit();
            bi.UriSource = new Uri(@Environment.CurrentDirectory + "/media/original.jpg", UriKind.RelativeOrAbsolute);
            bi.EndInit();

            Image img = new Image {
                Stretch = Stretch.Fill,
                Source = bi
            };

            gridImagen.Children.Add(img);
            btnCropImage.Visibility = Visibility.Visible;
        }

        // Carga una imagen 
        private void manualLoadImage(object sender, RoutedEventArgs e) {

            limpiarContenedoresImagenes();

            Microsoft.Win32.OpenFileDialog fileDialog = new Microsoft.Win32.OpenFileDialog() {
                CheckFileExists = true,
                CheckPathExists = true,
                Multiselect = false,
                Filter = "All files (*.*)|*.*|Archivos JPG(*.jpg)|*.jpg|Archivos JPEG (*.jpeg) |*.jpeg|Archivos PNG (*.png)|*.png "
            };

            try {

                fileDialog.ShowDialog();
                Stream[] files = fileDialog.OpenFiles();

                BitmapImage bi = new BitmapImage();
                bi.BeginInit();
                bi.UriSource = new Uri(fileDialog.FileName.ToString());
                bi.EndInit();

                Image img = new Image {
                    Source = bi,
                    Stretch = Stretch.Fill
                };

                gridImagen.Children.Add(img);
                btnCropImage.Visibility = Visibility.Visible;
            } catch { MessageBox.Show("Error"); }
        }

        // Carga las imagenes troceadas
        private void cropImage(object sender, RoutedEventArgs e) {

            MessageBox.Show("Cropped");
        }

        // Boton limpiar imagenes
        private void cleanImages(object sender, RoutedEventArgs e) {

            MessageBox.Show("Limpiar contenido");

            btnCropImage.Visibility = Visibility.Collapsed;
            limpiarContenedoresImagenes();
        }

        // Limpia los contenedores de imagenes
        private void limpiarContenedoresImagenes() {

            gridImagen.Children.RemoveRange(0, gridImagen.Children.Count - 1);
            croppedImages.Children.RemoveRange(0, croppedImages.Children.Count - 1);
        }
    }
}