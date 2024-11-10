package com.lukalopez.tema05;

import com.lukalopez.lib.Escaner;

public class Ejercicio8 {
    private static String palabrasDelTextoLongitud(String texto) {
        texto = (texto.replaceAll("\\s+", " ")).trim();
        //Declaramos variables
        int caracterFinal, caracterInicial = 0;
        String palabra;
        StringBuilder textoPalabraPorPalabra = new StringBuilder();

        //Bucle que recorre tod0 el texto
        for (int i = 0; i < texto.length(); i++) {

            //Si encuentra un espacio significará que ha encontrado una palabra
            if (texto.charAt(i) == ' ' || i == texto.length() - 1) {

                //En caso de que llegue al final
                if (i == texto.length() - 1) {
                    caracterFinal = texto.length();
                } else {
                    caracterFinal = i;
                }
                palabra = texto.substring(caracterInicial, caracterFinal);
                textoPalabraPorPalabra.append("\"").append(palabra).append("\" Contiene: ").append(palabra.length()).append(" caracteres.\n");
                caracterInicial = i + 1;
            }
        }
        return textoPalabraPorPalabra.toString();
    }
    public static void main(String args[]){
        //Definimos variables
        String texto, palabrasLongitud;

        //Solicitamos el texto
        System.out.println("Escribe un texto y te lo devolveré palabra por  palabra, indicando la cantidad de caracteres que contiene:");
        texto = Escaner.lector.nextLine();

        //Convertimos el texto y lo imprimimos
        palabrasLongitud = palabrasDelTextoLongitud(texto);
        System.out.println(palabrasLongitud);
    }
}
