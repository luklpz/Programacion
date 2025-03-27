package com.lukalopez.tema05.Arrays;

import com.lukalopez.lib.Array;
import com.lukalopez.lib.Escaner;
import com.lukalopez.lib.IO;

public class Ejercicio5 {

    /**
     * Contar los valores de un array presentes dentro de un rango.
     *
     * @param array Array sobre el que trabajar.
     * @param minimo Valor 'double' mínimo que puede valer.
     * @return Devuelve el número de valores que contiene el array presentes dentro del rango.
     */
    private static int contarValores(double[] array, double minimo){
        int contador=0;
        for (double i:array){
            if (i>minimo){
                contador++;
            }
        }
        return contador;
    }

    public static void main(String[] args) {
        int indices;
        double[] array;
        double media;
        final double VALORMINIMO = 0.2;
        final double VALORMAXIMO = 2.5;
        final int VALORMINIMOPERSONAS = 1;

        indices = IO.solicitarInt("\nIntroduzca el número total de personas: ",VALORMINIMOPERSONAS, IO.Condicion.MINIMO);
        array = new double[indices];
        System.out.println("A continuación introduzca las estaturas en metros:");
        Array.solicitarDatosArray(array,VALORMINIMO,VALORMAXIMO);
        media = Array.mediaArray(array);
        System.out.printf("\n\nEstatura media: %.2f\n",media);
        System.out.printf("El número de personas con una estatura superior a la media es: %d",contarValores(array, media));
        Escaner.dispose();
    }
}
