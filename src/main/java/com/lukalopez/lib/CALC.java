package com.lukalopez.lib;

import java.util.Random;

public class CALC {
    private static Random random = new Random();

    /**
     * Devuelve un 'int' aleatorio comprendido entre dos valores.
     *
     * @param min Número mínimo que se puede generar.
     * @param max Número máximo que se puede generar.
     * @return Deuvelve un entero aleatorio 'resultado'.
     */
    public static int calcRandomInt(int min, int max){
        int resultado=(int) (Math.random() *(max+1))+min;
        return resultado;
    }
}
