using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Windows;
using System.Windows.Controls;
using Newtonsoft.Json;

namespace _26_Manejo_Datos.Components {

    public partial class Json_Gest : UserControl {

        private PdfGenerator pdfGenerator = new PdfGenerator();
        private List<Sensor> mediciones = null;
        private Sensor registro = null;
        private string jsonPath = Environment.CurrentDirectory + "/data/sensores.json";
        private string pdfName = Environment.CurrentDirectory + "/docs/sensores.pdf";
        private string json = null;
        private int indiceList;
        private bool nuevo = false;

        /// <summary>Carga los componentes de la ventana</summary>
        public Json_Gest() => InitializeComponent();

        /// <summary>Carga los datos iniciales de la ventana</summary>
        /// <param name="sender">Elemento que realiza la accion</param>
        /// <param name="e">Parametros de la accion</param>
        private void UserControl_Loaded(object sender, RoutedEventArgs e) => cargarDefReg();

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

        /// <summary>Elimina el registro actual</summary>
        /// <param name="sender">Elemento que realiza la accion</param>
        /// <param name="e">Parametros de la accion</param>
        private void btn_delete_reg_Click(object sender, RoutedEventArgs e) {

            // Eliminar registro actual y guardarlo en el fichero json
            mediciones.Remove((Sensor)mediciones.ElementAt(indiceList));

            // Guarda el registro actual en el fichero JSON
            string newJson = JsonConvert.SerializeObject(mediciones);
            File.WriteAllText(jsonPath, newJson);

            // Aqui vuelve a cargar los datos iniciales
            cargarDefReg();

            MessageBox.Show("Registro eliminado correctamente");
        }

        /// <summary>Crea/Edita un registro</summary>
        /// <param name="sender">Elemento que realiza la accion</param>
        /// <param name="e">Parametros de la accion</param>
        private void btn_save_reg_Click(object sender, RoutedEventArgs e) {

            // Edita un registro actual
            if (!nuevo) {

                // Obtiene los datos editados del registro
                mediciones.ElementAt(indiceList).Id = int.Parse(tb_json_id.Text.ToString());
                mediciones.ElementAt(indiceList).DescripcionSensor = tb_json_descripcion.Text.ToString();
                mediciones.ElementAt(indiceList).Fecha = tb_json_fecha.Text.ToString();
                mediciones.ElementAt(indiceList).Hora = tb_json_hora.Text.ToString();
                mediciones.ElementAt(indiceList).Latitud = tb_json_latitud.Text.ToString();
                mediciones.ElementAt(indiceList).Longitud = tb_json_longitud.Text.ToString();
                mediciones.ElementAt(indiceList).Humedad = float.Parse(tb_json_humedad.Text.ToString());
                mediciones.ElementAt(indiceList).Temperatura = float.Parse(tb_json_temperatura.Text.ToString());

                // Guarda el registro actual en el fichero JSON
                string newJson = JsonConvert.SerializeObject(mediciones);
                File.WriteAllText(jsonPath, newJson);

                // Visualiza el registro que hemos editado
                registro = mediciones.ElementAt(indiceList);
                visualizarRegistros(registro);

                MessageBox.Show("Registro editado correctamente");
            }

            // Crea un registro nuevo
            else {

                /* ========== Comprobar si los campos no estan vacios y que los datos de los campos son correctos ========== */

                // Crea el registro en la lista mediciones
                Sensor newSensor = new Sensor() {
                    Id = int.Parse(tb_json_id.Text.ToString()),
                    DescripcionSensor = tb_json_descripcion.Text.ToString(),
                    Fecha = tb_json_fecha.Text.ToString(),
                    Hora = tb_json_hora.Text.ToString(),
                    Latitud = tb_json_latitud.Text.ToString(),
                    Longitud = tb_json_longitud.Text.ToString(),
                    Humedad = float.Parse(tb_json_humedad.Text.ToString()),
                    Temperatura = float.Parse(tb_json_temperatura.Text.ToString())
                };
                mediciones.Add(newSensor);

                // Guarda el registro actual en el fichero JSON
                string newJson = JsonConvert.SerializeObject(mediciones);
                File.WriteAllText(jsonPath, newJson);

                // Visualiza el registro que hemos creado
                indiceList = mediciones.Count - 1;
                registro = mediciones.ElementAt(indiceList);
                visualizarRegistros(registro);

                MessageBox.Show("Registro creado correctamente");
            }
        }

        /// <summary>Vacia los campos del formulario y </summary>
        /// <param name="sender">Elemento que realiza la accion</param>
        /// <param name="e">Parametros de la accion</param>
        private void btn_new_reg_Click(object sender, RoutedEventArgs e) {

            nuevo = true;
            vaciarFormulario();
        }

        /// <summary>Sincroniza los datos de la aplicacion con los datos del fichero JSON</summary>
        /// <param name="sender">Elemento que realiza la accion</param>
        /// <param name="e">Parametros de la accion</param>
        private void btn_update_reg_Click(object sender, RoutedEventArgs e) => cargarDefReg();

        /// <summary>Llama al metodo que genera el fichero pdf</summary>
        /// <param name="sender">Elemento que realiza la accion</param>
        /// <param name="e">Parametros de la accion</param>
        private void btn_generar_pdf_Click(object sender, RoutedEventArgs e) => pdfGenerator.pdfJSON(mediciones, pdfName);

        /// <summary>Muestra los registros de un sensor en los campos del formulario</summary>
        /// <param name="r">Registros del sensor</param>
        private void visualizarRegistros(Sensor r) {

            nuevo = false;

            tb_json_id.Text = r.Id.ToString();
            tb_json_descripcion.Text = r.DescripcionSensor.ToString();
            tb_json_fecha.Text = r.Fecha.ToString();
            tb_json_hora.Text = r.Hora.ToString();
            tb_json_latitud.Text = r.Latitud.ToString();
            tb_json_longitud.Text = r.Longitud.ToString();
            tb_json_humedad.Text = r.Humedad.ToString();
            tb_json_temperatura.Text = r.Temperatura.ToString();
        }

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

        /// <summary>Carga el fichero JSON y carga el primer registro</summary>
        private void cargarDefReg() {

            vaciarFormulario();
            indiceList = 0;
            nuevo = false;

            try {

                json = File.ReadAllText(jsonPath);
                mediciones = JsonConvert.DeserializeObject<List<Sensor>>(json);
                registro = mediciones.ElementAt(indiceList);
                visualizarRegistros(registro);
            } catch (Exception err) { MessageBox.Show("Error al cargar el fichero. Pongase en contacto con el administrador."); }
        }
    }
}