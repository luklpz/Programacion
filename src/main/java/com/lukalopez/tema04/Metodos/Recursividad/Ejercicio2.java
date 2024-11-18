package com.lukalopez.tema04.Metodos.Recursividad;

public class Ejercicio2 {

    /**
     * Calcula la suma recursiva de un número.
     *
     * @param numero Número sobre el que se desea calcular la suma recursiva.
     * @return Devuelve el resultado de la suma.
     */
    private static int sumaRecursiva(int numero){
        if (numero<1){
            System.err.println("No se puede hacer una suma recursiva de un número inferior a 1.");
            return 0;
        } else if (numero==1){
            return numero;
        }
        return numero + sumaRecursiva(numero-1);
    }

    public static void main(String args[]) {
        System.out.println(sumaRecursiva(6));
    }
}
