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
    }
}