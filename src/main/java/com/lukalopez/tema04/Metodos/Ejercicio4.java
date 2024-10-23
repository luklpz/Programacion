package com.lukalopez.tema04.Metodos;

import java.util.Scanner;

public class Ejercicio4 {
    /**
     * Solicita cuatro 'float' y devuelve el valor máximo.
     *
     * @param mensaje Mensaje que se le muestra al usuario para solicitar los cuatro números.
     * @return Devuelve un 'float' como máximo validado.
     * @author luklpz
     */
    private static float calcMayor(String mensaje){
        Scanner lector = new Scanner(System.in);
        float w,x,y,z,max;
        //Solicitamos los números
        System.out.println(mensaje);
        System.out.println("Primer número:");
        w = Float.parseFloat(lector.nextLine());
        System.out.println("Segundo número:");
        x = Float.parseFloat(lector.nextLine());
        System.out.println("Tercer número:");
        y = Float.parseFloat(lector.nextLine());
        System.out.println("Cuarto número:");
        z = Float.parseFloat(lector.nextLine());
        //Comprobamos el máximo
        max=w;
        if (x>max){
            max = x;
        }
        if (y>max){
            max = y;
        }
        if (z>max){
            max = z;
        }
        return max;
    }
    public static void main(String args[]){
        float mayor = calcMayor("\nIntroduzca cuatro números y devolveré el mayor.");
        System.out.println(mayor);
    }
}
