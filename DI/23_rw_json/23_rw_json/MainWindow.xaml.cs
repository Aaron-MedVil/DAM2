using System.Windows;
using Newtonsoft.Json;

namespace _23_rw_json {
    
    public partial class MainWindow : Window {

        public MainWindow() => InitializeComponent();

        private void Window_Loaded(object sender, RoutedEventArgs e) {
            Microsoft.Win32.OpenFileDialog dlg = new Microsoft.Win32.OpenFileDialog {

            };
        }
    }
}