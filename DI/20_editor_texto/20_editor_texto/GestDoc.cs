using Microsoft.Win32;
using System.IO;
using System.Linq;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Documents;
using System.Windows.Media;

namespace _20_editor_texto {

    class GestDoc {

        private MainWindow mw;
        private BrushConverter bc = new BrushConverter();
        private string nomDocumento;

        /// <summary>Constructor de la clase</summary>
        /// <param name="mw">Instancia de la clase MainWindow</param>
        public GestDoc(MainWindow mw) => this.mw = mw;

        /// <summary>Vacia el cajon de texto</summary>
        public void vaciarCajaTexto() => mw.cajaTexto.Document.Blocks.Clear();

        /// <summary>Guarda un fichero nuevo</summary>
        /// <param name="nomdoc">Ruta del documento que vamos a crear</param>
        /// <returns type="Boolean">True si el fichero se ha creado correctamente</returns>
        public bool generarnuevoFichero(string? nomdoc) {

            if (nomdoc == "" || nomdoc == null) {

                SaveFileDialog dlg = new SaveFileDialog { Filter = "rtf (*.rtf)|*.rtf|txt (*.txt)|*.txt" };

                if (dlg.ShowDialog() == true) {

                    mw.nomDocumento = dlg.FileName;

                    TextRange t = new TextRange(mw.cajaTexto.Document.ContentStart, mw.cajaTexto.Document.ContentEnd);
                    FileStream file = new FileStream(mw.nomDocumento, FileMode.Create);
                    t.Save(file, DataFormats.XamlPackage);
                    file.Close();

                    return true;
                } else { return false; }
            } else {

                TextRange t = new TextRange(mw.cajaTexto.Document.ContentStart, mw.cajaTexto.Document.ContentEnd);
                FileStream file = new FileStream(nomdoc, FileMode.Create);
                t.Save(file, DataFormats.XamlPackage);
                file.Close();
                return true;
            }
        }

        /// <summary>Imprime un documento</summary>
        /// <returns type="Boolean">True si el fichero se imprime correctamente</returns>
        public bool printDoc() {

            PrintDialog pd = new PrintDialog();

            if (pd.ShowDialog() == true) {

                pd.PrintVisual(mw.cajaTexto as Visual, "VistaPrevia");
                pd.PrintDocument(((IDocumentPaginatorSource)mw.cajaTexto.Document).DocumentPaginator, "Impresión del Documento");

                return true;
            } else { return false; }
        }

        /// <summary>Cambia el tema de la aplicacion</summary>
        /// <param name="theme">Tema implementado actualmente</param>
        /// <returns type="String">Nombre del tema que hemos implementado</returns>
        public string setTheme(string theme) {

            switch (theme) {
                case "light":
                    mw.miChangeEditorBackground.Header = "Modo noche";
                    // mw.Background = (Brush)bc.ConvertFrom(c.light());
                    return "dark";
                default:
                    mw.miChangeEditorBackground.Header = "Modo día";
                    // mw.Background = (Brush)bc.ConvertFrom(c.dark());
                    return "light";
            }
        }

        /// <summary>Abre un fichero</summary>
        /// <param name="nomdoc">Ruta del documento que vamos a abrir</param>
        /// <returns Type="Boolean">True si el fichero se abre correctamente</returns>
        public bool openDoc(string? nomdoc) {

            if (nomdoc == "" || nomdoc == null) {

                OpenFileDialog dlg = new OpenFileDialog {
                    DefaultExt = ".rtf",
                    Filter = "Fichero de texto|*.txt|Fichero de texto enriquecido|*.rtf"
                };

                if (dlg.ShowDialog() == true) {

                    vaciarCajaTexto();

                    mw.nomDocumento = dlg.FileName;
                    TextRange t = new TextRange(mw.cajaTexto.Document.ContentStart, mw.cajaTexto.Document.ContentEnd);

                    FileStream file = new FileStream(mw.nomDocumento, FileMode.Open);
                    t.Load(file, DataFormats.XamlPackage);
                    file.Close();

                    return true;
                } else { return false; }
            } else {

                vaciarCajaTexto();

                File.WriteAllText(nomdoc, new TextRange(mw.cajaTexto.Document.ContentStart, mw.cajaTexto.Document.ContentEnd).Text);
                return true;
            }
        }

        /// <summary>Cambia las propiedades del estilo de un texto</summary>
        /// <param name="prop">Propiedad que vamos a cambiar</param>
        public void changePropText(string? prop) {

            if (prop != "" || prop != null) {

                TextRange rango = new TextRange(mw.cajaTexto.Selection.Start, mw.cajaTexto.Selection.End);

                if (prop == "bold") {

                    var propertyValue = rango.GetPropertyValue(TextElement.FontWeightProperty);

                    if (propertyValue.ToString() == "Normal") {
                        rango.ApplyPropertyValue(TextElement.FontWeightProperty, FontWeights.Bold);
                    } else {
                        rango.ApplyPropertyValue(TextElement.FontWeightProperty, FontWeights.Normal);
                    }
                }
                else if (prop == "italic") {

                    var propertyValue = rango.GetPropertyValue(TextElement.FontStyleProperty);

                    if (propertyValue.ToString() == "Normal") {
                        rango.ApplyPropertyValue(TextElement.FontStyleProperty, FontStyles.Italic);
                    } else {
                        rango.ApplyPropertyValue(TextElement.FontStyleProperty, FontStyles.Normal);
                    }
                }
                else if (prop == "underline") {

                    var propertyValue = rango.GetPropertyValue(TextBlock.TextDecorationsProperty);

                    if (propertyValue.ToString() != "Baseline") {
                        rango.ApplyPropertyValue(TextBlock.TextDecorationsProperty, TextDecorations.Baseline);
                    } else {
                        rango.ApplyPropertyValue(TextBlock.TextDecorationsProperty, null);
                    }
                }
                else if (prop == "color") {

                    Color coloruso = (Color)mw.selectorColor.SelectedColor;
                    Brush mibrush = new SolidColorBrush(coloruso);
                    rango.ApplyPropertyValue(TextElement.ForegroundProperty, mibrush);
                }
                else if (prop == "fontSize") {

                    int valor = (int)mw.cbFontSize.SelectedItem;
                    rango.ApplyPropertyValue(TextElement.FontSizeProperty, (double)valor);
                } else if (prop == "fontFamily") {

                    FontFamily familia = (FontFamily)mw.cbFontType.SelectedItem;
                    rango.ApplyPropertyValue(TextElement.FontFamilyProperty, new FontFamily(familia.FamilyNames.Values.First()));
                }
            } else { MessageBox.Show("Propiedad no definida"); }
        }
    }
}