package com.lukalopez.tema05.Strings;

import com.lukalopez.lib.Escaner;

public class Ejercicio3 {

    public static int contarPalabras(String texto){
        int contador = 1;
        for (int i=0;i<texto.length();i++){
            if (String.valueOf(texto.charAt(i)).equals(" ")){
                contador++;
            }
        }
        return contador;
    }

    public static void main(String args[]){
        //Definimos las variables
        String texto;
        int palabras;

        //Solicitamos le texto
        System.out.println("Escribe un texto y te diré cuantas palabras contiene:");
        texto = Escaner.lector.nextLine();

        //Comprobamos el número de palabras
        palabras = contarPalabras(texto);

        //Imprimimos el resultado
        System.out.printf("Tu texto contiene %d palabra/s.", palabras);
    }
}
