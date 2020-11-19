using Microsoft.Win32;
using System;
using System.IO;
using System.Windows;
using System.Windows.Documents;
using System.Windows.Input;

namespace _24_repaso_ut1 {

    public partial class ManejoFicheros : Window {

        private string? fileName;
        private string urlInit = Environment.CurrentDirectory + "\\res";

        /// <summary>Funcion que carga los componentes de la pagina</summary>
        public ManejoFicheros() => InitializeComponent();

        /// <summary>Funcion quese ejecuta cuando se carga la ventana</summary>
        /// <param name="sender">Objeto que ejecuta la accion</param>
        /// <param name="e">Objeto evento</param>
        private void Window_Loaded(object sender, RoutedEventArgs e) {

            // Vacia el editor de texto
            textEditor.Document.Blocks.Clear();

            // Open file dialog para seleccionar un fichero
            OpenFileDialog dg = new OpenFileDialog {
                InitialDirectory = urlInit,
                Filter = "Fichero JSON|*.json|Fichero de texto|*.txt",
                Multiselect = false,
                Title = "Seleccione un fichero"
            };

            // Comprueba si se producen errores con el dialog
            if (dg.ShowDialog() == true) {

                fileName = dg.FileName;
                textEditor.Document.Blocks.Add(new Paragraph(new Run(File.ReadAllText(fileName))));
            }
        }

        /// <summary>Funcion que guarda el documento en la ruta actual</summary>
        /// <param name="sender">Objeto que ejecuta la accion</param>
        /// <param name="e">Objeto evento</param>
        private void commandGuardar(object sender, ExecutedRoutedEventArgs e) {
            
            if (fileName != null && fileName != "") {

                string richText = new TextRange(textEditor.Document.ContentStart, textEditor.Document.ContentEnd).Text;
                File.WriteAllText(fileName, richText);
            } else {

                SaveFileDialog sfd = new SaveFileDialog {
                    InitialDirectory = urlInit,
                    Filter = "Fichero JSON|*.json|Fichero de texto|*.txt",
                    Title = "Guardar un fichero"
                };

                if (sfd.ShowDialog() == true) {

                    fileName = sfd.FileName;
                    string richText = new TextRange(textEditor.Document.ContentStart, textEditor.Document.ContentEnd).Text;
                    File.WriteAllText(fileName, richText);
                } else { MessageBox.Show("Error al guardar el archivo"); }
            }
        }

        /// <summary>Guarda un fichero seleccionando el destino</summary>
        /// <param name="sender">Objeto que ejecuta la accion</param>
        /// <param name="e">Objeto evento</param>
        private void commandGuardarComo(object sender, ExecutedRoutedEventArgs e) {

            SaveFileDialog sfd = new SaveFileDialog {
                InitialDirectory = urlInit,
                Filter = "Fichero JSON|*.json|Fichero de texto|*.txt",
                Title = "Guardar un fichero"
            };

            if (sfd.ShowDialog() == true) {

                fileName = sfd.FileName;
                string richText = new TextRange(textEditor.Document.ContentStart, textEditor.Document.ContentEnd).Text;
                File.WriteAllText(fileName, richText);
            } else { MessageBox.Show("Error al guardar el archivo"); }
        }

        /// <summary>Abre un fichero nuevo</summary>
        /// <param name="sender">Objeto que ejecuta la accion</param>
        /// <param name="e">Objeto evento</param>
        private void commandAbrir(object sender, ExecutedRoutedEventArgs e) {

            // Vacia el editor de texto
            textEditor.Document.Blocks.Clear();

            // Open file dialog para seleccionar un fichero
            OpenFileDialog dg = new OpenFileDialog {
                InitialDirectory = urlInit,
                Filter = "Fichero JSON|*.json|Fichero de texto|*.txt",
                Multiselect = false,
                Title = "Abrir un fichero"
            };

            // Comprueba si se producen errores con el dialog
            if (dg.ShowDialog() == true) {

                fileName = dg.FileName;
                textEditor.Document.Blocks.Add(new Paragraph(new Run(File.ReadAllText(fileName))));
            }
        }

        /// <summary>Crea un fichero nuevo</summary>
        /// <param name="sender">Objeto que ejecuta la accion</param>
        /// <param name="e">Objeto evento</param>
        private void commandNuevo(object sender, ExecutedRoutedEventArgs e) {

            fileName = null;
            textEditor.Document.Blocks.Clear();
        }

        /// <summary>Cierra la ventana</summary>
        /// <param name="sender">Objeto que ejecuta la accion</param>
        /// <param name="e">Objeto evento</param>
        private void commandCerrarVentana(object sender, ExecutedRoutedEventArgs e) => this.Close();

        /// <summary>Elimina un fichero</summary>
        /// <param name="sender">Objeto que ejecuta la accion</param>
        /// <param name="e">Objeto evento</param>
        private void commandEliminar(object sender, ExecutedRoutedEventArgs e) {

            OpenFileDialog ofd = new OpenFileDialog {
                InitialDirectory = urlInit,
                Multiselect = false,
                Filter = "All Files|*.*|Fichero de texto|*.txt|Fichero JSON|*.json",
                Title = "Eliminar un fichero"
            };

            if (ofd.ShowDialog() == true) { File.Delete(ofd.FileName); }
            else { MessageBox.Show("Error al eliminar el fichero"); }
        }
    }
}