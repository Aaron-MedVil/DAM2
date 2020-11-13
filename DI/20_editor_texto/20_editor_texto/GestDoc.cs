namespace _20_editor_texto {

    class GestDoc {

        MainWindow mw = new MainWindow();

        // Vacia el cajon de texto
        public void vaciarCajaTexto() => mw.cajaTexto.Document.Blocks.Clear();
    }
}