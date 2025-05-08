package com.lukalopez.tema10.Ejercicio6.Personas;

import com.lukalopez.tema10.Ejercicio6.MinorAgeException;

import java.time.LocalDate;
import java.util.NoSuchElementException;

public class Socio extends Persona {
    private final String nif;
    private final LocalDate fechaNacimiento;
    private final String poblacion;

    public Socio(String nombre, String primerApellido, String segundoApellido, String nif, LocalDate fechaNacimiento, String poblacion) throws MinorAgeException {
        super(nombre, primerApellido, segundoApellido);
        if (esMayorEdad(fechaNacimiento)){
            throw new MinorAgeException("El socio no puede ser menor de edad.");
        }
        this.nif = nif;
        this.fechaNacimiento = fechaNacimiento;
        this.poblacion = poblacion;
    }

    private static boolean esMayorEdad(LocalDate fecha){
        return LocalDate.now().isAfter(fecha.plusYears(18));
    }
}
