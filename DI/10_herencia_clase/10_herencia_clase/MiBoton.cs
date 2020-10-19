using System;
using System.Collections.Generic;
using System.Runtime.CompilerServices;
using System.Text;
using System.Windows.Controls;

namespace _10_herencia_clase {

    class MiBoton : Button {

        protected override void OnClick() {

            this.Content = "Cambio de mensaje";
            this.Width = 78;
            this.Height = 54;
            base.OnClick();
        }
    }
}
