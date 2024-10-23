package com.lukalopez.tema04.Metodos;

public class Ejercicio5 {
    /**
     * Imprime un 'String' el numero de veces solicitado 'n'.
     *
     * @param imprimir 'String' a imprimir.
     * @param n Número de veces que se desaea imprimir.
     * @author luklpz
     */
    private static String repetir(char imprimir,int n){
        if (n<1) {
            return null;
        }
        String resultado="";
        for (int i=n;i!=0;i--){
            resultado+=imprimir+"\n";
        }
        return resultado;
    }

    public static void main(String args[]){
        String texto = repetir('h', -2);
        if (texto == null){
            System.err.println("Debes indicar un número positivo.");
        }
        else {
            System.out.print(texto);
        }
    }
}
