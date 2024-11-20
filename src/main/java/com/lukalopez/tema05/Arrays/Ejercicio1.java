package com.lukalopez.tema05.Arrays;

import com.lukalopez.lib.Array;
import com.lukalopez.lib.Escaner;

public class Ejercicio1 {
    private static double[] rellenarArrayNumerico(int dimension){
        double[] array;
        array = new double[dimension];
        for (int i=0;i<array.length;i++){
            System.out.printf("Inserte el valor %d del array:\n", i+1);
            array[i] = Integer.parseInt(Escaner.lector.nextLine());
        }
        return array;
    }

    private static double mediaArray(double[] array){
        double sumatorio=0;
        for (double i : array) {
            sumatorio += i;
        }
        System.out.println(sumatorio);
        return sumatorio/array.length;
    }

    public static void main(String[] args) {
        //Definimos las variables
        double[] array;

        //Rellenamos el array
        array = rellenarArrayNumerico(10);

        //Imprimimos los valores
        System.out.println("Imprimimos el array:");
        Array.arrayToString(array, 2);
        System.out.println("La media de los números que contiene el array es:");
        System.out.println(mediaArray(array));
    }
}
