package com.lukalopez.tema04.Metodos.Recursividad;

public class Ejercicio5 {

    /**
     * Realiza la secuencia de Fibonacci de un número.
     *
     * @param contador Numero de la secuencia.
     * @return Devuelve el restultado de la secuencia de Fibonacci para el número indicado.
     */
    private static int secuenciaFibonacci(int contador){
        if (contador==0){
            return -1;
        }
        return secuenciaFibonacci(0,1,contador-3);
    }

    private static int secuenciaFibonacci(int num1, int num2, int contador){
        if (contador==0){
            return num2;
        }
        return num2+secuenciaFibonacci(num2,num2+num1,contador-1);
    }

    public static void main(String args[]) {
        System.out.println(secuenciaFibonacci(7));
    }
}