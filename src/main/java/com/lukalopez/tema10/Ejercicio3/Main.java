package com.lukalopez.tema10.Ejercicio3;

import com.lukalopez.lib.IO;

public class Main {
    public static void main(String[] args) {
        Coche coche;
        int[] numeroMarchas = {15,30,50,70,90,120};
        String matricula = IO.solicitarString("Ingrese la matrícula del coche: ");
        boolean automatico = IO.solicitarBoolean("¿Es el coche automático? (Si/No)","Si","No","Error");

        if (automatico){
            coche = new CocheCambioAutomatico(numeroMarchas,matricula);
        } else {
            coche = new CocheCambioManual(numeroMarchas, matricula);
            coche.cambiarMarcha(3);
        }
        System.out.println("\nDatos del coche recien creado:");
        System.out.println("Matrícula: " + coche.getMatricula());
        System.out.println("Velocidad actual: " + coche.getVelocidadActual());
        System.out.println("Marcha actual: " + coche.getMarchaActual());
        coche.acelerar(60);
        System.out.println("\nDatos del coche tras acelerar:");
        System.out.println("Matrícula: " + coche.getMatricula());
        System.out.println("Velocidad actual: " + coche.getVelocidadActual());
        System.out.println("Marcha actual: " + coche.getMarchaActual());
    }
}
