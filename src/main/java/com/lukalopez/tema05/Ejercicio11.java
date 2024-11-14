package com.lukalopez.tema05;

import com.lukalopez.lib.Escaner;

public class Ejercicio11 {

    public static void main(String args[]){
        //Declaramos las variables
        String nombre, primerApellido, segundoApellido, nombreCompleto;

        //Solicitamos las cadenas de texto
        System.out.println("¿Cuál es tu nombre?");
        nombre = Escaner.lector.nextLine();
        System.out.println("\n¿Cuál es tu primer apellido?");
        primerApellido = Escaner.lector.nextLine();
        System.out.println("\n¿Cuál es tu segundo apellido?");
        segundoApellido = Escaner.lector.nextLine();

        //Creamos el 'String' del nombre completo
        StringBuilder sb = new StringBuilder();
        sb.append(nombre).append(" ").append(primerApellido).append(" ").append(segundoApellido);
        nombreCompleto = sb.toString().replaceAll("\\s+"," ").trim();

        //Imprimimos lo solicitado
        System.out.printf("Tu nombre completo es: %s\n",nombreCompleto);
        if (nombreCompleto.length()>4) {
            System.out.printf("\nLos cinco primeros caracteres de tu nombre completo: %s\n", nombreCompleto.substring(0, 5));
        }
        if (nombreCompleto.length()>1) {
            System.out.printf("\nLos dos últimos caracteres de tu nombre completo: %s\n", nombreCompleto.substring(nombreCompleto.length()-4,nombreCompleto.length()-1));
        }
        //El d y el e no se que significan

        //Arreglamos el texto y lo imprimimos
        System.out.printf("\n*** %s ***\n", nombreCompleto);
        sb.replace(0,sb.length(),nombreCompleto).reverse();
        System.out.printf("\nCadena invertida: %s\n", sb.reverse());
        Escaner.dispose();
        }
}
