using System;
using System.Collections.Generic;

#nullable disable

namespace _25_EFCS
{
    public partial class Familium
    {
        public Familium()
        {
            MateriasPrimas = new HashSet<MateriasPrima>();
        }

        public int Id { get; set; }
        public string Descripcion { get; set; }

        public virtual ICollection<MateriasPrima> MateriasPrimas { get; set; }
    }
}
