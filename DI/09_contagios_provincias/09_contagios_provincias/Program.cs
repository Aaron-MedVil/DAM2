using System;

namespace _09_contagios_provincias {

    class Program {

        // Array de contagios
        public static Contagios[] contagios = new Contagios[9]; 

        // Metodo main
        static void Main(string[] args) {

            Console.WriteLine("Inserte el nombre de la provincia de CyL o Fin para terminar:");
            string nombreP = Console.ReadLine().ToUpper();

            Registro rr = new Registro();

            while (nombreP != "FIN") {

                int indice = rr.obtenerIndice(nombreP); ;

                contagios[indice].nombre = nombreP;

                contagios[indice].contagios = (contagios[indice].contagios > 0) ? contagios[indice].contagios++ : 1;

                Console.WriteLine($"Nº ingresos de la provincia {contagios[indice].nombre}: {contagios[indice].contagios}");

                Console.WriteLine("Inserte el nombre de la provincia de CyL o Fin para terminar:");
                nombreP = Console.ReadLine().ToUpper();
            }

            Console.WriteLine("Fin del programa");
        }
    }

    // Estructura
    public struct Contagios {

        public int contagios; public String nombre;

        // Constructor
        public Contagios(int nContagios, String sProvincia) {
            contagios = nContagios;
            nombre = sProvincia;
        }
    }
}