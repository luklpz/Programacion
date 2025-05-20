package com.lukalopez.tema10.Comparador;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

public class Alumno implements Serializable {
    private final String nia;
    private final String nombre;
    private final String apellido;
    private final String password;


    public static class ComparatorNia implements Comparator<Alumno>{

        @Override
        public int compare(Alumno o1, Alumno o2) throws NumberFormatException{
            int nia1 = Integer.valueOf(o1.nia);
            int nia2 = Integer.valueOf(o2.nia);
            return nia1-nia2;
        }
    }

    public static class ComparatorApellidos implements Comparator<Alumno>{

        @Override
        public int compare(Alumno o1, Alumno o2) {
            return o1.apellido.compareTo(o2.apellido);
        }
    }

    public Alumno(String nia, String nombre, String apellido, String password) {
        this.nia = nia;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return Objects.equals(nia, alumno.nia) && Objects.equals(nombre, alumno.nombre) && Objects.equals(apellido, alumno.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nia, nombre, apellido);
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nia='" + nia + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
