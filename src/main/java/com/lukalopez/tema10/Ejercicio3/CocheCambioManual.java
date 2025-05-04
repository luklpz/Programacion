package com.lukalopez.tema10.Ejercicio3;

public class CocheCambioManual extends Coche {

    public CocheCambioManual(int[] numeroMarchas, String matricula) {
        super(numeroMarchas, matricula);
    }

    @Override
    public void cambiarMarcha(int marcha) {
        if (marcha<0){
            System.out.println("No se puede poner una marcha negativa.");
        } else {
            super.cambiarMarcha(marcha);
        }
    }
}
