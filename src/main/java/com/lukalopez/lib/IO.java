package com.lukalopez.lib;

import com.lukalopez.lib.Excepciones.InvalidLowerLimitException;
import com.lukalopez.lib.Excepciones.InvalidUpperLimitException;
import com.lukalopez.lib.Excepciones.InvalidEmptyException;

public class IO {

    //===========================================================================\\
    //                                 SOLICITAR                                 \\
    //===========================================================================\\

    public enum Condicion{
        MAXIMO, MINIMO
    }


    //********************************* INT *********************************\\

    /**
     * Mét0do para solicitar un 'int' sin condiciones.
     *
     * @param mensaje Mensaje que se imprime para solicitar el 'int'.
     * @return Devuelve el 'int'.
     */
    public static int solicitarInt(String mensaje) {
        return solicitarInt(mensaje, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * Mét0do para solicitar un 'int' dentro de un máximo o un mínimo.
     *
     * @param mensaje Mensaje que se imprime para solicitar el 'int'.
     * @param valor Valor que máximo o mínimo, según la condición, que puede valer el 'int'.
     * @param condicion Condición que indica si el valor indicado es un máximo o un mínimo.
     * @return Devuelve el 'int' una vez validado dentro del rango.
     */
    public static int solicitarInt(String mensaje, int valor, Condicion condicion) {
        if (condicion == Condicion.MAXIMO){
            return solicitarInt(mensaje, Integer.MIN_VALUE, valor);
        } else {
            return solicitarInt(mensaje, valor, Integer.MAX_VALUE);
        }

    }

    /**
     * Mét0do para solicitar un 'int' dentro de un rango.
     * @param mensaje Mensaje que se imprime para solicitar el 'int'.
     * @param minimo Número mínimo válido que puede valer el 'int'.
     * @param maximo Número máximo válido que puede valer el 'int'.
     * @return Devuelve el 'int' una vez validado dentro del rango.
     */
    public static int solicitarInt(String mensaje, int minimo, int maximo){
        //Definimos las variables
        String entrada;
        boolean valido=false;
        int numero=0;
        do {
            try {
                //Solicitamos el número
                System.out.print(mensaje);
                entrada = Escaner.lector.nextLine().trim();

                //Verificamos que la entrada no sea nula
                isBlankCheck(entrada);

                numero = Integer.parseInt(entrada);

                //Verificamos que no supere el máximo ni el mínimo
                if (numero>maximo){
                    throw new InvalidUpperLimitException(String.format("El número %d sobrepasa el máximo %d",numero, maximo));
                } else if (numero<minimo){
                    throw new InvalidLowerLimitException(String.format("El número %d sobrepasa el máximo %d",numero, minimo));
                } else {
                    valido = true;
                }
            } catch (InvalidEmptyException nee){
                System.out.println(nee.getMessage());
            } catch(InvalidUpperLimitException iple){
                System.out.println(iple.getMessage());
            } catch(InvalidLowerLimitException ille){
                System.out.println(ille.getMessage());
            } catch (NumberFormatException nfe) {
                System.out.println("Solo se aceptan números sin decimales.");
            }
        } while (!valido);
        return numero;
    }




    //********************************* DOUBLE *********************************\\

    /**
     * Mét0do para solicitar un 'double' sin condiciones.
     * @param mensaje Mensaje que se imprime para solicitar el 'double'.
     * @return Devuelve el 'double'.
     */
    public static double solicitarDouble(String mensaje) {
        return solicitarDouble(mensaje, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * Mét0do para solicitar un 'double' dentro de un máximo o un mínimo.
     *
     * @param mensaje Mensaje que se imprime para solicitar el 'double'.
     * @param valor Valor que máximo o mínimo, según la condición, que puede valer el 'double'.
     * @param condicion Condición que indica si el valor indicado es un máximo o un mínimo.
     * @return Devuelve el 'double' una vez validado dentro del rango.
     */
    public static double solicitarDouble(String mensaje, double valor, Condicion condicion) {
        if (condicion == Condicion.MAXIMO){
            return solicitarDouble(mensaje, Double.MIN_VALUE, valor);
        } else {
            return solicitarDouble(mensaje, valor, Double.MAX_VALUE);
        }
    }

    /**
     * Mét0do para solicitar un 'double' dentro de un rango.
     * @param mensaje Mensaje que se imprime para solicitar el 'double'.
     * @param minimo Número mínimo válido que puede valer el 'double'.
     * @param maximo Número máximo válido que puede valer el 'double'.
     * @return Devuelve el 'double' una vez validado dentro del rango.
     */
    public static double solicitarDouble(String mensaje, double minimo, double maximo){
        //Definimos las variables
        String entrada;
        boolean valido=false;
        double numero=0;
        do {
            try {
                //Solicitamos el número
                System.out.print(mensaje);
                entrada = Escaner.lector.nextLine().trim();

                //Verificamos que la entrada no sea nula
                isBlankCheck(entrada);

                numero = Double.parseDouble(entrada);

                //Verificamos que no supere el máximo ni el mínimo
                if (numero>maximo){
                    throw new InvalidUpperLimitException(String.format("El número %f sobrepasa el máximo %f",numero, maximo));
                } else if (numero<minimo){
                    throw new InvalidLowerLimitException(String.format("El número %f sobrepasa el máximo %f",numero, minimo));
                } else {
                    valido = true;
                }
            } catch (InvalidEmptyException nee){
                System.out.println(nee.getMessage());
            } catch(InvalidUpperLimitException iple){
                System.out.println(iple.getMessage());
            } catch(InvalidLowerLimitException ille){
                System.out.println(ille.getMessage());
            } catch (NumberFormatException nfe) {
                System.out.println("Solo se aceptan números.");
            }
        } while (!valido);
        return numero;
    }


    //********************************* FLOAT *********************************\\

    /**
     * Mét0do para solicitar un 'float' sin condiciones.
     * @param mensaje Mensaje que se imprime para solicitar el 'float'.
     * @return Devuelve el 'float'.
     */
    public static double solicitarFloat(String mensaje) {
        return solicitarFloat(mensaje, Float.MIN_VALUE, Float.MAX_VALUE);
    }

    /**
     * Mét0do para solicitar un 'float' dentro de un máximo o un mínimo.
     *
     * @param mensaje Mensaje que se imprime para solicitar el 'float'.
     * @param valor Valor que máximo o mínimo, según la condición, que puede valer el 'float'.
     * @param condicion Condición que indica si el valor indicado es un máximo o un mínimo.
     * @return Devuelve el 'float' una vez validado dentro del rango.
     */
    public static float solicitarFloat(String mensaje, float valor, Condicion condicion) {
        if (condicion == Condicion.MAXIMO){
            return solicitarFloat(mensaje, Float.MIN_VALUE, valor);
        } else {
            return solicitarFloat(mensaje, valor, Float.MAX_VALUE);
        }
    }

    /**
     * Mét0do para solicitar un 'float' dentro de un rango.
     * @param mensaje Mensaje que se imprime para solicitar el 'float'.
     * @param minimo Número mínimo válido que puede valer el 'float'.
     * @param maximo Número máximo válido que puede valer el 'float'.
     * @return Devuelve el 'float' una vez validado dentro del rango.
     */
    public static float solicitarFloat(String mensaje, float minimo, float maximo){
        //Definimos las variables
        String entrada;
        boolean valido=false;
        float numero=0;
        do {
            try {
                //Solicitamos el número
                System.out.print(mensaje);
                entrada = Escaner.lector.nextLine().trim();

                //Verificamos que la entrada no sea nula
                isBlankCheck(entrada);

                numero = Float.parseFloat(entrada);

                //Verificamos que no supere el máximo ni el mínimo
                if (numero>maximo){
                    throw new InvalidUpperLimitException(String.format("El número %f sobrepasa el máximo %f",numero, maximo));
                } else if (numero<minimo){
                    throw new InvalidLowerLimitException(String.format("El número %f sobrepasa el máximo %f",numero, minimo));
                } else {
                    valido = true;
                }
            } catch (InvalidEmptyException nee){
                System.out.println(nee.getMessage());
            } catch(InvalidUpperLimitException iple){
                System.out.println(iple.getMessage());
            } catch(InvalidLowerLimitException ille){
                System.out.println(ille.getMessage());
            } catch (NumberFormatException nfe) {
                System.out.println("Solo se aceptan números.");
            }
        } while (!valido);
        return numero;
    }

    //********************************* STRING *********************************\\

    /**
     * Mét0do para solicitar un 'String' sin condiciones.
     * @param mensaje Mensaje que se imprime para solicitar el 'String'.
     * @return Devuelve el 'String'.
     */
    public static String solicitarString(String mensaje) {
        return solicitarString(mensaje, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * Mét0do para solicitar un 'double' dentro de un máximo o un mínimo.
     *
     * @param mensaje Mensaje que se imprime para solicitar el 'String'.
     * @param valor Valor que máximo o mínimo, según la condición, que puede ser la longitud del 'String'.
     * @param condicion Condición que indica si el valor indicado es un máximo o un mínimo.
     * @return Devuelve el 'String' una vez validada su longitud dentro del rango.
     */
    public static String solicitarString(String mensaje, int valor, Condicion condicion) {
        if (condicion == Condicion.MAXIMO){
            return solicitarString(mensaje, Integer.MIN_VALUE, valor);
        } else {
            return solicitarString(mensaje, valor, Integer.MAX_VALUE);
        }
    }

    /**
     * Mét0do para solicitar un 'String' validando su longitud dentro de un rango.
     *
     * @param mensaje Mensaje que se imprime para solicitar el 'String'.
     * @param lngMin  Número mínimo de caracteres que debe tener el 'String'.
     * @param lngMax  Número máximo de caracteres que puede tener el 'String'.
     * @return Devuelve el 'String' una vez validada su longitud dentro del rango.
     * @author luklpz
     * */
    public static String solicitarString(String mensaje, int lngMin, int lngMax) {
        String entrada=null;
        int lngEntrada;
        boolean valido;
        do {
            valido=false;
            try {
                //Solicitamos el número
                System.out.print(mensaje);
                entrada = Escaner.lector.nextLine().trim();

                //Verificamos que la entrada no sea nula
                isBlankCheck(entrada);
                lngEntrada=entrada.length();
                //Verificamos que no supere el máximo ni el mínimo
                if (lngEntrada>lngMax){
                    throw new InvalidUpperLimitException(String.format("La entrada sobrepasa el máximo de carácteres aceptados '%d'. Número de carácteres actuales: %d",lngMax, lngEntrada));
                } else if (lngEntrada<lngMin){
                    throw new InvalidLowerLimitException(String.format("La entrada es menor al mínimo de carácteres aceptados '%d'. Número de carácteres actuales: %d",lngMin, lngEntrada));
                } else {
                    valido = true;
                }
            } catch (InvalidEmptyException nee){
                System.out.println(nee.getMessage());
            } catch(InvalidUpperLimitException iple){
                System.out.println(iple.getMessage());
            } catch(InvalidLowerLimitException ille){
                System.out.println(ille.getMessage());
            }
        } while (!valido);
        return entrada;
    }


    //********************************* CHAR *********************************\\

    /**
     * Solicita un 'char' y valida que se haya introducido un único caracter.
     *
     * @param mensaje Mensaje que se le muestra al usuario.
     * @return Devuelve un 'char' validado.
     */
    public static char solicitarChar(String mensaje){
        return solicitarChar(mensaje,"El número de carácteres introducidos es inválido.");
    }


    /**
     * Solicita un 'char' y valida que se haya introducido un único caracter.
     *
     * @param mensaje Mensaje que se le muestra al usuario.
     * @param mensajeError Mensaje de error que se muestra al introducir un número de carácteres inválido.
     * @return Devuelve un 'char' validado.
     */
    public static char solicitarChar(String mensaje, String mensajeError){
        boolean valido=false;
        String respuesta;
        do {
            //Solicitarmos el 'char'
            System.out.print(mensaje);
            respuesta = Escaner.lector.nextLine();
            if (respuesta.length()!=1){
                System.err.println(mensajeError);
            } else {
                valido=true;
            }
        } while (!valido);
        return respuesta.charAt(0);
    }




    //********************************* BOOLEAN *********************************\\

    /**
     * Solicita un 'boolean' y valida que se haya introducido una respuesta válida.
     *
     * @param mensaje Mensaje que se le muestra al usuario.
     * @param textoTrue Texto que ha de introducir el usuario para devolver 'True'.
     * @param textoFalse Texto que ha de introducir el usuario para devolver 'False'.
     * @param mensajeError Mensaje que se muestra si la validación falla.
     * @return Devuelve true o false según la entrada del usuario.
     */
    public static boolean solicitarBoolean(String mensaje,String textoTrue, String textoFalse, String mensajeError){
        boolean valido=false;
        boolean devuelve=false;
        String respuesta;
        do{
            //Solicitamos el boolean
            System.out.print(mensaje);
            respuesta = (Escaner.lector.nextLine()).trim().replaceAll("\\s+","").toLowerCase();

            //Verificamos si la respuesta corresponde exactamente
            if (respuesta.equals(textoTrue.toLowerCase())){
                devuelve = true;
                valido = true;
            }
            else if (respuesta.equals(textoFalse.toLowerCase())) {
                valido = true;
            } else {
                System.err.print(mensajeError);
            }
        } while (!valido);
        return devuelve;
    }

    //===========================================================================\\
    //                             MÉTODOS AUXILIARES                            \\
    //===========================================================================\\

    /**
     * Mét0do para verificar si una cadena de texto se encuentra vacía o solo cuenta con espacios en blanco, esi es el caso lanza una InvalidEmptyExcepcion.
     * @param cadena 'String' que se desea comprobar.
     * @throws InvalidEmptyException Se lanza esta excepción si la cadena de texto resulta estar vacía o solo contener espacios en blanco.
     */
    public static void isBlankCheck(String cadena) throws InvalidEmptyException{
        if (cadena.isBlank()) {
            throw new InvalidEmptyException("No se puede introducir una entrada vacía.");
        }
    }
}