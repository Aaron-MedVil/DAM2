using System;
using System.Collections.Generic;
using System.Text;

namespace _08_comprobar_temperatura {

    class Pistola {

        private int temperatura;

        /**
         * [Propiedad que calcula el resultado mediante la temperatura]
        */
        public string trabajo {

            get {

                if ( temperatura == -1 ) {

                    // Cambia el color del texto de la consola a amarillo
                    Console.ForegroundColor = ConsoleColor.Yellow;
                    return "Error de temperatura";
                } else if (temperatura < 35) {

                    // Cambia el color del texto de la consola a azul
                    Console.ForegroundColor = ConsoleColor.Blue;
                    return "Temperatura muy Fría";
                } else if (temperatura > 37) {

                    // Cambia el color del texto de la consola a rojo
                    Console.ForegroundColor = ConsoleColor.Red;
                    return "Venga chaval, a tu casa";
                } else {

                    // Cambia el color del texto de la consola a verde
                    Console.ForegroundColor = ConsoleColor.Green;
                    return "A tu clase";
                }
            } set { try { temperatura = int.Parse(value); } catch { temperatura = -1; } }
        }
    }
}