package com.lukalopez.tema05.Arrays;

import com.lukalopez.lib.Array;

public class Ejercicio13 {

    /**
     * Crear array con los números pares d
     *
     * @param array
     * @return
     */
    private static int[] copiarParesOImpares(int[] array, Array.Paridad paridad){
        //No verificamos si el array está vacio porque ya lo hace la función "Array.contarParesOImpares"

        //Contamos la cantidad de pares o de impares que contiene el array y creamos otro array con esa cantidad de elementos
        final int cantidadParesOImpares = Array.contarParesOImpares(array, paridad);
        int[] arrayP = new int[cantidadParesOImpares];

        int contador=0;
        //
        for (int i=0;i<array.length;i++){
            if (array[i] % 2== (paridad == Array.Paridad.PAR ? 0 : 1)){
                arrayP[contador]=array[i];
                contador++;
            }
        }
        return arrayP;
    }

    public static void main(String[] args) {
        int[] array = new int[50];
        Array.rellenarArray(array, 0,100);
        System.out.println(Array.arrayToString(array));
        array = copiarParesOImpares(array, Array.Paridad.PAR);
        System.out.println(Array.arrayToString(array));
    }
}
