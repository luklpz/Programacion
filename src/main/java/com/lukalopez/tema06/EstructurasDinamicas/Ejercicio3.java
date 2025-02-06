package com.lukalopez.tema06.EstructurasDinamicas;
import com.lukalopez.lib.Escaner;
import com.lukalopez.lib.EstructurasDinamicas.Pila;
import com.lukalopez.lib.Texto;

import java.io.File;
import java.io.FileNotFoundException;

public class Ejercicio3 {

    private static final Pila pilaCajas = new Pila();


//    /**
//     * Verifica si el caracter se encuentra en el 'String'.
//     *
//     * @param caracter Es el caracter a validar.
//     * @return Devuelve 'true' si el caracter se encuentra en el 'String'.
//     */
//    public static boolean validarPresencia(char caracter, String cajas){
//        return (cajas.indexOf(caracter)>=0);
//    }


    private static boolean validarCorchetes(final String texto){

        char caracter, aux;

        for (int i = 0; i < texto.length(); i++) {
            caracter = texto.charAt(i);

            //Verificamos si el caracter es una caja de opertura
            if (Texto.validarPresencia(caracter, "{[(")){
                pilaCajas.push(caracter);

            } else if (Texto.validarPresencia(caracter, ")]}")) {
                aux = (char) pilaCajas.pop();
                switch (caracter){
                    case ')' -> {
                        if (!(aux == '(')){
                            return false;
                        }
                    }
                    case ']' -> {
                        if (!(aux == '[')){
                            return false;
                        }
                    }
                    case '}' -> {
                        if (!(aux == '{')){
                            return false;
                        }
                    }
                    default -> {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws FileNotFoundException {
        //Definimos las variables
        final File ARCHIVO = new File("C:\\Users\\lukal\\Desktop\\FP_DAM\\Programacion\\src\\main\\java\\com\\lukalopez\\tema06\\EstructurasDinamicas\\Ejercicio3Texto.txt");
        final String TEXTO = Escaner.leerArchivo(ARCHIVO);
        final boolean resultado;

        //Validamos el texto
        resultado= validarCorchetes(TEXTO);
        System.out.printf("\nValidando el texto:\n\u001b[36m%s\u001b[0m\n",TEXTO);

        if (resultado){
            System.out.println("\u001b[1;32mEl texto está libre de errores.\u001b[0m");
        } else {
            System.out.println("\u001b[1;31mSe han encontrado errores en el texto.\u001b[0m");
        }
    }
}
