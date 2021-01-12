using System;
using System.Collections.Generic;

#nullable disable

namespace _25_EFCS
{
    public partial class MateriasPrima
    {
        public int Id { get; set; }
        public string Descripcion { get; set; }
        public int? IdProveedor { get; set; }
        public int? IdFamilia { get; set; }
        public int? Stock { get; set; }
        public int? StockMinimo { get; set; }
        public double? PrecioCoste { get; set; }
        public string RutaImagen { get; set; }
        public byte[] Imagen { get; set; }

        public virtual Familium IdFamiliaNavigation { get; set; }
    }
}
