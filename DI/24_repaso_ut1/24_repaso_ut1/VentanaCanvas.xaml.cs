using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Shapes;

namespace _24_repaso_ut1 {

    public partial class VentanaCanvas : Window {

        private Point currentPoint = new Point();
        private string evnt = "dibujar";

        /// <summary>Funcion main</summary>
        public VentanaCanvas() => InitializeComponent();

        /// <summary>Evento que se ejecuta al hacer click en el canvas</summary>
        /// <param name="sender">Objeto que ejecuta la accion</param>
        /// <param name="e">Objeto evento</param>
        private void canvasDibujo_MouseDown(object sender, MouseButtonEventArgs e) {

            // Evento que se produce si se pulsa el boton izquierdo del raton
            if (e.LeftButton == MouseButtonState.Pressed) {

                // Situa el cursor en la posicion que hemos hecho click
                currentPoint = e.GetPosition(this);
            }
        }

        /// <summary>Evento que se ejecuta al mover el boton sobre el canvas</summary>
        /// <param name="sender">Objeto que ejecuta la accion</param>
        /// <param name="e">Objeto evento</param>
        private void canvasDibujo_MouseMove(object sender, MouseEventArgs e) {

            // Evento que se produce si se pulsa el boton izquierdo del raton
            if (e.LeftButton == MouseButtonState.Pressed) {

                // Crea la linea
                Line linea = new Line {
                    Stroke = new SolidColorBrush(Colors.Maroon),
                    StrokeThickness = 3
                };

                // Asigna la posicion inicial de la lina
                linea.X1 = currentPoint.X;
                linea.Y1 = currentPoint.Y - 50;

                // Asigna la posicion final de la linea
                linea.X2 = e.GetPosition(this).X;
                linea.Y2 = e.GetPosition(this).Y - 50;

                // Situa el cursor en el ultimo vector que hemos dejado el cursor
                currentPoint = e.GetPosition(this);

                // Agrega la linea al canvas
                canvasDibujo.Children.Add(linea);
            }
        }

        private void MenuItem_Click(object sender, RoutedEventArgs e) {

            MenuItem mi = (MenuItem)sender;
            mi.Background = new SolidColorBrush(Colors.Black);

            // Hay que quitar los colorinchis a los otros items cuando se pulsa uno

            evnt = "";
            /*
             * dibujar
             * borrar
             * mover
             * cambiar_color
             * cambiar_grosor
             */
        }
    }
}