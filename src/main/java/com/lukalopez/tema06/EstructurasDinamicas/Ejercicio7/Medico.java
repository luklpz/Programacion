package com.lukalopez.tema06.EstructurasDinamicas.Ejercicio7;

public class Medico {
    private final String numeroColegiado;
    private final String nombre;
    private final String apellidos;

    public Medico(String numeroColegiado, String nombre, String apellidos) {
        this.numeroColegiado = numeroColegiado;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return "colegiado nº" + numeroColegiado + "; " + apellidos + ", " + nombre;
    }
}
