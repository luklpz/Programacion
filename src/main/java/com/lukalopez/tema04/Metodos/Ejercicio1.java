package com.lukalopez.tema04.Metodos;

import java.util.Scanner;

public class Ejercicio1 {
    /**
     * Calcula la suma de dos números.
     *
     * @param x El primer número.
     * @param y El segundo número.
     * @return La suma de los dos números.
     * @author Luka López
     *
     */
    public static float sumar(float x, float y) {
        return x + y;
    }

    public static void main(String args[]) {
        Scanner lector = new Scanner(System.in);
        System.out.println("\nIntroduce dos números y los sumaré.Primer número: ");
        float x = Float.parseFloat(lector.nextLine());
        System.out.println("Segundo número:");
        float y = Float.parseFloat(lector.nextLine());
        float suma=sumar(x,y);
        System.out.printf("%f%s%f%s%f%s",x,"+",y,"=",suma,"\n");
    }
}
