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
        Point currentPoint = new Point();

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

            double widthCrop = imgWidth / 7, heightCrop = imgHeight / 5;
            int aX = (Int32)widthCrop; int aY = (Int32)heightCrop;
            CroppedBitmap cb;

            canvasLoadImage.Children.RemoveRange(0, canvasLoadImage.Children.Count);

            double cWidthCrop = canvasLoadImage.ActualWidth / 7, cHeightCrop = canvasLoadImage.ActualHeight / 5;

            for (double x = 0; x <= imgWidth; x = x + widthCrop) {

                for (double y = 0; y <= imgHeight; y = y + heightCrop) {

                    try {

                        int iX = (Int32)x; int iY = (Int32)y;
                        cb = new CroppedBitmap(actualImgUrl, new Int32Rect(iX, iY, aX, aY));

                        Image img = new Image { Source = cb, Height = cHeightCrop, Width = cWidthCrop };
                        Canvas cvImg = new Canvas();
                        cvImg.Children.Add(img);
                        cvImg.MouseLeftButtonDown += new MouseButtonEventHandler(Canvas_MouseLeftButtonDown);
                        cvImg.MouseLeftButtonUp += new MouseButtonEventHandler(Canvas_MouseLeftButtonUp);
                        cvImg.MouseMove += new MouseEventHandler(Canvas_MouseMove);
                        Canvas.SetLeft(cvImg, (x / widthCrop) * cWidthCrop);
                        Canvas.SetTop(cvImg, (y / heightCrop) * cHeightCrop);
                        Canvas.SetZIndex(cvImg, 0);

                        canvasLoadImage.Children.Add(cvImg);
                    } catch (Exception) {}
                }
            }
        }

        // Boton limpiar imagenes
        private void cleanImages(object sender, RoutedEventArgs e) {

            btnCropImage.Visibility = Visibility.Collapsed;
            limpiarContenedoresImagenes();
        }

        // Limpia los contenedores de imagenes
        private void limpiarContenedoresImagenes() {
            gridLoadSelectedImage.Children.RemoveRange(0, gridLoadSelectedImage.Children.Count);
            canvasLoadImage.Children.RemoveRange(0, canvasLoadImage.Children.Count);
        }

        // Evento que se produce al pulsar el click con el boton izquierdo en las imagenes
        private void Canvas_MouseLeftButtonDown(object sender, MouseButtonEventArgs e) {

            Canvas layer1 = sender as Canvas;

            Canvas.SetZIndex(layer1, 1);
            if (layer1 != null) { layer1.CaptureMouse(); }
        }

        // Evento que se produce al soltar el click con el boton izquierdo en las imagenes
        private void Canvas_MouseLeftButtonUp(object sender, MouseButtonEventArgs e) {

            Canvas layer1 = sender as Canvas;
            if (layer1 != null) { layer1.ReleaseMouseCapture(); }
        }

        // Evento que se produce al arrastrar las imagenes
        private void Canvas_MouseMove(object sender, MouseEventArgs e) {

            Canvas layer1 = sender as Canvas;

            if (layer1 != null && layer1.IsMouseCaptured) {

                currentPoint = e.GetPosition(this);
                Canvas.SetLeft(layer1, (currentPoint.X - ((int)spBotonera.ActualWidth + 10)));
                Canvas.SetTop(layer1, currentPoint.Y);
            }
        }
    }
}