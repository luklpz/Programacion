package com.lukalopez.tema05.RepasoNavidad.OperacionesBasicas;

import com.lukalopez.lib.Random;

public class Ejercicio2 {
    public static void main(String[] args) {
        final double a = Random.randomDouble(1,100);
        final double b = Random.randomDouble(1,100);
        double resultado;
        StringBuilder sb = new StringBuilder();
        String numA = String.format("%.2f",a);
        String numB = String.format("%.2f",b);


        //Imprimimos el valor de los números
        sb.append("Numero A: ").append(numA).append("\n");
        sb.append("Numero B: ").append(numB).append("\n\n");

        //Realizamos los cálculos
        resultado=a+b;

        sb.append("Suma: ").append(numA).append(" + ").append(numB).append(" = ").append(String.format("%.2f",resultado)).append("\n");
        resultado=a-b;
        sb.append("Resta: ").append(numA).append(" - ").append(numB).append(" = ").append(String.format("%.2f",resultado)).append("\n");
        resultado=a*b;
        sb.append("Multiplicación: ").append(numA).append(" x ").append(numB).append(" = ").append(String.format("%.2f",resultado)).append("\n");
        resultado=a/b;
        sb.append("División: ").append(numA).append(" / ").append(numB).append(" = ").append(String.format("%.2f",resultado)).append("\n");
        resultado=a % b;
        sb.append("Resto de la división: ").append(numA).append(" % ").append(numB).append(" = ").append(String.format("%.2f",resultado));

        //Imprimimos el resultado
        System.out.print(sb);

    }
}
