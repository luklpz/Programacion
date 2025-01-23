package com.lukalopez.tema05.RepasoNavidad.ConversionesDeTipo;

import com.lukalopez.lib.IO;

public class Ejercicio1 {
    public static void main(String[] args) {
        final int num = IO.solicitarInt("Ingresa un número entero y te devolveré el doble con dos decimales: ");
        final double numDouble = num*2;
        System.out.printf("El doble de %d es %.2f",num,numDouble);
    }
}
