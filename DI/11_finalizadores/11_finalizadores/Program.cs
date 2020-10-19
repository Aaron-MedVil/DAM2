using System;

namespace _11_finalizadores {

    class Primero {
        ~Primero() {
            System.Diagnostics.Trace.WriteLine("Llamada a primer Destructor");
        }
    }

    class Segundo : Primero {
        ~Segundo() {
            System.Diagnostics.Trace.WriteLine("Llamada a Segundo Destructor");
        }
    }

    class Tercero : Segundo {
        ~Tercero() {
            System.Diagnostics.Trace.WriteLine("Llamada a Tercer Destructor ");
        }
    }
    class TestDestructors {
        static void Main() {
            Tercero t = new Tercero();
        }
    }
}
