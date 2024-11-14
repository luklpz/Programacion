package com.lukalopez.tema05;

import com.lukalopez.lib.Escaner;
import com.lukalopez.lib.IO;
import com.lukalopez.lib.Texto;

public class Ejercicio13 {

    /**
     * Mostrar el menú principal
     * @return Opción validada que devuelve el usuario
     */
    private static int mostrarMenu(){
        //Imprimimos el menú
        System.out.println("\n\nMENÚ PRINCIPAL\n==============\n1. Palabra más larga.\n2. Palabra más corta.\n3. Número de vocales.\n------------------------------------\n0. Salir\n");
        //Solicitamos y validamos las opciones del menu
        return IO.solicitarInt("",0,3,"\nSe ha introducido una opción inválida. Ingrese una entrada válida:\n");
    }

    /**
     * Solicita un número determinado de palabras
     *
     * @param mensajeSolicitud Mensaje que se imprime para solicitar las palabras
     * @param numeroDePalabras Número de palabras que se desea obtener
     * @return Devuelve un string que contiene el número de palabras deseado.
     */
    private static String solicitarNumeroPalabras(String mensajeSolicitud, int numeroDePalabras){
        //Definimos las variables
        String palabras;
        int contador=1;
        boolean validado=false;

        //Solicitamos las palabras
        System.out.println(mensajeSolicitud);
        do {
            palabras = ((Escaner.lector.nextLine()).replaceAll("\\s+", " ")).trim();

            //Contamos las palabras
            for (int i = 0; i < palabras.length(); i++) {
                if (palabras.charAt(i) == ' ') {
                    contador++;
                }
            }
            //Si son 'numeroDePalabras3' palabras hemos validado la entrada
            if (contador==numeroDePalabras){
                validado=true;
            }
            else {
                System.out.printf("\nHas introducido %d palabras, has de introducir %d. A continuación prueba otra vez:",contador, numeroDePalabras);
            }
        } while (!validado);
        return palabras;
    }

    /**
     * Detectar la palabra de mayor longitud presente en un texto.
     *
     * @param texto Texto en el que se desea buscar.
     * @return Devuelve un 'String' que contiene la palabra de mayor longitud presente en el texto.
     */
    private static String palabraMayorLongitud(String texto){
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

    /**
     * Detectar la palabra de menor longitud presente en un texto.
     *
     * @param texto Texto en el que se desea buscar.
     * @return Devuelve un 'String' que contiene la palabra de menor longitud presente en el texto.
     */
    private static String palabraMenorLongitud(String texto){
        String palabra="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
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

                //Comprobamos si la palabra es más corta
                if (palabra.length()>(texto.substring(caracterInicial, caracterFinal).length())){
                    palabra = texto.substring(caracterInicial, caracterFinal);
                }
                caracterInicial = i + 1;
            }
        }
        return palabra;
    }

    public static void main(String args[]){
        //Declaramos variables
        int opcion;
        boolean salir=false;

        //Ejecutamos el programa
        do {
            opcion = mostrarMenu();
            switch (opcion){
                //Palabra más larga
                case 0 -> salir=true;
                case 1 -> System.out.printf("La palabra más larga es %s.",palabraMayorLongitud(solicitarNumeroPalabras("\nIntroduce tres palabras y te diré cuál es la más larga: \n",3)));
                case 2 -> System.out.printf("La palabra más corta es %s.",palabraMenorLongitud(solicitarNumeroPalabras("\nIntroduce tres palabras y te diré cuál es la más corta: \n",3)));
                case 3 -> System.out.printf("La palabra tiene %d vocales",Texto.contarVocales(solicitarNumeroPalabras("\nIntroduce una palabra y te diré cuantas vocales tiene:\n",1)));
                default -> System.out.println("\u001b[1;31mERROR\u001b[0m");
            }
        } while(!salir);
        Escaner.dispose();
    }
}
