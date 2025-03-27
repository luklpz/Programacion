package com.lukalopez.tema07.Ejercicio8;

public class Ejercicio8 {

    public static void pruebaErrores(int[] arrayVacio, int dividendo, int divisor, int capacidadArray, int[] arrayInicializado){
        boolean arithmeticException = false;
        boolean nullPointerException = false;
        boolean indexOutOfBoundsException = false;
        for (int i = 0; i < 4; i++) {
            try {
                if (!arithmeticException){
                    System.out.println(dividendo/divisor);
                } else if (!nullPointerException) {
                    System.out.println(arrayVacio[3]);
                } else if (!indexOutOfBoundsException){
                    for (int j = 0; j < capacidadArray; j++) {
                        System.out.println(arrayInicializado[j]);
                    }
                }
            } catch (ArithmeticException ae) {
                System.out.println("ArithmeticException: No se puede dividir por cero.");
                arithmeticException = true;
            } catch (NullPointerException npe) {
                System.out.println("NullPointerException: Se ha introducido un array no inicializado.");
                nullPointerException = true;
            } catch (IndexOutOfBoundsException ioobe) {
                System.out.println("IndexOutOfBoundsException: Se ha superado la capacidad del array.");
                indexOutOfBoundsException = true;
            }
        }
    }

    public static void main(String[] args) {
        pruebaErrores(null,2,0,4, new int[]{});
    }
}
