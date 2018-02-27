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
        nombre = "caballo";
        color = "Blanco";
        puntos = 3;
    }

    public Caballo(String color) {
        super(color);
        nombre = "caballo";
        puntos = 3;
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
     /**
  * Dibuja la pieza usando el cñodigo unicode asignado a cada pieza de ajedrez segun su color.
  * @return Símbolo unicode de la pieza.
  */
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