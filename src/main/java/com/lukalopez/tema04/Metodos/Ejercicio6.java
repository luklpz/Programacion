package com.lukalopez.tema04.Metodos;

public class Ejercicio6 {
    /**
     * Imprime un 'String' el numero de veces solicitado 'n', los conjuntos de veces seleccionados 'c'.
     *
     * @param imprimir 'String' a imprimir.
     * @param n Número de veces que se desaea imprimir.
     * @param c Número de conjuntos que se desea imprimir.
     * @author luklpz
     */
    private static void repetir(String imprimir, int n, int c){
        for (int i=c;i==0;i--){
            for (int j=n;j==0;j--){
                System.out.println(imprimir);
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        repetir("Mensaje por defecto.",4, 3);
    }
}
