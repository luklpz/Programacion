package com.lukalopez.tema06.EstructurasDinamicas;

import com.lukalopez.lib.Escaner;
import com.lukalopez.lib.EstructurasDinamicas.Cola;
import com.lukalopez.lib.EstructurasDinamicas.DynamicArray;
import com.lukalopez.lib.EstructurasDinamicas.Pila;
import com.lukalopez.lib.IO;
import com.lukalopez.lib.Random;

public class EjercicioGenerics {

    public static String menuGenerics(){
        return """
                
                
                          |--------------------------|
                          |       MENU GENERICS      |
                          |--------------------------|
                          |  1.Ejemplo pila          |
                          |  2.Ejemplo cola          |
                          |  3.Ejemplo DynamicArray  |
                          |  4.Salir                 |
                          |--------------------------|
                
                """;
    }

    public static boolean ejecutarMenu(){
        boolean cerrar = false;
        int respuesta;
        do {
            System.out.println(menuGenerics());
            respuesta = IO.solicitarInt("Seleccion: ",1,4,"ERROR: Se ha entrado una entrada invalida.\n");

            switch (respuesta){
                case 1 -> {
                    System.out.println("\n\n                          |--------------------------|\n                          |       EJEMPLO PILA       |\n                          |--------------------------|\n");
                    Pila pila = new Pila();

                    System.out.printf("Creamos la pila: %s\n\n", pila);

                    for (int i = 0; i < 10; i++) {
                        pila.push(Random.randomInt(-9,99));
                    }
                    System.out.printf("Rellenamos la pila: %s\n\n", pila);

                    pila.clear();
                    System.out.printf("Clear: %s\n\n", pila);

                    for (int i = 0; i < 10; i++) {
                        pila.push(Random.randomInt(-9,99));
                    }
                    System.out.printf("Rellenamos la pila (otra vez): %s\n\n", pila);

                    Pila copiaPila;
                    copiaPila = pila.clone();
                    System.out.printf("Clone (la nueva pila):         %s\n", copiaPila);
                    System.out.println("¿Son iguales?\n");

                    Pila peek;
                    peek = pila.peek(4);
                    System.out.printf("Peek(4): %s\n\n", peek);

                    pila.push(4);
                    System.out.printf("Push(4): %s\n", pila);
                    System.out.printf("Search(4): %d\n", pila.search(4));

                    pila.push(5);
                    System.out.printf("Push(5): %s\n", pila);
                    System.out.printf("Search(4): %d\n\n", pila.search(4));

                    pila.reverse();
                    System.out.printf("Reverse: %s\n\n",pila.toString());

                }
                case 2 -> {
                    System.out.println("\n\n                          |--------------------------|\n                          |       EJEMPLO COLA       |\n                          |--------------------------|\n");
                    Cola cola = new Cola();

                    System.out.printf("Creamos la Cola: %s\n\n", cola);

                    for (int i = 0; i < 10; i++) {
                        cola.add(Random.randomInt(-9,99));
                    }
                    System.out.printf("Rellenamos la cola: %s\n\n", cola);

                    cola.clear();
                    System.out.printf("Clear: %s\n\n", cola);

                    for (int i = 0; i < 10; i++) {
                        cola.add(Random.randomInt(-9,99));
                    }
                    System.out.printf("Rellenamos la cola (otra vez): %s\n\n", cola);

                    Cola copiaCola;
                    copiaCola = cola.clone();
                    System.out.printf("Clone (la nueva cola):         %s\n", copiaCola);
                    System.out.println("¿Son iguales?\n");

                    int peekLast;
                    peekLast= (int) cola.peekLast();
                    System.out.printf("PeekLast(): %d\n\n", peekLast);

                    cola.add(4);
                    System.out.printf("Add(4): %s\n", cola);
                    System.out.printf("Search(4): %d\n", cola.search(4));

                    cola.add(5);
                    System.out.printf("Add(5): %s\n", cola);
                    System.out.printf("Search(4): %d\n\n", cola.search(4));

                    cola.reverse();
                    System.out.printf("Reverse: %s\n\n",cola.toString());


                }
                case 3 -> {
                    System.out.println("\n\n                          |--------------------------|\n                          |   EJEMPLO DYNAMIC ARRAY  |\n                          |--------------------------|\n");
                    DynamicArray dynamicArray = new DynamicArray();

                    System.out.printf("Creamos el DynamicArray: %s\n\n", dynamicArray);

                    for (int i = 0; i < 10; i++) {
                        dynamicArray.add(Random.randomInt(-9,99));
                    }
                    System.out.printf("Rellenamos el DynamicArray: %s\n\n", dynamicArray);

                    dynamicArray.clear();
                    System.out.printf("Clear: %s\n\n", dynamicArray);

                    for (int i = 0; i < 10; i++) {
                        dynamicArray.add(Random.randomInt(-9,99));
                    }
                    System.out.printf("Rellenamos el DynamicArray (otra vez): %s\n\n", dynamicArray);

                    DynamicArray copiaDynamicArray;
                    copiaDynamicArray = dynamicArray.clone();
                    System.out.printf("Clone (el nuevo DynamicArray):         %s\n", copiaDynamicArray);
                    System.out.println("¿Son iguales?\n");

                    dynamicArray.add(4);
                    System.out.printf("Add(4): %s\n", dynamicArray);
                    System.out.printf("Search(4): %d\n", dynamicArray.indexOf(4));

                    dynamicArray.add(5);
                    System.out.printf("Add(5): %s\n", dynamicArray);
                    System.out.printf("IndexOf(4): %d\n\n", dynamicArray.indexOf(4));

                    dynamicArray.trimToSize();
                    System.out.printf("TrimToSize: %s\n\n",dynamicArray);
                    System.out.printf("Size: %d\n",dynamicArray.size());
                    System.out.printf("Lenght: %d\n",dynamicArray.getLenght());

                    System.out.println(dynamicArray.swap(0,1));
                    System.out.printf("Swap(0,1): %s\n\n",dynamicArray);

                    System.out.println(dynamicArray.swap(1,2));
                    System.out.printf("Swap(1,2): %s\n\n",dynamicArray);
                }

                default -> cerrar=true;
            }
        } while (!cerrar);
        return true;
    }


    public static void main(String[] args) {
        final boolean fin = ejecutarMenu();

        if (fin){
            System.out.println("El programa se ha ejecutado correctamente.");
        }
        Escaner.dispose();
    }
}
