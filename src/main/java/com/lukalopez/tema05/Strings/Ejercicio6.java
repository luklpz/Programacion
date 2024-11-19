package com.lukalopez.tema05.Strings;

import com.lukalopez.lib.Escaner;

public class Ejercicio6 {
    /**
     * Repetir un texto una cantidad determinada de veces.
     *
     * @param texto Texto que se proporciona.
     * @param factorDeMultiplicacion Veces que se desea repetir el texto.
     * @return Devuelve un 'String' que contiene el texto repetido la cantidad de veces determinada.
     */
    public static StringBuilder repetirTexto(String texto, int factorDeMultiplicacion){
        StringBuilder textoRepetido = new StringBuilder();
        for (int i=0;i<factorDeMultiplicacion;i++){
            textoRepetido.append(texto);
        }
        return textoRepetido;
    }

    public static void main(String args[]){
        //Declaramos las variables
        int factorDeMultiplicacion;
        String texto, textoRepetido;

        //Solicitamos los datos
        System.out.println("En este programa repetiremos un mismo texto tantas veces como se desee.\nEscriba el texto que desea repetir:");
        texto= Escaner.lector.nextLine();
        System.out.println("\nA continuación escriba el número de veces que desea repetir el texto:\n");
        factorDeMultiplicacion = Integer.parseInt(Escaner.lector.nextLine());
        System.out.println();

        //Repetimos el texto y lo imprimimos
        textoRepetido = repetirTexto(texto, factorDeMultiplicacion).toString();
        System.out.print(textoRepetido);
    }
}
