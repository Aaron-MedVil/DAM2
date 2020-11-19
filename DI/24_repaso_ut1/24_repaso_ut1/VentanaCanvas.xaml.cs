using System;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Shapes;

namespace _24_repaso_ut1 {

    public partial class VentanaCanvas : Window {

        private Point currentPoint = new Point();
        private string evnt;

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
                linea.X1 = currentPoint.X; linea.Y1 = currentPoint.Y - 50;

                // Asigna la posicion final de la linea
                linea.X2 = e.GetPosition(this).X; linea.Y2 = e.GetPosition(this).Y - 50;

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
    }
}