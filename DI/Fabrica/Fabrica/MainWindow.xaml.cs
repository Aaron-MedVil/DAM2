using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Input;

namespace Fabrica {

    public partial class MainWindow : Window {

        private Modelo.FabricaSql fabricaSql = new Modelo.FabricaSql();
        private DataTable tablaMateriasPrimas = null;
        private DataRow[] filas = null;

        /// <summary>Funcion que carga los componentes de la pagina</summary>
        public MainWindow() => InitializeComponent();

        /// <summary>Carga los datos iniciales</summary>
        /// <param name="sender">Objeto que lanza la accion</param>
        /// <param name="e">Parametros del evento</param>
        private void Window_Loaded(object sender, RoutedEventArgs e) {

            Dictionary<String, dynamic> resultConn = new Dictionary<string, dynamic>();
            resultConn = fabricaSql.checkConn();

            if ((bool)resultConn["status"]) {

                Dictionary<String, dynamic> result = new Dictionary<string, dynamic>();
                result = fabricaSql.cargaDatosMateriasPrimas(null);

                if ((bool)result["status"]) {

                    tablaMateriasPrimas = (DataTable)result["data"];
                    filas = tablaMateriasPrimas.Select("id > 0");
                    visualizaRegistro(filas[0]);
                } else { MessageBox.Show(result["msg"]); }
            } else { MessageBox.Show(resultConn["msg"]); }
        }

        /// <summary>Visualiza los datos en la interfaz</summary>
        /// <param name="registro">Registros</param>
        public void visualizaRegistro(DataRow registro) {

            cId.Text          = registro["id"].ToString();
            cDescripcion.Text = registro["descripcion"].ToString();
            cProveedor.Text   = registro["idProveedor"].ToString();
            cFamilia.Text     = registro["idFamilia"].ToString();
            cStock.Text       = registro["stock"].ToString();
            cStockMinimo.Text = registro["stockMinimo"].ToString();
            cPrecioCoste.Text = registro["precioCoste"].ToString();
            cTImagen.Text     = registro["rutaImagen"].ToString();

            cDescripcion.Focus();
        }

        private void SiguienteRegistro(object sender, RoutedEventArgs e) {}

        private void AnterioreRegistro(object sender, RoutedEventArgs e) {}

        private void PrimerRegistro(object sender, RoutedEventArgs e) {}

        private void UltimoRegistro(object sender, RoutedEventArgs e) {}

        private void NuevoRegistro(object sender, RoutedEventArgs e) {}

        private void GrabarRegistro(object sender, RoutedEventArgs e) {}

        private void BorrarRegistro(object sender, RoutedEventArgs e) {}

        private void BuscarRegistro(object sender, RoutedEventArgs e) {}

        private void BuscarRegistroSiguiente(object sender, MouseButtonEventArgs e) {}
    }
}
