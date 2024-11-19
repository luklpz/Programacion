package com.lukalopez.tema05.Strings;

import com.lukalopez.lib.Escaner;

public class Ejercicio9 {

    /**
     * Métod0 para devolver un texto con las posiciones impares del texto proporcionado.
     *
     * @param texto 'String' proporcionado
     * @return Devuelve un 'String' que contiene las posiciones impares del texto proporcionado.
     * @author luklpz
     */
    private static String returnImpares(String texto){
        StringBuilder sb = new StringBuilder();
        char c;
        for (int i = 0; i < texto.length(); i++) {
            c=texto.charAt(i);
            if (i % 2 !=0){
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String args[]){
        //Definimos las variables
        String texto, textoImpares;

        //Solicitamos el texto
        System.out.println("Escribe un texto y te devolveré solo las posiciones impares: ");
        texto = Escaner.lector.nextLine();

        //Ejecutamos el métod0 e imprimimos el resultado
        textoImpares = returnImpares(texto);
        System.out.println(textoImpares);
        Escaner.dispose();
    }
}
