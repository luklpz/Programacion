package com.lukalopez.tema09.Ejercicio11;

import java.util.Objects;

public class Profesor {
    private final String dni;
    private final String nombre;
    private final String apellidos;
    private final double sueldo;

    public Profesor(String dni, String nombre, String apellidos, double sueldo){
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sueldo = sueldo;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public double getSueldo() {
        return sueldo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Profesor profesor = (Profesor) o;
        return Objects.equals(dni, profesor.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dni);
    }

    /**
     * Hacer un toString dejado un espacio tabulado.
     * @param tabulado Número de espacios que conforman el tabulado.
     * @return Devuelve el 'String' listo para imprimir.
     */
    public String toString(int tabulado){
        StringBuilder espacios = new StringBuilder(tabulado);
        //Me lo ha hecho intelliJ:
        espacios.append(" ".repeat(Math.max(0, tabulado)));

        return espacios + dni + "\n" +
                espacios + "  Nombre: " + nombre + ", " + apellidos +  "\n";

    }

    @Override
    public String toString() {
        return toString(0);
    }
}
