package com.lukalopez.tema05.Arrays;

import com.lukalopez.lib.Array;

public class Ejercicio11 {
    /**
     * Genera un array que contiene los caracteres de el array otorgado invertidos.
     *
     * @param array Es el array proporcionado para invertir.
     * @return Devuelve un nuevo array con las posiciones invertidas.
     */
    private static double[] generarArrayInverso(double[] array){
        if (array==null){
            System.err.println("Array vacio.");
            System.exit(-1);
        }
        double[] arrayP = new double[array.length];
        for (int i=0;i<array.length;i++){
            arrayP[array.length-1-i] = array[i];
        }
        return arrayP;
    }

    public static void main(String[] args) {
        double[] array = new double[10];
        Array.rellenarArray(array,1,10);
        System.out.println(Array.arrayToString(array,2));
        array = generarArrayInverso(array);
        System.out.println(Array.arrayToString(array,2));
    }
}
