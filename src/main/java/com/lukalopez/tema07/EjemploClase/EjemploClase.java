package com.lukalopez.tema07.EjemploClase;

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
    public static boolean validarMatricula(String matricula) throws InvalidPlateLengthException, InvalidPlateException, InvalidPlateLettersException, InvalidPlateNumberException{
        int i;
        if (matricula.length() != 8) {
            throw new InvalidPlateLengthException("La matricula debe tener 8 caracteres de longitud.");
        }
        for (i = 0; i < 4; i++) {
            if (!Character.isDigit(matricula.charAt(i))) {
                throw new InvalidPlateNumberException("Los cuatro primeros digitos han de ser números.");
            }
        }
        if (!Character.isWhitespace(matricula.charAt(i++))) {
            throw new InvalidPlateException("Tras los números ha de haber un espacio en blanco.");
        }
        for (int j = i; j < matricula.length(); j++) {
            if (!Character.isLetter(matricula.charAt(j))) {
                throw new InvalidPlateLettersException("Los tres últimos dígitos han de ser letra.");
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean matriculaValida=false;
        do {
            String matricula = leerString("Mete una matricula anda (NNNN LLL):", 8, 8);
            try {
                System.out.println(validarMatricula(matricula));
                matriculaValida=true;
            } catch (InvalidPlateLengthException iplhe) {
                System.out.println(iplhe.getMessage());
            }catch (InvalidPlateLettersException iplte) {
                System.out.println(iplte.getMessage());
            } catch (InvalidPlateNumberException ipne){
                System.out.println(ipne.getMessage());
            } catch (InvalidPlateException ipe) {
                System.out.println(ipe.getMessage());
            }
        } while (!matriculaValida);
    }
}
