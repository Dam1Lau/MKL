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
     * Comprobación de que el movimiento introducido es diagonal o no. Para ello
     * restas las coordenadas (fila, columna) de la posicion final con las
     * coordenadas de la posicion inicial en valor absoluto (Math.abs) para que
     * si retrocedemos de fila o columna podamos hacer la comparación.
     *
     * @return = true si el movimiento que comprueba el método es diagonal.
     */
    public boolean esDiagonal() {
        boolean diagonal = false;
        if (Math.abs(numVertical()) == Math.abs(numHorizontal())) {
            diagonal = true;
        }
        return diagonal;
    }

    /**
     * Numero Horizontal hace el cálculo de cuantas casillas se ha movido la
     * pieza, horizontalmente, para ayudarnos en cada pieza a comprobar si el
     * movimiento es válido o no.
     *
     * @return int - número de casillas en horizontal que se desplaza la pieza
     * en cada movimiento.
     */
    public int numHorizontal() {
        int numero = posFinal.getColumna() - posInicial.getColumna();
        return numero;
    }

    /**
     * Numero Vertical hace el hace el cálculo de cuantas casillas se ha movido
     * la pieza, verticalmente, para ayudarnos en cada pieza a comprobar si el
     * movimiento es válido o no.
     *
     * @return int - número de casillas en vertical que se desplaza la pieza
     * en cada movimiento.
     */
    public int numVertical() {
        int numero = posFinal.getFila() - posInicial.getFila();
        return numero;
    }

    @Override
    public String toString() {
        return "Movimiento{" + "posInicial=" + posInicial + ", posFinal=" + posFinal + '}';
    }

}
