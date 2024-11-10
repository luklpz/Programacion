package com.lukalopez.lib;

public class Texto {
    /**
     * Verifica si el caracter entregado es una vocal.
     *
     * @param c Es el caracter sobre el cual se desea verificar.
     * @return Se devuelve 'true' si el caracter es una vocal
     */
    public static boolean esVocal(char c){
        String vocales = "aáàäâeéèëêiíìïîoóòöôuúùüûAÁÀÄÂEÉÈËÊIÍÌÏÎOÓÒÖÔUÚÙÜÛ";
        return (vocales.indexOf(c)>=0);
    }

    /**
     * Verifica si el caracter entregado es una consonante.
     *
     * @param c Es el caracter sobre el cual se desea verificar.
     * @return Se devuelve 'true' si el caracter es una consonante.
     */
    public static boolean esConsonante(char c) {
        return Character.isLetter(c)&&!esVocal(c);
    }

    /**
     * Cuenta el número de vocales que contiene un texto.
     *
     * @param texto Es el texto sobre el cual se desea contar.
     * @return Se devuelve el número de vocales que contiene el texto.
     */
    public static int contarVocales(String texto){
        int contador=0;
        for (int i=1;i<=texto.length();i++) {
            if (esVocal(texto.charAt(i))){
                contador++;
            }
        }
        return contador;
    }

    /**
     * Cuenta el número de consonantes que contiene un texto.
     *
     * @param texto Es el texto sobre el cual se desea contar.
     * @return Se devuelve el número de consonantes que contiene el texto.
     */
    public static int contarConsonantes(String texto){
        int contador=0;
        for (int i=1;i<=texto.length();i++) {
            if (esConsonante(texto.charAt(i))){
                contador++;
            }
        }
        return contador;
    }
}
