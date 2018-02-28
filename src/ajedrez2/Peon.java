package ajedrez2;

public class Peon extends Pieza {

    //constructores
    /**
     * Constructor por defecto para un Peón. Los atributos se inicializan del
     * siguiente modo: Nombre: Peon Color: Blanco Puntos: 1
     */
    public Peon() {

        nombre = "Peon";
        color = "blanco";
        puntos = 1;
    }

    /**
     * Constructor para crear una nueva Pieza de tipo Peon. El atributo que
     * podemos especificar es el color, que se instroduce como primer parámetro.
     * El resto de atributos del Peón son la puntuación y el nombre, que ya
     * están inicializados con un valor.
     *
     * @param color Color de la pieza = "blanco" si es blanca, "negro" si
     * pertenece a las piezas negras.
     */
    public Peon(String color) {
        super(color);
        nombre = "Peon";
        puntos = 1;
    }

    /**
     * En el caso del peón el movimiento es válido en estas situaciones: Si son
     * blancos: Cuando el movimiento vertical es +1 (+2 si nunca se ha movido) y
     * no hay piezas contrarias en sus diagonal. Si son negros: Cuando el
     * movimiento vertical es -1 (-2 si nucna se ha movido anteriormente) y si
     * no hay piezas contrarias en sus diagonales. En ambos casos si hay pieza
     * contraria en sus diagonales, tambien pueden moverse en diagonal.
     *
     * @param movimiento - movimiento introducido por el usuario tras
     * comprobarlo.
     * @return boolean = true si el movimiento se puede realizar.
     */
    @Override
    public boolean puedeMoverse(Movimiento movimiento, Tablero tablero) {
        boolean movi = false;

        if (color.charAt(0) == 'b' && movimiento.esVertical()) {
            if (movimiento.numVertical() == 1) {
                movi = true;
            } else if (movimiento.getPosInicial().getFila() == 1 && movimiento.numVertical() <= 2 && movimiento.numVertical() > 0) {
                movi = true;
            } else {
                System.out.println("Peon no puede retroceder.");
            }

        }
        if (color.charAt(0) == 'n' && movimiento.esVertical()) {
            if (movimiento.numVertical() == -1) {
                movi = true;
            } else if (movimiento.getPosInicial().getFila() == 6 && movimiento.numVertical() >= -2 && movimiento.numVertical() < 0) {
                movi = true;
            } else {
                movi = false;
                System.out.println("Peon no puede retroceder.");
            }
        }
        if(color.charAt(0) == 'b' && movimiento.numVertical()==1 && Math.abs(movimiento.numHorizontal()) == 1){
            if(tablero.hayPieza(movimiento.getPosFinal().getFila(), movimiento.getPosFinal().getColumna())){
                movi = true;
            }
        }
        if(color.charAt(0) == 'n' && movimiento.numVertical()==-1 && Math.abs(movimiento.numHorizontal()) == 1){
            if(tablero.hayPieza(movimiento.getPosFinal().getFila(), movimiento.getPosFinal().getColumna())){
                movi = true;
            }
        }
        if (movimiento.esVertical() && tablero.hayPieza(movimiento.getPosFinal().getFila(), movimiento.getPosFinal().getColumna())) {
            movi = false;
        }
//        if (color.charAt(0) == 'b') {
//            if (movimiento.esDiagonal()
//                    && tab.hayPieza(movimiento.getPosFinal().getFila(), movimiento.getPosFinal().getColumna())
//                    && movimiento.numHorizontal() == 1 && movimiento.numVertical() == 1) {
//                movi = true;
//            } else if (movimiento.numVertical() == 1) {
//                movi = true;
//            } else if (movimiento.getPosInicial().getFila() == 1 && movimiento.numVertical() <= 2 && movimiento.numVertical() > 0) {
//                movi = true;
//            } else {
//                System.out.println("Peon no puede retroceder.");
//            }
//
//        } else {
//            if (movimiento.esDiagonal()
//                    && tab.hayPieza(movimiento.getPosFinal().getFila(), movimiento.getPosFinal().getColumna())
//                    && movimiento.numHorizontal() == -1 && movimiento.numVertical() == -1) {
//                movi = true;
//
//            } else if (movimiento.numVertical() == -1) {
//                movi = true;
//            } else if (movimiento.getPosInicial().getFila() == 6 && movimiento.numVertical() >= -2 && movimiento.numVertical() < 0) {
//                movi = true;
//            } else {
//                movi = false;
//                System.out.println("Peon no puede retroceder.");
//            }
//            if (movimiento.esDiagonal()
//                    && tab.hayPieza(movimiento.getPosFinal().getFila(), movimiento.getPosFinal().getColumna())
//                    && movimiento.numHorizontal() == 1 && movimiento.numVertical() == 1) {
//                movi = true;
//            } else {
//                if (color.charAt(0) == 'b' && movimiento.esVertical() == true) {
//                    if (movimiento.numVertical() == 1) {
//                        movi = true;
//                    } else if (movimiento.getPosInicial().getFila() == 1 && movimiento.numVertical() <= 2 && movimiento.numVertical() > 0) {
//                        movi = true;
//                    } else {
//                        System.out.println("Peon no puede retroceder.");
//                    }
//                } else if (color.charAt(0) == 'n' && movimiento.esVertical() == true) {
//                    if (movimiento.numVertical() == -1) {
//                        movi = true;
//                    } else if (movimiento.getPosInicial().getFila() == 6 && movimiento.numVertical() >= -2 && movimiento.numVertical() < 0) {
//                        movi = true;
//                    } else {
//                        movi = false;
//                        System.out.println("Peon no puede retroceder.");
//                    }
//                }
//
//           }

        return movi;
    }

    /**
     * Dibuja la pieza usando el cñodigo unicode asignado a cada pieza de
     * ajedrez segun su color.
     *
     * @return Símbolo unicode de la pieza.
     */
    @Override
    public String pintarPieza() {
        String pieza;
        if (this.color.compareToIgnoreCase("blanca") == 0) {
            pieza = "\u2659";
        } else {
            pieza = "\u265F";
        }
        return pieza;
    }

}
