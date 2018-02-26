/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez2;

import java.util.Scanner;

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
        //tab.ponerPieza(new Alfil("blanca"), 5, 4);
        j1.comenzarJuego(tab);
        Scanner lector = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            tab.hacerMovimiento(j1.meterJugada(tab));
            j1.pintaMe(tab);
            j1.setTurno(i+1);
            System.out.println("Turno de " + j1.toString());
            
        }
        System.out.println("FIN DEL JUEGO");
        j1.recuentoFinal(tab);
        
//        tab.hacerMovimiento(j1.meterJugada(tab),tab);
//        j1.pintaMe(tab);
    }

}

/*NOTAS A HACER:
- Peones: Movimiento comer en diagonal y poder avanzar 2 casillas en el primer turno
- Comprobar el caballo
- Añadir puntuación a cada pieza

*/