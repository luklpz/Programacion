package com.lukalopez.tema10.Ejercicio3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public abstract class Coche {
    private final String matricula;
    private double velocidadActual;
    private int marchaActual;
    private final int[] numeroMarchas;

    public Coche(int[] numeroMarchas, String matricula) {
        this.numeroMarchas = numeroMarchas;
        this.matricula = matricula;
        this.velocidadActual=0;
        this.marchaActual=0;
    }

    /**
     * Mét0do para aumentar la velocidad del vehículo.
     * @param
     */
    public void acelerar(double velocidad){
        velocidadActual+=velocidad;
    }

    /**
     * Mét0do para reducir la velocidad del vehículo.
     * @param velocidad
     */
    public void frenar(double velocidad){
        velocidadActual+=velocidad;
    }

    /**
     * Mét0do para modificar la marcha actual del vehículo.
     * @param marcha
     */
    protected void cambiarMarcha(int marcha){
        marchaActual=marcha;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getVelocidadActual() {
        return velocidadActual;
    }

    public void setVelocidadActual(double velocidadActual) {
        this.velocidadActual = velocidadActual;
    }

    public int getMarchaActual() {
        return marchaActual;
    }

    public void setMarchaActual(int marchaActual) {
        this.marchaActual = marchaActual;
    }

    public int[] getNumeroMarchas() {
        return numeroMarchas;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Coche coche = (Coche) o;
        return Double.compare(velocidadActual, coche.velocidadActual) == 0 && marchaActual == coche.marchaActual && Objects.equals(matricula, coche.matricula) && Objects.deepEquals(numeroMarchas, coche.numeroMarchas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula, velocidadActual, marchaActual, Arrays.hashCode(numeroMarchas));
    }

    @Override
    public String toString() {
        return "Coche{" +
                "matricula='" + matricula + '\'' +
                ", velocidadActual=" + velocidadActual +
                ", marchaActual=" + marchaActual +
                ", numeroMarchas=" + Arrays.toString(numeroMarchas) +
                '}';
    }
}
