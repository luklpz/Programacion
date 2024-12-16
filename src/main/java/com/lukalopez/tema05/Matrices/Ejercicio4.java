package com.lukalopez.tema05.Matrices;

import com.lukalopez.lib.Array;
import com.lukalopez.lib.IO;
import com.lukalopez.lib.Matriz;

public class Ejercicio4 {

    /**
     * Cambiar la última columna por un sumatorio de todas las anteriores.
     *
     * @param matriz Matriz sobre la que trabajar.
     * @return Se devuelve la matriz proporcionada con la última columna modificada.
     */
    public static int[][] sumatorioEnUltimaColumna(int[][] matriz){
        final int ULTIMA_COLUMNA = matriz[1].length-1;
        int sumatorio;
        for (int i = 0; i<matriz.length; i++){
            sumatorio = 0;
            for (int j = 0; j < matriz[i].length-1; j++) {
                sumatorio+=matriz[i][j];
            }
            matriz[i][ULTIMA_COLUMNA]=sumatorio;
        }
        return matriz;
    }

    public static void main(String[] args) {
        int[][] matriz;
        matriz = Matriz.crearMatrizAleatoria(4,8,1,10);
        System.out.println("***MATRIZ POR FILAS***");
        System.out.println(Matriz.matrizToString(matriz,2));
        System.out.println("\n***MATRIZ POR COLUMNAS***");
        System.out.println(Matriz.matrizToString(Matriz.transpuesta(matriz),2));
        System.out.println("\n***CON SUMA DE LAS FILAS***");
        System.out.println(Matriz.matrizToString(matriz,2,true,true));
        System.out.printf("\n\nValor máximo de la matriz: %d", Matriz.calcularExtremo(matriz, IO.Condicion.MAXIMO));
        System.out.printf("\n\nMedia de la matriz: %f", Matriz.calcularMedia(matriz));
        System.out.printf("\n\nElemento en matriz[3][3]: %s",Matriz.elementoToString(matriz,3,3));
        System.out.printf("\n\nImprimo la primera fila: %s",Array.arrayToString(Matriz.extraerFila(matriz,0)));
        System.out.printf("\n\nImprimo la primera columna: %s",Array.arrayToString(Matriz.extraerColumna(matriz,0)));
        System.out.println("\n\nMatriz con un sumatorio el sumatorio en la última columna: ");
        System.out.println(Matriz.matrizToString(sumatorioEnUltimaColumna(matriz),2));
    }
}
