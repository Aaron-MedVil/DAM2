using Microsoft.EntityFrameworkCore;
using System.Windows;
using System.Windows.Data;

namespace _25_EFCS {

    public partial class MainWindow : Window {

        private readonly FabricaContext _context = new FabricaContext();
        private CollectionViewSource proveedoresViewSource;

        /// <summary>Funcion que se carga los componentes de la ventana</summary>
        public MainWindow() => InitializeComponent();

        /// <summary>Funcion quese ejecuta al cargarse los componentes de la ventana</summary>
        /// <param name="sender">Elemento que realiza la accion</param>
        /// <param name="e">Parametros de la accion</param>
        private void Window_Loaded(object sender, RoutedEventArgs e) {

            // Crea un elemento de coleccion de datos
            proveedoresViewSource = (CollectionViewSource)FindResource(nameof(proveedoresViewSource));

            // Crea la conexion a la base de datos con la cadena de conexion del fichero FabricaContext.cs
            _context.Database.EnsureCreated();

            // Carga en la conexion los datos de proveedores
            _context.Proveedores.Load();

            // bind to the source
            proveedoresViewSource.Source = _context.Proveedores.Local.ToObservableCollection();
        }

        /// <summary>Metodo para mostrar el formulario con los datos del registro</summary>
        /// <param name="sender">Elemento que realiza la accion</param>
        /// <param name="e">Parametros de la accion</param>
        private void VisualizarRegistro_Click(object sender, RoutedEventArgs e) {

            if (Formulario.Visibility == Visibility) { Formulario.Visibility = Visibility.Hidden; }
            else { Formulario.Visibility = Visibility; }
        }
    }
}