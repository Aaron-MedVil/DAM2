using System;

namespace _06_calcular_dni {

    /**
     * [Clase propiedades]
    */
    class propiedades {

        private string clave;

        // Constructor vacio (No es necesario)
        public propiedades() { }

        // Metodo para comprobar que un dni sea correcto
        public String comprobanteDni {

            get {

                // Comprobamos que no se produzca ningun error al comprobar el dni
                try {

                    // Comprobamos que lalongitud del dni es la correcta
                    if (clave.Length == 9) {

                        // Separamos la letra y los números del DNI
                        string letra = clave.Substring(clave.Length - 1, 1).ToUpper();
                        int numero = int.Parse(clave.Substring(0, clave.Length - 1));

                        // Calculamos el resto de dividir los números del DNI por 23
                        var restoDNI = numero % 23;

                        // Array que contiene las letras para los DNI
                        string[] letras = {"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};

                        // Comprobamos si la letra del DNI insertado es correcta
                        String result = (letra.Equals(letras[restoDNI])) ? "DNI correcto" : $"EL formato del DNI es incorrecto. La letra correcta sería {letras[restoDNI]}";

                        return result;
                    } else { return "La longitud del DNI es incorrecta"; }
                } catch (Exception e) { return e.Message; }
            } set { clave = value; }
        }
    }
}