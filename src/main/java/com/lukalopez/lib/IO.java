package com.lukalopez.lib;

import com.sun.nio.sctp.IllegalReceiveException;

import java.util.Scanner;

public class IO {
    /**
     * Solicita un String y valida que su longitud esté comprendida entre una longitud mínima y una longitud máxima.
     *
     * @param mensaje Mensaje que se le muestra al usuario.
     * @param lngMin  Número mínimo de caracteres que debe tener el texto.
     * @param lngMax  Número máximo de caracteres que puede tener el texto.
     * @return Devuelve el String validado.
     * @throws IllegalReceiveException Si la respuesta no se comprende dentro del rango de caracteres permitido.
     * @author luklpz
     */
    public static String solicitarString(String mensaje, int lngMin, int lngMax) {
        Scanner lector = new Scanner(System.in);
        String respuesta;
        do {
            System.out.println(mensaje);
            respuesta = lector.nextLine();
            if (respuesta.length() < lngMin || respuesta.length() > lngMax) {
                System.out.printf("La respuesta proporcionada no puede tener una longitud inferior a %s, ni superior a %s caracteres.\n\n", lngMin, lngMax);
            }
        } while (respuesta.length() < lngMin || respuesta.length() > lngMax);
        return respuesta;
    }
}