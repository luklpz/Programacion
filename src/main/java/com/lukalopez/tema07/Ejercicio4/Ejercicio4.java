package com.lukalopez.tema07.Ejercicio4;

import com.lukalopez.lib.Array;
import com.lukalopez.lib.Escaner;
import com.lukalopez.tema07.Ejercicio1.NumberEmptyException;

public class Ejercicio4 {

    public static int[] rellenarArray(int[] array){
        boolean valido;
        int contador = 0;
        String entrada;
        int numero;
        try {
            do {
                do {
                    valido=false;
                    try {
                        System.out.printf("Intoduce el %dº número: ", contador+1);
                        entrada = Escaner.lector.nextLine().trim();

                        if (entrada.isEmpty()) {
                            throw new NumberEmptyException("No se puede introducir una entrada vacía.");
                        }
                        numero = Integer.parseInt(entrada);
                        array[contador]=numero;
                        valido=true;
                        contador++;
                    } catch(NumberEmptyException nee){
                        System.out.println(nee.getMessage());
                    } catch (NumberFormatException nfe) {
                        System.out.println("Solo se aceptan números.");
                    }
                } while (!valido);
            } while (true);
        } catch (NullPointerException npe) {
            System.out.println("ERROR: El array no ha sido creado.");
        }catch (ArrayIndexOutOfBoundsException aobe) {
            System.out.printf("Se han llenado todas las posiciones del array. Número de posiciones: %d\n", contador);
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = null;
        System.out.println(Array.arrayToString(rellenarArray(array)));
    }
}
