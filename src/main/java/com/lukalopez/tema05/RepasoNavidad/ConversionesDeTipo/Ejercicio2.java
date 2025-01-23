package com.lukalopez.tema05.RepasoNavidad.ConversionesDeTipo;

import com.lukalopez.lib.IO;

public class Ejercicio2 {
    public static void main(String[] args) {
        final double num = IO.solicitarDouble("Ingresa un número real y te devolveré su doble como un entero: ");
        final int numEntero = (int) num*2;

        System.out.printf("El doble de %s es %d", num, numEntero);
    }
}
