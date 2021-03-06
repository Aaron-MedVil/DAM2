﻿using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Windows;
using iTextSharp.text;
using iTextSharp.text.pdf;

namespace _26_Manejo_Datos {

    class PdfGenerator {

        private Rectangle PageSize = new Rectangle(700f, 1024f);
        
        /// <summary>Genera un fichero PDF con los datos del JSON</summary>
        /// <param name="mediciones">Datos para completar el fichero PDF</param>
        /// <param name="pdfName">Nombre del fichero PDF</param>
        public void pdfJSON(List<Sensor> mediciones, string pdfName) {

            string[] nomCols = new string[] { "Id", "Sensor", "Fecha", "Hora", "Humedad", "Temperatura" };
            float[] anchoColumnas = new float[] { 50f, 250f, 100f, 100f, 75f, 75f };
            float yPos = 940f;

            try {

                // Crea el fichero PDF y lo abre
                FileStream fs = new FileStream(pdfName, FileMode.Create, FileAccess.Write, FileShare.None);
                Document doc = new Document(PageSize);
                PdfWriter writer = PdfWriter.GetInstance(doc, fs);
                doc.Open();

                /* ========== CABECERA ========== */
                BaseColor foregroundTitle = new BaseColor(28, 40, 51);
                Font fontTitle = FontFactory.GetFont(FontFactory.TIMES_ROMAN, 32f, Font.BOLD, foregroundTitle);
                Chunk chkTitle = new Chunk("LISTADO SENSORES", fontTitle);
                Phrase textTitle = new Phrase(0f, chkTitle);
                doc.Add(new Paragraph(textTitle));

                /* ========== TABLA DE CABECERA ========== */
                PdfPTable titulos = new PdfPTable(nomCols.Length) {
                    DefaultCell = {
                        HorizontalAlignment = Element.ALIGN_CENTER,
                        VerticalAlignment = Element.ALIGN_CENTER,
                        BackgroundColor = new BaseColor(173, 68, 99),
                        FixedHeight = 20f
                    }
                };
                titulos.SetTotalWidth(anchoColumnas);
                foreach (string col in nomCols) { titulos.AddCell(col); }
                titulos.WriteSelectedRows(0, -1, 10f, 940f, writer.DirectContent);

                /* ========== TABLA DE DATOS ========== */
                PdfPTable datos = new PdfPTable(nomCols.Length) {
                    DefaultCell = {
                        HorizontalAlignment = Element.ALIGN_CENTER,
                        VerticalAlignment = Element.ALIGN_CENTER,
                            FixedHeight = 20f
                    }
                };
                datos.SetTotalWidth(anchoColumnas);
                foreach (Sensor s in mediciones) {

                    if (yPos <= 60) {
                        yPos = 1000f - 20;
                        doc.NewPage();
                        titulos.WriteSelectedRows(0, -1, 10f, 1000f, writer.DirectContent);
                    } else { yPos = yPos - 20; }

                    datos.AddCell(s.Id.ToString());
                    datos.AddCell(s.DescripcionSensor.ToString());
                    datos.AddCell(s.Fecha.ToString());
                    datos.AddCell(s.Hora.ToString());
                    datos.AddCell(s.Temperatura.ToString());
                    datos.AddCell(s.Humedad.ToString());

                    datos.WriteSelectedRows(0, -1, 10f, yPos, writer.DirectContent);
                    datos = new PdfPTable(nomCols.Length) {
                        DefaultCell = {
                            HorizontalAlignment = Element.ALIGN_CENTER,
                            VerticalAlignment = Element.ALIGN_CENTER,
                            FixedHeight = 20f
                        }
                    };
                    datos.SetTotalWidth(anchoColumnas);
                }

                // Cierra el fichero
                doc.Close();

                // Muestra el fichero
                openPdf(pdfName);
            }
            catch (Exception err) { MessageBox.Show("Se ha producido un error al generar el fichero PDF"); }
        }


        public void pdfDb(string pdfName) {}

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