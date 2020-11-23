using System.Windows;

namespace _20_editor_texto {

    public partial class MainWindow : Window {

        private GestDoc gestDoc;

        private string theme = "light";
        public string? nomDocumento;

        /// <summary>Funcion para cargar los componentes de la ventana</summary>
        public MainWindow() => InitializeComponent();

        /// <summary>Funcion que se ejecuta cuando se carga la ventana</summary>
        /// <param name="sender">Objeto que produce el evento</param>
        /// <param name="e">Objeto con la informacion del evento</param>
        private void mainWindowOnLoad(object sender, RoutedEventArgs e) {}
    }
}