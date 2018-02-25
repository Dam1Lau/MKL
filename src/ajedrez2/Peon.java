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
        color = "blanco";
        puntos = 1;
    }

    public Peon(String color) {
        super(color);
        nombre = "Peon";
        puntos = 1;
    }

    //Métodos
    
    /**
     * En el caso del peón el movimiento es válido en estas situaciones:
     *      Si son blancos: Cuando el movimiento vertical es +1 (+2 si nunca se ha movido) y no hay piezas contrarias en sus diagonal.
     *      Si son negros:  Cuando el movimiento vertical es -1 (-2 si nucna se ha movido) y si no hay piezas contrarias en sus diagonales.   
     *      En ambos casos si hay pieza contraria en sus diagonales, tambien pueden moverse en diagonal.
     * @param movimiento - movimiento introducido por el usuario tras comprobarlo.
     * @return boolean = true si el movimiento se puede realizar.
     */
    @Override
    public boolean puedeMoverse(Movimiento movimiento) {
        boolean movi = false;
        if (color.charAt(0)== 'b' && movimiento.esVertical() == true && movimiento.numVertical() == 1) {
            movi = true;
        } else if (color.charAt(0)== 'n' && movimiento.esVertical() == true && movimiento.numVertical() == -1) {
            movi=true;
        }
        
        return movi;
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
