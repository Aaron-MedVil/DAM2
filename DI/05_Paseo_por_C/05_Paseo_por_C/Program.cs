using System;

namespace _05_Paseo_por_C {

    class Program {

        static void Main(string[] args) {

            Punto p = new Punto(123, 456);

            p.visualizarPunto();
            var s = Console.ReadKey();
        }
    }
}
