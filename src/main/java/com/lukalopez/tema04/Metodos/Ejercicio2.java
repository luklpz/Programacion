package com.lukalopez.tema04.Metodos;

import java.util.Scanner;

public class Ejercicio2 {
    /**
     * Calcula el área de un círculo.
     *
     * @param r El radio del círculo.
     * @return El área calculada del círculo.
     * @throws IllegalArgumentException Si el radio es negativo.
     * @see Math#PI
     * @author Luka López
     *
     */
    private static float area(float r) {
        if (r < 0) {
            throw new IllegalArgumentException("El radio no puede ser negativo.");
        }
        else {
            return (float) Math.PI * r * r;
        }
    }



    /**
     * Calcula el perímertro de un círculo.
     *
     * @param r El radio del círculo.
     * @return El perímetro calculado del círculo.
     * @throws IllegalArgumentException Si el radio es negativo.
     * @see Math#PI
     * @author luklpz
     *
     */
    private static float perimetro(float r) {
        if (r < 0) {
            throw new IllegalArgumentException("El radio no puede ser negativo.");
        } else {
            return (float) Math.PI * r * 2;
        }
    }


    public static void main(String args[]) {
        Scanner lector = new Scanner(System.in);
        System.out.println("\nIntroduce el radio de un círculo en centímetros y devolveré su área y su perímetro: ");
        float r = Float.parseFloat(lector.nextLine());
        float a = area(r);
        float p = perimetro(r);
        System.out.printf("El área es de %fcm², el perímetro es de %fcm.\n",a,p);
    }
}
