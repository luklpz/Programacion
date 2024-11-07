package com.lukalopez.tema05;

public class Ejercicio7 {
    private static String returnTextoPalabraPorPalabra(String texto) {
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
                palabra = texto.substring(caracterInicial, caracterFinal);

                textoPalabraPorPalabra.append(palabra);
                caracterInicial = i + 1;
            }
        }
        return textoPalabraPorPalabra.toString();
    }

    public static void main(String args[]){

    }
}
