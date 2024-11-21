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
    private static boolean verificarNumero(double[] array, double numero){
        for (double i : array) {
            if (numero == i) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //Declaramos las variables
        boolean encontrado;
        double numero;
        double[] array;
        array = new double[100];

        //Rellenamos el array
        Array.rellenarArray(array,1,2);

        //Solicitamos el número y verificamos si se encuentra en el array
        numero = IO.solicitarDouble("Introduce un número del 1.00 al 100.00: ",1,100);
        encontrado = Array.verificarNumero(array, numero);
        //Imprimimos el resultado
        if (encontrado){
            System.out.printf("El numero %.2f se encuentra en el array.", numero);
        } else {
            System.out.printf("El numero %.2f no se encuentra en el array.", numero);
        }
    }
}
