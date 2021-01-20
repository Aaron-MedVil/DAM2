using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using iTextSharp.text;
using iTextSharp.text.pdf;

namespace _26_Manejo_Datos {

    class PdfGenerator {

        private Rectangle PageSize = new Rectangle(700f, 1024f);

        /// <summary>Genera el fichero PDF del JSON</summary>
        /// <param name="mediciones">Datos que guardaremos en el pdf</param>
        public void pdfJSON(List<Sensor> mediciones, string pdfName) {
            
            // Crea el fichero PDF y lo abre
            FileStream fs = new FileStream(pdfName, FileMode.Create, FileAccess.Write, FileShare.None);
            Document doc = new Document(PageSize);
            PdfWriter writer = PdfWriter.GetInstance(doc, fs);
            doc.Open();

            /* ========== CABECERA ========== */
            Chunk chkTitle = new Chunk("Listado Sensores", FontFactory.GetFont(FontFactory.HELVETICA, 24f, Font.BOLD, new BaseColor(0, 210, 120)));
            Phrase textotituloListado = new Phrase(18f, chkTitle);
            doc.Add(new Paragraph(textotituloListado));

            string[] nomCols = new string[] { "Id", "Sensor", "Fecha", "Hora", "Humedad", "Temperatura" };

            /* ========== TABLA DE CABECERA ========== */
            PdfPTable titulos = new PdfPTable(nomCols.Length) {
                DefaultCell = {
                    HorizontalAlignment = Element.ALIGN_CENTER,
                    VerticalAlignment = Element.ALIGN_CENTER,
                    BackgroundColor = new BaseColor(199, 226, 226)
                }
            };

            float[] anchoColumnas = new float[] { 50f, 250f, 100f, 100f, 75f, 75f };

            // Asignar el array de anchos de columna a la tabla
            titulos.SetTotalWidth(anchoColumnas);

            titulos.AddCell("Id");
            titulos.AddCell("Sensor");
            titulos.AddCell("Fecha");
            titulos.AddCell("Hora");
            titulos.AddCell("Humedad");
            titulos.AddCell("Temperatura");

            titulos.WriteSelectedRows(0, -1, 10f, 940f, writer.DirectContent);

            /* ========== TABLA DE DATOS ========== */
            PdfPTable datos = new PdfPTable(nomCols.Length) {
                DefaultCell = {
                    HorizontalAlignment = Element.ALIGN_CENTER,
                    VerticalAlignment = Element.ALIGN_CENTER,
                }
            };

            // Asignar el array de anchos de columna a la tabla
            datos.SetTotalWidth(anchoColumnas);

            int cf = 0;

            foreach (Sensor r in mediciones) {

                datos.AddCell(r.Id.ToString());
                datos.AddCell(r.DescripcionSensor.ToString());
                datos.AddCell(r.Fecha.ToString());
                datos.AddCell(r.Hora.ToString());
                datos.AddCell(r.Temperatura.ToString());
                datos.AddCell(r.Humedad.ToString());

                cf++;

                if (cf > 1) {

                    //Salto de página
                    datos.WriteSelectedRows(0, -1, 10f, 920f, writer.DirectContent);

                    // Borrar los datos de la PdfTable
                    datos = new PdfPTable(nomCols.Length);
                    datos.SetTotalWidth(anchoColumnas);

                    // Página nueva
                    doc.NewPage();

                    doc.Add(new Paragraph(textotituloListado));

                    titulos.WriteSelectedRows(0, -1, 10f, 940f, writer.DirectContent);
                }
            }

            datos.WriteSelectedRows(0, -1, 10f, 970f, writer.DirectContent);

            doc.Close();

            openPdf(pdfName);
        }

        /// <summary>Abre un fichero PDF</summary>
        /// <param name="pdfName">Ruta del fichero PDF</param>
        public void openPdf(string pdfName) {
            Process p = new Process();
            p.StartInfo = new ProcessStartInfo(@pdfName) { UseShellExecute = true };
            p.Start();
        }
    }
}