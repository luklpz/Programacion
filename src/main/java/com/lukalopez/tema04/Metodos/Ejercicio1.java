package com.lukalopez.tema04.Metodos;

import java.util.Scanner;

public class Ejercicio1 {
    /**
     * Calcula la suma de dos números.
     *
     * @param x El primer número.
     * @param y El segundo número.
     * @return La suma de los dos números.
     * @author luklpz
     *
     */
    public static int sumar(int x, int y) {
        return x + y;
    }

    public static void main(String args[]) {
        Scanner lector = new Scanner(System.in);
        System.out.println("\nIntroduce dos números enteros y los sumaré.Primer número: ");
        int x = Integer.parseInt(lector.nextLine());
        System.out.println("Segundo número:");
        int y = Integer.parseInt(lector.nextLine());
        int suma=sumar(x,y);
        System.out.printf("%1x + %2x = %3x\n",x,y,suma);
    }
}
