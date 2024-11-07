package com.lukalopez.tema05;

import com.lukalopez.lib.Escaner;

public class Ejercicio2 {

    /**
     * Contar el número de vocales que contiene un 'String'.
     * @param texto 'String' en el que contar el número de vocales.
     * @return Devuelve el número de vocales que contiene el 'Strin'.
     */
    public static int contarVocales(String texto){
        int contador=0;
        texto = texto.toLowerCase();
        String vocales = "aeiou";
        for (int i=0; i<texto.length(); i++) {
            char c = texto.charAt(i);

            if (vocales.indexOf(c)!=-1) { // Verificamos si el carácter es una consonante
                contador++;
            }
        }
        return contador;
    }

    /**
     * Contar el número de consonantes que contiene un 'String'.
     * @param texto 'String' en el que contar el número de consonantes.
     * @return Devuelve el número de consonantes que contiene el 'Strin'.
     */
    public static int contarConsonantes(String texto){
        int contador=0;
        texto = texto.toLowerCase();
        String consonantes = "bcdfghjklmnpqrstvwxyz";
        for (int i=0; i<texto.length(); i++) {
            char c = texto.charAt(i);

            if (consonantes.indexOf(c)!=-1) { // Verificamos si el carácter es una consonante
                contador++;
            }
        }
        return contador;
    }

    public static void main(String args[]){
        //Definimos variables
        String texto;
        int consonantes, vocales;

        //Solicitamos el texto
        System.out.println("Escribe un texto y te diré el número de vocales y de consonantes que contiene: ");
        texto = Escaner.lector.nextLine();

        //Contamos el número de vocale y de consonantes
        vocales = contarVocales(texto);
        consonantes = contarConsonantes(texto);

        //Imprimimos el resultado
        System.out.printf("\n\nVocales: %d\nConsonantes: %d",vocales,consonantes);

        Escaner.dispose();
    }
}
