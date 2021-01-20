using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Windows;
using System.Windows.Controls;
using Newtonsoft.Json;

namespace _26_Manejo_Datos.Components {

    public partial class Json_Gest : UserControl {

        private string jsonPath = Environment.CurrentDirectory + "/data/sensores.json";
        private string json = null;
        private List<Sensor> mediciones = null;
        private int indiceList = 0;
        private Sensor currentReg = null, registro = null;

        /// <summary>Carga los componentes de la ventana</summary>
        public Json_Gest() => InitializeComponent();

        /// <summary>Carga los datos iniciales de la ventana</summary>
        /// <param name="sender">Elemento que realiza la accion</param>
        /// <param name="e">Parametros de la accion</param>
        private void UserControl_Loaded(object sender, RoutedEventArgs e) {

            vaciarFormulario();

            try {

                json = File.ReadAllText(jsonPath);
                mediciones = JsonConvert.DeserializeObject<List<Sensor>>(json);
                registro = mediciones.ElementAt(indiceList);
                visualizarRegistros(registro);
            } 
            catch (Exception err) { MessageBox.Show("Error al cargar el fichero. Pongase en contacto con el administrador."); }
        }

        /// <summary>Muestra el primer registro</summary>
        /// <param name="sender">Elemento que realiza la accion</param>
        /// <param name="e">Parametros de la accion</param>
        private void btn_first_reg_Click(object sender, RoutedEventArgs e) {

            indiceList = 0;
            registro = mediciones.ElementAt(indiceList);
            visualizarRegistros(registro);
        }

        /// <summary>Muestra el registro anterior</summary>
        /// <param name="sender">Elemento que realiza la accion</param>
        /// <param name="e">Parametros de la accion</param>
        private void btn_previous_reg_Click(object sender, RoutedEventArgs e) {

            indiceList = ((indiceList - 1) < 0) ? 0 : indiceList - 1;
            registro = mediciones.ElementAt(indiceList);
            visualizarRegistros(registro);
        }

        /// <summary>Muestra el siguiente registro</summary>
        /// <param name="sender">Elemento que realiza la accion</param>
        /// <param name="e">Parametros de la accion</param>
        private void btn_next_reg_Click(object sender, RoutedEventArgs e) {

            indiceList = ((indiceList + 1) > (mediciones.Count - 1)) ? (mediciones.Count - 1) : indiceList + 1;
            registro = mediciones.ElementAt(indiceList);
            visualizarRegistros(registro);
        }

        /// <summary>Muestra el ultimo registro</summary>
        /// <param name="sender">Elemento que realiza la accion</param>
        /// <param name="e">Parametros de la accion</param>
        private void btn_last_reg_Click(object sender, RoutedEventArgs e) {

            indiceList = mediciones.Count - 1;
            registro = mediciones.ElementAt(indiceList);
            visualizarRegistros(registro);
        }

        private void btn_delete_reg_Click(object sender, RoutedEventArgs e) {}

        private void btn_save_reg_Click(object sender, RoutedEventArgs e) {}

        private void btn_new_reg_Click(object sender, RoutedEventArgs e) {}

        /// <summary>Limpia los campos del formulario</summary>
        private void vaciarFormulario() {

            tb_json_id.Text = "";
            tb_json_descripcion.Text = "";
            tb_json_fecha.Text = "";
            tb_json_hora.Text = "";
            tb_json_latitud.Text = "";
            tb_json_longitud.Text = "";
            tb_json_humedad.Text = "";
            tb_json_temperatura.Text = "";
        }

        /// <summary>Muestra los registros de un sensor en los campos del formulario</summary>
        /// <param name="r">Registros del sensor</param>
        private void visualizarRegistros(Sensor r) {

            currentReg = r;

            tb_json_id.Text = r.Id.ToString();
            tb_json_descripcion.Text = r.DescripcionSensor.ToString();
            tb_json_fecha.Text = r.Fecha.ToString();
            tb_json_hora.Text = r.Hora.ToString();
            tb_json_latitud.Text = r.Latitud.ToString();
            tb_json_longitud.Text = r.Longitud.ToString();
            tb_json_humedad.Text = r.Humedad.ToString();
            tb_json_temperatura.Text = r.Temperatura.ToString();
        }
    }
}