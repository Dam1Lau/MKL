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
public class Caballo extends Piezas {
    //constructores
    
    public Caballo() {
        nombre = "Caballo";
        color = "Blanco";
    }

    public Caballo(String color) {
        super(color);
        nombre = "Caballo";
    }
    
    //Métodos
    
    @Override
    public boolean puedeMoverse(){
        boolean movimiento=false;
    
        
        return movimiento;
    }
    
    @Override
    public String pintarPieza(){
        String pieza;
        if (this.color.compareToIgnoreCase("blanca")==0)
        pieza = "\u2658";
        else
            pieza = "\u265E";
        return pieza;
    }


}