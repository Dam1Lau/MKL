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
    }

    public Dama(String color) {
        super(color);
        nombre = "Reina";
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
            pieza = "\u2655";
        } else {
            pieza = "\u265B";
        }
        return pieza;
    }
}
