using System;
using System.Collections.Generic;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;

namespace _16_puzzle {

    class Mybutton : Button {

        // Evento click personalizado de los botones del puzzle
        protected override void OnClick() {

            // Aqui se crea el código onclick de los botones del puzzle
            MessageBox.Show("Click personalizado");
        }
    }
}