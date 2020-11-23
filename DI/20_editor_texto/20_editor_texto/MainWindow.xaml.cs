using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Text;
using System.Text.RegularExpressions;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;

namespace _20_editor_texto {

    public partial class MainWindow : Window {

        private GestDoc gestDoc;
        private string theme = "light";
        public string? nomDocumento;

        /// <summary>Funcion para cargar los componentes de la ventana</summary>
        public MainWindow() => InitializeComponent();

        /// <summary>Funcion que se ejecuta cuando se carga la ventana</summary>
        /// <param name="sender">Objeto que produce el evento</param>
        /// <param name="e">Objeto con la informacion del evento</param>
        private void mainWindowOnLoad(object sender, RoutedEventArgs e) {

            gestDoc = new GestDoc(this);
            fillMenuComboBox();
            theme = gestDoc.setTheme(theme);
            cajaTexto.SpellCheck.IsEnabled = true;
        }

        /// <summary>Rellena la informacion de lo ComboBox del menu</summary>
        private void fillMenuComboBox() {

            // Rellena el ComboBox del tamaño de letra
            for (int i = 4; i < 72; i = i + 4) { cbFontSize.Items.Add(i); }
            cbFontSize.Text = "20";

            // Rellena el ComboBox de la fuente
            foreach (FontFamily fuente in Fonts.SystemFontFamilies) { cbFontType.Items.Add(fuente); }
            cbFontType.Text = "Comic Sans MS";

            // Asigna el default al editor
            cajaTexto.FontSize = (int)cbFontSize.SelectedItem;
            cajaTexto.FontFamily = new FontFamily(cbFontType.SelectedItem.ToString());
        }

        /// <summary>Funcion para poner la ventana en FullScreen</summary>
        /// <param name="sender">Objeto que produce el evento</param>
        /// <param name="e">Objeto con la informacion del evento</param>
        private void pantallaCompleta(object sender, RoutedEventArgs e) {

            // Cambia el texto del MenuItem de cambiar a pantalla completa
            miFullScreen.Header = (WindowStyle.ToString() != "None") ? "Salir de pantalla completa" : "Pantalla completa";

            // Si la ventana esta en pantalla completa lo pone en ventana con marcos y viceversa
            WindowStyle = (WindowStyle.ToString() != "None") ? WindowStyle.None : WindowStyle.SingleBorderWindow;
            Hide(); Show();
        }

        /// <summary>Ejecuta un documento que seleccionemos</summary>
        /// <param name="sender">Objeto que produce el evento</param>
        /// <param name="e">Objeto con la informacion del evento</param>
        private void showAyuda(object sender, ExecutedRoutedEventArgs e) {

            string ruta = @"D:\Github\DAM2\DI\20_editor_texto\20_editor_texto\bin\Debug\netcoreapp3.1\resources\ago_doc.pdf";

            var p = new Process();
            p.StartInfo = new ProcessStartInfo($"{ruta}") { UseShellExecute = true };
            p.Start();
        }

        /// <summary>Llama al metodo para cambiar el tema</summary>
        /// <param name="sender">Objeto que produce el evento</param>
        /// <param name="e">Objeto con la informacion del evento</param>
        private void changeTheme(object sender, RoutedEventArgs e) => theme = gestDoc.setTheme(theme);

        /// <summary>Evento que llama a la funcion para crear un evento nuevo</summary>
        /// <param name="sender">Objeto que produce el evento</param>
        /// <param name="e">Objeto con la informacion del evento</param>
        private void nuevoDocumento(object sender, ExecutedRoutedEventArgs e) {

            if (gestDoc.generarnuevoFichero(nomDocumento)) {

                MessageBox.Show("Fichero guardado correctamente");
                gestDoc.vaciarCajaTexto();
                nomDocumento = null;
            } else { MessageBox.Show("Error al guardar el fichero"); }
        }

        /// <summary>Guarda un documento</summary>
        /// <param name="sender">Objeto que produce el evento</param>
        /// <param name="e">Objeto con la informacion del evento</param>
        private void guardarDocumento(object sender, ExecutedRoutedEventArgs e) {

            if (gestDoc.generarnuevoFichero(nomDocumento)) { MessageBox.Show("Fichero guardado correctamente"); }
            else { MessageBox.Show("Error al guardar el fichero"); }
        }

        /// <summary>Funcion para cerrar la aplicacion con el boton escape</summary>
        /// <param name="sender">Objeto que produce el evento</param>
        /// <param name="e">Objeto con la informacion del evento</param>
        private void salirPrograma(object sender, ExecutedRoutedEventArgs e) => Close();

        /// <summary>Evento que controla que se imprima correctamente el documento</summary>
        /// <param name="sender">Objeto que produce el evento</param>
        /// <param name="e">Objeto con la informacion del evento</param>
        private void imprimirDocumento(object sender, ExecutedRoutedEventArgs e) {

            if (gestDoc.printDoc() == true) { MessageBox.Show("Documento impreso correctamente"); }
            else { MessageBox.Show("Error al imprimir el documento"); }
        }

        /// <summary>Evento que controla que se abra correctamente un documento</summary>
        /// <param name="sender">Objeto que produce el evento</param>
        /// <param name="e">Objeto con la informacion del evento</param>
        private void abrirDocumento(object sender, ExecutedRoutedEventArgs e) {

            if (gestDoc.openDoc(nomDocumento) == true) { MessageBox.Show("Fichero abierto correctamente"); } else { MessageBox.Show("Error al abrir el documento"); }
        }

        /// <summary>Activa la corrección ortográfica en tiempo real</summary>
        /// <param name="sender">Objeto que produce el evento</param>
        /// <param name="e">Objeto con la informacion del evento</param>
        private void toggleSpellCheck(object sender, RoutedEventArgs e) => cajaTexto.SpellCheck.IsEnabled = !cajaTexto.SpellCheck.IsEnabled;

        /// <summary>Activa/Desactiva la propiedad negrita del texto seleccionado</summary>
        /// <param name="sender">Objeto que produce el evento</param>
        /// <param name="e">Objeto con la informacion del evento</param>
        private void toggleBoldText(object sender, ExecutedRoutedEventArgs e) => gestDoc.changePropText("bold");

        /// <summary>Activa/Desactiva la propiedad cursiva del texto seleccionado</summary>
        /// <param name="sender">Objeto que produce el evento</param>
        /// <param name="e">Objeto con la informacion del evento</param>
        private void toggleItalicText(object sender, ExecutedRoutedEventArgs e) => gestDoc.changePropText("italic");

        /// <summary>Activa/Desactiva la propiedad subrayado del texto seleccionado</summary>
        /// <param name="sender">Objeto que produce el evento</param>
        /// <param name="e">Objeto con la informacion del evento</param>
        private void toggleUnderlineText(object sender, ExecutedRoutedEventArgs e) => gestDoc.changePropText("underline");

        /// <summary>Cambia el color del texto seleccionado</summary>
        /// <param name="sender">Objeto que produce el evento</param>
        /// <param name="e">Objeto con la informacion del evento</param>
        private void EventoColor(object sender, RoutedPropertyChangedEventArgs<Color?> e) => gestDoc.changePropText("color");

        /// <summary>Cambia el tamaño del texto</summary>
        /// <param name="sender">Objeto que produce el evento</param>
        /// <param name="e">Objeto con la informacion del evento</param>
        private void fontSizeChanged(object sender, SelectionChangedEventArgs e) => gestDoc.changePropText("fontSize");

        /// <summary>Cambia la familia del texto</summary>
        /// <param name="sender">Objeto que produce el evento</param>
        /// <param name="e">Objeto con la informacion del evento</param>
        private void fontFamilyChanged(object sender, SelectionChangedEventArgs e) => gestDoc.changePropText("fontFamily");

        /// <summary>Busca y reemplaza una cadena de texto</summary>
        /// <param name="sender">Objeto que produce el evento</param>
        /// <param name="e">Objeto con la informacion del evento</param>
        private void buscarReemplazarShow(object sender, RoutedEventArgs e) {

            VentanaGoesBrrrr vgb = new VentanaGoesBrrrr();
            vgb.ShowDialog();

            if (vgb.accion == "Cancelar") { return; }

            var textoBuscar = vgb.palabraAbuscar.Text.Trim();
            var textoCambio = vgb.PalabraCambio.Text.Trim();

            if (textoBuscar == "") { return; }

            // Buscara palabras y remarcarlas las encontradas en rojo
            if (textoCambio == "") {

                cajaTexto.SelectAll();
                cajaTexto.Selection.ApplyPropertyValue(TextElement.ForegroundProperty, new SolidColorBrush(Colors.Black));
                cajaTexto.Selection.ApplyPropertyValue(TextElement.FontWeightProperty, FontWeights.Normal);

                Regex reg = new Regex(textoBuscar.Trim(), RegexOptions.Compiled | RegexOptions.IgnoreCase);

                TextPointer position = cajaTexto.Document.ContentStart;
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
            }
            else {

                var textRange = new TextRange(cajaTexto.Document.ContentStart, cajaTexto.Document.ContentEnd);
                string rtf;

                using (var memoryStream = new MemoryStream()) {
                    textRange.Save(memoryStream, DataFormats.Rtf);
                    rtf = ASCIIEncoding.Default.GetString(memoryStream.ToArray());
                }

                rtf = rtf.Replace(textoBuscar, textoCambio);

                MemoryStream stream = new MemoryStream(ASCIIEncoding.Default.GetBytes(rtf));
                cajaTexto.SelectAll();
                cajaTexto.Selection.Load(stream, DataFormats.Rtf);
            }
        }
    }
}