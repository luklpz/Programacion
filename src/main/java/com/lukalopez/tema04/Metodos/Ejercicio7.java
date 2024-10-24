package com.lukalopez.tema04.Metodos;

public class Ejercicio7 {
    /**
     * Solicita un número 'n' y calcula su factorial.
     *
     * @param n El número entero sobre el cual se va a calcular el factorial.
     * @return Devuelve el resultado 'resultado' de calcular el factorial sobre 'n'.
     * @author luklpz
     */
    private static int factorial(int n){
        if (n<1){
            return 0;
        }
        int resultado = n;
        for (int i=0;i!=n-1;i++){
            resultado *=(n-1-i);
        }
        return resultado;
    }
    public static void main(String args[]){
        int resultado = factorial(2);
        System.out.println(resultado);
    }
}
