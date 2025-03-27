package com.lukalopez.tema05.Arrays;

import com.lukalopez.lib.Escaner;
import com.lukalopez.lib.IO;
import com.lukalopez.lib.Random;

public class Ejercicio9 {

    //****************************************************************\\
    //rellena el array con números aleatorios del 0 al 50.
    public static void crearArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = Random.randomInt(0, 50);
        }
    }

    //****************************************************************\\
    //Visualiza tod0 el contenido del array.
    public static void visualizarArray(int[] array) {
        //En caso de que esté vacio...
        if (array == null) {
            System.out.println("Array vacio.");
            System.exit(-1);
        }

        //Definimos las variables
        StringBuilder stringArray = new StringBuilder();
        String espacio = "";
        String coma = ",";

        //Rellenamos el 'String' con los datos
        stringArray.append("[");
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) { // último elemento
                coma = "";
            }
            stringArray.append(espacio).append(String.format("%d", array[i])).append(coma);
            if (i == 0) {
                espacio = " ";
            }
        }
        stringArray.append("]");

        //Imprimimos el resultado
        System.out.println(stringArray);
    }

    //****************************************************************\\

    //Muestra la posición y el contenido de los elementos que tienen valor par.
    public static void visualizarPares(int[] array) {
        //En caso de que esté vacio...
        if (array == null) {
            System.out.println("Array vacio.");
            System.exit(-1);
        }

        //Definimos las variables
        StringBuilder stringArray = new StringBuilder();
        String espacio = "";
        String coma = ",";

        //Rellenamos el 'String' con los datos
        stringArray.append("[");
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                if (i == array.length - 1) { // último elemento
                    coma = "";
                }
                stringArray.append(espacio).append(String.format("%d", array[i])).append(coma);
                if (i == 0) {
                    espacio = " ";
                }
            }
        }
        stringArray.append("]");

        //Imprimimos el resultado
        System.out.println(stringArray);
    }

    //****************************************************************\\

    public static void visualizarMultiplos3(int[] array){
        //En caso de que esté vacio...
        if (array == null) {
            System.out.println("Array vacio.");
            System.exit(-1);
        }

        //Definimos las variables
        StringBuilder stringArray = new StringBuilder();
        String espacio = "";
        String coma = ",";

        //Rellenamos el 'String' con los datos
        stringArray.append("[");
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 3 == 0) {
                if (i == array.length - 1) { // último elemento
                    coma = "";
                }
                stringArray.append(espacio).append(String.format("%d", array[i])).append(coma);
                if (i == 0) {
                    espacio = " ";
                }
            }
        }
        stringArray.append("]");

        //Imprimimos el resultado
        System.out.println(stringArray);
    }

    //****************************************************************\\

    //Muestra la posición y el contenido de los elementos que son múltiplo de 3.


    public static void main(String[] args) {
        boolean cerrar=false;
        int opcion;
        String menu = "\n1" +
                "MENÚ PRINCIPAL\n==============\n1.-Rellenar array.\n2.-Visualizar contenido del array\n3.-Visualizar contenido par.\n4.-Visualizar contenido múltiplo de 3\n0.-Salir del menú.\n";
        int[] array;
        array = new int[10];
        do {
            //Imprimo el menú
            System.out.println(menu);
            opcion = IO.solicitarInt("Selecciona una opción: \n",0,4);
            switch (opcion){
                case 0-> cerrar=true;
                case 1-> crearArray(array);
                case 2-> visualizarArray(array);
                case 3-> visualizarPares(array);
                case 4-> visualizarMultiplos3(array);
            }
        } while (!cerrar);
        Escaner.dispose();
    }
}
