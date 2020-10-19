using System;

namespace _12_tratamiento_errores {

    class Program {

        static void Main(string[] args) {

            Console.WriteLine("---------- Capturando errores ----------");

            // Manejo de rrores 1
            try {
                int nn = 0;
                nn = 4 / nn;
            } catch (Exception e) { Console.WriteLine(e.Message); }

            // Manejo de errores 2
            try {

                String diaSemana = "Lunes";

                if (diaSemana.ToUpper().IndexOf("L") >= 0) {
                    throw new CapturadorExcepciones("No me gustan los lunes");
                }
            } catch (Exception e) { Console.WriteLine(e.Message); }
        }
    }
}
