using System;
using System.Collections.Generic;
using System.Text;

namespace _07_otra_propiedad {

    class PropiedadEdad {

        private int edad;

        public int tEdad {

            get {

                if (edad < 50)
                    Console.WriteLine("Tu edad no es menor de 50");
                    edad = 0;

                return edad;
            }
            set { this.edad = (value < 50) ? 0 : value; }
        }
    }
}