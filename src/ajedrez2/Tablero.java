/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez2;

public class Tablero {

    public Pieza[][] casillas = new Pieza[8][8];

    /**
     * Constructor de un tablero. Inicializa todas las posiciones del array con
     * piezas en del color correcto el lugar correspondiente, y el resto quedan
     * vacias.
     */
    public Tablero() {
        casillas[0][0] = new Torre("blanca");
        casillas[0][1] = new Caballo("blanca");
        casillas[0][2] = new Alfil("blanca");
        casillas[0][3] = new Dama("blanca");
        casillas[0][4] = new Rey("blanca");
        casillas[0][5] = new Alfil("blanca");
        casillas[0][6] = new Caballo("blanca");
        casillas[0][7] = new Torre("blanca");
        for (int i = 0; i < 8; i++) {
            casillas[1][i] = new Peon("blanca");
            casillas[6][i] = new Peon("negra");
        }
        casillas[7][0] = new Torre("negra");
        casillas[7][1] = new Caballo("negra");
        casillas[7][2] = new Alfil("negra");
        casillas[7][3] = new Dama("negra");
        casillas[7][4] = new Rey("negra");
        casillas[7][5] = new Alfil("negra");
        casillas[7][6] = new Caballo("negra");
        casillas[7][7] = new Torre("negra");
    }

    //Metodos
    /**
     * Hay pieza: Nos indica que en el lugar especificado del tablero hay una
     * pieza. Si no hay una pieza en esa casilla, devuelve false.
     *
     * @param fila perteneciente al array de piezas llamado casillas.
     * @param columna pertenecsiente al array casillas.
     * @return true = si hay una pieza en esa fila y columna, false si está
     * vacia.
     */
    public boolean hayPieza(int fila, int columna) {
        boolean hay = true;
        if (casillas[fila][columna] == null) //si la casilla esta a null es que no hay pieza ---> hay pieza = false
        {
            hay = false;
        }
        return hay;
    }

    /**
     * Hay pieza V2: En la posición introducida por el parametro posicion de
     * tipo/clase Posicion comprueba si hay una pieza en ese lugar.
     *
     * @param posicion de tipo Posición, compuesto a su vez de dos atributos
     * fila y columna.
     * @return hay de tipo boolean. Toma el valor true si hay una pieza en ese
     * lugar, y false y está a null.
     */
    public boolean hayPieza(Posicion posicion) {
        boolean hay = true;
        if (casillas[posicion.getFila()][posicion.getColumna()] == null) {
            hay = false;
        }
        return hay;
    }

    /**
     * Poner Pieza: La pieza introducida mediante el parámetro pieza se coloca
     * en el tablero en la posición que indican la fila y la columna. En el
     * array bidimensional que es el tablero podemos elegir la posición exacta
     * gracias a las filas y columnas.
     *
     * @param pieza Pieza que deseamos posicionar en la casilla del tablero.
     * @param fila Fila en la que colocamos la pieza en el array.
     * @param columna Columna en la que colocamos la pieza en el array.
     */
    public void ponerPieza(Pieza pieza, int fila, int columna) {
        casillas[fila][columna] = pieza;
    }

    /**
     * Poner Pieza: La pieza introducida mediante se coloca en el tablero en la
     * posición que indican el parámetro introducido.
     *
     * @param pieza Pieza que deseamos posicionar en la casilla del tablero.
     * @param posicion Posición en la que queremos poner la pieza.
     */
    public void ponerPieza(Pieza pieza, Posicion posicion) {
        casillas[posicion.getFila()][posicion.getColumna()] = pieza;
    }

    /**
     * Quitar Pieza: Elimina del array tablero la información que esté contenida
     * en la posicion definida mediante fila y columna. Si hay una referencia a
     * una pieza, cambia el valor a null.
     *
     * @param fila Fila del array que nos ayuda a determinar la posición a
     * borrar.
     * @param columna Columna del array para poder saber la posición a borrar.
     */
    public void quitarPieza(int fila, int columna) {
        casillas[fila][columna] = null;
    }

    /**
     * Quitar Pieza: Elimina del array tablero la información que esté contenida
     * en el lugar definido mediante el parámetro posición.
     *
     * @param posicion
     */
    public void quitarPieza(Posicion posicion) {
        casillas[posicion.getFila()][posicion.getColumna()] = null;
    }

    /**
     * Ideantifica la pieza que esté en la posición introducida mediante una
     * fila y columna.
     *
     * @param fila - En la que queremos buscar la pieza - de 0 a 7.
     * @param columna - En la que quieremos buscar la pieza - de 0 a 7 para
     * nosotros.
     * @return Pieza encontrada en esa posición.
     */
    public Pieza buscarPieza(int fila, int columna) {
        return casillas[fila][columna];
    }

    /**
     * Ideantifica la pieza que esté en la posición introducida mediante una
     * posición.
     *
     * @param posicion - posición en el tablero donde quiero ver si hay pieza.
     * @return
     */
    public Pieza buscarPieza(Posicion posicion) {
        return casillas[posicion.getFila()][posicion.getColumna()];
    }

    /**
     * El movimiento se realizará las comprobaciones necesarias tras recibir un
     * movimiento haciendo una llamada al metodo individual de cada pieza que
     * indica si puede mover (método puedeMoverse) y a su vez comprueba si hay
     * piezas entre la pieza inicial y el movimiento final. Si hay piezas, el
     * movimiento no se realiza.
     *
     * @param movimiento
     * @return realizado = si es true el movimiento se ha realizado
     * correctamente
     */
    public boolean hacerMovimiento(Movimiento movimiento) {

        boolean realizado;
        if ((buscarPieza(movimiento.getPosInicial().getFila(), movimiento.getPosInicial().getColumna()).puedeMoverse(movimiento,this)) == true
                && hayPiezasEntre(movimiento) == false) {
            Pieza aux = casillas[movimiento.getPosInicial().getFila()][movimiento.getPosInicial().getColumna()];
            quitarPieza(movimiento.getPosInicial().getFila(), movimiento.getPosInicial().getColumna());
            ponerPieza(aux, movimiento.getPosFinal().getFila(), movimiento.getPosFinal().getColumna());
            realizado = true;
        } else {
            System.out.println("La pieza no puede moverse de ese modo.");
            realizado = false;
        }
        return realizado;
    }
    

    /**
     * Hay Piezas Entre: Método que recorre el tablero entre la posición inicial
     * de la pieza, y la posición final a la que queremos que se mueva,
     * comprobando si en esas casillas intermedias existe una pieza.
     *
     * @param movimiento - Movimiento introducido por el usuario.
     * @return True si existe una pieza entre la posición inicial y la final.
     * False si no hay piezas entre ambas posiciones.
     */
    public boolean hayPiezasEntre(Movimiento movimiento) {
        boolean hay = false;
        if (buscarPieza(movimiento.getPosInicial().getFila(), movimiento.getPosInicial().getColumna()).getNombre().compareToIgnoreCase("caballo") == 0) {
            hay = false;
        } else if (movimiento.esHorizontal() == true && movimiento.numHorizontal() > 0) {
            for (int i = movimiento.getPosInicial().getColumna() + 1; i < movimiento.getPosFinal().getColumna(); i++) {
                if (hayPieza(movimiento.getPosInicial().getFila(), i) == true) {
                    hay = true;
                }
            }
        } else if (movimiento.esHorizontal() == true && movimiento.numHorizontal() < 0) {
            for (int i = movimiento.getPosFinal().getColumna() + 1; i < movimiento.getPosInicial().getColumna(); i++) {
                if (hayPieza(movimiento.getPosInicial().getFila(), i) == true) {
                    hay = true;
                }
            }
        } else if (movimiento.esVertical() == true && movimiento.numVertical() > 0) {
            for (int i = movimiento.getPosInicial().getFila() + 1; i < movimiento.getPosFinal().getFila(); i++) {
                if (hayPieza(i, movimiento.getPosInicial().getColumna()) == true) {
                    hay = true;
                }
            }
        } else if (movimiento.esVertical() == true && movimiento.numVertical() < 0) {
            for (int i = movimiento.getPosFinal().getFila() + 1; i < movimiento.getPosInicial().getFila(); i++) {
                if (hayPieza(i, movimiento.getPosInicial().getColumna()) == true) {
                    hay = true;
                }
            }
        } else if (movimiento.numVertical() < 0 && movimiento.numHorizontal() > 0) { //Diagonal hacia ariba derecha: Filas bajan, columnas suben
            for (int i = movimiento.getPosInicial().getFila() - 1, j = movimiento.getPosInicial().getColumna() + 1; i > movimiento.getPosFinal().getFila() && j < movimiento.getPosFinal().getColumna() && hay == false; i--, j++) {
                if (hayPieza(i, j) == true) {
                    hay = true;
                }
            }
        } else if (movimiento.numVertical() < 0 && movimiento.numHorizontal() < 0) { //Diagonal arriba izquierda: Filas bajan, columnas bajan.
            for (int i = movimiento.getPosInicial().getFila() - 1, j = movimiento.getPosInicial().getColumna() - 1; i > movimiento.getPosFinal().getFila() && j > movimiento.getPosFinal().getColumna() && hay == false; i--, j--) {
                if (hayPieza(i, j) == true) {
                    hay = true;
                }
            }

        } else if (movimiento.numVertical() > 0 && movimiento.numHorizontal() > 0) {  //Diagonal abajo derecha: Filas aumentan, columnas aumentan
            for (int i = movimiento.getPosInicial().getFila() + 1, j = movimiento.getPosInicial().getColumna() + 1; i < movimiento.getPosFinal().getFila() && j < movimiento.getPosFinal().getColumna() && hay == false; i++, j++) {
                if (hayPieza(i, j) == true) {
                    hay = true;
                }
            }
        } else if (movimiento.numVertical() > 0 && movimiento.numHorizontal() < 0) { //Diagonal abajo izquierda: Filas aumentan(i), columnas bajan(j)
            for (int i = movimiento.getPosInicial().getFila() + 1, j = movimiento.getPosInicial().getColumna() - 1; i < movimiento.getPosFinal().getFila() && j > movimiento.getPosFinal().getColumna() && hay == false; i++, j--) {
                if (hayPieza(i, j) == true) {
                    hay = true;
                }
            }

        }
        return hay;
    }

//    public boolean comerPeon(Movimiento movimiento) {
//        boolean puedeComer=false;
//        if (buscarPieza(movimiento.getPosInicial().getFila(), movimiento.getPosInicial().getColumna()).getColor().charAt(0) == 'b'
//                && (hayPieza(movimiento.getPosInicial().getFila() + 1, movimiento.getPosInicial().getColumna() + 1)
//                || hayPieza(movimiento.getPosInicial().getFila() + 1, movimiento.getPosInicial().getColumna() - 1)))
//        {
//            puedeComer=true;
//        }else if (hayPieza(movimiento.getPosInicial().getFila()-1,movimiento.getPosInicial().getColumna()-1)
//                || hayPieza(movimiento.getPosInicial().getFila()-1,movimiento.getPosInicial().getColumna()+1) ){
//            puedeComer=true;
//        }else{
//            System.out.println("No puede comer en diagonal.");
//        }
//        
//        return puedeComer;
//    }
}
