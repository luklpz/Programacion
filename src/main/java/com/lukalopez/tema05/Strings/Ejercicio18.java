package com.lukalopez.tema05.Strings;

import com.lukalopez.lib.Escaner;
import com.lukalopez.lib.IO;
import com.lukalopez.lib.Texto;

public class Ejercicio18 {

    /**
     * Realiza el sumatorio de los digitos de un número.
     * @param numero Número sobre el que se calcula el sumatorio.
     * @return Devuelve el resultado del sumatorio.
     */
    private static int sumatorioDeDigitos(int numero){
        if (numero<1){
            System.err.println("No se puede hacer un sumatorio de un número inferior a 1.");
            return 0;
        }
        if (numero==0){
            return 0;
        }
        String num = String.valueOf(numero);

        return Integer.parseInt(String.valueOf(num.charAt(num.length()-1)))+sumatorioDeDigitos(numero/10);
    }

    //Hacerlo funcionar con un SB
    private static boolean validarFecha(StringBuilder fecha){
        if (fecha.charAt(2)=='-'&&fecha.charAt(5)=='-'&& Texto.retirarCaracteresNoNumericos(fecha.toString()).length()==8){
            return true;
        }
        System.err.println("La fecha introducida no es válida o está en un formato inválido.");
        return false;
    }

    public static void main(String args[]) {
        //Definimos las variables.
        StringBuilder fecha = new StringBuilder();
        boolean validacion;
        int numero;

        //Solicitamos la fecha y la validamos teniendo en cuenta que ha de ser un 'String'.
        do {
            fecha.setLength(0);
            System.out.println("En este programa calcularemos su número de la suerte.\nIntroduzca su fecha de nacimimento: (dd-mm-yyyy)");
            fecha.append(Escaner.lector.nextLine().replaceAll("\\s+",""));
            validacion = validarFecha(fecha);
        } while (!validacion);

        //Calculamos el número de la suerte
        numero = Integer.parseInt(Texto.retirarCaracteresNoNumericos(fecha.toString()));
        while (String.valueOf(numero).length()!=1){
            numero = sumatorioDeDigitos(numero);
        }

        System.out.printf("\nTu número de la suerte es: %d",numero);
    }
}
