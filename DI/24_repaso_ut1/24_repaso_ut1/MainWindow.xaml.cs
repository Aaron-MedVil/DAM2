using System.Windows;

namespace _24_repaso_ut1 {

    public partial class MainWindow : Window {

        public MainWindow() => InitializeComponent();

        private void btn1_Click(object sender, RoutedEventArgs e) {

            ManejoJSON w1 = new ManejoJSON();
            w1.Show();
        }

        private void btn2_Click(object sender, RoutedEventArgs e) {

        }
    }
}