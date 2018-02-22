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
    public boolean puedeMoverse(Movimiento movimiento){
        boolean movi=false;
        if(movimiento.esHorizontal() !=true 
                && movimiento.esVertical() != true 
                && movimiento.esDiagonal()!= true 
                && Math.abs(movimiento.numHorizontal()) <3
                && Math.abs(movimiento.numVertical()) <3){
            movi = true;
        }
        return movi;
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