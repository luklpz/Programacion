package com.lukalopez.tema05;

import com.lukalopez.lib.Escaner;

public class Ejercicio10 {

    private static boolean esPalindromo(String texto){
        texto = ((texto.replaceAll("\\s+", "")).trim()).toLowerCase();
        for (int i=0; i<((texto.length()/2));i++){
            if (texto.charAt(i)!=texto.charAt(texto.length()-i-1)){
                return false;
            }
        }
        return true;
    }


    public static void main(String args[]){
        //Definimos las variables
        String texto;
        boolean palindromo;

        //Solicitamos el texto
        System.out.println("Escribe un texto y te diré si es palíndromo: ");
        texto = Escaner.lector.nextLine();

        //Ejecutamos el métod0 e imprimimos el resultado
        palindromo = esPalindromo(texto);
        System.out.println(palindromo);
        Escaner.dispose();
    }
}
