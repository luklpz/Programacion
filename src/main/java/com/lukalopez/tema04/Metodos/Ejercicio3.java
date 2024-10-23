package com.lukalopez.tema04.Metodos;

import java.util.Scanner;

public class Ejercicio3 {
    /**
     * Solicita dos 'float' y devuelve el valor máximo.
     *
     * @param mensaje Mensaje que se le muestra al usuario para solicitar los dos números.
     * @return Devuelve un 'float' como máximo validado.
     * @author luklpz
     */
    private static float calcMayor(String mensaje){
        Scanner lector = new Scanner(System.in);
        //Solicitamos los números
        System.out.println(mensaje);
        System.out.println("Primer número:");
        float x = Float.parseFloat(lector.nextLine());
        System.out.println("Segundo número:");
        float y = Float.parseFloat(lector.nextLine());

        //Comprobamos el máximo
        if (x>y){
            return x;
        }
        else {
            return  y;
        }
    }

    public static void main(String args[]){
        float mayor = calcMayor("\nIntroduzca dos números y devolveré el mayor.");
        System.out.println(mayor);
    }
}
