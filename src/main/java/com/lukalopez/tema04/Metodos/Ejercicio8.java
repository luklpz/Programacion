package com.lukalopez.tema04.Metodos;

public class Ejercicio8 {
    /**
     * Solicita cuatro 'int' y comprueba si la secuencia de números es capicua.
     *
     * @param n1 Primer número.
     * @param n2 Segundo número.
     * @param n3 Tercer número.
     * @param n4 Cuarto número.
     * @return Devuelve 'true' si la secuencia es capicua, o 'false' en su defecto.
     * @author luklpz-
     */
    private static boolean capicuo(int n1, int n2, int n3, int n4){
        String numero = ""+n1+n2+n3+n4;
        String izq = "";
        String der = "";
        int lngNum = numero.length();
        for (int i=0;i!=lngNum/2;i++){
            izq+=numero.charAt(i);
            der+=numero.charAt(lngNum-i-1);
        }
        boolean resultado = false;
        if (izq.equals(der)){
            resultado=true;
        }
        else {
            resultado=false;
        }
        return resultado;
    }

    public static void main(String args[]){
    boolean capNum =capicuo(133,212,2123,31);
        System.out.println(capNum);
    }
}
