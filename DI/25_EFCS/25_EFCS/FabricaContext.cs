using System;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata;

#nullable disable

namespace _25_EFCS {

    public partial class FabricaContext : DbContext {

        public FabricaContext() {}

        public FabricaContext(DbContextOptions<FabricaContext> options) : base(options) {}

        public virtual DbSet<Familium> Familia { get; set; }
        public virtual DbSet<MateriasPrima> MateriasPrimas { get; set; }
        public virtual DbSet<Proveedore> Proveedores { get; set; }

        /// <summary>Configuracuion de la conexion a la base de datos</summary>
        /// <param name="optionsBuilder"></param>
        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder) {

            if (!optionsBuilder.IsConfigured) {

                /* #warning To protect potentially sensitive information in your connection string, you should move it out of source code.
                 * You can avoid scaffolding the connection string by using the Name= syntax to read it from configuration -
                 * see https://go.microsoft.com/fwlink/?linkid=2131148.
                 * For more guidance on storing connection strings, see http://go.microsoft.com/fwlink/?LinkId=723263. */
                optionsBuilder.UseSqlServer("Data Source=127.0.0.1,1433;Initial Catalog=Fabrica;User ID=SA;Password=sa_sa_2018@2018sa;");
            }
        }

        /// <summary>Propiedades de las tablas de la base de datos</summary>
        /// <param name="modelBuilder"></param>
        protected override void OnModelCreating(ModelBuilder modelBuilder) {

            modelBuilder.HasAnnotation("Relational:Collation", "SQL_Latin1_General_CP1_CI_AS");

            // Tabla de familias
            modelBuilder.Entity<Familium>(entity => {
                entity.Property(e => e.Id).HasColumnName("id");

                entity.Property(e => e.Descripcion)
                    .HasMaxLength(50)
                    .IsUnicode(false);
            });

            // Tabla de materias primas
            modelBuilder.Entity<MateriasPrima>(entity => {
                entity.Property(e => e.Id).HasColumnName("id");

                entity.Property(e => e.Descripcion)
                    .HasMaxLength(50)
                    .IsUnicode(false);

                entity.Property(e => e.IdFamilia).HasColumnName("idFamilia");

                entity.Property(e => e.IdProveedor).HasColumnName("idProveedor");

                entity.Property(e => e.Imagen)
                    .HasColumnType("image")
                    .HasColumnName("imagen");

                entity.Property(e => e.PrecioCoste).HasColumnName("precioCoste");

                entity.Property(e => e.RutaImagen)
                    .HasMaxLength(100)
                    .IsUnicode(false)
                    .HasColumnName("rutaImagen");

                entity.Property(e => e.Stock).HasColumnName("stock");

                entity.Property(e => e.StockMinimo).HasColumnName("stockMinimo");

                entity.HasOne(d => d.IdFamiliaNavigation)
                    .WithMany(p => p.MateriasPrimas)
                    .HasForeignKey(d => d.IdFamilia)
                    .OnDelete(DeleteBehavior.Cascade)
                    .HasConstraintName("FK_Familia");
            });

            // Tabla de proveedores
            modelBuilder.Entity<Proveedore>(entity => {
                entity.Property(e => e.Id).HasColumnName("id");

                entity.Property(e => e.Cp)
                    .HasMaxLength(5)
                    .IsUnicode(false)
                    .HasColumnName("cp");

                entity.Property(e => e.Direccion)
                    .HasMaxLength(50)
                    .IsUnicode(false)
                    .HasColumnName("direccion");

                entity.Property(e => e.Email)
                    .HasMaxLength(150)
                    .IsUnicode(false)
                    .HasColumnName("email");

                entity.Property(e => e.Nif)
                    .HasMaxLength(9)
                    .IsUnicode(false)
                    .HasColumnName("nif");

                entity.Property(e => e.Nombre)
                    .HasMaxLength(50)
                    .IsUnicode(false)
                    .HasColumnName("nombre");

                entity.Property(e => e.PedientePago).HasColumnName("pedientePago");

                entity.Property(e => e.Poblacion)
                    .HasMaxLength(50)
                    .IsUnicode(false)
                    .HasColumnName("poblacion");

                entity.Property(e => e.Provincia)
                    .HasMaxLength(30)
                    .IsUnicode(false)
                    .HasColumnName("provincia");

                entity.Property(e => e.Telefonos)
                    .HasMaxLength(15)
                    .IsUnicode(false)
                    .HasColumnName("telefonos");

                entity.Property(e => e.TotalFacturado).HasColumnName("totalFacturado");

                entity.Property(e => e.Web)
                    .HasMaxLength(150)
                    .IsUnicode(false)
                    .HasColumnName("web");
            });

            OnModelCreatingPartial(modelBuilder);
        }

        partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
    }
}
