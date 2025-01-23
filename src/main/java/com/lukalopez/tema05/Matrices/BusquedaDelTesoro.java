package com.lukalopez.tema05.Matrices;

import com.lukalopez.lib.Random;

public class BusquedaDelTesoro {
    private enum Celda {
        VACIA(Config.SPRITE_VACIO),
        NPC(Config.SPRITE_NPC),
        OBSTACULO(Config.SPRITE_OBSTACULO),
        TESORO(Config.SPRITE_TESORO),
        JUGADOR(Config.SPRITE_JUGADOR),
        EXCAVADA(Config.SPRITE_EXCAVADA),
        HABILIDAD(Config.SPRITE_HABILIDAD);

        private final String sprite;

        Celda(String sprite) {
            this.sprite = sprite;
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }

    public static void generarMapa(Celda[][] mapa) {
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                mapa[i][j]=Celda.VACIA;
                posicionesLibres[cantidadPosicionesLibres++] = new Posicion(i,j);
            }
        }

        //Generamos obstaculos
        for (int i = 0; i < Config.CANTIDAD_OBSTACULOS; i++) {
            generarCeldaAleatoria(Celda.OBSTACULO);
        }
        generarCeldaAleatoria(Celda.JUGADOR);
    }

    private static Celda[][] mapa;
    private static Posicion[] posicionesLibres;
    private static int cantidadPosicionesLibres;

    public static void reset(){

    }

    public static void main(String[] args) {
        mapa = new Celda[Config.FILAS][Config.COLUMNAS];
        cantidadPosicionesLibres = Config.FILAS*Config.COLUMNAS;
        posicionesLibres = new Posicion[cantidadPosicionesLibres];

        generarMapa(mapa);
        System.out.println(mapaToString(mapa));
    }

    public static void generarCeldaAleatoria(Celda celda){
        //Si no hay posiciones libres, salimos.
        if (cantidadPosicionesLibres == 0){
            return;
        }
        //Generamos un indice aleatorio
        int indiceAleatorio = Random.randomInt(0,cantidadPosicionesLibres-1);
        //Obtenemos la posición que hay en ese indicce
        Posicion posicion = posicionesLibres[indiceAleatorio];
        //Decrementamos la cantidad de posiciones libres
        cantidadPosicionesLibres--;
        //Ubicamos el último elemento en la posición que acabamos de extraer
        posicionesLibres[indiceAleatorio]=posicionesLibres[cantidadPosicionesLibres];
        //Finalmente ponemos la celda que hemos recibidod cómo parámetro en la posición indicada
        mapa[posicion.fila][posicion.columna] = celda;
    }

    public static String mapaToString(Celda[][] mapa) {
        StringBuilder sb = new StringBuilder();
        sb.append(Celda.OBSTACULO.sprite.repeat(Config.COLUMNAS+2)).append("\n");
        for (Celda[] fila: mapa){
            for (Celda celda : fila){
                sb.append(celda);
            }
            sb.append("\n");
        }
        sb.append(Celda.OBSTACULO.sprite.repeat(Config.COLUMNAS+2)).append("\n");
        return sb.toString();
    }

    public static class Posicion {
        private int fila;
        private int columna;

        public int getFila() {
            return fila;
        }

        public int getColumna() {
            return columna;
        }

        public void setColumna(int columna) {
            this.columna = columna;
        }

        public void setFila(int fila) {
            this.fila = fila;
        }

        public Posicion(int fila, int columna){

            this.fila=fila;
            this.columna=columna;
        }
    }
}
