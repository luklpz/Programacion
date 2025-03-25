package com.lukalopez.tema07;

import com.lukalopez.lib.Escaner;

import java.util.NoSuchElementException;

public class EjemploClase {

    /**
     * Solicitar un String y validar su longitud.
     *
     * @param mensaje Mensaje que se imprime para solicitar el String.
     * @param minLength Longitud mínima.
     * @param maxLength Longitud máxima.
     * @return Devuelve el 'String' que ha introducido el usuario.
     */
    public static String leerString(String mensaje, int minLength, int maxLength) {
        boolean valido=false;
        String valor=null;
        do {
            try {
                System.out.println(mensaje);
                valor = Escaner.lector.nextLine();
                int length = valor.length();
                valido = length >= minLength && length <= maxLength;
                if (!valido) {
                    System.out.printf("La longitud debe de estar entre %d y %d\n", minLength, maxLength);
                }
                //Porque sout o serr?
            } catch (NoSuchElementException nsee) {
                System.out.println("La entrada no puede estar vacía.");
            } catch (IllegalStateException ise) {
                System.out.println("El escaner se encuentra cerrado.");
                //En este caso sería imposible que se diera ya que el mét0do Escaner lo inicializa en caso de estar cerrado.
            }
        } while (!valido);
        return valor;
    }

    /**
     * Mét0do para verificar si un 'String' cumple con el formato de matricula.
     * @param matricula 'String' que se desea validar.
     * @return Devuelve 'true' en caso de que el 'String' cumpla el formato.
     */
    public static boolean validarMatricula(String matricula) {
        int i;
        if (matricula.length() != 8) {
            return false;
        }
        for (i = 0; i < 4; i++) {
            if (!Character.isDigit(matricula.charAt(i))) {
                return false;
            }
        }
        if (!Character.isWhitespace(matricula.charAt(i++))) {
            return false;
        }
        for (int j = i; j < matricula.length(); j++) {
            if (!Character.isLetter(matricula.charAt(j))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String matricula = leerString("Mete una matricula anda (NNNN LLL):",8,8);
        System.out.println(validarMatricula(matricula));
    }
}
