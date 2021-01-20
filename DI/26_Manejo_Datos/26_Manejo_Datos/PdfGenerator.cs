using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Windows;
using iTextSharp.text;
using iTextSharp.text.pdf;

namespace _26_Manejo_Datos {

    class PdfGenerator {

        private Rectangle PageSize = new Rectangle(700f, 1024f);

        /// <summary>Genera el fichero PDF del JSON</summary>
        /// <param name="mediciones">Datos que guardaremos en el pdf</param>
        public void pdfJSON(List<Sensor> mediciones, string pdfName) {

            string[] nomCols = new string[] { "Id", "Sensor", "Fecha", "Hora", "Humedad", "Temperatura" };
            float[] anchoColumnas = new float[] { 50f, 250f, 100f, 100f, 75f, 75f };
            float yPos = 920f;

            try {

                // Crea el fichero PDF y lo abre
                FileStream fs = new FileStream(pdfName, FileMode.Create, FileAccess.Write, FileShare.None);
                Document doc = new Document(PageSize);
                PdfWriter writer = PdfWriter.GetInstance(doc, fs);
                doc.Open();

                /* ========== CABECERA ========== */
                BaseColor foregroundTitle = new BaseColor(0, 210, 120);
                Font fontTitle = FontFactory.GetFont(FontFactory.HELVETICA, 24f, Font.BOLD, foregroundTitle);
                Chunk chkTitle = new Chunk("Listado Sensores", fontTitle);
                Phrase textTitle = new Phrase(0f, chkTitle);
                doc.Add(new Paragraph(textTitle));

                /* ========== TABLA DE CABECERA ========== */
                PdfPTable titulos = new PdfPTable(nomCols.Length) {
                    DefaultCell = {
                        HorizontalAlignment = Element.ALIGN_CENTER,
                        VerticalAlignment = Element.ALIGN_CENTER,
                        BackgroundColor = new BaseColor(199, 226, 226)
                    }
                };

                // Asignar el array de anchos de columna a la tabla
                titulos.SetTotalWidth(anchoColumnas);
                foreach (string col in nomCols) { titulos.AddCell(col); }
                titulos.WriteSelectedRows(0, -1, 10f, 940f, writer.DirectContent);

                /* ========== TABLA DE DATOS ========== */
                PdfPTable datos = new PdfPTable(nomCols.Length) {
                    DefaultCell = {
                        HorizontalAlignment = Element.ALIGN_CENTER,
                        VerticalAlignment = Element.ALIGN_CENTER,
                    }
                };
                datos.SetTotalWidth(anchoColumnas);

                // Rellenamos la tabla de datos
                foreach (Sensor r in mediciones) {

                    datos.AddCell(r.Id.ToString());
                    datos.AddCell(r.DescripcionSensor.ToString());
                    datos.AddCell(r.Fecha.ToString());
                    datos.AddCell(r.Hora.ToString());
                    datos.AddCell(r.Temperatura.ToString());
                    datos.AddCell(r.Humedad.ToString());

                    // Asigna la posicion Y y resta el ancho de la columna para el siguiente registro
                    datos.WriteSelectedRows(0, -1, 10f, yPos, writer.DirectContent);

                    // Limpiamos los datos de la columna
                    datos = new PdfPTable(nomCols.Length) {
                        DefaultCell = {
                            HorizontalAlignment = Element.ALIGN_CENTER,
                            VerticalAlignment = Element.ALIGN_CENTER,
                        }
                    };
                    datos.SetTotalWidth(anchoColumnas);

                    if (yPos > 60) { yPos = yPos - 15; }
                    else {

                        yPos = 1000f - 20;

                        // Página nueva
                        doc.NewPage();
                        titulos.WriteSelectedRows(0, -1, 10f, 1000f, writer.DirectContent);
                    }
                }

                // Cierra el fichero
                doc.Close();

                // Muestra el fichero
                openPdf(pdfName);
            }
            catch (Exception err) { MessageBox.Show("Se ha producido un error al generar el fichero PDF"); }
        }

        /// <summary>Abre un fichero PDF</summary>
        /// <param name="pdfName">Ruta del fichero PDF</param>
        public void openPdf(string pdfName) {

            try {
                Process p = new Process();
                p.StartInfo = new ProcessStartInfo(@pdfName) { UseShellExecute = true };
                p.Start();
            }
            catch (Exception err) { MessageBox.Show("Error al abrir el fichero " + pdfName.ToString()); }
        }
    }
}