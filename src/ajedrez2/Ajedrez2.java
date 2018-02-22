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
        tab.ponerPieza(new Rey("blanca"),5,4);
        j1.comenzarJuego(tab);
        Scanner lector = new Scanner(System.in);
        tab.hacerMovimiento(j1.meterJugada(tab),tab);
        j1.pintaMe(tab);
    }

}
