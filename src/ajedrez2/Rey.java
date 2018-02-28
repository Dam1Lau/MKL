/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez2;

/**
 *
 * @author dam1
 */
public class Rey extends Pieza {
/**
 * Constructor por defecto para Rey. Inicializa su nombre a Rey, color a blanca y puntos a 8.
 */
    public Rey() {
        nombre = "Rey";
        color = "blanco";
        puntos = 8;
    }
/**
 * Constructor para Rey. Como parámetro podemos introducir su color.
 * @param color - recomendado: blanca para pieza de color blanco, negra para pieza de color negro.
 */
    public Rey(String color) {
        super(color);
        nombre = "Rey";
        puntos = 8;
    }

/**
 * Puede Moverse: El ey podrá moverse siempre y cuando el movimiento introducido por el
 * jugador sea de tipo horizontal, vertical o diagonal, pero solo de una en una casillas.
 * @param movimiento - Movimiento introducido por el usuario.
 * @return boolean True si el movimiento es correcto. False si no puede moverse de ese modo.
 */
    @Override
    public boolean puedeMoverse(Movimiento movimiento, Tablero tab) {
        boolean movi = false;
        if (Math.abs(movimiento.numHorizontal()) == 1 || Math.abs(movimiento.numVertical()) == 1) {
            movi = true;
        }
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
            pieza = "\u2654";
        } else {
            pieza = "\u265A";
        }
        return pieza;
    }
}
