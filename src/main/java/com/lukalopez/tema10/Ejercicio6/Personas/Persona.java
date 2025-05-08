package com.lukalopez.tema10.Ejercicio6.Personas;

import java.util.Objects;

public abstract class Persona {
    private final String nombre;
    private final String primerApellido;
    private final String segundoApellido;

    public Persona(String nombre, String primerApellido, String segundoApellido) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Persona autor = (Persona) o;
        return Objects.equals(nombre, autor.nombre) && Objects.equals(primerApellido, autor.primerApellido) && Objects.equals(segundoApellido, autor.segundoApellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, primerApellido, segundoApellido);
    }

    @Override
    public String toString() {
        return primerApellido+ " " + segundoApellido + ", " + nombre;
    }
}
