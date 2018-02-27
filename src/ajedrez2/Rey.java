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
public class Rey extends Piezas {
    //constructores

    public Rey() {
        nombre = "Rey";
        color = "blanco";
    }

    public Rey(String color) {
        super(color);
        nombre = "Rey";
    }

    //Métodos
    @Override
    public boolean puedeMoverse(Movimiento movimiento) {
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
