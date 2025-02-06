package com.lukalopez.tema06.EstructurasDinamicas;

import com.lukalopez.lib.EstructurasDinamicas.Pila;
import com.lukalopez.lib.Random;

public class Ejercicio2 {
    public static void main(String[] args) {
        //Creamos la pila
        Pila miPila = new Pila();

        //Rellenamos la pila
        for (int i = 0; i < 10; i++) {
            miPila.push(Random.randomDouble(0,20));
            if (i % 5 == 0){
                System.out.println(miPila.top());
            }
            System.out.println(miPila.toString());
        }

        for (int i = 9; i > -1; i--) {
            miPila.pop();
            if (i % 5 == 0){
                System.out.println(miPila.top());
            }
            System.out.println(miPila);
        }
    }
}
