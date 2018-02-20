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
    }

    public Alfil(String color) {
        super(color);
        nombre = "Alfil";
    }

    //Métodos
    @Override
    public boolean puedeMoverse() {
        boolean movimiento = false;

        return movimiento;
    }

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
