package com.lukalopez.tema05.RepasoNavidad.ConversionesDeTipo;

import com.lukalopez.lib.IO;

public class Ejercicio4 {
    public static void main(String[] args) {
        final int caracter = IO.solicitarInt("Introduce un entero y te devolveré su caracter ANSI (1-127): ",0,128);
        System.out.printf("El número ANSI de %d es %s.",caracter,(char) caracter);
    }
}
