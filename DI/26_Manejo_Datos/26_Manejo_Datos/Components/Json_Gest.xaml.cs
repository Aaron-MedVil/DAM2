using System.Windows;
using System.Windows.Controls;

namespace _26_Manejo_Datos.Components {

    public partial class Json_Gest : UserControl {

        /// <summary>Carga los componentes de la ventana</summary>
        public Json_Gest() => InitializeComponent();

        /// <summary>Carga los datos iniciales de la ventana</summary>
        /// <param name="sender">Elemento que realiza la accion</param>
        /// <param name="e">Parametros de la accion</param>
        private void UserControl_Loaded(object sender, RoutedEventArgs e) {

            // Cargar fichero JSON y mostrar primer registro
        }
    }
}