using System.Windows;
using System.Windows.Controls;

namespace _24_repaso_ut1 {

    public partial class MainWindow : Window {
        public object NavigationService { get; private set; }

        /// <summary>Funcion main</summary>
        public MainWindow() => InitializeComponent();

        /// <summary>Abre la ventana de manejo de JSON</summary>
        /// <param name="sender">Objeto que ejecuta la accion</param>
        /// <param name="e">Objeto evento</param>
        private void btnManejoJson_Click(object sender, RoutedEventArgs e) {

            ManejoJSON w1 = new ManejoJSON();
            w1.Show();
        }

        /// <summary>Abre la ventana de manejo de canvas</summary>
        /// <param name="sender">Objeto que ejecuta la accion</param>
        /// <param name="e">Objeto evento</param>
        private void btnManejoCanvas_Click(object sender, RoutedEventArgs e) {

            VentanaCanvas vc = new VentanaCanvas();
            vc.Show();
        }

        /// <summary>Abre la ventana de manejo de ficheros</summary>
        /// <param name="sender">Objeto que ejecuta la accion</param>
        /// <param name="e">Objeto evento</param>
        private void btnManejoFicheros_Click(object sender, RoutedEventArgs e) {

            ManejoFicheros mf = new ManejoFicheros();
            mf.Show();
        }

        /// <summary>Cambia el estilo de los elementos de la pagina principal</summary>
        /// <param name="sender">Objeto que ejecuta la accion</param>
        /// <param name="e">Objeto evento</param>
        private void btnCambiarEstilos_Click(object sender, RoutedEventArgs e) {

            Button btn = (Button)sender;

            // Recurso llamado desde la propia ventana
            Style st = (Style)this.Resources["cambioBtnStyle"];
            string res = (btn.Style == st) ? "boton_para_heredar" : "cambioBtnStyle";
            btn.Style = (Style)this.Resources[res];

            // Recurso llamado desde el fichero App.xaml
            Style st2 = (Style)App.Current.Resources["windowDark"];
            string res2 = (this.Style == st2) ? "windowWhite" : "windowDark";
            this.Style = (Style)App.Current.Resources[res2];
        }
    }
}
