using System;

namespace _06_calcular_dni {

    class Program {

        /**
         * [Clase principal]
        */
        static void Main(string[] args) {

            // Instanciamos la propiedad
            propiedades pcd = new propiedades();

            // Pedimos al usuario que inserte un número de DNI
            Console.WriteLine("Introduzca un DNI con formato 12345678X:");
            String dni = Console.ReadLine();

            // Comprobamos si es correcto el DNI insertado
            Console.WriteLine($"¿Es correcto el dni {dni}?");
            pcd.comprobanteDni = dni;
            Console.WriteLine($"{pcd.comprobanteDni}");
        }
    }
}