package com.lukalopez.tema05.Matrices;

import com.lukalopez.lib.Escaner;

public class Ejercicio1 {
    private static void rellenarMatriz(double[][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("[%d,%d] = ",i,j);
                matriz[i][j]=Double.parseDouble(Escaner.lector.nextLine());
                System.out.println();
            }
        }
    }

    private static double valorMaximoDeMatriz(double[][] matriz){
        double maximo = matriz[0][0];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j]>maximo){
                    maximo=matriz[i][j];
                }
            }
        }
        return maximo;
    }

    private static String matrizToString(double[][] matriz){
        StringBuilder sb = new StringBuilder();
        final int ANCHURA = String.valueOf((int)valorMaximoDeMatriz(matriz)).length();
        String espacio;
        String formato = "%0"+ANCHURA+".4f";
        for (int i = 0; i < matriz.length; i++) {
            espacio="";
            for (int j = 0; j < matriz[i].length; j++) {
                sb.append(espacio).append(String.format(formato,matriz[i][j]));
                if (j == 0) {
                    espacio = " ";
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        double[][] matriz = new double[3][3];
        rellenarMatriz(matriz);
        System.out.print(matrizToString(matriz));
    }
}
