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
//        Tablero tab = new Tablero();
        pintaMe(tablero);
        System.out.println(this.toString());
    }

    public void pintaMe(Tablero tablero) {
        int num = 1;
        System.out.println("   a  b  c d  e f  g  h  ");
        System.out.println("   _____________________");
        for (int i = 0; i < tablero.casillas.length; i++, num++) {
            System.out.print(num + " |");
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
     * @param jugada El usuario solo puede introducir una jugada de esta forma
     * "A1B1" donde las letras son las columnas del movimiento, y los números
     * las filas del movimiento generado. Si la jugada genera un movimiento no
     * válido, le debe preguntar de nuevo por el movimiento que desea
     * introducir.
     * @param tablero
     * @return
     */
    public Movimiento meterJugada(Tablero tablero) {  //ESTE ES IGUAL QUE EL PRIMERO QUE HICE EN EL CONSTRUCTOR DE MOVIMIENTO D:
        boolean noValido = true;
        Movimiento movi = new Movimiento();
        Scanner lector = new Scanner(System.in);
        while (noValido == true) {
            System.out.println("Introduce la jugada:");
            String jugada = lector.next();
            if (jugada.length() != 4) {
                System.out.println("Jugada inválida, introduce una jugada de cuatro caracteres en éste orden: A1C2");
            } else if (jugada.toUpperCase().charAt(0) < 'A' || jugada.toUpperCase().charAt(0) > 'H' || jugada.toUpperCase().charAt(2) < 'A' || jugada.toUpperCase().charAt(2) > 'H') {
                System.out.println("Jugada incorrecta. Ha introducido una letra inválida o en posición errónea.");
            } else if (jugada.charAt(1) < '1'   //OJO aqui habiae cambiado los '1' y no iba bien ni casteando a (int) 
                    || jugada.charAt(1) > '8'
                    || jugada.charAt(3) < '1'
                    || jugada.charAt(3) > '8') {
                System.out.println("Jugada incorrecta. Ha introducido un número inválido o en posición incorrecta.");
            } else {
                movi.setPosInicial(new Posicion(jugada.toUpperCase().charAt(1) - 49,jugada.toUpperCase().charAt(0) -65));
                movi.setPosFinal(new Posicion(jugada.toUpperCase().charAt(3) - 49, jugada.toUpperCase().charAt(2) - 65));
                noValido = false;
            }
        }
        return movi;
    }

    @Override
    public String toString() {
        String color;
        if (turno == 0) {
            color = " BLANCAS";
        } else {
            color = " NEGRAS";
        }
        return "Es el turno de" + color;
    }
}
