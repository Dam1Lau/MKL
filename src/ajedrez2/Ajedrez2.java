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
        j1.comenzarJuego(tab);
        Scanner lector = new Scanner(System.in);
        j1.meterJugada(tab);
        

        
        
        
        
        
        
        
        
        
        
        
        
        
        // pruebas con tablero
//        Tablero p4 = new Tablero();
//        System.out.println(p4.hayPieza(5, 5));
//        p4.ponerPieza(new Caballo(), 5, 5);
//
//        Posicion posicionTest = new Posicion(2, 1);  //fila, columna
//        Posicion posicionDos = new Posicion(0, 0);
//        Posicion posicionReina = new Posicion(4, 4);
//        p4.ponerPieza(new Dama("negra"), posicionReina); //Probando a meter fichas random
//        j1.pintaMe(p4);
//        System.out.println(p4.buscarPieza(0, 0).pintarPieza());
//        System.out.println(p4.buscarPieza(0, 0));
//        System.out.println(p4.buscarPieza(7, 4));  //los nombres salen con null en todas menos caballo y reina WHY
//        System.out.println(p4.buscarPieza(posicionTest));
//
//        Movimiento movi = new Movimiento(posicionDos, posicionTest); //creando un movimiento
//        p4.hacerMovimiento(movi);
//        j1.pintaMe(p4);
//
//        //pruebas strings
////        Scanner lector = new Scanner(System.in);
////        System.out.println("Introduce la jugada:");
////        int c1, f1, c2, f2;
////        String jugadaUsuario = lector.next();
////        c1 = jugadaUsuario.toUpperCase().charAt(0)-65;
////        f1 = jugadaUsuario.toUpperCase().charAt(1)-49;
////        c2 = jugadaUsuario.toUpperCase().charAt(2)-65;
////        f2 = jugadaUsuario.toUpperCase().charAt(3)-49;
////        System.out.println(c1);
////        System.out.println(f1);
////        System.out.println(c2);
////        System.out.println(f2);
//        Movimiento vamoaver = new Movimiento(posicionDos,posicionTest);  //Inicial - Final
//        System.out.println(vamoaver.esDiagonal());
    }

}
