package com.lukalopez.tema05.Arrays;

import com.lukalopez.lib.Array;
import com.lukalopez.lib.Escaner;

public class Ejercicio4 {
    /**
     * Calcular la media de los valores contenidos en un array.
     *
     * @param array Array de 'double' sobre el que trabajar.
     * @param valorMinimo Valor mínimo 'double' que puede valer para contar en la media.
     * @param valorMaximo Valor máximo 'double' que puede valer para contar en la media.
     * @return Devuelve la media de los valores presentes en el segmento, devuelve 0 si no se encuentran argumentos.
     */
    private static double mediaArray(double[] array, double valorMinimo, double valorMaximo){
        int contador = 0;
        double sumatorio = 0;
        for (double i:array){
            if ((valorMinimo<=i)&&(i<=valorMaximo)){
                sumatorio+=i;
                contador++;
            }

        }
        if (contador==0){
            return 0;
        }
        return sumatorio/contador;
    }

    public static void main(String[] args) {
        double[] array;
        array = new double[10];
        Array.rellenarArray(array,0,10);
        System.out.printf("\nEl valor medio de los examenes aprobados es: %.2f\n",mediaArray(array,5,10));
        System.out.println(Array.arrayToString(array,2));
        Escaner.dispose();
    }
}
