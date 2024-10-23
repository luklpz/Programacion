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
    private static String repetir(char imprimir, int n, int c){
        if ((n<1)||(c<1)) {
            return null;
        }
        String resultado = "";
        for (int i=c;i!=0;i--){
            for (int j=n;j!=0;j--){
                resultado+=imprimir+"\n";
            }
            resultado+="\n";
        }
        return resultado;
    }
    public static void main(String args[]){
        String texto = repetir('h', 2,2);
        if (texto == null){
            System.err.println("Debes indicar un número positivo.");
        }
        else {
            System.out.print(texto);
        }
    }
}
