package com.lukalopez.tema05.Arrays;

import com.lukalopez.lib.Array;

public class Ejercicio12 {

    /**
     * Crea un array el cual sus posiciones son el sumatorio de esa posición y todas las anteriores de un array otorgado.
     *
     * @param array Array que contiene los valores.
     * @return Devuelve un array que contiene el sumatorio de la posición y todas las anteriores de un array.
     */
    private static double[] sumatorioDePosicionesArray(double[] array){
        double sumatorio;
        if (array==null){
            System.err.println("Array vacio.");
            System.exit(-1);
        }
        double [] arrayP = new double[array.length];
        for (int i=0;i<array.length;i++){
            sumatorio=0;
            for (int j=i;j>-1;j--){
                sumatorio+=array[j];
            }
            arrayP[i]=sumatorio;
        }
        return arrayP;
    }

    public static void main(String[] args) {
        double[] array = new double[50];
        Array.rellenarArray(array, 0,10);
        System.out.println(Array.arrayToString(array,2));
        array = sumatorioDePosicionesArray(array);
        System.out.println(Array.arrayToString(array,2));
    }
}
