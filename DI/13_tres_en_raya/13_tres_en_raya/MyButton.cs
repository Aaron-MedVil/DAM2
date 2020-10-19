using System;
using System.Collections.Generic;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;

namespace _13_tres_en_raya {

    class MyButton : Button {

        static Boolean turnoColor = true;
        static int nRojos = 0, nVerdes = 0;
        private MainWindow padre;

        // Constructor
        public MyButton(MainWindow mw) => padre = mw;

        protected override void OnClick() {

            // Pulsar boton blanco
            if (this.Background.ToString() == "#FFDDDDDD" && nRojos < 3 || nVerdes < 3) {

                // Turno rojo
                if (turnoColor && nRojos < 3) {
                    pintarRojo();
                }

                // Turno verde
                else if (nVerdes < 3) {
                    pintarVerde();
                }

                padre.changeTurno();
            }

            // Pulsar boton verde/rojo
            else {

                // Turno rojo
                if (turnoColor) {

                    if (this.Background.ToString() == "#FFFF0000") {

                        pintarBlanco();
                        turnoColor = true;
                        nRojos--;
                    }
                }

                // Turno verde
                else if (!turnoColor) {

                    if (this.Background.ToString() == "#FF008000") {

                        pintarBlanco();
                        turnoColor = false;
                        nVerdes--;
                    }
                }
            }
            
            base.OnClick();
        }

        // Pinta un boton de blanco
        private void pintarBlanco() {

            // Creo un color nuevo en la clase Brushes
            var converter = new System.Windows.Media.BrushConverter();
            var wht = (Brush)converter.ConvertFromString("#FFDDDDDD");

            this.Foreground = Brushes.Black;
            this.Background = wht;
        }

        // Pinta un boton de rojo
        private void pintarRojo() {

            this.Foreground = Brushes.White;
            this.Background = Brushes.Red;
            turnoColor = false;
            nRojos++;
        }

        // Pinta un boton de verde
        private void pintarVerde() {

            this.Foreground = Brushes.Black;
            this.Background = Brushes.Green;
            turnoColor = true;
            nVerdes++;
        }

        // Devuelve la variable de turno
        public Boolean returnTurno() => turnoColor;

        // Cambia el turno
        public void setTurno(Boolean turn) => turnoColor = turn;

        // Cambia el numero de rojos
        public void setNRojos(int n) => nRojos = n;

        // Cambia el numero de verdes
        public void setNVerdes(int n) => nVerdes = n;
    }
}
