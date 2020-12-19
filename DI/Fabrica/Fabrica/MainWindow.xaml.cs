using System;
using System.Collections.Generic;
using System.Data;
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

            Dictionary<string, dynamic> resultConn = new Dictionary<string, dynamic>();
            resultConn = fabricaSql.checkConn();

            if ((bool)resultConn["status"]) {

                Dictionary<string, dynamic> result = new Dictionary<string, dynamic>();
                result = fabricaSql.cargaDatosMateriasPrimas(null);

                if ((bool)result["status"]) {

                    tablaMateriasPrimas = (DataTable)result["data"];
                    filas = tablaMateriasPrimas.Select("id > 0");
                    visualizaRegistro(filas[0]);
                } else { MessageBox.Show(result["msg"]); }
            } else { MessageBox.Show(resultConn["msg"]); }
        }

        /// <summary>Visualiza los datos en la interfaz</summary>
        /// <param name="registro">Registros de la base de datos</param>
        private void visualizaRegistro(DataRow registro) {

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

        /// <summary></summary>
        /// <param name="sender">Objeto que lanza la accion</param>
        /// <param name="e">Parametros del evento</param>
        private void SiguienteRegistro(object sender, RoutedEventArgs e) {
            MessageBox.Show("SiguienteRegistro");
        }

        /// <summary></summary>
        /// <param name="sender">Objeto que lanza la accion</param>
        /// <param name="e">Parametros del evento</param>
        private void AnterioreRegistro(object sender, RoutedEventArgs e) {
            MessageBox.Show("AnterioreRegistro");
        }

        /// <summary></summary>
        /// <param name="sender">Objeto que lanza la accion</param>
        /// <param name="e">Parametros del evento</param>
        private void PrimerRegistro(object sender, RoutedEventArgs e) {
            MessageBox.Show("PrimerRegistro");
        }

        /// <summary></summary>
        /// <param name="sender">Objeto que lanza la accion</param>
        /// <param name="e">Parametros del evento</param>
        private void UltimoRegistro(object sender, RoutedEventArgs e) {
            MessageBox.Show("UltimoRegistro");
        }

        /// <summary></summary>
        /// <param name="sender">Objeto que lanza la accion</param>
        /// <param name="e">Parametros del evento</param>
        private void NuevoRegistro(object sender, RoutedEventArgs e) {
            MessageBox.Show("NuevoRegistro");
        }

        /// <summary></summary>
        /// <param name="sender">Objeto que lanza la accion</param>
        /// <param name="e">Parametros del evento</param>
        private void GrabarRegistro(object sender, RoutedEventArgs e) {
            MessageBox.Show("GrabarRegistro");
        }

        /// <summary></summary>
        /// <param name="sender">Objeto que lanza la accion</param>
        /// <param name="e">Parametros del evento</param>
        private void BorrarRegistro(object sender, RoutedEventArgs e) {
            MessageBox.Show("BorrarRegistro");
        }

        /// <summary></summary>
        /// <param name="sender">Objeto que lanza la accion</param>
        /// <param name="e">Parametros del evento</param>
        private void BuscarRegistro(object sender, RoutedEventArgs e) {
            MessageBox.Show("BuscarRegistro");
        }

        /// <summary></summary>
        /// <param name="sender">Objeto que lanza la accion</param>
        /// <param name="e">Parametros del evento</param>
        private void BuscarRegistroSiguiente(object sender, MouseButtonEventArgs e) {
            MessageBox.Show("BuscarRegistroSiguiente");
        }
    }
}