package com.lukalopez.tema04.Metodos;

import java.util.Scanner;

public class Ejercicio9 {
    /**
     * Solicita un número y devuelve su sumatorio.
     *
     * @param n Número sobre el cual calcular el sumatorio.
     * @return Devuelve el sumatorio del número 'n'.
     * @author luklpz
     */
    private static int sumatorio(int n){
        if (n<1){
            return 0;
        }
        int resultado = n;
        for (int i=0;i!=n-1;i++){
            resultado +=(n-1-i);
        }
        return resultado;
    }
    public static void main(String args[]){
        int num, resultado;
        Scanner lector = new Scanner(System.in);
        System.out.println("\nIntroduzca un número y devolveré su sumatorio:");
        num = Integer.parseInt(lector.nextLine());
        resultado = sumatorio(num);
        System.out.println(resultado);
    }
}
