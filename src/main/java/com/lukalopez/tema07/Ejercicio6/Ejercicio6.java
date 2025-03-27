package com.lukalopez.tema07.Ejercicio6;

public class Ejercicio6 {
    public static void dividirEntreArray(int dividendo, int[] divisores){
        for (int divisor : divisores) {
            try {
                System.out.printf("%d / %d = %d\n", dividendo, divisor, dividendo / divisor);
            } catch (ArithmeticException ae) {
                System.out.printf("No se puede dividir %d entre %d.\n", dividendo, divisor);
            }
        }
    }

    public static void main(String[] args) {
        dividirEntreArray(2, new int[] {-2,-1,0,1,2});
    }
}
