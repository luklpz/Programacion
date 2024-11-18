package com.lukalopez.tema04.Metodos.Recursividad;

public class Ejercicio6 {

    /**
     * Calcula el factorial de un número.
     *
     * @param numero Número sobre el que calcular el factorial.
     * @return Devuelve el restultado del factorial.
     */
    private static int factorial(int numero){
        if (numero<1){
            System.err.println("No se puede hacer el factorial de un número inferior a 1.");
            return -1;
        } else if (numero==1){
            return 1;
        }
        return numero*factorial(numero-1);
    }

    public static void main(String args[]) {
        System.out.println(factorial(4));
    }
}
