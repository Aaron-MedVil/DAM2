using System;

namespace _07_otra_propiedad {

    class Program {

        static void Main(string[] args) {

            Console.WriteLine("---------- Uso de propiedades ----------");

            PropiedadEdad pe = new PropiedadEdad();

            pe.tEdad = 55;
            Console.WriteLine($"La edad es {pe.tEdad}");
        }
    }
}