using System.Windows;
using System.Windows.Controls;

namespace _26_Manejo_Datos {

    public partial class MainWindow : Window {

        /// <summary>Carga los componentes graficos de la aplicacion</summary>
        public MainWindow() => InitializeComponent();

        /// <summary>Carga los datos iniciales de la aplicacion</summary>
        /// <param name="sender">Elemento que realiza la accion</param>
        /// <param name="e">Parametros de la accion</param>
        private void Window_Loaded(object sender, RoutedEventArgs e) => checkSession();

        /// <summary>Comprueba si existe una sesion activa y si no existe la crea</summary>
        private void checkSession() {

            /*if (!Globals.sessionStatus) { MessageBox.Show("Iniciar sesion"); }
            else { MessageBox.Show("Cargar Datos"); }*/
        }

        /// <summary>Sale de la aplicacion</summary>
        /// <param name="sender">Elemento que realiza la accion</param>
        /// <param name="e">Parametros de la accion</param>
        private void btn_exit_Click(object sender, RoutedEventArgs e) => this.Close();


        private void btn_home_Click(object sender, RoutedEventArgs e) { /* cont_pages */ }

        private void btn_json_Click(object sender, RoutedEventArgs e) { /* cont_pages */ }

        private void btn_db_Click(object sender, RoutedEventArgs e) { /* cont_pages */ }

        private void btn_user_Click(object sender, RoutedEventArgs e) { /* cont_pages */ }
    }
}