package com.lukalopez.tema05;

import com.lukalopez.lib.Escaner;
import com.lukalopez.lib.Texto;

public class Ejercicio12 {

    /**
     * Sustituye una secuencia de caracteres por la secuencia de caracteres indicada.
     *
     * @param texto Es el texto del cual se desea sustituir la secuencia.
     * @param secuenciaOcurrencia 'String' que se desea sustituir.
     * @param secuenciaSustituta 'String' que se desea añadir.
     * @return Devuelve el texto con la secuencia intercambiada.
     */
    private static String sustituirTexto(String texto, String secuenciaOcurrencia, String secuenciaSustituta){
        return texto.replace(secuenciaOcurrencia,secuenciaSustituta);
    }

    /**
     * Sustituye un 'String' por otro 'String' en un texto.
     *
     * @param texto Es el texto del cual se desea sustituir la secuencia.
     * @param secuenciaOcurrencia 'String' que se desea sustituir.
     * @param secuenciaSustituta 'String' que se desea añadir.
     * @return Devuelve el texto con la secuencia intercambiada.
     */
    private static String sustituirTodoTexto(String texto, String secuenciaOcurrencia, String secuenciaSustituta){
        return texto.replace(secuenciaOcurrencia,secuenciaSustituta);
    }


    public static void main(String args[]){
        String texto = "esto1234es5678bueno900";
        //Usamos los métodos
        System.out.println(Texto.sustituirOcurrencias(texto,"es","no por"));
        System.out.println(Texto.sustituirOcurrenciasConCondiciones(texto,"\\d+","*"));
        Escaner.dispose();
    }
}
