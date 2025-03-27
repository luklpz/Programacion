package com.lukalopez.tema07.Ejercicio1;

import com.lukalopez.lib.Escaner;
import com.lukalopez.lib.Excepciones.InvalidEmptyException;

import java.util.ArrayList;

public class Ejercicio1 {

    /**
     * Mét0do para solicitar un 'Double'.
     * @param mensaje Mensaje de solicitud.
     * @return Devuelve el 'int' en caso de que sea válido.
     * @throws NumberFormatException Excepción en caso de que la entrada no sea un número.
     */
    public static double solicitarDouble(String mensaje){
        //Definimos las variables
        String entrada;
        boolean valido=false;
        double numero=0;
        do {
            try {
                //Solicitamos el número
                System.out.print(mensaje);
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
        return numero;
    }

    /**
     * Mét0do para solicitar un array de 'Double', la solicitud se detiene al introducir un número negativo.
     * @param mensaje Mensaje de solicitud.
     * @return Devuelve un array de 'Double' validado.
     */
    public static Double[] solicitarDoubles(String mensaje) throws ClassCastException{
        ArrayList<Double> almacen = new ArrayList<>();
        double num=0;
        System.out.println(mensaje);
        int contador=1;
        do {
            if (num>=0){
                almacen.add(num);
            }
        } while (num<=0);
        //Diferencia entre Double y double
        return (Double[]) almacen.toArray();
    }

    public static void main(String[] args) {
        System.out.println(solicitarDouble("Introduzca un double: "));
    }
}
