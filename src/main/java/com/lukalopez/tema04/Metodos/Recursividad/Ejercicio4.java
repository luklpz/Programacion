package com.lukalopez.tema04.Metodos.Recursividad;

public class Ejercicio4 {

    /**
     * Realiza el sumatorio de los digitos de un número.
     * @param numero Número sobre el que se calcula el sumatorio.
     * @return Devuelve el resultado del sumatorio.
     */
    private static int sumatorioDeDigitos(int numero){
        if (numero<1){
            System.err.println("No se puede hacer un sumatorio de un número inferior a 1.");
            return 0;
        }
        if (numero<10){
            return numero;
        }


        return (numero % 10)+sumatorioDeDigitos(numero/10);
    }

    public static void main(String args[]) {
        System.out.println(sumatorioDeDigitos(-1));
    }
}
