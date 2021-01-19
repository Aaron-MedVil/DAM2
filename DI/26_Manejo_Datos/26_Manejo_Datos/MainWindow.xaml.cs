using System;
using System.Windows;

namespace _26_Manejo_Datos {

    public partial class MainWindow : Window {

        /// <summary>Carga los componentes graficos de la aplicacion</summary>
        public MainWindow() => InitializeComponent();

        /// <summary>Carga los datos iniciales de la aplicacion</summary>
        /// <param name="sender">Elemento que realiza la accion</param>
        /// <param name="e">Parametros de la accion</param>
        private void Window_Loaded(object sender, RoutedEventArgs e) {
            cont_pages.Children.Clear();
            cont_pages.Children.Add(new Components.Home());
        }

        /// <summary>Carga la pagina home</summary>
        /// <param name="sender">Elemento que realiza la accion</param>
        /// <param name="e">Parametros de la accion</param>
        private void btn_home_Click(object sender, RoutedEventArgs e) {
            cont_pages.Children.Clear();
            cont_pages.Children.Add(new Components.Home());
        }

        /// <summary>Carga la pagina de gestion del fichero JSON</summary>
        /// <param name="sender">Elemento que realiza la accion</param>
        /// <param name="e">Parametros de la accion</param>
        private void btn_json_Click(object sender, RoutedEventArgs e) {

            if (!Globals.sessionStatus) {
                cont_pages.Children.Clear();
                cont_pages.Children.Add(new Components.Json_Gest());
            } else { MessageBox.Show("El usuario identificado no tiene acceso a esta parte del programa"); }
        }

        /// <summary>Carga la pagina de gestion de la base de datos</summary>
        /// <param name="sender">Elemento que realiza la accion</param>
        /// <param name="e">Parametros de la accion</param>
        private void btn_db_Click(object sender, RoutedEventArgs e) {

            if (Globals.sessionStatus) {
                cont_pages.Children.Clear();
                cont_pages.Children.Add(new Components.Db_Gest());
            }
            else { MessageBox.Show("El usuario identificado no tiene acceso a esta parte del programa"); }
        }

        /// <summary>Carga la pagina de usuario</summary>
        /// <param name="sender">Elemento que realiza la accion</param>
        /// <param name="e">Parametros de la accion</param>
        private void btn_user_Click(object sender, RoutedEventArgs e) {
            cont_pages.Children.Clear();
            cont_pages.Children.Add(new Components.User_Gest());
        }

        /// <summary>Sale de la aplicacion</summary>
        /// <param name="sender">Elemento que realiza la accion</param>
        /// <param name="e">Parametros de la accion</param>
        private void btn_exit_Click(object sender, RoutedEventArgs e) => Application.Current.Shutdown();

        /// <summary>Sale de la aplicacion</summary>
        /// <param name="sender">Elemento que realiza la accion</param>
        /// <param name="e">Parametros de la accion</param>
        private void Window_Closed(object sender, EventArgs e) => Application.Current.Shutdown();
    }
}