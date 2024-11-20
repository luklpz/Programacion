package com.lukalopez.lib;

public class Random {
    public static double aleatorio(double valorMinimo, double valorMaximo){
        java.util.Random random = new java.util.Random();
        return random.nextDouble()*(valorMaximo-valorMinimo)+valorMinimo;
    }
}
