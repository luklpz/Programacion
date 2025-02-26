package com.lukalopez.tema06.POO.Ejercicio3;

import java.time.LocalDate;

public class Alumno {


    private final String nia;
    private final String nombre;
    private final String apellidos;
    private final LocalDate fechaNacimiento;
    private final Centro.Grupo grupo;
    private final String telefono;

    public Alumno(String nia, String nombre, String apellidos, LocalDate fechaNacimiento, Centro.Grupo grupo, String telefono) {
        this.nia = nia;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.grupo = grupo;
        this.telefono = telefono;
    }

    public String getNia() {
        return nia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Centro.Grupo getGrupo() {
        return grupo;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return "Alumno:" +
                "\n  NIA = " + nia +
                "\n  Nombre = " + nombre +
                "\n  Apellidos = " + apellidos +
                "\n  Fecha de nacimiento = " + fechaNacimiento +
                "\n  Grupo = " + grupo +
                "\n  Telefono = " + telefono +
                '\n';
    }
}


