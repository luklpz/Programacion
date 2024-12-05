package com.lukalopez.tema05.Matrices;

import com.lukalopez.lib.IO;

import java.util.Arrays;

public class Ejercicio3 {
    private enum Ficha{
        O,X,N
    }

    private enum Jugador{
        PLAYER1,PLAYER2
    }

    private static void reset(Ficha[][] tablero){
        for (Ficha[] fichas : tablero) {
            Arrays.fill(fichas, Ficha.N);
        }
        turnoActual=Jugador.PLAYER1;
    }

    private static void play(Ficha[][] tablero){
        boolean esJugadaValida;
        int fila, columna;
        do {
            //Solicitamos la fila
            if (turnoActual==Jugador.PLAYER1){
                System.out.println("PLAYER 1 [X]");
            } else {
                System.out.println("PLAYER 2 [O]");
            }
            fila= IO.solicitarInt("Ingrese la fila: ",1,3,"Entrada no válida. Filas: 1-2-3")-1;
            columna = IO.solicitarInt("Ingrese la columna: ",1,3,"Entrada no válida. Filas: 1-2-3")-1;
            esJugadaValida=esJugadaValida(tablero,fila,columna);
            if (!esJugadaValida){
                System.err.println("La posición indicada ya está ocupada. Seleccione otra posición.");
            }
            else {
                if (turnoActual==Jugador.PLAYER1){
                    tablero[fila][columna]=Ficha.X;
                    turnoActual=Jugador.PLAYER2;
                } else {
                    tablero[fila][columna]=Ficha.O;
                    turnoActual=Jugador.PLAYER1;
                }
            }
        } while (!esJugadaValida);

    }

    private static boolean esJugadaValida(Ficha[][] tablero, int fila, int columna){
        return tablero[fila][columna] == Ficha.N;
    }

    private static String tableroToString(Ficha[][] tablero){
        StringBuilder sb = new StringBuilder();
        sb.append("\n***TABLERO***\n");
        for (Ficha[] fila : tablero){
            sb.append("   ");
            for (Ficha valor : fila){
                if (valor==Ficha.N){
                    sb.append("-");
                } else {
                    sb.append(valor);
                }
                sb.append("  ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private static boolean esJugadaGanadora(Ficha[][] tablero){

        for (Ficha[] fila : tablero){
            if (fila[0]==fila[1]&&fila[1]==fila[2]&&fila[1]!=Ficha.N){
                ganador=fila[1];
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (tablero[i][0]==tablero[i][1]&&tablero[i][1]==tablero[i][2]&&tablero[i][1]!=Ficha.N){
                ganador=tablero[i][1];
                return true;
            }
        }

        if (tablero[0][0]==tablero[1][1]&&tablero[1][1]==tablero[2][2]&&tablero[1][1]!=Ficha.N){
            ganador=tablero[1][1];
            return true;
        }

        if (tablero[0][2]==tablero[1][1]&&tablero[1][1]==tablero[2][0]&&tablero[1][1]!=Ficha.N){
            ganador=tablero[1][1];
        } else{
            for (Ficha[] fila : tablero) {
                for (Ficha valor : fila) {
                    if (valor==Ficha.N){
                        return false;
                    }
                }
            }
            ganador=Ficha.N;
        }
        return true;
    }

    private static Ficha ganador;

    //False==PLAYER1==X/True==PLAYER2==O
    private static Jugador turnoActual;

    public static void main(String[] args) {
        Ficha[][] tablero = new Ficha[3][3];
        boolean cerrar=true;
        int jugarOtraVez;

        do {
            reset(tablero);
            do {
                System.out.println(tableroToString(tablero));
                play(tablero);
            } while (!esJugadaGanadora(tablero));

            System.out.println(tableroToString(tablero));

            switch (ganador){
                case N -> System.out.println("\n***EMPATE***\n");
                case X -> System.out.println("\n***PLAYER1 GANA***\n");
                case O -> System.out.println("\n***PLAYER2 GANA***\n");
            }

            jugarOtraVez = IO.solicitarInt("¿Quieres jugar otra vez? (Si=1)","Has de introducir un número.");
            if (jugarOtraVez==1){
                cerrar=false;
            }
        } while (!cerrar);

    }
}
