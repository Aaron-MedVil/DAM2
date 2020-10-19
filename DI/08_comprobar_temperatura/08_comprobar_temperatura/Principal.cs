using System;
using System.IO;

namespace _08_comprobar_temperatura {

    class Principal {

        static void Main(string[] args) {

            Pistola p = new Pistola();
            int bcl = 1;

            // Bucle para medir mas temperaturas
            while (bcl != 0) {

                // Mide la temperatura
                Console.Write("Inserte la temperatura medida:");
                String tt = Console.ReadLine();
                p.trabajo = tt;
                Console.WriteLine($"{p.trabajo}");

                // Pregunta al usuario si quiere seguir midiendo temperaturas
                Console.ForegroundColor = ConsoleColor.Magenta;
                Console.Write("¿Desea medir otra temperatura (0 para salir)?");
                try { bcl = Convert.ToInt32(Console.ReadLine()); } catch { bcl = 1; }

                // Devuelve el estilo predeterminado a la consola
                Console.ForegroundColor = ConsoleColor.White;
            }
        }
    }
}