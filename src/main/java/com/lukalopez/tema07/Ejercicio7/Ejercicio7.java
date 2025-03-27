package com.lukalopez.tema07.Ejercicio7;

import com.lukalopez.lib.Random;

public class Ejercicio7 {

    public static void mostrarCadenasArray(char[][] arrayCadenasChar){
        String saltoLinea = "\n";
        for (int i = 0; i < arrayCadenasChar.length; i++) {
            try{
                System.out.printf("Cadena[%d][0] = ", i);
                System.out.println(arrayCadenasChar[i][1]);
                System.out.println(saltoLinea);
            } catch (NullPointerException npe){
                System.out.println("Array no inicializado.\n");
            }
        }
    }

    public static void main(String[] args) {
        char[][] arrays = new char[10][3];
        for (int j = 0; j < arrays.length; j++) {
            if (j!=3) {
                for (int i = 0; i < arrays[j].length; i++) {

                    arrays[j][i] = (char) Random.randomInt(1, 90);
                }
            } else {
                arrays[j] = null;
            }
        }

        mostrarCadenasArray(arrays);
    }
}
