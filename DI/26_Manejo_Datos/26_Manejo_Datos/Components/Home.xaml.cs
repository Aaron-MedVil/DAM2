using System;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Media.Imaging;

namespace _26_Manejo_Datos.Components {

    public partial class Home : UserControl {

        private MainWindow mw = new MainWindow();
        private Uri uri_def_img = new Uri(@Environment.CurrentDirectory + "/media/homeBg.jpg", UriKind.RelativeOrAbsolute);

        /// <summary>Metodo que carga los componentes de la pagina</summary>
        public Home() => InitializeComponent();

        /// <summary>Carga la interfaz de la pagina</summary>
        /// <param name="sender">Elemento que realiza la accion</param>
        /// <param name="e">Parametros de la accion</param>
        private void UserControl_Loaded(object sender, RoutedEventArgs e) => img_home.Source = new BitmapImage(uri_def_img);
    }
}