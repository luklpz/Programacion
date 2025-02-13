package com.lukalopez.tema06.EstructurasDinamicas.Ejercicio7;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Paciente {
    private final String sip;
    private final String nombre;
    private final String apellidos;
    private final LocalDateTime fechaHoraIngreso;

    public Paciente(String sip, String nombre, String apellidos, LocalDateTime fechaHoraIngreso) {
        this.sip = sip;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaHoraIngreso = fechaHoraIngreso;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return  "    Paciente: " + apellidos + ", " + nombre + "\n    SIP: " + sip +
                "; " + "\n    Fecha: " + fechaHoraIngreso.format(formatter) + "\n\n";
    }
}
