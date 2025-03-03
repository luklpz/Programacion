package com.lukalopez.tema06.EstructurasDinamicas.Ejercicio7;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Paciente {
    enum Sexo{
        HOMBRE, MUJER
    }

    public Sexo crearSexo(int num){
        switch (num){
            case 0 -> {
                return Sexo.HOMBRE;
            }
            case 1 -> {
                return Sexo.MUJER;
            }
        }
        return null;
    }

    private final String sip;
    private final String nombre;
    private final String apellidos;
    private final Sexo sexo;
    private final LocalDateTime fechaHoraIngreso;
    private final String Sintomatologia;

    public Paciente(String sip, String nombre, String apellidos, Sexo sexo, LocalDateTime fechaHoraIngreso, String sintomatologia) {
        this.sip = sip;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.fechaHoraIngreso = fechaHoraIngreso;
        this.Sintomatologia = sintomatologia;
    }

    public String getSip() {
        return sip;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public LocalDateTime getFechaHoraIngreso() {
        return fechaHoraIngreso;
    }

    public String getSintomatologia() {
        return Sintomatologia;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return  "    SIP: " + sip +
                "\n    Paciente: " + apellidos + ", " + nombre +
                "\n    Sexo: " + sexo +
                "\n    Fecha: " + fechaHoraIngreso.format(formatter) +
                "\n    Sintomatologia:\n" + Sintomatologia +"\n\n";
    }
}
