package com.lukalopez.lib;

public class Array {

    public static void solicitarDatosArray(double[] array, double minimo) {
        solicitarDatosArray(array,minimo ,Double.MAX_VALUE);
    }

    public static void solicitarDatosArray(double[] array) {
        solicitarDatosArray(array, Double.MAX_VALUE,Double.MAX_VALUE);
    }

    public static void solicitarDatosArray(double[] array, double minimo, double maximo) {
        double valor;
        if (array == null) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            do {
            System.out.printf("a[%d]?\n", i);
            valor = Double.parseDouble(Escaner.lector.nextLine());
            if ((valor<minimo)||(valor>maximo)){
                if (minimo==Double.MIN_VALUE){
                    System.err.printf("El valor no está dentro del rango (%f>x). Introduzca de nuevo el valor: \n",maximo);
                } else if (maximo==Double.MAX_VALUE) {
                    System.err.printf("El valor no está dentro del rango (%f<x). Introduzca de nuevo el valor: \n",minimo);
                } else{
                    System.err.printf("El valor no está dentro del rango (%f - %f). Introduzca de nuevo el valor: \n",minimo, maximo);
                }
            }
            } while ((valor<minimo)||(valor>maximo));

            array[i] = valor;
        }
    }

    public static void solicitarDatosArray(char[] array) {
        if (array == null) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.printf("a[%d]?\n", i);
            array[i] = Escaner.lector.nextLine().charAt(0);
        }
    }

    public static String arrayToString(double[] array, int decimales) {
        if (array == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        String espacio = "";
        String coma = ",";
        String formato = "%." + decimales + "f";
        for (int i = 0; i < array.length; i++) {
            if (i == array.length -1) { // último elemento
                coma = "";
            }
            sb.append(espacio).append(String.format(formato, array[i])).append(coma);
            if (i == 0) {
                espacio = " ";
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public enum Paridad{
        PAR, IMPAR
    }

    public static String arrayToString(char[] array, Paridad paridad) {
        StringBuilder sb = new StringBuilder();
        int inicio = paridad == Paridad.PAR ? 0 : 1;
        for (int i = inicio; i < array.length; i += 2) {
            sb.append(array[i]);
        }
        return sb.toString();
    }

    public static String arrayToString(double[] array, int decimales, int columnas){
        return arrayToString(array,decimales,columnas,2);
    }

    public static String arrayToString(double[] array, int decimales, int columnas, int padding) {
        if (array == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int tamanyoColumna = determinarLongitudMaxima(array, decimales) + padding;
        String formato = "%" + tamanyoColumna + "." + decimales + "f";
        String formatoColumna = "%-" + tamanyoColumna + "s";
        for (int i = 0; i < array.length; i++) {
            sb.append(String.format(formatoColumna, String.format(formato, array[i])));
            if ((i + 1) % columnas == 0) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public static int determinarLongitudMaxima(double[] array, int decimales) {
        int longitudMaxima = 0;
        String formato = "%." + decimales + "f";
        for (double numero : array) {
            int longitudActual = String.format(formato, numero).length();
            if (longitudMaxima < longitudActual) {
                longitudMaxima = longitudActual;
            }
        }
        return longitudMaxima;
    }

    public static void rellenarArray(double[] array, double valorMinimo, double valorMaximo) {
        for (int i = 0; i < array.length; i++) {
            array[i] = Random.aleatorio(valorMinimo,valorMaximo);
        }
    }

    public static void rellenarArray(char[] array, char caracterMinimo, char caracterMaximo) {
        java.util.Random random = new java.util.Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = (char)random.nextInt(caracterMinimo, caracterMaximo);
        }
    }

    /**
     * Calcular la media de los valores contenidos en un array.
     *
     * @param array Array de 'double' sobre el que trabajar.
     * @param valorMinimo Valor mínimo 'double' que puede valer para contar en la media.
     * @param valorMaximo Valor máximo 'double' que puede valer para contar en la media.
     * @return Devuelve la media de los valores presentes en el segmento, devuelve 0 si no se encuentran argumentos.
     */
    public static double mediaArray(double[] array, double valorMinimo, double valorMaximo){
        int contador = 0;
        double sumatorio = 0;
        for (double i:array){
            if ((valorMinimo<=i)&&(i<=valorMaximo)){
                sumatorio+=i;
                contador++;
            }

        }
        if (contador==0){
            return 0;
        }
        return sumatorio/contador;
    }

}
