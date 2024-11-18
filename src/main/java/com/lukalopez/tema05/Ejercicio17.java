package com.lukalopez.tema05;

import com.lukalopez.lib.Escaner;
import com.lukalopez.lib.IO;

public class Ejercicio17 {

    /**
     * Valida si la letra de un NIF es la correcta.
     *
     * @param nif Es el NIF que se recibe para realizar la comprobación.
     * @return Devuelve 'true' si la letra del NIF es la correcta.
     */
    private static boolean comprobarNIF(String nif){
        char letra = nif.charAt(nif.length()-1);
        int dni = Integer.parseInt(IO.retirarCaracteresNoNumericos(nif));
        if (letra==Ejercicio16.letraSegunDNI(dni)){
            return true;
        }
        return false;
    }

    private static String solicitarNif(String mensajeSolicitud){
        //Definimos variables
        StringBuilder nif = new StringBuilder();
        boolean validado= false;

        //Solicitamos y validamos el DNI.
        System.out.println(mensajeSolicitud);
        do {
            nif.append(Escaner.lector.nextLine().replaceAll("\\s+",""));
            if (nif.isEmpty()){
                System.err.println("ERROR: No se han introducido valores.");
            } else if (nif.length()!=9) {
                System.err.println("ERROR: El NIF ha de tener 9 caracteres");
            } else if (IO.retirarCaracteresNoNumericos(nif.substring(0,nif.length()-1)).length()!=8) {
                System.err.println("ERROR: El NIF ha de contener 8 números y una letra al final.");
            } else {
                validado=true;
            }
            if (!validado){
                System.out.println("Intentelo de nuevo: ");
                nif.delete(0,nif.length());
            }
        } while (!validado);
        return nif.toString();
    }

    public static void main(String args[]) {
        if (comprobarNIF(solicitarNif("Introduzca a continuación un NIF y validaré si la letra es correcta."))) {
            System.out.println("La letra del NIF es correcta.");
        } else {
            System.out.println("La letra del NIF no es correcta.");
        }
    }
}
