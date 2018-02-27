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
public class Dama extends Piezas {
    //constructores

    public Dama() {
        nombre = "Reina";
        color = "Blanca";
        puntos = 10;
    }

    public Dama(String color) {
        super(color);
        nombre = "Reina";
        puntos = 10;
    }

    //Métodos
    @Override
    public boolean puedeMoverse(Movimiento movimiento) {
        boolean movi = false;
        if(movimiento.esDiagonal() || movimiento.esHorizontal() || movimiento.esVertical())
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
            pieza = "\u2655";
        } else {
            pieza = "\u265B";
        }
        return pieza;
    }
}
