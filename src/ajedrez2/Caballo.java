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
/**
 * Constructor por defecto para la pieza Caballo. 
 */
    public Caballo() {
        nombre = "caballo";
        color = "Blanco";
        puntos = 3;
    }
/**
 * Constructor para pieza Caballo.
 * @param color - recomendado: blanca para pieza de color blanco, negra para pieza de color negro.
 */
    public Caballo(String color) {
        super(color);
        nombre = "caballo";
        puntos = 3;
    }
    
/**
 * Puede Moverse: El caballo podrá moverse siempre y cuando el movimiento introducido por el
 * jugador no sea ni vertical, ni horizontal ni diagonal, pero el salto dado en vertical y horizontal sea 
 * menor que 3 (hasta dos casillas).
 * @param movimiento - Movimiento introducido por el usuario.
 * @return boolean True si el movimiento es correcto. False si no puede moverse de ese modo.
 */
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