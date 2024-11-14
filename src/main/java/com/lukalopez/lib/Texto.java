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

    /**
     * Convertir 'String' a un 'array' que contiene cada palabra del 'String'.
     *
     * @param texto Es el texto del que se desean sacar las palabras.
     * @return Devuelve un array que contiene las
     */
    public static String[] porPalabras(String texto){
        texto = texto.trim();
        return texto.split("\\s+");
    }

    /**
     * Sustituye una secuencia de caracteres de un texto por la secuencia de caracteres indicada.
     *
     * @param texto Es el texto del cual se desea sustituir la secuencia.
     * @param secuenciaOcurrencia 'String' que se desea sustituir.
     * @param secuenciaSustituta 'String' que se desea añadir.
     * @return Devuelve el texto con la secuencia intercambiada.
     */
    public static String sustituirOcurrencias(String texto, String secuenciaOcurrencia, String secuenciaSustituta){
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
    public static String sustituirOcurrenciasConCondiciones(String texto, String secuenciaOcurrencia, String secuenciaSustituta){
        return texto.replaceAll(secuenciaOcurrencia,secuenciaSustituta);
    }

    /**
     * Detectar la palabra de mayor longitud presente en un texto.
     *
     * @param texto Texto en el que se desea buscar.
     * @return Devuelve un 'String' que contiene la palabra de mayor longitud presente en el texto.
     */
    public static String palabraDeMayorLongitud(String texto){
        String palabra="";
        int caracterFinal, caracterInicial=0;

        //Bucle que recorre tod0 el texto
        for (int i=0; i<texto.length(); i++) {

            //Si encuentra un espacio significará que ha encontrado una palabra
            if (texto.charAt(i) == ' ' || i == texto.length() - 1) {

                //En caso de que llegue al final
                if (i == texto.length() - 1) {
                    caracterFinal = texto.length();
                } else {
                    caracterFinal = i;
                }

                //Comprobamos si la palabra es más larga
                if (palabra.length()<(texto.substring(caracterInicial, caracterFinal).length())){
                    palabra = texto.substring(caracterInicial, caracterFinal);
                }
                caracterInicial = i + 1;
            }
        }
        return palabra;
    }
}
