package com.lukalopez.lib;
import static com.lukalopez.lib.Escaner.lector;
import java.util.Scanner;

public class IO {
    /**
     * Solicita un 'String' y valida que su longitud esté comprendida entre una longitud mínima 'lngMin' y una longitud máxima 'lngMax'.
     *
     * @param mensaje Mensaje que se le muestra al usuario.
     * @param lngMin  Número mínimo de caracteres que debe tener el 'String'.
     * @param lngMax  Número máximo de caracteres que puede tener el 'String'.
     * @return Devuelve el 'String' validado.
     * @author luklpz
     */
    public static String solicitarString(String mensaje, int lngMin, int lngMax) {
        String respuesta;
        do {
            //Solicitamos el 'String'
            System.out.println(mensaje);
            respuesta = lector.nextLine();
            //Validamos la respuesta
            if (respuesta.length() < lngMin || respuesta.length() > lngMax) {
                System.err.printf("La respuesta proporcionada no puede tener una longitud inferior a %s, ni superior a %s caracteres.\n\n", lngMin, lngMax);
            }
        } while (respuesta.length() < lngMin || respuesta.length() > lngMax);
        return respuesta;
    }



    /**
     * Solicita un 'int' y valida que se encuentre en el rango comprendido entre un mínimo 'min' y un máximo 'max'.
     *
     * @param mensaje Mensaje que se le muestra al usuario.
     * @param min Número mínimo valido que puede valer el 'int'.
     * @param max Número máximo válido que puede valer el 'int'.
     * @return Devuelve un 'int' validado.
     * @author luklpz
     */
    public static int solicitarInt(String mensaje, int min, int max) {
        int respuesta;
        do {
            //Solicitamos el 'int'
            System.out.println(mensaje);
            respuesta = Integer.parseInt(lector.nextLine());
            //Validamos la respuesta
            if (respuesta<min||respuesta>max) {
                System.err.printf("El número introducido no puede ser inferior a %d, ni superior a %d.\n\n", min, max);
            }
        } while (respuesta<min||respuesta>max);
        return respuesta;
    }



    /**
     * Solicita un 'float' y valida que se encuentre en el rango comprendido entre un mínimo 'min' y un máximo 'max'.
     *
     * @param mensaje Mensaje que se le muestra al usuario.
     * @param min Número mínimo válido que puede valer el 'float'.
     * @param max Número máximo válido que puede valer el 'float'.
     * @return Devuelve un 'float' validado.
     * @author luklpz
     */
    public static float solicitarFloat(String mensaje, float min, float max) {
        float respuesta;
        do {
            //Solicitamos el 'float'
            System.out.println(mensaje);
            respuesta = Float.parseFloat(lector.nextLine());
            //Validamos la respuesta
            if (respuesta<min||respuesta>max) {
                System.err.printf("El número introducido no puede ser inferior a %f, ni superior a %f.\n\n", min, max);
            }
        } while (respuesta<min||respuesta>max);
        return respuesta;
    }



    /**
     * Solicita un 'double' y valida que se encuentre en el rango comprendido entre un mínimo 'min' y un máximo 'max'.
     *
     * @param mensaje Mensaje que se le muestra al usuario.
     * @param min Número mínimo válido que puede valer el 'double'.
     * @param max Número máximo válido que puede valer el 'double'.
     * @return
     */
    public static double solicitarDouble(String mensaje, double min, double max) {
        double respuesta;
        do {
            //Solicitamos el 'double'
            System.out.println(mensaje);
            respuesta = Double.parseDouble(lector.nextLine());
            //Validamos la respuesta
            if (respuesta<min||respuesta>max) {
                System.err.printf("El número introducido no puede ser inferior a %f, ni superior a %f.\n\n", min, max);
            }
        } while (respuesta<min||respuesta>max);
        return respuesta;
    }
}