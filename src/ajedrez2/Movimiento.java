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

    /**
     * Constructor por defecto para un movimiento.
     */
    public Movimiento() {

    }

    /**
     * Constructor para crear un nuevo movimiento, introduciendo dos parámetros
     * de tipo Posicion.
     *
     * @param posInicial - de clase Posicion. Es la posición inicial del
     * movimiento. De donde parte la pieza.
     * @param posFinal - de clase Posicion. Es la posición final del movimiento.
     * A dónde muevo la pieza.
     */
    public Movimiento(Posicion posInicial, Posicion posFinal) {
        this.posInicial = posInicial;
        this.posFinal = posFinal;
    }

    /**
     * Get posicion inicial. Para conocer el contenido de la posición inicial.
     *
     * @return una Posicion, en éste caso la inicial. De donde parte el
     * movimiento de la pieza.
     */
    public Posicion getPosInicial() {
        return posInicial;
    }

    /**
     * Set posicion inicial: Para cambiar el cotenido de la posición inicial.
     *
     * @param posInicial - Posición Inicial.
     */
    public void setPosInicial(Posicion posInicial) {
        this.posInicial = posInicial;
    }

    /**
     * Get posicion final. Para conocer el contenido de la posición final.
     *
     * @return una Posicion, en éste caso la final. Dónde se quiere colocar
     * finalmente la pieza.
     */
    public Posicion getPosFinal() {
        return posFinal;
    }

    /**
     * Set posicion final. Para cambiar el contenido de la posición final.
     *
     * @param posFinal - Posición Final.
     */
    public void setPosFinal(Posicion posFinal) {
        this.posFinal = posFinal;
    }

    /**
     * Es vertical - Nos indica si el movimiento introducido es vertical
     * comparando la columna de donde parte el movimiento con la columna a la
     * que llega (posición inicial y final). Si seguimos en la misma columna, el
     * movimiento es vertical.
     *
     * @return True si efectivamente es vertical. False si no lo es.
     */
    public boolean esVertical() {
        boolean vertical = false;
        if (posInicial.getColumna() == posFinal.getColumna() && posInicial != posFinal) {
            vertical = true;
        }
        return vertical;
    }

    /**
     * Es horizontal - Nos indica si el movimiento introducido es horizontal
     * comparando la fila de donde parte el movimiento con la fila a la que
     * llega (posición inicial y final).Si seguimos en la misma fila, el
     * movimiento es horizontal.
     *
     * @return True si efectivamente es horizontal. False si no lo es.
     */
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
     * coordenadas de la posicion inicial en valor absoluto (Math.abs) para que,
     * si retrocedemos de fila o columna, podamos hacer la comparación.
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
     * Numero Horizontal: hace el cálculo de cuantas casillas se ha movido la
     * pieza horizontalmente para ayudarnos a comprobar si el
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
     * Numero Vertical: hace el hace el cálculo de cuantas casillas se ha movido
     * la pieza verticalmente, para ayudarnos a comprobar si el
     * movimiento es válido o no.
     *
     * @return int - número de casillas en vertical que se desplaza la pieza en
     * cada movimiento.
     */
    public int numVertical() {
        int numero = posFinal.getFila() - posInicial.getFila();
        return numero;
    }

    /**
     * To String - Devuelve los valores de los atributos de la clase Movimiento.
     *
     * @return String con el valor de posInicial y de posFinal.
     */
    @Override
    public String toString() {
        return "Movimiento{" + "posInicial=" + posInicial + ", posFinal=" + posFinal + '}';
    }

}
