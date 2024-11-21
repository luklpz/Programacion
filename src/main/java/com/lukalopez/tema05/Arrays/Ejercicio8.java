package com.lukalopez.tema05.Arrays;

import com.lukalopez.lib.Array;
import com.lukalopez.lib.IO;

public class Ejercicio8 {

    /**
     * Verifica si un número existe dentro de un array 'double[]'.
     *
     * @param array Array sobre el que se desea trabajar.
     * @param numero Número a buscar.
     * @return Devuelve 'true' si el número se encuentra en el array.
     */
    private static int verificarNumero(double[] array, double numero){
        for (int i=0;i<array.length;i++) {
            if (numero == array[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //Declaramos las variables
        int posicion;
        double numero;
        double[] array;
        array = new double[100];
        final int MAXIMO=100,MINIMO=1;

        //Rellenamos el array
        Array.rellenarArray(array,MINIMO,MAXIMO);
        //Solicitamos el número y verificamos si se encuentra en el array
        numero = IO.solicitarDouble("Introduce un número del 1.00 al 100.00: ",MINIMO,MAXIMO);
        posicion = verificarNumero(array, numero);
        //Imprimimos el resultado
        if (posicion!=-1){
            System.out.printf("El numero %.2f se encuentra en la posición %d del array.", numero, posicion);
        } else {
            System.out.printf("El numero %.2f no se encuentra en el array.", numero);
        }
    }
}
