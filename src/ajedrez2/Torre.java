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
public class Torre extends Piezas {
    //constructores

    public Torre() {
        nombre = "Torre";
        color = "Blanca";
    }

    public Torre(String color) {
        super(color);
        nombre = "Torre";
    }

    //Métodos
    @Override
    public boolean puedeMoverse(Movimiento movimiento) {
        boolean mov = false;
        if (movimiento.esHorizontal() == true || movimiento.esVertical() == true) {
            mov = true;
        }
        return mov;
    }

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
