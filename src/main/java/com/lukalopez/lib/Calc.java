package com.lukalopez.lib;

import java.util.Random;

public class Calc {
    private static Random random = new Random();

    /**
     * Devuelve un 'int' aleatorio comprendido entre dos valores.
     *
     * @param min Número mínimo que se puede generar.
     * @param max Número máximo que se puede generar.
     * @return Deuvelve un entero aleatorio 'resultado'.
     */
    public static int randomInt(int min, int max){
        int resultado=(int) (Math.random() *(max-1))+min;
        return resultado;
    }

    /**
     * Calcula el factorial de un entero.
     *
     * @param n Número del que se desea calcular el factorial.
     * @return Devuelve un entero como factorial de 'n'.
     */
    public static int factorial(int n){
        int resultado = 1;
        if (n<0){
            //No se puede calcular el factorial de números negativos."
            return 0;
        }
        else {
            for (int i = n; i != 0; i--) {
                resultado *=i;
            }
            return resultado;
        }
    }
}
