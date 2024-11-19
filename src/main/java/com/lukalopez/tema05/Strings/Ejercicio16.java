package com.lukalopez.tema05.Strings;


import com.lukalopez.lib.Escaner;
import com.lukalopez.lib.IO;
import com.lukalopez.lib.Texto;

public class Ejercicio16 {

    /**
     * Obtener la letra de un DNI.
     * @param dni DNI sobre el que se desea obtener su letra.
     * @return Devuelve un 'char' que contiene la letra del DNI.
     */
    public static char letraSegunDNI(int dni){
        String s="TRWAGMYFPDXBNJZSQVHLCKE";
        return s.charAt(dni % 23);
    }

    private static int solicitarDNI(String mensajeSolicitud){
        System.out.println(mensajeSolicitud);
        boolean validado;
        String texto;
        do {
            texto = IO.retirarCaracteresNoNumericos(Escaner.lector.nextLine().trim().replaceAll("\\s+"," "));
            validado = Texto.validarLongitud(texto, 8, 8, "El DNI ha de tener 8 digitos sin letras. Pruebe otra vez: ");
        } while (!validado);
        return Integer.parseInt(texto);
    }

    public static void main(String args[]) {
        //Declaramos las variables
        int dni;
        StringBuilder nif = new StringBuilder();

        //Solicitamos el DNI
        dni = solicitarDNI("\nIntroduzca a continuación su DNI y le devolveré su NIF: ");
        nif.append(dni);
        //Calculamos la letra segun el DNI y cremos el NIF
        nif.append(letraSegunDNI(dni));

        System.out.printf("Tu NIF es: %s",nif);
        Escaner.dispose();
    }
}
