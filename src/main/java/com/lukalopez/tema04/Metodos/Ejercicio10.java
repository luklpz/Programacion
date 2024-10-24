package com.lukalopez.tema04.Metodos;

import java.util.Scanner;

public class Ejercicio10 {

    private static Scanner lector = new Scanner(System.in);

    public static void dispose(){
        lector.close();
    }

    /**
     * Imprime un mensaje 'mensaje' y solicita un número 'num' para crear su tabla de multiplicar, el programa se detiene al introducir un número negativo.
     *
     * @param mensaje Es el 'String' que se muestra para solicitar el introducir un número.
     * @return Devuelve un 'String' que contiene la/s tabla/s de multiplicar.
     * @author luklpz
     */
    private static String tablaMultiplicar(String mensaje){
        String resultado="";
        int num;
        System.out.println(mensaje);
        num = Integer.parseInt(lector.nextLine());
        do {
            resultado+="*** TABLA DEL "+num+" ***\n";
            for (int i=1;i!=11;i++){
                resultado+=num+" * "+i+" = "+num*i+"\n";
            }
            resultado+="\n\n";
            System.out.println(mensaje);
            num = Integer.parseInt(lector.nextLine());
        } while (num>-1);
        return resultado;
    }

    public static void main(String args[]){
        String tablas = tablaMultiplicar("Introduce un números y al introducir un número negativo devolveremos sus respectivas tablas de multiplicar.");
        System.out.print(tablas);
        Ejercicio10.dispose();
    }
}
