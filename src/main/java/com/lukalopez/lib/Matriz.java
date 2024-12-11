package com.lukalopez.lib;

public class Matriz {

//******************************** RELLENAR ALEATORIAMENTE UNA MATRIZ ********************************\\

//----------INT----------\\

    /**
     * Crear una matriz aleatoria de las filas y columnas indicadas.
     *
     * @param filas Filas que ha de tener la matriz.
     * @param columnas Columnas que ha de tener la matriz.
     * @return Devuelve una matriz aleatoria.
     */
    public static int[][] crearMatrizAleatoria(int filas, int columnas){
        return crearMatrizAleatoria(filas, columnas,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    /**
     * Crear una matriz aleatoria de las filas y columnas indicadas, con valores enteros dentro de un rango.
     *
     * @param filas Filas que ha de tener la matriz.
     * @param columnas Columnas que ha de tener la matriz.
     * @param minimo Valor mínimo que puede contener la matriz.
     * @param maximo Valor máximo que puede contener la matriz.
     * @return Devuelve una matriz que contiene los valores aleatorios comprendidos en el rango.
     */
    public static int[][] crearMatrizAleatoria(int filas, int columnas, int minimo, int maximo){
        int[][] matriz = new int[filas][columnas];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j]=Random.randomInt(minimo,maximo);
            }
        }
        return matriz;
    }

//----------DOUBLE----------\\

    /**
     * Crear una matriz aleatoria de las filas y columnas indicadas, con valores decimales dentro de un rango.
     *
     * @param filas Filas que ha de tener la matriz.
     * @param columnas Columnas que ha de tener la matriz.
     * @param minimo Valor mínimo que puede contener la matriz.
     * @param maximo Valor máximo que puede contener la matriz.
     * @return Devuelve una matriz que contiene los valores aleatorios comprendidos en el rango.
     */
    public static double[][] crearMatrizAleatoria(int filas, int columnas, double minimo, double maximo){
        double[][] matriz = new double[filas][columnas];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j]=Random.randomDouble(minimo,maximo);
            }
        }
        return matriz;
    }

//******************************** MATRIZ TO STRING ********************************\\

//----------INT----------\\

    /**
     * Convierte a una matriz 'int[][]' a un 'String'.
     *
     * @param matriz Matriz que se desea convertir.
     * @param padding Espacios en blanco que se dejan como margen.
     * @return Devuelve un 'String' que contiene la matriz.
     */
    public static String matrizToString(int[][] matriz, int padding){
        int anchoColumna = determinarLongitudMaxima(matriz);
        String formatoPadding = "%"+(anchoColumna+padding)+"s";
        StringBuilder sb = new StringBuilder();
        for (int[] fila : matriz){
            for (double valor : fila){
                sb.append(String.format(formatoPadding, String.format("%.0f",valor)));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

//----------DOUBLE----------\\

    /**
     * Convierte a una matriz 'double[][]' a un 'String'.
     *
     * @param matriz Matriz que se desea convertir.
     * @param decimales Número de decimales con los que se imprimirán los valores.
     * @param padding Espacios en blanco que se dejan como margen.
     * @return Devuelve un 'String' que contiene la matriz.
     */
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

//******************************** DETERMINAR LONGITUD MÁXIMA ********************************\\

//----------INT----------\\

    /**
     * Determina la longitud mayor de los indices de una matriz 'int[][]'.
     *
     * @param matriz Matriz sobre la que se desea trabajar.
     * @return Devuelve la máxima longitud del array como un 'int'.
     */
    public static int determinarLongitudMaxima(int[][] matriz){
        int longitudMaxima = 0;
        for (int[] fila : matriz){
            int longitud =Array.determinarLongitudMaxima(fila);
            if (longitud>longitudMaxima){
                longitudMaxima=longitud;
            }
        }
        return longitudMaxima;
    }

    /**
     * Determina la longitud mayor de los indices de un array 'double[]'.
     *
     * @param matriz Matriz sobre el que se desea trabajar.
     * @param decimales Número de decimales que se han de tener en cuenta.
     * @return Devuelve la máxima longitud del array como un 'int'.
     */
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
