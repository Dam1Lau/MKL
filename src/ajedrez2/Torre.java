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
public class Torre extends Pieza {
 /**
 * Constructor por defecto para Torre. Inicializa su nombre a Torre, color a blanca y puntos a 5.
 */
    public Torre() {
        nombre = "Torre";
        color = "blanca";
        puntos = 5;
    }
/**
 * Constructor para Torre. Como parámetro podemos introducir su color.
 * @param color - recomendado: blanca para pieza de color blanco, negra para pieza de color negro.
 */
    public Torre(String color) {
        super(color);
        nombre = "Torre";
        puntos = 5;
    }
/**
 * Puede Moverse: La torre podrá moverse siempre y cuando el movimiento introducido por el
 * jugador sea de tipo horizontal.
 * @param movimiento - Movimiento introducido por el usuario.
 * @return boolean True si el movimiento es correcto. False si no puede moverse de ese modo.
 */
    @Override
    public boolean puedeMoverse(Movimiento movimiento, Tablero tab) {
        boolean mov = false;
        if (movimiento.esHorizontal() == true || movimiento.esVertical() == true) {
            mov = true;
        }
        return mov;
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
            pieza = "\u2656";
        } else {
            pieza = "\u265C";
        }
        return pieza;
    }

}
