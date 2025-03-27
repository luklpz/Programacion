package com.lukalopez.tema07.Ejercicio2;

import com.lukalopez.lib.Escaner;
import com.lukalopez.lib.Excepciones.InvalidEmptyException;

public class Ejercicio2 {

    public static double[] solicitarArrayDouble(final int CANTIDAD_DOUBLES){
        //Definimos las variables
        int contadorExcepciones = 0;
        String entrada;
        boolean valido;
        double numero=0;
        double[] almacen = new double[CANTIDAD_DOUBLES];

        for (int j = 0; j < CANTIDAD_DOUBLES; j++) {
            valido=false;
            do {
                try {
                    //Solicitamos el número
                    System.out.printf("Intoduce el %dº número: ", j+1);
                    entrada = Escaner.lector.nextLine().trim();

                    if (entrada.isEmpty()) {
                        throw new InvalidEmptyException("No se puede introducir una entrada vacía.");
                    }

                    numero = Double.parseDouble(entrada);
                    valido = true;
                } catch (InvalidEmptyException nee){
                    System.out.println(nee.getMessage());
                }catch (NumberFormatException nfe) {
                    System.out.println("Solo se aceptan números.");
                }
            } while (!valido);
            almacen[j]=numero;
        }

        System.out.printf("Se han producido %d excepciones.\n",contadorExcepciones);
        return almacen;
    }

    public static double maxDouble(double[] array) throws ArrayIndexOutOfBoundsException{
        double max = array[0];
        double aux;
        for (int i = 1; i < array.length; i++) {
            aux= array[i];
            if (aux>max){
                max=aux;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxDouble(solicitarArrayDouble(10)));
    }
}
