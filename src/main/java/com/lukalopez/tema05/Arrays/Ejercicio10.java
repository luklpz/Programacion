package com.lukalopez.tema05.Arrays;

public class Ejercicio10 {
    //Escribe un programa que permita introducir un array P de 10 elementos numéricos, visualizar su
    //contenido y crear otro array S con los elementos de P que sean mayores de 10 (cuando los
    //elementos sean <=10, se pondrá un -1). Visualizar después el contenido de S

    private static int[] crearArraySuperior(int[] arrayP){
        if (arrayP==null){
            System.out.println("Array vacio.");
            return null;
        }

        int[] arrayS;
        arrayS = new int[arrayP.length];

        //Llenamos el segundo array
        for (int i=0;i<arrayP.length;i++){
            if (arrayP[i]<=10){
                arrayS[i]=-1;
            } else {
                arrayS[i]=arrayP[i];
            }
        }
        return arrayS;
    }

    public static void main(String[] args) {
        int[] arrayP;
        int[] arrayS;
        arrayP = new int[10];
        Ejercicio9.crearArray(arrayP);
        arrayS = crearArraySuperior(arrayP);
        Ejercicio9.visualizarArray(arrayS);
    }
}
