package com.lukalopez.tema06.EstructurasDinamicas.Ejercicio7_2;

import java.time.LocalDate;

public class Paciente {

    private final int sip;
    private final String nombre;
    private final String primerApellido;
    private final String segundoApellido;
    private final LocalDate fechaNacimiento;
    private final Sexo sexo;

    public Paciente(int sip, String nombre, String primerApellido, String segundoApellido, LocalDate fechaNacimiento, Sexo sexo) {
        this.sip = sip;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
    }

    public int getSip() {
        return sip;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "sip=" + sip +
                ", nombre='" + nombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", sexo=" + sexo +
                '}';
    }
}
