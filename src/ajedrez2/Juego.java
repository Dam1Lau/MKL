package ajedrez2;

import java.util.Scanner;

public class Juego {

    /**
     * Turno tomará dos valores: 0 si es el turno de las piezas blancas 1 si lo
     * es el de las piezas negras
     */
    private int turno;

    /**
     * CONSTRUCTOR DEL JUEGO El juego siempre comienza en el turno de las piezas
     * blancas.
     */
    public Juego() {
        this.turno = 0;
    }

    /**
     * Get turno: Nos devuelve el turno en el que nos encontramos.
     *
     * @return Número entero indicando el turno.
     */
    public int getTurno() {
        return turno;
    }

    /**
     * Set turno: Nos permite cambiar el turno en el que nos encontramos.
     *
     * @param turno - número entero para cambiar el turno anterior por el nuevo
     * introducido.
     */
    public void setTurno(int turno) {
        this.turno = turno;
    }

    /**
     * Comenzar juego: Encargado de realizar las acciones necesarias para poder
     * jugar. Indica el turno, pinta el tablero si el movimiento se realiza, y
     * al finalizar el juego muestra puntuación final.
     *
     * @param tablero - tablero en el que estamos jugando.
     */
    public void comenzarJuego(Tablero tablero) {
        System.out.println("***¡Comienza el juego!***");
        pintaMe(tablero);
        System.out.println("* Es el turno de " + this.toString() + " *");
        Scanner lector = new Scanner(System.in);
        for (int i = 0; i < 50; i++) {
            //tablero.hacerMovimiento(this.meterJugada(tablero));
            if (tablero.hacerMovimiento(this.meterJugada(tablero)) == true) {
                this.pintaMe(tablero);
                this.setTurno(i + 1);
                System.out.println("Turno de " + this.toString());
            } else {
                System.out.println("Turno de: " + this.toString());
            }
        }
        System.out.println("FIN DEL JUEGO");
        this.recuentoFinal(tablero);
    }

    /**
     * Pintame: Dibuja el tablero en el que jugamos. Llama al método pintarPieza
     * e introduce en los lugares vacios del array un espacio en blanco.
     *
     * @param tablero - tablero en el que jugamos. Necesario para acceder a las
     * casillas.
     */
    public void pintaMe(Tablero tablero) {
        System.out.println("   a  b  c d  e f  g  h  ");
        System.out.println("   _____________________");
        for (int i = 0; i < tablero.casillas.length; i++) {
            System.out.print(i + 1 + " |");
            for (int j = 0; j < tablero.casillas.length; j++) {
                if (tablero.casillas[i][j] != null) {
                    System.out.print(tablero.casillas[i][j].pintarPieza() + " ");
                } else {
                    System.out.print("\u2003 ");
                }
            }
            System.out.println("|");
        }
        System.out.println("   ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");

    }

    /**
     * Preguntará al usuario el movimiento que quiere hacer (su jugada) y eso
     * hará que se genere un movimiento.
     *
     * El usuario solo puede introducir una jugada de esta forma "A1B1" donde
     * las letras son las columnas del movimiento, y los números las filas del
     * movimiento generado. Si la jugada genera un movimiento no válido, le debe
     * preguntar de nuevo por el movimiento que desea introducir. Además,
     * debemos hacer todas las comprobaciones necesarias para estar seguros de
     * que el movimiento es correcto antes de devolver el movimiento en el
     * ultimo paso.
     *
     * @param tablero
     * @return movimiento válido tras las comprobaciones
     */
    public Movimiento meterJugada(Tablero tablero) {
        boolean noValido = true;
        Movimiento movi = new Movimiento();
        Scanner lector = new Scanner(System.in);
        while (noValido == true) {
            System.out.println("Introduce la jugada:");
            String jugada = lector.nextLine().toUpperCase();
            if (jugada.length() != 4) {
                System.out.println("Jugada inválida, introduce una jugada de cuatro caracteres en éste orden: A1C2");
            } else if (jugada.charAt(0) < 'A' || jugada.charAt(0) > 'H' || jugada.charAt(2) < 'A' || jugada.charAt(2) > 'H') {
                System.out.println("Jugada incorrecta. Ha introducido una letra inválida o en posición errónea.");
            } else if ((int) jugada.charAt(1) < 49
                    || jugada.charAt(1) > '8'
                    || jugada.charAt(3) < '1'
                    || jugada.charAt(3) > '8') {
                System.out.println("Jugada incorrecta. Ha introducido un número inválido o en posición incorrecta.");
            } else if (tablero.hayPieza((int) jugada.charAt(1) - 49, (int) jugada.charAt(0) - 65) == false) {
                System.out.println("No hay pieza en esa casilla.");
            } else if (tablero.buscarPieza((int) jugada.charAt(1) - 49, (int) jugada.charAt(0) - 65).getColor().charAt(0) != this.toString().charAt(0)) {
                System.out.println("Esa pieza no es de tu color. No es tu turno.");

            } else if (tablero.hayPieza(jugada.charAt(3) - 49, jugada.charAt(2) - 65) == true
                    && tablero.buscarPieza((int) jugada.charAt(3) - 49, (int) jugada.charAt(2) - 65).getColor().charAt(0) == this.toString().charAt(0)) {
                System.out.println("Hay una pieza de tu color en esa posición.");
            } else {
                movi.setPosInicial(new Posicion(jugada.charAt(1) - 49, jugada.charAt(0) - 65));
                movi.setPosFinal(new Posicion(jugada.charAt(3) - 49, jugada.charAt(2) - 65));
                if (tablero.hayPiezasEntre(movi) == true) {
                    System.out.println("Hay pieza entre la tuya y la posición introducida.");
                } else {
                    noValido = false;
                }
            }
        }
        return movi;
    }

    /**
     * Cuando el juego ha finalizado, se llama a este método que se encargará de
     * recorrer el tablero y al ir encontrando piezas, observa cuál es su color
     * y añade la puntuación de cada pieza al contador de cada color. Finalmente
     * imprime el resultado en puntos.
     *
     * @param tablero
     */
    public void recuentoFinal(Tablero tablero) {
        int blancas = 0, negras = 0;
        for (int i = 0; i < tablero.casillas.length; i++) {
            for (int j = 0; j < tablero.casillas.length; j++) {
                if (tablero.buscarPieza(i, j) != null && tablero.buscarPieza(i, j).getColor().charAt(0) == 'b') {
                    blancas = blancas + tablero.buscarPieza(i, j).getPuntos();
                } else if (tablero.buscarPieza(i, j) != null) {
                    negras = negras + tablero.buscarPieza(i, j).getPuntos();
                }
            }
        }
        System.out.println("Puntuación blancas: " + blancas);
        System.out.println("Puntuación negras: " + negras);

    }
/**
 * Devuelve el turno en el que nos encontramos. En caso de que el turno sea par, es el turno de las piezas blancas.
 * Si el turno es un número impar, es el turno de las piezas negras.
 * @return 
 */
    @Override
    public String toString() {
        String color;
        if (turno % 2 == 0) {
            color = "blancas";
        } else {
            color = "negras";
        }
        return color;
    }
}
