using System;
using System.Collections.Generic;
using System.Text;

namespace _23_rw_json {

    class Productos {

        private int idArticulo, stock, stockMinimo;
        private string descripcion, urlImagen;
        private float tiempoFabricacionAcumulado;

        public int Id_Articulo {
            get => idArticulo;
            set => idArticulo = value;
        }
        
        public int Stock {
            get => stock;
            set => stock = value;
        }
        
        public int StockMinimo {
            get => stockMinimo;
            set => stockMinimo = value;
        }
        
        public String Descripcion {
            get => descripcion;
            set => descripcion = value;
        }
        
        public String UrlImagen {
            get => urlImagen;
            set => urlImagen = value;
        }
        
        public float TiempoFabricacionAcumulado {
            get => tiempoFabricacionAcumulado;
            set => tiempoFabricacionAcumulado = value;
        }
    }
}