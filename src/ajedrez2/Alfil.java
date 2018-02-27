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
public class Alfil extends Piezas {
    //constructores

    public Alfil() {
        nombre = "Alfil";
        color = "Blanca";
        puntos = 4;
    }

    public Alfil(String color) {
        super(color);
        nombre = "Alfil";
        puntos = 4;
    }

/**
 * Puede Moverse: El alfil podrá moverse siempre y cuando el movimiento introducido por el
 * jugador sea de tipo diagonal.
 * @param movimiento - Movimiento introducido por el usuario.
 * @return boolean True si el movimiento es correcto. False si no puede moverse de ese modo.
 */
    @Override
    public boolean puedeMoverse(Movimiento movimiento) {
        boolean movi = false;
        if(movimiento.esDiagonal() == true)
            movi = true;
        return movi;
    }
    
 /**
  * Dibuja la pieza usando el cñodigo unicode asignado a cada pieza de ajedrez segun su color.
  * @return Símbolo unicode de la pieza.
  */
    @Override
    public String pintarPieza() {
        String pieza;
        if (this.color.compareToIgnoreCase("blanca") == 0) {
            pieza = "\u2657";
        } else {
            pieza = "\u265D";
        }
        return pieza;
    }

}
