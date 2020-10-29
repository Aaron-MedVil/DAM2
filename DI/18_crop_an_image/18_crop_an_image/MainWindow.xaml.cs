using System;
using System.IO;
using System.Windows;
using System.Windows.Controls;
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

            actualImgUrl = new BitmapImage();
            actualImgUrl.BeginInit();
            actualImgUrl.UriSource = new Uri(@Environment.CurrentDirectory + "/media/original.jpg", UriKind.RelativeOrAbsolute);
            actualImgUrl.EndInit();

            imgWidth = actualImgUrl.Width; imgHeight = actualImgUrl.Height;

            Image img = new Image { Stretch = Stretch.Fill, Source = actualImgUrl };

            gridLoadSelectedImage.Children.Add(img);
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

                actualImgUrl = new BitmapImage();
                actualImgUrl.BeginInit();
                actualImgUrl.UriSource = new Uri(fileDialog.FileName.ToString());
                actualImgUrl.EndInit();

                imgWidth = actualImgUrl.Width; imgHeight = actualImgUrl.Height;

                Image img = new Image { Stretch = Stretch.Fill, Source = actualImgUrl };

                gridLoadSelectedImage.Children.Add(img);
                btnCropImage.Visibility = Visibility.Visible;
            } catch { MessageBox.Show("Error al cargar la imagen"); }
        }

        // Carga las imagenes troceadas
        private void cropImage(object sender, RoutedEventArgs e) {

            double widthCrop = imgWidth / 7; double heightCrop = imgHeight / 5;
            CroppedBitmap cb;

            try {

                // Hay que hacer que la imagen se parta en 7 de largo y 5 de alto
                // El x inicial tiene que ser el punto anterior igual que el y

                cb = new CroppedBitmap(actualImgUrl, new Int32Rect(0, 0, (int)widthCrop, (int)heightCrop));
                Image img = new Image { Source = cb, Height = 100, Width = 100 };
                canvasLoadImage.Children.Add(img);

                for (int x = 0; x < 5; x++) {
                    for (int y = 0; y < 7; y++) { }
                }
            } catch (Exception) { MessageBox.Show("Error al trocear la imagen"); }
        }

        // Boton limpiar imagenes
        private void cleanImages(object sender, RoutedEventArgs e) {

            btnCropImage.Visibility = Visibility.Collapsed;
            limpiarContenedoresImagenes();
        }

        // Limpia los contenedores de imagenes
        private void limpiarContenedoresImagenes() {
            gridLoadSelectedImage.Children.RemoveRange(0, gridLoadSelectedImage.Children.Count);
        }
    }
}