using System;
using System.Windows;
using System.Windows.Controls;

namespace _20_editor_texto {

    public partial class VentanaGoesBrrrr : Window {

        public string accion = String.Empty;

        public VentanaGoesBrrrr() => InitializeComponent();

        private void Salir_Click(object sender, RoutedEventArgs e) {

            Button bb = (Button)sender;
            accion = (bb.Name == "Cancelar") ? "Cancelar" : "Ejecutar";
            this.Close();
        }
    }
}