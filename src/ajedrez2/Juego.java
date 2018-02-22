/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez2;

import java.util.Scanner;

/**
 *
 * @author dam1
 */
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

    //Get y Set del Turno
    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    // Métodos 
    public void comenzarJuego(Tablero tablero) {
        System.out.println("***¡Comienza el juego!***");
        pintaMe(tablero);
        System.out.println("* Es el turno de " + this.toString() + " *");
    }

    public void pintaMe(Tablero tablero) {
        System.out.println("   a  b  c d  e f  g  h  ");
        System.out.println("   _____________________");
        for (int i = 0; i < tablero.casillas.length; i++) {
            System.out.print(i+1 + " |");
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
                    && tablero.buscarPieza((int) jugada.charAt(3) - 49, (int) jugada.charAt(2) - 65).getColor().charAt(0) == this.toString().charAt(0)){
                System.out.println("Hay una pieza de tu color en esa posición.");
            } else {
                movi.setPosInicial(new Posicion(jugada.charAt(1) - 49, jugada.charAt(0) - 65));
                movi.setPosFinal(new Posicion(jugada.charAt(3) - 49, jugada.charAt(2) - 65));
                noValido = false;
            }
        }
        return movi;
    }

    @Override
    public String toString() {
        String color;
        if (turno%2 == 0) {
            color = "blancas";
        } else {
            color = "negras";
        }
        return color;
    }
}
