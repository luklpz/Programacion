package com.lukalopez.tema04.Metodos.Recursividad;

public class Ejercicio5 {

    /**
     * Realiza la secuencia de Fibonacci de un número.
     *
     * @param numero Numero de la secuencia.
     * @return Devuelve el restultado de la secuencia de Fibonacci para el número indicado.
     */
    private static int secuenciaFibonacci(int numero){
        if (numero<1){
            System.err.println("No se realizar la secuencia de Fibonacci de un número inferior a 1.");
            return -1;
        }
        if (numero==0){
            return 0;
        }
        if (numero==1){
            return 0;
        }
        return (secuenciaFibonacci(numero-1)+secuenciaFibonacci(numero-2));
    }

    public static void main(String args[]) {
        System.out.println(secuenciaFibonacci(7));
    }
}