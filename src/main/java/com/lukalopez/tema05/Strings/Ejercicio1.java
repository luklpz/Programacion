package com.lukalopez.tema05.Strings;

import com.lukalopez.lib.Escaner;

public class Ejercicio1 {

    /**
     * String abecedario.
     * @return Devuelve un 'String' que contiene el abecedario.
     */
    private static String minAbc(){
        return "abcdefghijklmnopqrstuvwxyz";
    }

    /**
     * Validar que un caracter es una letra
     * @param caracter Es el caracter 'char' a validar.
     * @return Devuelve un 'true' si el caracter es una letra.
     */
    private static boolean validarLetra(char caracter){
        String minAbc = minAbc();
        for (int i=0;i<minAbc.length();i++){
            if ((String.valueOf(caracter).toLowerCase()).equals(String.valueOf(minAbc.charAt(i)))){
                return true;
            }
        }
        return false;
    }


    public static void main(String args[]){
        //Definimos las variables
        String texto;
        char primeraLetra;
        StringBuilder textoFinal = new StringBuilder();
        boolean letra = false;
        int posicion = 0;

        //Solicitamos el texto
        System.out.println("Introduce un texto y lo imprimiré con la primera letra en mayusculas:");
        texto = Escaner.lector.nextLine();

        //Nos aseguramos que el primer caracter sea una letra
        do {
            primeraLetra = texto.substring(posicion,posicion+1).charAt(0);
            letra = validarLetra(primeraLetra);
            posicion++;
        } while ((!letra)&&posicion<=texto.length());

        //Si la letra es minuscula la cambiamos
        if (!String.valueOf(primeraLetra).equals(String.valueOf(primeraLetra).toUpperCase())){
            textoFinal.append(texto, 0, posicion-1);
            textoFinal.append(String.valueOf(primeraLetra).toUpperCase());
            textoFinal.append(texto,posicion,texto.length());
            System.out.println(textoFinal);
        } else {
            System.out.println(texto);
        }

        Escaner.dispose();
    }
}
