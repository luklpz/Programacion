package com.lukalopez.tema04.Metodos;

import com.lukalopez.lib.Calc;

public class Ejercicio14 {
    private static int numeroCombinatorio(int m, int n){
        int factM = Calc.factorial(m);
        int factN = Calc.factorial(n);
        int factNmenosM = Calc.factorial(n-m);
        return factN/(factM*factNmenosM);
    }

    public static void main(String args[]){
        System.out.println(numeroCombinatorio(3,4));
    }
}
