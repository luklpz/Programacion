package com.lukalopez.tema05.Matrices;

import com.lukalopez.lib.Array;
import com.lukalopez.lib.Matriz;

public class Ejercicio2 {

    private static double[][] multiplicacionArrays(double[] array1, double[] array2){
        double[][] matriz = new double[array1.length][array2.length];
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                matriz[i][j]=array1[i]*array2[j];
            }
        }
        return matriz;
    }

    public static void main(String[] args) {
        //Determino las variables
        final int longitudV=50;
        final int longitudP=20;
        double[] V = new double[longitudV];
        double[] P = new double[longitudP];
        double[][] M;

        //Llenamos los array y la matriz
        Array.rellenarArray(V,1,10);
        Array.rellenarArray(P,1,10);
        M =multiplicacionArrays(V,P);

        //Mostramos el resultado
        System.out.println(Matriz.matrizToString(M,2,2));
    }
}
