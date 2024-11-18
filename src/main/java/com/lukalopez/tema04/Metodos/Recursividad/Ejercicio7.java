package com.lukalopez.tema04.Metodos.Recursividad;

public class Ejercicio7 {

    private static int potencia(int numero, int potencia){
        if (potencia<1){
            System.err.println("No se puede hacer el factorial de un número inferior a 1.");
            return -1;
        } else if (potencia==1){
            return numero;
        }
        return numero*potencia(numero, potencia-1);
    }

    public static void main(String args[]) {
        System.out.println(potencia(2,4));
    }
}
