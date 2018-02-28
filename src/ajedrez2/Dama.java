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
public class Dama extends Pieza {
/**
 * Constructor por defecto para Dama. Inicializa su nombre a Dama, color a blanca y puntos a 10.
 */
    public Dama() {
        nombre = "Reina";
        color = "Blanca";
        puntos = 10;
    }
/**
 * Constructor para Dama. Como parámetro podemos introducir su color.
 * @param color - recomendado: blanca para pieza de color blanco, negra para pieza de color negro.
 */
    public Dama(String color) {
        super(color);
        nombre = "Reina";
        puntos = 10;
    }

/**
 * Puede Moverse: La reina o dama podrá moverse en diagonal, horizontal o vertical tantas casillas
 * como el usuario introduzca.
 * @param movimiento - Movimiento introducido por el usuario.
 * @return boolean True si el movimiento es correcto. False si no puede moverse de ese modo.
 */
    @Override
    public boolean puedeMoverse(Movimiento movimiento, Tablero tab) {
        boolean movi = false;
        if(movimiento.esDiagonal() || movimiento.esHorizontal() || movimiento.esVertical())
            movi = true;
        return movi;
    }
 /**
  * Dibuja la pieza usando el cñodigo unicode asignado a cada pieza de ajedrez segun su color.
  * @return Símbolo unicode de la pieza.
  */
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
