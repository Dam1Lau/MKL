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
public class Movimiento {

    private Posicion posInicial;
    private Posicion posFinal;

    //construct
    public Movimiento() {
//        boolean noValido = true;
//        Scanner lector = new Scanner(System.in);
//        while (noValido == true) {
//            System.out.println("Introduzca su movimiento:");
//            String jugadaUsuario = lector.next();
//            if(jugadaUsuario.length()!=4)
//                System.out.println("Jugada inválida, introduce una jugada de cuatro caracteres en éste orden: A1C2");
//            else if(jugadaUsuario.toUpperCase().charAt(0)<'A' || jugadaUsuario.toUpperCase().charAt(0)> 'H' || jugadaUsuario.toUpperCase().charAt(2)<'A' || jugadaUsuario.toUpperCase().charAt(2)>'H')
//                System.out.println("Jugada incorrecta. Ha introducido una letra inválida o en posición errónea.");
//            else if(jugadaUsuario.charAt(1)<'1' || jugadaUsuario.charAt(1)>'8' || jugadaUsuario.charAt(3)<'1' || jugadaUsuario.charAt(3)>'8')
//                System.out.println("Jugada incorrecta. Ha introducido un número inválido o en posición incorrecta.");
//            else{
//                Posicion ini = new Posicion(jugadaUsuario.toUpperCase().charAt(0)- 65,jugadaUsuario.toUpperCase().charAt(1) - 49);
//                posInicial = ini;
//                Posicion fin = new Posicion(jugadaUsuario.toUpperCase().charAt(2) - 65,jugadaUsuario.toUpperCase().charAt(3) - 49);
//                posFinal = fin;
//                noValido = false;
//            }
//        }
    }

    public Movimiento(Posicion posInicial, Posicion posFinal) {
        this.posInicial = posInicial;
        this.posFinal = posFinal;
    }

    //get set
    public Posicion getPosInicial() {
        return posInicial;
    }

    public void setPosInicial(Posicion posInicial) {
        this.posInicial = posInicial;
    }

    public Posicion getPosFinal() {
        return posFinal;
    }

    public void setPosFinal(Posicion posFinal) {
        this.posFinal = posFinal;
    }

    // metodos
    public boolean esVertical() {
        boolean vertical = false;
        if (posInicial.getColumna() == posFinal.getColumna() && posInicial != posFinal) {
            vertical = true;
        }
        return vertical;
    }

    public boolean esHorizontal() {
        boolean horizontal = false;
        if (posInicial.getFila() == posFinal.getFila() && posInicial != posFinal) {
            horizontal = true;
        }
        return horizontal;
    }
    /**
     * Comprobación de que el movimiento introducido es diagonal o no. Para ello restas las coordenadas (fila, columna)
     * de la posicion final con las coordenadas de la posicion inicial en valor absoluto (Math.abs)
     * para que si retrocedemos de fila o columna podamos hacer la comparación.
     * @return = true si el movimiento que comprueba el método es diagonal.
     */
    public boolean esDiagonal() {
        boolean diagonal = false;
        if (Math.abs(posFinal.getFila() - posInicial.getFila()) == Math.abs(posFinal.getColumna() - posInicial.getColumna()) && posInicial != posFinal) {
            diagonal = true;
        }
        return diagonal;
    }

    public int numHorizontal() {
        int numero = Math.abs(posFinal.getColumna() - posInicial.getColumna()); 
        return numero;
    }

    public int numVertical() {
        int numero = Math.abs(posFinal.getFila() - posInicial.getFila()); 
        return numero;
    }

    @Override
    public String toString() {
        return "Movimiento{" + "posInicial=" + posInicial + ", posFinal=" + posFinal + '}';
    }

}