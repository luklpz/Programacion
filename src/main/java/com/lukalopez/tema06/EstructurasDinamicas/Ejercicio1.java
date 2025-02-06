package com.lukalopez.tema06.EstructurasDinamicas;

import com.lukalopez.lib.EstructurasDinamicas.DynamicArray;
import com.lukalopez.lib.Random;

public class Ejercicio1 {
    public static void main(String[] args) {
        final int ELEMENTOS_ARRAY = 11;
        //Creamos el array dinamico
        DynamicArray miArrayDinamico = new DynamicArray();

        //Rellenamos el array dinamico
        for (int i = 0; i < ELEMENTOS_ARRAY; i++) {
            miArrayDinamico.add(Random.randomDouble(0,20));
        }

        //Imprimimos el array dinamico
        System.out.printf("Imprimiendo el array, número de elementos: %d \n", ELEMENTOS_ARRAY);
        System.out.println(miArrayDinamico.toString());

        //Imprimimos los elementos individualmente
        System.out.println("\nImprimiendo individualmente los elementos del array: ");
        for (int i = 0; i < miArrayDinamico.size(); i++) {
            System.out.printf("miArrayDinamico[%d] = %.2f\n",i,miArrayDinamico.get(i));
        }

        //Ejecutamos los métodos e imprimimos
        System.out.println("\nadd(9,70); (mueve los demás a la derecha, no se pierden datos)");
        miArrayDinamico.add(9,70);
        System.out.printf("miArrayDinamico[%d] = %.2f\n",9,miArrayDinamico.get(9));

        System.out.println("\nadd(30);");
        miArrayDinamico.add(30);
        System.out.printf("miArrayDinamico[%d] = %.2f\n",12,miArrayDinamico.get(12));

        System.out.println("\nremove(12);");
        miArrayDinamico.remove(12);
        System.out.printf("miArrayDinamico[miArrayDinamico.size()-1] = %.2f\n",miArrayDinamico.get((miArrayDinamico.size()-1)));

        System.out.printf("\nmiArrayDinamico[%d] = %.2f\n",9,miArrayDinamico.get(9));
        System.out.println("remove(30.);");
        miArrayDinamico.remove(70.);
        System.out.printf("miArrayDinamico[%d] = %.2f\n",9,miArrayDinamico.get(9));

        System.out.println("\nset(9,70);");
        miArrayDinamico.set(9,70.);
        System.out.printf("miArrayDinamico[%d] = %.2f\n",9,miArrayDinamico.get(9));
    }
}
