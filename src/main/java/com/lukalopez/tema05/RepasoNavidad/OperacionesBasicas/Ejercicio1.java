package com.lukalopez.tema05.RepasoNavidad.OperacionesBasicas;

import com.lukalopez.lib.Random;

public class Ejercicio1 {
    public static void main(String[] args) {
        final int a = Random.randomInt(1,100);
        final int b = Random.randomInt(1,100);
        int resultado;
        StringBuilder sb = new StringBuilder();

        //Imprimimos el valor de los números
        sb.append("Numero A: ").append(a).append("\n");
        sb.append("Numero B: ").append(b).append("\n\n");

        //Realizamos los cálculos
        resultado=a+b;
        sb.append("Suma: ").append(a).append("+").append(b).append("=").append(resultado).append("\n");
        resultado=a-b;
        sb.append("Resta: ").append(a).append("-").append(b).append("=").append(resultado).append("\n");
        resultado=a*b;
        sb.append("Multiplicación: ").append(a).append("x").append(b).append("=").append(resultado).append("\n");
        resultado=a/b;
        sb.append("División: ").append(a).append("/").append(b).append("=").append(resultado).append("\n");
        resultado=a % b;
        sb.append("Resto de la división: ").append(a).append("%").append(b).append("=").append(resultado);

        //Imprimimos el resultado
        System.out.println(sb);
    }
}
