
package ajedrez2;

/**
 *
 * @author dam1
 */
public class Alfil extends Pieza {

/**
 * Constructor por defecto para Alfil. Inicializa su nombre a Alfil, color a blanca y puntos a 4.
 */
    public Alfil() {
        nombre = "alfil";
        color = "blanca";
        puntos = 4;
    }
/**
 * Constructor para Alfil. Como parámetro podemos introducir su color.
 * @param color - recomendado: blanca para pieza de color blanco, negra para pieza de color negro.
 */
    public Alfil(String color) {
        super(color);
        nombre = "alfil";
        puntos = 4;
    }

/**
 * Puede Moverse: El alfil podrá moverse siempre y cuando el movimiento introducido por el
 * jugador sea de tipo diagonal.
 * @param movimiento - Movimiento introducido por el usuario.
 * @return boolean True si el movimiento es correcto. False si no puede moverse de ese modo.
 */
    @Override
    public boolean puedeMoverse(Movimiento movimiento, Tablero tab) {
        boolean movi = false;
        if(movimiento.esDiagonal() == true)
            movi = true;
        return movi;
    }
    
 /**
  * Dibuja la pieza usando el código unicode asignado a cada pieza de ajedrez segun su color.
  * @return String: Símbolo unicode de la pieza.
  */
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
