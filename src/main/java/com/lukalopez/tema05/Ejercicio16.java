package com.lukalopez.tema05;


import com.lukalopez.lib.Escaner;
import com.lukalopez.lib.IO;
import com.lukalopez.lib.Texto;

public class Ejercicio16 {

    private static char letraSegunDNI(int dni){
        String s="TRWAGMYFPDXBNJZSQVHLCKE";
        return s.charAt(dni % 23);
    }

    public static void main(String args[]) {
        //Declaramos las variables
        int dni;
        String texto;
        boolean validado;
        StringBuilder nif = new StringBuilder();

        //Solicitamos el DNI
        System.out.println("\nIntroduzca a continuación su DNI y le devolveré su NIF: ");
        do {
            texto = IO.retirarCaracteresNoNumericos(Escaner.lector.nextLine().trim().replaceAll("\\s+"," "));
            validado = Texto.validarLongitud(texto, 8, 8, "El DNI ha de tener 8 digitos sin letras. Pruebe otra vez: ");
        } while (!validado);
        dni = Integer.parseInt(texto);
        nif.append(dni);
        //Calculamos la letra segun el DNI y cremos el NIF
        nif.append(letraSegunDNI(dni));

        System.out.printf("Tu NIF es: %s",nif);
        Escaner.dispose();
    }
}
