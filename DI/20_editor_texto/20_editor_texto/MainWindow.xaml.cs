using System.Windows;
using System.Windows.Input;

namespace _20_editor_texto {

    public partial class MainWindow : Window {

        public MainWindow() {

            InitializeComponent();
            /* // Ventana completa
            WindowState = WindowState.Maximized;
            WindowStyle = WindowStyle.None;
            */

            for (int i = 0; i < 72; i = i + 4) {

                // Esto es un ComboBox que se va a rellenar
                // textSize.Items.add(i);
            }

            this.PreviewKeyDown += new KeyEventHandler(HandleEsc);
        }

        // Funcion para cerrar la aplicacion
        private void HandleEsc(object sender, KeyEventArgs e) { if (e.Key == Key.Escape) {Close();} }
    }
}