package com.lukalopez.tema05.Strings;

import com.lukalopez.lib.Escaner;

public class Ejercicio4 {

    public static void main(String args[]) {
        // Definimos variables
        String texto, palabra;
        int consonantes, vocales, caracterFinal;
        int caracterInicial = 0;

        // Solicitamos el texto
        System.out.println("Escribe un texto y te diré el número de vocales y consonantes que contiene cada palabra:");
        texto = Escaner.lector.nextLine();
        texto= texto.replaceAll("\\s+", " ");
        System.out.println();

        // Contamos e imprimimos el número de consonantes y vocales de cada palabra
        for (int i=0; i<texto.length(); i++) {

            //Si encuentra un espacio significará que ha encontrado una palabra
            if (texto.charAt(i)==' '||i==texto.length()-1) {

                //En caso de que llegue al final
                if (i==texto.length()-1) {
                    caracterFinal=texto.length();
                } else {
                    caracterFinal=i;
                }

                //Imprimimos el resultado una vez encontrada la palabra
                palabra = texto.substring(caracterInicial, caracterFinal);
                vocales = Ejercicio2.contarVocales(palabra);
                consonantes = Ejercicio2.contarConsonantes(palabra);
                System.out.printf("%s:\n   Vocales: %d\n   Consonantes: %d\n\n", palabra, vocales, consonantes);
                caracterInicial = i + 1;
            }
        }
        Escaner.dispose();
    }
}
