using System;
using System.Collections.Generic;
using System.Linq;
using System.Media;
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
using System.Windows.Threading;

namespace _21_marcianito {

    public partial class MainWindow : Window {

        private int widthCanvas, heightCanvas;
        private Button btn = new Button();

        // Uri Imagenes
        private Uri uriImg = new Uri(@Environment.CurrentDirectory + "/media/marcianito.jpg", UriKind.RelativeOrAbsolute);
        private Uri uriImg2 = new Uri(@Environment.CurrentDirectory + "/media/explosion.png", UriKind.RelativeOrAbsolute);

        // Uri sonidos
        private Uri uriSound = new Uri(@Environment.CurrentDirectory + "/media/marcianito.mp3", UriKind.RelativeOrAbsolute);
        private Uri uriSound2 = new Uri(@Environment.CurrentDirectory + "/media/explosion.mp3", UriKind.RelativeOrAbsolute);
        
        // Temporizadores
        private DispatcherTimer disp = new DispatcherTimer();
        private DispatcherTimer disp2 = new DispatcherTimer();

        // Sonidos
        private MediaPlayer mediaPlayer = new MediaPlayer();
        private MediaPlayer mediaPlayer2 = new MediaPlayer();

        // Funcion para cargar la ventana inicial
        public MainWindow() => InitializeComponent();

        // Funcion que se ejecuta cuando carga la ventana
        private void Window_Loaded(object sender, RoutedEventArgs e) => startMovimientoMarcianito();

        // Inicia el movimiento del marcianito
        public void startMovimientoMarcianito() {

            mediaPlayer.Open(uriSound);
            mediaPlayer.Play();

            // Obtiene el ancho y alto del canvas 
            widthCanvas = (int)mainWindowCanvas.ActualWidth;
            heightCanvas = (int)mainWindowCanvas.ActualHeight;

            cargarImagen();
            cargarDispatcherTime();
        }

        // Genera el boton
        private void cargarImagen() {

            BitmapImage bi = new BitmapImage();
            bi.BeginInit();
            bi.UriSource = uriImg;
            bi.EndInit();

            // Creacion de la imagen
            Image img = new Image {
                Source = bi,
                Stretch = Stretch.Fill,
                Width = 100,
                Height = 100
            };

            // Crea el marcianito y lo posiciona en el canvas
            btn = new Button { Content = img };
            btn.Click += new RoutedEventHandler(endProgram);
            Canvas.SetTop(btn, 0);
            Canvas.SetLeft(btn, 0);
            mainWindowCanvas.Children.Add(btn);
        }

        // Carga el temporizador
        private void cargarDispatcherTime() {

            disp = new DispatcherTimer();
            disp.Tick += new EventHandler(actualizarMovimientoMarcianito);
            disp.Interval = new TimeSpan(0, 0, 1);
            disp.Start();
        }

        // Funcion que actualiza la posicion del marcianito
        private void actualizarMovimientoMarcianito(object sender, EventArgs e) {
               
            // Genera un numero aleatorio entre 0 y el ancho/alto del canvas
            Random rand = new Random();
            int h = rand.Next(0, (widthCanvas - 100));
            int w = rand.Next(0, (heightCanvas - 100));

            // Cambia la posicion del boton en el canvas
            Canvas.SetTop(btn, w);
            Canvas.SetLeft(btn, h);
        }

        // Funcion cuando pulsas en el marcianito
        private void endProgram(object sender, EventArgs e) {
            
            disp.Stop();
            mediaPlayer.Stop();

            cambioFase();
        }

        // Cambia las propiedades del boton para terminar el programa
        private void cambioFase() {

            mediaPlayer2.Open(uriSound2);
            mediaPlayer2.Play();

            disp2 = new DispatcherTimer();
            disp2.Tick += new EventHandler(acabarPrograma);
            disp2.Interval = new TimeSpan(0, 0, 4);
            disp2.Start();

            BitmapImage bi = new BitmapImage();
            bi.BeginInit();
            bi.UriSource = uriImg2;
            bi.EndInit();

            // Creacion de la imagen
            Image img = new Image {
                Source = bi,
                Stretch = Stretch.Fill,
                Width = 100,
                Height = 100
            };
            btn.Content = img;
        }

        // Ejecuta el final del programa
        private void acabarPrograma(object sender, EventArgs e) {

            mediaPlayer2.Stop();
            disp2.Stop();
            MessageBox.Show("Has ganado");
            Close();
        }
    }
}