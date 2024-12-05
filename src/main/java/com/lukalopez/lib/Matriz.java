package com.lukalopez.lib;

public class Matriz {


    public static double[][] crearMatrizAleatoria(int filas, int columnas, double minimo, int maximo){
        double[][] matriz = new double[filas][columnas];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j]=Random.randomDouble(minimo,maximo);
            }
        }
        return matriz;
    }

    public static String matrizToString(double[][] matriz, int decimales, int padding){
        int anchoColumna = determinarLongitudMaxima(matriz,decimales);
        String formatoDecimales = "%"+anchoColumna+"."+decimales+"f";
        String formatoPadding = "%"+(anchoColumna+padding)+"s";
        StringBuilder sb = new StringBuilder();
        for (double[] fila : matriz){
            for (double valor : fila){
                sb.append(String.format(formatoPadding, String.format(formatoDecimales,valor)));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static int determinarLongitudMaxima(double[][] matriz, int decimales){
        int longitudMaxima = 0;
        for (double[] fila : matriz){
            int longitud =Array.determinarLongitudMaxima(fila, decimales);
            if (longitud>longitudMaxima){
                longitudMaxima=longitud;
            }
        }
        return longitudMaxima;
    }
}
