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
public class Ajedrez2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Juego j1 = new Juego();
        Tablero tab = new Tablero();
        j1.comenzarJuego(tab);
        
    }

}

/*NOTAS A HACER:
- Peones: Movimiento comer en diagonal
- Peones negros vuelven hacia atras 1 casilla WHYYY
*/