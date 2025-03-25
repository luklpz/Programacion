package com.lukalopez.tema07.Ejercicio3;

import com.lukalopez.lib.Escaner;
import com.lukalopez.tema07.Ejercicio1.NumberEmptyException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Ejercicio3 {

    public static double solicitarDoubleHastaLetra(String mensaje) throws NumberLetterException{
        //Definimos las variables
        String entrada=null;
        boolean esLetra=false;
        boolean valido=false;
        double numero=0;
        char charAux;

        do {
            try {
                //Solicitamos el número
                System.out.print(mensaje);
                entrada = Escaner.lector.nextLine().trim();

                if (entrada.isEmpty()) {
                    throw new NumberEmptyException("No se puede introducir una entrada vacía.");
                }

                numero = Double.parseDouble(entrada);
                valido = true;
            } catch (NumberEmptyException nee){
                System.out.println(nee.getMessage());

            }catch (NumberFormatException nfe) {
                //Comprobamos si es una letra
                for (int i = 0; i < Objects.requireNonNull(entrada).length(); i++) {
                    charAux = entrada.charAt(i);
                    if (Character.isLetter(charAux)){
                        esLetra=true;
                        //Para que salga del bucle
                        break;
                    }
                }

                if (esLetra){
                    throw new NumberLetterException("Se ha introducido una letra, finalizando recogida de datos.");
                } else {
                    System.out.println("Solo se aceptan números.");
                }
            }
        } while (!valido);
        return numero;
    }

    public static double[] solicitarDoubles(String mensaje) {
        //Declaramos las variables
        double[] respuesta;
        int tamanoArrayList;
        ArrayList<Double> almacen = new ArrayList<>();
        int contador=1;
        boolean arrayVacio=true;

        System.out.println(mensaje);
        do {
            try {
                do {
                    //Solicitamos los números
                    almacen.add(solicitarDoubleHastaLetra(String.format("Ingrese el %dºnumero: ", contador)));
                    arrayVacio=false;
                    ++contador;
                } while (true);

            } catch (NumberLetterException nfe) {
                //Si no han introducido números
                if (arrayVacio){
                    System.out.println("No se han introducido números. Reiniciando la recogida de datos.\n");
                } else {
                    System.out.println(nfe.getMessage());
                }
            }
        } while (almacen.isEmpty());

        //Diferencia entre Double y double

        tamanoArrayList= almacen.size();
        respuesta = new double[tamanoArrayList];
        for (int i = 0; i < tamanoArrayList; i++) {
            respuesta[i]= (double) almacen.toArray()[i];
        }
        return respuesta;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solicitarDoubles("Ingresa los números: ")));
    }
}
