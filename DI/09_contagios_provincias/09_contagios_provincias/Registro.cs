using System;
using System.Collections.Generic;
using System.Text;

namespace _09_contagios_provincias {
    class Registro {

        // Enum de provincias
        public enum provincias { BURGOS, SORIA, AVILA, VALLADOLID, SEGOVIA, LEON, SALAMANCA, ZAMORA };

        // Busca el indice del enum de la provincia que se inserta
        public int obtenerIndice(string nProvincia) {

            int nn = (int)(Enum.Parse(typeof(provincias), nProvincia));
            return nn;
        }
    }
}
