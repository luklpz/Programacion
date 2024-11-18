package com.lukalopez.tema04.Metodos.Recursividad;

public class Ejercicio1 {
    /**
     * Imprime una cuenta regresiva.
     *
     * @param numero Numero sobre el que se imprimirá la cuenta regresiva.
     * @return Devuelve true si la cuenta regresiva se ha podido realizar.
     */
    private static boolean cuentaRegresiva(int numero){
        if (numero<1){
            System.err.println("No se puede hacer una cuenta regresiva de un número inferior a 1.");
            return false;
        } else if (numero==1){
            System.out.println(numero);
            return true;
        }
        System.out.println(numero);
        return cuentaRegresiva(numero-1);
    }

    public static void main(String args[]) {
        cuentaRegresiva(5);
    }
}
