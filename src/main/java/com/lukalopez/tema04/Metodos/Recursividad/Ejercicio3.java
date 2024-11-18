package com.lukalopez.tema04.Metodos.Recursividad;

public class Ejercicio3 {

    /**
     * Calcular el número de digitos de un 'int'.
     *
     * @param numero Numero sobre el que se desea trabajar.
     * @return Devuelve el número de digitos que tiene el número.
     */
    private static int numeroDeDigitos(int numero){
        int contador = 0;
        if (numero<1){
            numero = -numero;
        }
        if (numero==0){
            return 0;
        }
        contador = 1 + numeroDeDigitos(numero/10);
        return contador;
    }

    public static void main(String args[]) {
        System.out.println(numeroDeDigitos(152345235));
    }
}