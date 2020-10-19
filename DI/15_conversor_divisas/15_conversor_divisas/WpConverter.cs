using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Data;
using System.Windows;
using System.Diagnostics;

namespace _15_conversor_divisas {
    public class WpConverter : IValueConverter {

        private const double diff = 1.17;

        public object Convert(object value, Type targetType, object parameter, CultureInfo culture) {

            // Convierte de € a $ (Multiplica los € por 1.17)

            String val = value.ToString();

            if (val.Any()) {

                val = val.Replace(".", ",");

                double valdb = double.Parse(val);
                double cambio = valdb * diff;
                cambio = Math.Round(cambio, 2);
                return $"{cambio.ToString()}";
            } else { return ""; }
        }

        public object ConvertBack(object value, Type targetType, object parameter, CultureInfo culture) {

            // Convierte de $ a € (Divide los $ entre 1.17)

            String val = value.ToString();

            if (val.Any()) {

                val = val.Replace(".", ",");

                double valdb = double.Parse(val);
                double cambio = valdb / diff;
                cambio = Math.Round(cambio, 2);
                return $"{cambio.ToString()}";
            } else { return ""; }
        }
    }
}