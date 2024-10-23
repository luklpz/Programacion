package com.lukalopez.tema04.Metodos;

public class Ejercicio5 {
    /**
     * Imprime un 'String' el numero de veces solicitado 'n'.
     *
     * @param imprimir 'String' a imprimir.
     * @param n Número de veces que se desaea imprimir.
     * @author luklpz
     */
    private static void repetir(String imprimir,int n){
        for (int i=Math.abs(n);i==0;i--){
            System.out.println(imprimir);
        }
    }

    public static void main(String args[]){
        repetir("Mensaje por defecto.", 9);
    }
}
