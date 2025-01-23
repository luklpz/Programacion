package com.lukalopez.tema05.Matrices;

import com.lukalopez.lib.Matriz;
import com.lukalopez.lib.Random;

public class Ejercicio5 {

    /**
     * Colocar los NPC en el tablero
     *
     * @param mapa 'String[][]' mapa sobre el que trabajar.
     * @param DIMENSION_MAPA Dimensiones que tiene el mapa.
     * @param CANTIDAD_NPC Cantidad de NPC que se van a colocar.
     * @param LATITUD_TESORO Latitud en la que está ubicado el tesoro.
     * @param LONGITUD_TESORO Longitud en la que está ubicado el tesoro.
     * @return Devuelve el tablero con los NPC colocados
     */
    private static String[][] colocarNPC(String[][] mapa,int DIMENSION_MAPA, int CANTIDAD_NPC, int LATITUD_TESORO, int LONGITUD_TESORO){
        boolean posicionValida=false;
        int latitud;
        int longitud;
        String[] fila = new String[DIMENSION_MAPA];
        String[] columna = new String[DIMENSION_MAPA];
        boolean fila_vacia;
        boolean columna_vacia;
/*
        for (int i = 1; i < CANTIDAD_NPC+1; i++) {
            do {
                switch (i-(4*( i/4))) {
                    case 0 -> {
                        //Noroeste
                        latitud = Random.randomInt(0,DIMENSION_MAPA-1);
                        longitud = Random.randomInt(0,DIMENSION_MAPA-1);
                    }
                    case 1 -> {
                        //Noreste
                        latitud = Random.randomInt(0,DIMENSION_MAPA-1);
                        longitud = Random.randomInt(0,DIMENSION_MAPA-1);
                    }
                    case 2 -> {
                        //Suroeste
                        latitud = Random.randomInt(0,DIMENSION_MAPA-1);
                        longitud = Random.randomInt(0,DIMENSION_MAPA-1);
                    }
                    case 3 -> {
                        //Sureste
                        latitud = Random.randomInt(0,DIMENSION_MAPA-1);
                        longitud = Random.randomInt(0,DIMENSION_MAPA-1);
                    }
                    default -> {
                        System.err.println();
                    }

                }
                if (!(latitud==LATITUD_TESORO)&&!(longitud==LONGITUD_TESORO)&&(mapa[latitud][longitud]==null)){
                    fila_vacia = filaVacia(Matriz.extraerFila(mapa,latitud));
                    columna_vacia = filaVacia(Matriz.extraerColumna(mapa,longitud));

                    if (fila_vacia&&columna_vacia){
                        mapa[latitud][longitud]="N";
                        posicionValida=true;
                    }
                }
            } while (!posicionValida);
        }*/
        return mapa;
    }

    private static boolean filaVacia(String fila[]){
        for (String valor : fila){
            if (!valor.equals(null)){
                return true;
            }
        }
        return false;
    }

    /*private static String[][] rellenarMapa(String[][] mapa, int DIMENSION_MAPA, int CANTIDAD_NPC, int CANTIDAD_TESOROS, int CANTIDAD_OBSTACULOS, int LATITUD_TESORO, int LONGITUD_TESORO){
        mapa = new String[DIMENSION_MAPA][DIMENSION_MAPA];
        colocarNPC();
    }*/

    public static void main(String[] args) {
        String[][] mapa;
        final int DIMENSION_MAPA = 8;
        final int CANTIDAD_NPC = 4;
        final int CANTIDAD_TESOROS = 1;
        final int CANTIDAD_USOS_PALA = 3;
        final int CANTIDAD_OBSTACULOS = 4;
        final int LATITUD_TESORO = Random.randomInt(0,DIMENSION_MAPA-1);
        final int LONGITUD_TESORO = Random.randomInt(0,DIMENSION_MAPA-1);
    }
}
