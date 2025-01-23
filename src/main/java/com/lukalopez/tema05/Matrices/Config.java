package com.lukalopez.tema05.Matrices;

import com.lukalopez.lib.Random;

public class Config {
    //Constantes de configuración general
    public static final int FILAS = 8;
    public static final int COLUMNAS = FILAS*2;
    public static final int USUS_PICO = 3;
    public static final int CANTIDAD_OBSTACULOS = FILAS-1;
    public static final int CANTIDAD_NPC = FILAS*COLUMNAS/4;
    public static final int CANTIDAD_HABILIDADES = CANTIDAD_NPC;

    //Constantes oara sprites
    public static final String SPRITE_JUGADOR = "@";
    public static final String SPRITE_OBSTACULO = "X";
    public static final String SPRITE_NPC = "N";
    public static final String SPRITE_TESORO = "T";
    public static final String SPRITE_VACIO = " ";
    public static final String SPRITE_EXCAVADA = "0";
    public static final String SPRITE_HABILIDAD = "?";
}
