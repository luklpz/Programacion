package com.lukalopez.tema05.Strings;

import com.lukalopez.lib.Escaner;

public class Ejercicio7 {
    private static String returnTextoPalabraPorPalabra(String texto) {
        texto = (texto.replaceAll("\\s+", " ")).trim();
        //Declaramos variables
        int caracterFinal, caracterInicial = 0;
        String palabra = "";
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

                textoPalabraPorPalabra.append(texto.substring(caracterInicial, caracterFinal)).append("\n");
                caracterInicial = i + 1;
            }
        }
        return textoPalabraPorPalabra.toString();
    }

    public static void main(String args[]){
        //Declaramos las variables
        String texto, textoPalabraPorPalabra;

        //Solicitamos el texto
        System.out.println("Escribe un texto y lo mostraré palabra por palabra:");
        texto = Escaner.lector.nextLine();

        //Convertimos el texto y lo imprimimos
        textoPalabraPorPalabra = returnTextoPalabraPorPalabra(texto);
        System.out.println(textoPalabraPorPalabra);
        Escaner.dispose();
    }
}
