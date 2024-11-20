package com.lukalopez.lib;

public class IO {

    /**
     * Retorna un 'int' proveniente de retirar todos los caracteres no numericos de un 'String'.
     *
     * @param texto Texto sobre el cual trabajar.
     * @return Devuelve un "String" de los caracteres numericos de un 'String'.
     */
    public static String retirarCaracteresNoNumericos(String texto){
        if (texto.isEmpty()){
            return "";
        }
        return (texto.trim()).replaceAll("\\d+","");
    }

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
            respuesta = Escaner.lector.nextLine();
            //Validamos la respuesta
            if (respuesta.length() < lngMin || respuesta.length() > lngMax) {
                System.err.printf("La respuesta proporcionada no puede tener una longitud inferior a %s, ni superior a %s caracteres.\n\n", lngMin, lngMax);
            }
        } while (respuesta.length() < lngMin || respuesta.length() > lngMax);
        return respuesta;
    }

    public static int solicitarInt(String solicitud) {
        return solicitarInt(solicitud, Integer.MIN_VALUE, Integer.MAX_VALUE, "");
    }

    /**
     * Solicita un int mediante un mensaje, validando que sea un valor superior a un mínimo.
     *
     * @param solicitud Mensaje que se imprime para solicitar el 'int'.
     * @param minimo Valor mínimo que puede valer.
     * @return Devuelve el 'int' una vez validado.
     */
    public static int solicitarInt(String solicitud, int minimo, String mensajeError) {
        return solicitarInt(solicitud, minimo, Integer.MAX_VALUE, mensajeError);
    }

    /*
    public static int solicitarInt(String solicitud, int maximo) {
        return solicitarInt(solicitud,Integer.MIN_VALUE, maximo, "");
    }
    */

    /**
     * Solicita un 'int' y valida que se encuentre en el rango comprendido entre un mínimo 'min' y un máximo 'max'.
     *
     * @param solicitud Mensaje que se le muestra al usuario.
     * @param min Número mínimo valido que puede valer el 'int'.
     * @param max Número máximo válido que puede valer el 'int'.
     * @return Devuelve un 'int' validado.
     * @author luklpz
     */
    public static int solicitarInt(String solicitud, int min, int max, String mensajeError) {
        int respuesta;
        do {
            //Solicitamos el 'int'
            System.out.print(solicitud);
            respuesta = Integer.parseInt(retirarCaracteresNoNumericos(Escaner.lector.nextLine().trim()));
            //Validamos la respuesta
            if (respuesta<min||respuesta>max) {
                System.err.println(mensajeError);
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
            respuesta = Float.parseFloat(Escaner.lector.nextLine());
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
            respuesta = Double.parseDouble(Escaner.lector.nextLine());
            //Validamos la respuesta
            if (respuesta<min||respuesta>max) {
                System.err.printf("El número introducido no puede ser inferior a %f, ni superior a %f.\n\n", min, max);
            }
        } while (respuesta<min||respuesta>max);
        return respuesta;
    }


}