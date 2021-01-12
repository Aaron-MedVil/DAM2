using System;
using System.Collections.Generic;

#nullable disable

namespace _25_EFCS
{
    public partial class Proveedore
    {
        public int Id { get; set; }
        public string Nombre { get; set; }
        public string Nif { get; set; }
        public string Direccion { get; set; }
        public string Poblacion { get; set; }
        public string Provincia { get; set; }
        public string Cp { get; set; }
        public string Telefonos { get; set; }
        public string Email { get; set; }
        public string Web { get; set; }
        public double? TotalFacturado { get; set; }
        public double? PedientePago { get; set; }
    }
}
