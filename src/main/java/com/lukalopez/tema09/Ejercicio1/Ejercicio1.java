package com.lukalopez.tema09.Ejercicio1;

import com.lukalopez.lib.Random;

import java.util.ArrayList;
import java.util.Arrays;

public class Ejercicio1 {

    private static ArrayList<Integer> separadorPares(int[] array){
        final int arrayLenght= array.length;
        int[] arrayNegativos = new int[arrayLenght];
        ArrayList<Integer> lista = new ArrayList<>(arrayLenght);
        int contadorPositivos=0;
        int contadorNegativos=0;

        for (int valor : array) {
            if (valor % 2 == 0){
                lista.add(valor);
            } else {
                arrayNegativos[contadorNegativos]=valor;
                ++contadorNegativos;
            }
        }
        for (int i = 0; i < contadorNegativos; i++) {
            lista.add(arrayNegativos[i]);
        }
        return lista;
    }

    public static void main(String[] args) {
        ArrayList<Integer> lista;
        int[] array = new int[10];

        for (int i = 0; i < array.length; i++) {
            array[i] = Random.randomInt(0,50);
        }
        System.out.println(Arrays.toString(array));
        lista = separadorPares(array);
        System.out.println(lista);

    }
}
