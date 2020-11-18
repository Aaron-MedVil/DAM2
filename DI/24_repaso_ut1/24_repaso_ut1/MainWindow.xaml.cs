using System.Windows;

namespace _24_repaso_ut1 {

    public partial class MainWindow : Window {

        /// <summary>Funcion main</summary>
        public MainWindow() => InitializeComponent();

        /// <summary>Abre la ventana de manejo de JSON</summary>
        /// <param name="sender">Objeto que ejecuta la accion</param>
        /// <param name="e">Objeto evento</param>
        private void btn1_Click(object sender, RoutedEventArgs e) {

            ManejoJSON w1 = new ManejoJSON();
            w1.Show();
        }

        /// <summary>Abre la ventana de manejo de canvas</summary>
        /// <param name="sender">Objeto que ejecuta la accion</param>
        /// <param name="e">Objeto evento</param>
        private void btn2_Click(object sender, RoutedEventArgs e) {

            VentanaCanvas vc = new VentanaCanvas();
            vc.Show();
        }
    }
}