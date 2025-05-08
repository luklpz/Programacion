package com.lukalopez.tema10.Ejercicio7;

import java.util.Objects;

public class Equipo {
    private static int lastId = 0;
    private final int id;
    private final String nombre;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.id = ++lastId;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Equipo equipo = (Equipo) o;
        return Objects.equals(nombre, equipo.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombre);
    }

    @Override
    public String toString() {
        return nombre + " Nº"+ id;
    }
}
