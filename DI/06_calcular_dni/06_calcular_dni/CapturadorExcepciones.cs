using System;
using System.Collections.Generic;
using System.Text;

namespace _06_calcular_dni {
    class CapturadorExcepciones : Exception {

        public CapturadorExcepciones() {}

        public CapturadorExcepciones(string message) : base(message) {
            Console.ForegroundColor = ConsoleColor.Red;
            Console.WriteLine(message);
            Console.ForegroundColor = ConsoleColor.White;
        }
    }
}
