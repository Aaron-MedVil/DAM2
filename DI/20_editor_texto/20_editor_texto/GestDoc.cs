using Microsoft.Win32;
using Microsoft.Win32.SafeHandles;
using System.IO;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Documents;
using System.Windows.Media;

namespace _20_editor_texto {

    class GestDoc {

        private MainWindow mw;
        private Colors c = new Colors();
        private BrushConverter bc = new BrushConverter();
        private SafeFileHandle nomDocumento;

        // Constructor de la clase
        public GestDoc(MainWindow mw) => this.mw = mw;

        // Vacia el cajon de texto
        public void vaciarCajaTexto() => mw.cajaTexto.Document.Blocks.Clear();

        // Guarda un fichero nuevo
        public bool generarnuevoFichero(string? nomdoc) {

            if (nomdoc == "" || nomdoc == null) {

                SaveFileDialog dlg = new SaveFileDialog {
                    DefaultExt = ".rtf",
                    Filter = "rtf (*.rtf)|*.rtf|txt (*.txt)|*.txt"
                };

                if (dlg.ShowDialog() == true) {

                    mw.nomDocumento = dlg.FileName;
                    // File.WriteAllText(mw.nomDocumento, new TextRange(mw.cajaTexto.Document.ContentStart, mw.cajaTexto.Document.ContentEnd).Text);

                    TextRange t = new TextRange(mw.cajaTexto.Document.ContentStart, mw.cajaTexto.Document.ContentEnd);
                    FileStream file = new FileStream(mw.nomDocumento, FileMode.Create);
                    t.Save(file, DataFormats.XamlPackage);
                    file.Close();

                    return true;
                } else { return false; }
            } else {

                File.WriteAllText(nomdoc, new TextRange(mw.cajaTexto.Document.ContentStart, mw.cajaTexto.Document.ContentEnd).Text);
                return true;
            }
        }

        // Imprime un documento
        public bool printDoc() {

            PrintDialog pd = new PrintDialog();

            if (pd.ShowDialog() == true) {

                pd.PrintVisual(mw.cajaTexto as Visual, "VistaPrevia");
                pd.PrintDocument(((IDocumentPaginatorSource)mw.cajaTexto.Document).DocumentPaginator, "Impresión del Documento");

                return true;
            } else { return false; }
        }

        // Cambia el tema de la aplicacion
        public string setTheme(string theme) {

            switch (theme) {
                case "light":
                    mw.miChangeEditorBackground.Header = "Modo noche";
                    mw.Background = (Brush)bc.ConvertFrom(c.light());
                    return "dark";
                default:
                    mw.miChangeEditorBackground.Header = "Modo día";
                    mw.Background = (Brush)bc.ConvertFrom(c.dark());
                    return "light";
            }
        }

        // Abre un fichero
        public bool openDoc(string? nomdoc) {

            if (nomdoc == "" || nomdoc == null) {

                OpenFileDialog dlg = new OpenFileDialog {
                    DefaultExt = ".rtf",
                    Filter = "txt (*.txt)|*.txt"
                };

                if (dlg.ShowDialog() == true) {

                    mw.nomDocumento = dlg.FileName;
                    TextRange t = new TextRange(mw.cajaTexto.Document.ContentStart, mw.cajaTexto.Document.ContentEnd);

                    FileStream file = new FileStream(mw.nomDocumento, FileMode.Open);
                    t.Load(file, DataFormats.XamlPackage);
                    file.Close();

                    return true;
                } else { return false; }
            } else {

                File.WriteAllText(nomdoc, new TextRange(mw.cajaTexto.Document.ContentStart, mw.cajaTexto.Document.ContentEnd).Text);
                return true;
            }
        }

        public void changePropText(string? prop) {

            if (prop != "" || prop != null) {

                TextRange rango = new TextRange(mw.cajaTexto.Selection.Start, mw.cajaTexto.Selection.End);

                switch (prop) {
                    case "bold":
                        var propertyValue = rango.GetPropertyValue(TextElement.FontWeightProperty);
                        if (propertyValue.ToString() == "Normal") { rango.ApplyPropertyValue(TextElement.FontWeightProperty, FontWeights.Bold); }
                        else { rango.ApplyPropertyValue(TextElement.FontWeightProperty, FontWeights.Normal); }
                        break;
                }

                // bold
                // italic
                // underline
                // color
                // fontSize
                // fontFamily

                MessageBox.Show(prop);
            } else { MessageBox.Show("Propiedad no definida"); }
        }
    }
}

/*
 * // Activa/Desactiva la propiedad negrita del texto seleccionado
        private void toggleBoldText(object sender, ExecutedRoutedEventArgs e) {

           
           
            var propertyValue = rango.GetPropertyValue(TextElement.FontWeightProperty);
           
            if (propertyValue.ToString() == "Normal") { rango.ApplyPropertyValue(TextElement.FontWeightProperty, FontWeights.Bold); }
            else { rango.ApplyPropertyValue(TextElement.FontWeightProperty, FontWeights.Normal); }
        }

        // Activa/Desactiva la propiedad cursiva del texto seleccionado
        private void toggleItalicText(object sender, ExecutedRoutedEventArgs e) {

            TextRange rango = new TextRange(cajaTexto.Selection.Start, cajaTexto.Selection.End);

            var propertyValue = rango.GetPropertyValue(TextElement.FontStyleProperty);

            if (propertyValue.ToString() == "Normal") { rango.ApplyPropertyValue(TextElement.FontStyleProperty, FontStyles.Italic); }
            else { rango.ApplyPropertyValue(TextElement.FontStyleProperty, FontStyles.Normal); }
        }

        // Activa/Desactiva la propiedad subrayado del texto seleccionado
        private void toggleUnderlineText(object sender, ExecutedRoutedEventArgs e) {

            TextRange rango = new TextRange(cajaTexto.Selection.Start, cajaTexto.Selection.End);

            var propertyValue = rango.GetPropertyValue(TextBlock.TextDecorationsProperty);

            if (propertyValue.ToString() != "Baseline") { rango.ApplyPropertyValue(TextBlock.TextDecorationsProperty, TextDecorations.Strikethrough); }
            else { rango.ApplyPropertyValue(TextBlock.TextDecorationsProperty, null); }
        }

        // Cambia el color del texto seleccionado
        private void EventoColor(object sender, RoutedPropertyChangedEventArgs<Color?> e) {

            Color coloruso = (Color)selectorColor.SelectedColor;
            Brush mibrush = new SolidColorBrush(coloruso);

            TextRange rango = new TextRange(cajaTexto.Selection.Start, cajaTexto.Selection.End);
            rango.ApplyPropertyValue(TextElement.ForegroundProperty, mibrush);
        }
*/