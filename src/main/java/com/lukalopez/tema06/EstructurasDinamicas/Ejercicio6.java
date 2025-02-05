package com.lukalopez.tema06.EstructurasDinamicas;

import com.lukalopez.lib.Random;

public class Ejercicio6 {
    public static void main(String[] args) {
        //Creamos la cola
        Cola miCola = new Cola(5);

        //Rellenamos la pila
        for (int i = 0; i < 10; i++) {
            miCola.add(Random.randomDouble(0,20));
            if (i % 5 == 0){
                System.out.printf("\nPeek: %f\n\n",miCola.peek());
            }
            System.out.printf("Add: %s\n",miCola);
        }

        for (int i = 9; i > -1; i--) {
            miCola.pop();
            if (i % 5 == 0){
                System.out.printf("\nPeek: %f\n\n",miCola.peek());
            }
            System.out.printf("Pop: %s\n",miCola);
        }
    }
}
