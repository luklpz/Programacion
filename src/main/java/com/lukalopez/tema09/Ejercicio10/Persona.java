package com.lukalopez.tema09.Ejercicio10;

import com.lukalopez.lib.FH;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Persona {
    private final String nombre;
    private final String apellidos;
    private final LocalDate fechaNacimiento;

    public Persona(String nombre, String apellidos, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Calcula la edad actual de la persona.
     * @return Devuelve la edad actual de la persona.
     */
    public int getEdad(){
        return Period.between(this.fechaNacimiento, LocalDate.now()).getYears();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(nombre, persona.nombre) && Objects.equals(apellidos, persona.apellidos) && Objects.equals(fechaNacimiento, persona.fechaNacimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellidos, fechaNacimiento);
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

    @Override
    public String toString() {
        return nombre + ", " + apellidos + " - Fecha de nacimiento: " + FH.formatearFecha(fechaNacimiento,"dd/MM/yyyy");
    }
}
