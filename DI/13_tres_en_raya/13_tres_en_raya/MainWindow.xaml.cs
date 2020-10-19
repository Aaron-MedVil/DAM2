using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace _13_tres_en_raya {


    public partial class MainWindow : Window {

        // Clase principal
        public MainWindow() {

            InitializeComponent();
            inicializarJuego();
        }

        // Funcion para comprobar quien ha ganado
        private void comprobar(object sender, RoutedEventArgs e) {

            String cadenaExitoR = "", cadenaExitoV = "";
            Boolean winRed = false, winGreen = false;
            String[] arrWin = { "012", "345", "678", "036", "147", "258", "048", "246" };

            // Recorre los elementos del grid
            foreach (UIElement control in miRejilla.Children) {

                try {

                    MyButton boton = (MyButton)control;

                    // Esto lo hago porque mis botones no se llaman 0 o 1 y tengo que coger solo el numerito
                    String btn = boton.Content.ToString().Substring(boton.Content.ToString().Length - 1, 1);

                    // Si el boton es rojo lo guarda en cadenaExitoR
                    cadenaExitoR += (boton.Background.ToString() == "#FFFF0000") ? btn : "";

                    // Si el color es verde lo gana en CadenaExitoV
                    cadenaExitoV += (boton.Background.ToString() == "#FF008000") ? btn : "";
                } catch (Exception) { }
            }

            // Comprueba la cadena de exito del color rojo
            winRed = Array.Exists(arrWin, element => element == cadenaExitoR);

            // Comprueba la cadena de exito del color verde
            winGreen = Array.Exists(arrWin, element => element == cadenaExitoV);

            // Si gana el rojo
            if (winRed == true && winGreen == false) {
                MessageBox.Show("Ha ganado el rojo");
                resetGameDef();
            }
            
            // Si gana el verde
            else if (winRed == false && winGreen == true) {
                MessageBox.Show("Ha ganado el verde");
                resetGameDef();
            }
        }

        // Inicia el juego creando los botones
        public void inicializarJuego() {

            int i = 0;

            for (int columna = 0; columna < 3; columna++) {

                for (int fila = 0; fila < 3; fila++) {

                    MyButton mb00 = new MyButton(this);
                    mb00.Content = $"Boton {i}";
                    mb00.Click += new RoutedEventHandler(comprobar);

                    Grid.SetRow(mb00, columna);
                    Grid.SetColumn(mb00, fila);
                    miRejilla.Children.Add(mb00);

                    i++;
                }
            }

            changeTurno();
        }

        // Cambia el texto del turno
        public void changeTurno() {

            MyButton tc = new MyButton(this);
            Boolean rt = tc.returnTurno();

            if (rt) {
                textoTurno.Content = "Turno del rojo";
                textoTurno.Foreground = Brushes.Red;
            } else {
                textoTurno.Content = "Turno del verde";
                textoTurno.Foreground = Brushes.Green;
            }
        }

        // OnClick del boton para reiniciar el juego
        private void resetGame(object sender, RoutedEventArgs e) => resetGameDef();

        // Funcion para reiniciar el juego
        private void resetGameDef() {

            MessageBox.Show("Reiniciar juego");
            MyButton tc = new MyButton(this);

            // Aqui es donde se eliminan los botones de juego
            for (int row = 0; row < 3; row++) {

                for (int col = 0; col < 3; col++) {

                    /**
                     * Breve explicacion:
                     * Estoy guardando en la variable un elemento de UIElement
                     * Para ello creo esta estructura que es como un foreach pero no recorre los elementos
                     * Lo que hace es especificar mediante el Grid.GetRow y Grid.GetColumn la fila y la columna que quiera
                     * Una vez seleccionada la posicion del grid que quiero me selecciona el hijo (El hijo en este caso es un boton porque es lo que tengo contenido en la celda del grid)
                    */
                    var eList = from UIElement child in miRejilla.Children
                                where Grid.GetRow((FrameworkElement)child) == row && Grid.GetColumn((FrameworkElement)child) == col
                                select child;

                    // Una vez tengo el elemento en la variable compruebo que efectivamente no esta vacia
                    if (eList.Count() > 0) {

                        // Si la variable no esta vacia elimino de mi rejilla el elemento que he guardado en la variable anteriormente
                        miRejilla.Children.Remove(eList.First());
                    }

                    // Apunte: No se si en esa variable se podrian guardar varios elementos porque no lo he probado aun. Es una funcion que os dejo por si quereis probar.
                    // Tambien estoy seguro de que se podrian eliminar los botones de alguna manera más sencilla, pero esta es la que me ha funcionado. Tambien podeis probar metiendo en esta funcion los fragmentos de código que querais, pero recordad que en el grid que tengo creado no solamente existen los botones que se pintan de rojo o verde
                }
            }

            // Esto reinicia el turno a true que es el valor inicial
            tc.setTurno(true);

            // Esto reinicia el numero de verdes a 0 que es el valor inicial
            tc.setNVerdes(0);

            // Esto reinicia el numero de rojos a 0 que es el valor inicial
            tc.setNRojos(0);

            // Aqui hago que el display de abajo muestre cual es el color del proximo turno
            changeTurno();

            // Aqui vuelvo a iniciar el juego ( Crear los botones )
            inicializarJuego();
        }
    }
}