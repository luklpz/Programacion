package com.lukalopez.tema05.RepasoNavidad.ConversionesDeTipo;

import com.lukalopez.lib.IO;

public class Ejercicio3 {
    public static void main(String[] args) {
        final char caracter = IO.solicitarChar("Introduce un caracter y te devolveré su valor ANSI: ");
        System.out.printf("El número ANSI de %s es %d.",caracter,(int) caracter);
    }
}
