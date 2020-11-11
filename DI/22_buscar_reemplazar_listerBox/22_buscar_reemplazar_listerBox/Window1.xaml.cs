using System;
using System.Windows;
using System.Windows.Controls;

namespace _22_buscar_reemplazar_listerBox {

    public partial class Window1 : Window {

        public string accion= String.Empty;

        public Window1() => InitializeComponent();

        // Acciones de los botones
        private void Button_Click_Close(object sender, RoutedEventArgs e) {

            Button bb = new Button();
            bb = (Button)e.Source;

            accion = (bb.Name == "Cancelar") ? "Cancelar" : "Ejecutar";

            this.Close();
        }
    }
}
