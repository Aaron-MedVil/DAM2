using System.Windows;

namespace _20_editor_texto {
    
    public partial class MainWindow : Window {

        public MainWindow() {

            InitializeComponent();

            for (int i = 0; i < 72; i = i + 4) {

                // Esto es un ComboBox que se va a rellenar
                // textSize.Items.add(i);
            }
        }
    }
}