using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Text;
using System.Text.RegularExpressions;
using System.Windows;

namespace _26_Manejo_Datos {

    class Sensor : IDataErrorInfo {

        private int id;
        private string descripcionSensor, fecha, hora, latitud, longitud;
        private float humedad, temperatura;

        public int Id { get => id; set => id = value; }
        public string DescripcionSensor { get => descripcionSensor; set => descripcionSensor = value; }
        public string Fecha { get => fecha; set => fecha = value; }
        public string Hora { get => hora; set => hora = value; }
        public string Latitud { get => latitud; set => latitud = value; }
        public string Longitud { get => longitud; set => longitud = value; }
        public float Humedad { get => humedad; set => humedad = value; }
        public float Temperatura { get => temperatura; set => temperatura = value; }

        /* ========== VALIDACIONES DE ERRORES ========== */
        public string Error { get => null; }
        public string this[string name] {

            get {

                string result = null;

                switch (name) {
                    case "Id":
                        if (this.Id < 0 && this.Id > 99999) { result = "Id incorrecto"; }
                        break;
                    case "Descripcion":
                        break;
                }

                return result;
            }
        }
    }
}