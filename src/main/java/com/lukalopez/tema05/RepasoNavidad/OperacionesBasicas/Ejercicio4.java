package com.lukalopez.tema05.RepasoNavidad.OperacionesBasicas;

import com.lukalopez.lib.IO;

public class Ejercicio4 {

    private static String convertirSegundos (int numeroSegundos){
        StringBuilder sb = new StringBuilder();
        sb.append(numeroSegundos).append(" segundos son ");
        if (numeroSegundos>3599){
            sb.append(numeroSegundos/3600).append(" hora/s");
            numeroSegundos=numeroSegundos % 3600;
            if (numeroSegundos==0){
                sb.append(".");
                return sb.toString();
            } else {
                sb.append(", ");
            }
        }
        if (numeroSegundos>59) {
            sb.append(numeroSegundos/60).append(" minuto/s");
            numeroSegundos=numeroSegundos % 60;
            if (numeroSegundos==0){
                sb.append(".");
                return sb.toString();
            } else {
                sb.append(", ");
            }
        }
        sb.append(numeroSegundos).append(" segundo/s.");
        return sb.toString();
    }

    public static void main(String[] args) {
        final int numeroSegundos = IO.solicitarInt("Ingrese un número de segundos (0<x): ",0, IO.Condicion.MINIMO);

        System.out.println(convertirSegundos(numeroSegundos));
    }
}
