using System;
using System.IO;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;

namespace _18_crop_an_image {

    public partial class MainWindow : Window {

        static double imgWidth, imgHeight;
        static BitmapImage actualImgUrl;
        // Point currentPoint = new Point();
        // int posicionImagenPuzle = 0;

        public MainWindow() => InitializeComponent();

        // Carga una imagen definida
        private void autoLoadImage(object sender, RoutedEventArgs e) {

            limpiarContenedoresImagenes();

            BitmapImage bi = new BitmapImage();
            bi.BeginInit();
            bi.UriSource = new Uri(@Environment.CurrentDirectory + "/media/original.jpg", UriKind.RelativeOrAbsolute);
            bi.EndInit();

            actualImgUrl = bi;

            imgWidth = bi.Width; imgHeight = bi.Height;

            Image img = new Image {
                Width = canvasGridImagen.Width,
                Height = canvasGridImagen.Height,
                Stretch = Stretch.Fill,
                Source = bi
            };

            canvasGridImagen.Children.Add(img);
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

                actualImgUrl = bi;

                imgWidth = bi.Width; imgHeight = bi.Height;

                Image img = new Image {
                    Width = canvasGridImagen.Width,
                    Height = canvasGridImagen.Height,
                    Stretch = Stretch.Fill,
                    Source = bi
                };

                canvasGridImagen.Children.Add(img);
                btnCropImage.Visibility = Visibility.Visible;
            } catch { MessageBox.Show("Error"); }
        }

        // Carga las imagenes troceadas
        private void cropImage(object sender, RoutedEventArgs e) {

            double widthCrop = imgWidth / 7; double heightCrop = imgHeight / 5;

            BitmapImage bi = new BitmapImage();
            bi.BeginInit();
            bi.UriSource = new Uri(actualImgUrl.ToString());
            bi.EndInit();

            CroppedBitmap cb;

            try {

                croppedImages.Children.RemoveRange(0, croppedImages.Children.Count);

                // Hay que hacer que la imagen se parta en 7 de largo y 5 de alto
                // El x inicial tiene que ser el punto anterior igual que el y

                cb = new CroppedBitmap(bi, new Int32Rect(0, 0, (int)widthCrop, (int)heightCrop));
                Image img = new Image { Source = cb, Height = 100, Width = 100 };
                croppedImages.Children.Add(img);

                for (int x = 0; x < 5; x++) {
                    for (int y = 0; y < 7; y++) {}
                }
            } catch (Exception) { MessageBox.Show("Error"); }
        }

        // Boton limpiar imagenes
        private void cleanImages(object sender, RoutedEventArgs e) {

            btnCropImage.Visibility = Visibility.Collapsed;
            limpiarContenedoresImagenes();
        }

        // Limpia los contenedores de imagenes
        private void limpiarContenedoresImagenes() {

            canvasGridImagen.Children.RemoveRange(0, canvasGridImagen.Children.Count);
            croppedImages.Children.RemoveRange(0, croppedImages.Children.Count);
        }
    }
}