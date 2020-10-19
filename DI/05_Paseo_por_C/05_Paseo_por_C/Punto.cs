using System;
using System.Collections.Generic;
using System.Text;

namespace _05_Paseo_por_C
{
    class Punto {

        private int x, y;

        public Punto(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void visualizarPunto() {
            Console.WriteLine("Coordenadas punto: {0},{1}", x, y);
        }
    }
}
