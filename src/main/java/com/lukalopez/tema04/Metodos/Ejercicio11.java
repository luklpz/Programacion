package com.lukalopez.tema04.Metodos;

public class Ejercicio11 {
    private static int randomInt(int min, int max){
        int resultado=(int) (Math.random() *max)+min;
        return resultado;
    }

    private static String quiniela(String mensaje){
        String resultado=mensaje+"\n";
        for (int i=1;i<16;i++){
            int x = randomInt(0,3);
            if (x==0){
                resultado+="Partido"+i+"    X"+"\n";
            }
            else {
                resultado += "Partido" + i + "    " + x + "\n";
            }
        }
        return resultado;
    }

    public static void main(String args[]){
        String partido;
        partido = quiniela("*** Madrid x Barça ***");
        System.out.println(partido);
    }
}
