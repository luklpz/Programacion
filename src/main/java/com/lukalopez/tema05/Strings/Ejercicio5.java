package com.lukalopez.tema05.Strings;

import com.lukalopez.lib.Escaner;

public class Ejercicio5 {
    /**
     * Detectar la palabra de mayor longitud presente en un texto.
     *
     * @param texto Texto en el que se desea buscar.
     * @return Devuelve un 'String' que contiene la palabra de mayor longitud presente en el texto.
     */
    private static String palabraMayorLongitud(String texto){
        String palabra="";
        int caracterFinal, caracterInicial=0;

        //Bucle que recorre tod0 el texto
        for (int i=0; i<texto.length(); i++) {

            //Si encuentra un espacio significará que ha encontrado una palabra
            if (texto.charAt(i) == ' ' || i == texto.length() - 1) {

                //En caso de que llegue al final
                if (i == texto.length() - 1) {
                    caracterFinal = texto.length();
                } else {
                    caracterFinal = i;
                }

                //Comprobamos si la palabra es más larga
                if (palabra.length()<(texto.substring(caracterInicial, caracterFinal).length())){
                palabra = texto.substring(caracterInicial, caracterFinal);
                }
                caracterInicial = i + 1;
            }
        }
        return palabra;
    }

    public static void main(String args[]){
        //Definimos variables
        String texto, palabra;

        //Solicitamos el texto
        System.out.println("Escribe un texto y te devolveré la primera palabra más larga que contenga:");
        texto = Escaner.lector.nextLine();
        texto= texto.replaceAll("\\s+", " ");

        //Calculamos la palabra más larga
        palabra = palabraMayorLongitud(texto);

        //Imprimimos el resultado
        System.out.printf("La palabra más larga es \"%s\", conteniendo %d caracteres",palabra, palabra.length());
    }
}
