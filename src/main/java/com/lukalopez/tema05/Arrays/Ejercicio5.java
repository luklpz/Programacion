package com.lukalopez.tema05.Arrays;

import com.lukalopez.lib.Array;
import com.lukalopez.lib.Escaner;
import com.lukalopez.lib.IO;

public class Ejercicio5 {

    /**
     * Contar los valores de un 'String' presentes dentro de un rango.
     *
     * @param array Array sobre el que trabajar.
     * @param minimo Valor 'double' mínimo que puede valer.
     * @param maximo Valor 'double' máximo que puede valer.
     * @return Devuelve el número de valores que contiene el array presentes dentro del rango.
     */
    private static int contarValores(double[] array, double minimo, double maximo){
        int contador=0;
        for (double i:array){
            if (i>=minimo&&i<=maximo){
                contador++;
            }
        }
        return contador;
    }

    public static void main(String[] args) {
        int indices;
        double[] array;
        final double valorMinimo = 0.2;
        final double valorMaximo = 2.5;
        final int valorMinimoPersonas = 1;

        indices = IO.solicitarInt("\nIntroduzca el número total de personas: ",valorMinimoPersonas,"No se puede evaluar a menos de una persona.");
        array = new double[indices];
        System.out.println("A continuación introduzca las estaturas en metros:");
        Array.solicitarDatosArray(array,valorMinimo,valorMaximo);
        System.out.printf("\n\nEstatura media: %f\n",Array.mediaArray(array,valorMinimo,valorMaximo));
        System.out.printf("El número de personas con una estatura superior a la media es: %d",contarValores(array, valorMinimo+0.01,valorMaximo));
        Escaner.dispose();
    }
}
