package com.lukalopez.tema07.Ejercicio8;

public class Ejercicio8 {

    /**
     * Mét0do para realizar las pruebas de las excepciones "ArithmeticException", "NullPointerException" y "IndexOutOfBoundsException".
     * @param arrayVacio Array vacío para que suceda el error NullPointerException.
     * @param dividendo Dividendo de la división para el error "ArithmeticException".
     * @param divisor Divisor de la división para el error "ArithmeticException", ha de ser 0.
     * @param capacidadArray 'int' que determinará la capacidad falsa del array para el error "IndexOutOfBoundsException", ha de ser mayor que la capacidad real.
     * @param arrayInicializado Array inicializado con números, su capacidad ha de ser menor que el campo "capacidadArray".
     */
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
