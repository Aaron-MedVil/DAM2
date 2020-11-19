using System;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace _24_repaso_ut1 {

    public partial class VentanaCanvas : Window {

        private Point currentPoint = new Point();
        private string evnt;
        private String urlImg = Environment.CurrentDirectory + "/res/Pokemons/";

        /// <summary>Funcion main</summary>
        public VentanaCanvas() => InitializeComponent();

        /// <summary>Funcion que se ejecuta cuando se carga la pagina</summary>
        /// <param name="sender">Objeto que ejecuta la accion</param>
        /// <param name="e">Objeto evento</param>
        private void Window_Loaded(object sender, RoutedEventArgs e) => changeColorMenu(null);

        /// <summary>Evento que se ejecuta al hacer click en el canvas</summary>
        /// <param name="sender">Objeto que ejecuta la accion</param>
        /// <param name="e">Objeto evento</param>
        private void canvasDibujo_MouseDown(object sender, MouseButtonEventArgs e) {

            // Evento que se produce si se pulsa el boton izquierdo del raton
            if (e.LeftButton == MouseButtonState.Pressed && evnt == "dibujar") {

                // Situa el cursor en la posicion que hemos hecho click
                currentPoint = e.GetPosition(this);
            }
        }

        /// <summary>Evento que se ejecuta al mover el boton sobre el canvas</summary>
        /// <param name="sender">Objeto que ejecuta la accion</param>
        /// <param name="e">Objeto evento</param>
        private void canvasDibujo_MouseMove(object sender, MouseEventArgs e) {

            // Evento que se produce si se pulsa el boton izquierdo del raton
            if (e.LeftButton == MouseButtonState.Pressed && evnt == "dibujar") {

                // Crea la linea
                Line linea = new Line {
                    Stroke = new SolidColorBrush(Colors.Maroon),
                    StrokeThickness = 3
                };

                // Asigna la posicion inicial de la lina
                linea.X1 = currentPoint.X; linea.Y1 = currentPoint.Y - mHerramientas.ActualHeight;

                // Asigna la posicion final de la linea
                linea.X2 = e.GetPosition(this).X; linea.Y2 = e.GetPosition(this).Y - mHerramientas.ActualHeight;

                // Crea un evento para cada linea creada
                linea.MouseLeftButtonDown += new MouseButtonEventHandler(linea_MouseDown);

                // Situa el cursor en el ultimo vector que hemos dejado el cursor
                currentPoint = e.GetPosition(this);

                // Agrega la linea al canvas
                canvasDibujo.Children.Add(linea);
            }
        }

        /// <summary>"Borra" las lineas que hemos generado</summary>
        /// <param name="sender">Objeto que ejecuta la accion</param>
        /// <param name="e">Objeto evento</param>
        private void linea_MouseDown(object sender, MouseButtonEventArgs e) {
            if (evnt == "borrar") { canvasDibujo.Children.Remove((Line)sender); }
        }

        /// <summary>Cambia las propiedades de los elementos del menu</summary>
        /// <param name="sender">Objeto que ejecuta la accion</param>
        /// <param name="e">Objeto evento</param>
        private void MenuItem_Click(object sender, RoutedEventArgs e) => changeColorMenu((MenuItem)sender);

        /// <summary>Cambia las propiedades del menu superior dependiendo del boton que pulsemos</summary>
        /// <param name="mi" type="MenuItem || Null">MenuItem seleccionado en la interfaz</param>
        private void changeColorMenu(MenuItem? mi) {

            // Se actualiza el estilo de los items del menu
            foreach (MenuItem item in mHerramientas.Items) {
                item.Style = (Style)this.Resources["defaultMenuItem"];
            }

            // Si no se envia un objeto null se selecciona el item pulsado
            if (mi != null) {

                mi.Style = (Style)this.Resources["miSelected"];
                evnt = mi.Tag.ToString();
            }
            
            // Si se envia un objeto null se selecciona el primer item
            else {

                MenuItem firstItem = (MenuItem)mHerramientas.Items[0];
                evnt = firstItem.Tag.ToString();
                firstItem.Style = (Style)this.Resources["miSelected"];
            }            
        }

        /// <summary>Crea una imagen canvas en el lienzo y le asigna propiedades para poder moverla</summary>
        /// <param name="sender">Objeto que ejecuta la accion</param>
        /// <param name="e">Objeto evento</param>
        private void MenuItem_Click_1(object sender, RoutedEventArgs e) {

            changeColorMenu((MenuItem)sender);

            // Creamos el canvas
            Canvas c1 = new Canvas();

            // Creamos el bitmap de la imagen
            BitmapImage bi = new BitmapImage();
            bi.BeginInit();
            bi.UriSource = new Uri(urlImg + "Squirtle.png");
            bi.EndInit();

            // Creamos la imagen y le damos propiedades
            Image img = new Image { Source = bi, Stretch = Stretch.Fill, Height = 50, Width = 50 };

            // Agrega la imagen al canvas
            c1.Children.Add(img);

            c1.MouseLeftButtonDown += new MouseButtonEventHandler(Canvas_MouseLeftButtonDown);
            c1.MouseLeftButtonUp += new MouseButtonEventHandler(Canvas_MouseLeftButtonUp);
            c1.MouseMove += new MouseEventHandler(Canvas_MouseMove);

            // Asignar la posicion del canvas que vamos a agregar
            Canvas.SetLeft(c1, 50);
            Canvas.SetTop(c1, 50);

            // Agregamos el canvas nuevo al canvas base
            canvasDibujo.Children.Add(c1);
        }

        /// <summary>Crea una captura de raton en un evento canvas cuando lo pulsamos</summary>
        /// <param name="sender">Objeto que ejecuta la accion</param>
        /// <param name="e">Objeto evento</param>
        private void Canvas_MouseLeftButtonDown(object sender, MouseButtonEventArgs e) {

            Canvas layer1 = (Canvas)sender;
            if (layer1 != null) { layer1.CaptureMouse(); }
        }

        /// <summary>Para la captura de raton en un evento canvas cuando lo pulsamos</summary>
        /// <param name="sender">Objeto que ejecuta la accion</param>
        /// <param name="e">Objeto evento</param>
        private void Canvas_MouseLeftButtonUp(object sender, MouseButtonEventArgs e) {

            Canvas layer1 = (Canvas)sender;
            if (layer1 != null) { layer1.ReleaseMouseCapture(); }
        }

        /// <summary>Desplaza la imagen canvas por el lienzo</summary>
        /// <param name="sender">Objeto que ejecuta la accion</param>
        /// <param name="e">Objeto evento</param>
        private void Canvas_MouseMove(object sender, MouseEventArgs e) {

            Canvas layer1 = (Canvas)sender;

            if (layer1 != null && layer1.IsMouseCaptured) {

                currentPoint = e.GetPosition(this);
                Canvas.SetLeft(layer1, currentPoint.X);
                Canvas.SetTop(layer1, currentPoint.Y - mHerramientas.ActualHeight);
            }
        }
    }
}