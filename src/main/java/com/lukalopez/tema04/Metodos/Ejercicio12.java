package com.lukalopez.tema04.Metodos;

import com.lukalopez.lib.Calc;

public class Ejercicio12 {
    /**
     * Solicita una calificación 'n' comprendida desde el 0 hasta el 10 y la clasifica según su equivalente alfabético.
     *
     * @param n Calificación comprendida desde el 0 hasta el 10.
     * @return Devuelve el equivalente alfabético de la calificación 'n'.
     * @author luklpz
     */
    private static String calificar(int n){
        String calificacion="";
        switch (n){
            case 0,1,2,3,4:
                calificacion="INSUFICIENTE";
                break;
            case 5:
                calificacion="SUFICIENTE";
                break;
            case 6:
                calificacion="BIEN";
                break;
            case 7,8:
                calificacion="NOTABLE";
                break;
            case 9,10:
                calificacion="EXCELENTE";
                break;
            default:
                return null;
        }
        return calificacion;
    }

    public static void main(String args[]){
        for (int i=1;i!=51;i++){
            System.out.printf("Alumno %d: %s\n",i,calificar(Calc.randomInt(0,10)));
        }
    }
}
