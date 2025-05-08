package com.lukalopez.tema10.Ejercicio6.Multimedia;

import com.lukalopez.tema10.Ejercicio6.DataBase.Formato;
import com.lukalopez.tema10.Ejercicio6.DataBase.Plataforma;
import com.lukalopez.tema10.Ejercicio6.Personas.Persona;

import java.time.Year;

public class Videojuego extends Multimedia{
    private final Plataforma plataforma;

    public Videojuego(String titulo, Persona autor, Formato formato, Year year, Plataforma plataforma) {
        super(titulo, autor, formato, year);
        this.plataforma = plataforma;
    }

    @Override
    public double precioFinal() {
        int modificador = 0;
        if (getYear().isBefore(Year.of(2010))){
            modificador = -1;
        }
        return modificador + super.precioFinal();
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }

    @Override
    public String toString() {
        return "Videojuego{" +
                "plataforma=" + plataforma +
                "} " + super.toString();
    }
}
