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

            proveedoresViewSource = (CollectionViewSource)FindResource(nameof(proveedoresViewSource));

            _context.Database.EnsureCreated();

            // load the entities into EF Core
            _context.Proveedores.Load();

            // bind to the source
            proveedoresViewSource.Source = _context.Proveedores.Local.ToObservableCollection();
        }
    }
}