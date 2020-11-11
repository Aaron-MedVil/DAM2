using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Media;

namespace _22_buscar_reemplazar_listerBox {

    public partial class MainWindow : Window {

        Window1 vm = new Window1();

        public MainWindow() => InitializeComponent();

        private void Button_Click(object sender, RoutedEventArgs e) => vm.ShowDialog();

        private void Buscar_reemplazar(object sender, RoutedEventArgs e) {

            //buscar en el texto
            vm.ShowDialog();

            // MessageBox.Show(BuscarReemplazar.accion);

            if (vm.accion == "Cancelar") { return; }

            var textoBuscar = vm.palabraAbuscar.Text.Trim();
            var textoCambio = vm.PalabraCambio.Text.Trim();

            if (textoBuscar == "") { return; }

            // Buscara palabras y remarcarlas las encontradas en rojo
            if (textoCambio == "") {

                CuadroTexto.SelectAll();
                CuadroTexto.Selection.ApplyPropertyValue(TextElement.ForegroundProperty, new SolidColorBrush(Colors.Black));
                CuadroTexto.Selection.ApplyPropertyValue(TextElement.FontWeightProperty, FontWeights.Normal);

                // https://docs.microsoft.com/es-es/dotnet/api/system.text.regularexpressions.regex?view=netframework-4.8

                Regex reg = new Regex(textoBuscar.Trim(), RegexOptions.Compiled | RegexOptions.IgnoreCase);
                TextPointer position = CuadroTexto.Document.ContentStart;
                List<TextRange> ranges = new List<TextRange>();

                while (position != null) {

                    if (position.GetPointerContext(LogicalDirection.Forward) == TextPointerContext.Text) {

                        string text = position.GetTextInRun(LogicalDirection.Forward);
                        var matchs = reg.Matches(text);

                        foreach (Match match in matchs) {

                            TextPointer start = position.GetPositionAtOffset(match.Index);
                            TextPointer end = start.GetPositionAtOffset("Hola".Trim().Length);
                            TextRange textrange = new TextRange(start, end);
                            ranges.Add(textrange);
                        }
                    }

                    position = position.GetNextContextPosition(LogicalDirection.Forward);
                }

                foreach (TextRange range in ranges) {

                    range.ApplyPropertyValue(TextElement.ForegroundProperty, new SolidColorBrush(Colors.Red));
                    range.ApplyPropertyValue(TextElement.FontWeightProperty, FontWeights.Bold);
                }
            } else {

                /* reemplazar */
                // Sustituir Texto
                var textRange = new TextRange(CuadroTexto.Document.ContentStart, CuadroTexto.Document.ContentEnd);
                string rtf;

                using (var memoryStream = new MemoryStream()) {

                    textRange.Save(memoryStream, DataFormats.Rtf);
                    rtf = ASCIIEncoding.Default.GetString(memoryStream.ToArray());
                }

                rtf = rtf.Replace(textoBuscar, textoCambio);
                MemoryStream stream = new MemoryStream(ASCIIEncoding.Default.GetBytes(rtf));
                CuadroTexto.SelectAll();
                CuadroTexto.Selection.Load(stream, DataFormats.Rtf);
            }
        }
    }
}
