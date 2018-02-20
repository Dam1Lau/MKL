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
public class Peon extends Piezas {
    //constructores

    public Peon() {
        nombre = "Peon";
        color = "Blanco";
    }

    public Peon(String color) {
        super(color);
        nombre = "Peon";
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
            pieza = "\u2659";
        } else {
            pieza = "\u265F";
        }
        return pieza;
    }

}
