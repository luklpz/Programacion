package com.lukalopez.tema10.Ejercicio6.Multimedia;

import com.lukalopez.tema10.Ejercicio6.Personas.Actor;
import com.lukalopez.tema10.Ejercicio6.Personas.Persona;
import com.lukalopez.tema10.Ejercicio6.DataBase.Formato;

import java.time.Year;

public class Pelicula extends Multimedia{
    private int segundosDuracion;
    private Actor actorPrincipal;
    private Actor actrizPrincipal;

    public Pelicula(String titulo, Persona autor, Formato formato, Year year, int segundosDuracion, Actor actorPrincipal, Actor actrizPrincipal) {
        super(titulo, autor, formato, year);
        this.segundosDuracion = segundosDuracion;
        this.actorPrincipal = actorPrincipal;
        this.actrizPrincipal = actrizPrincipal;
    }

    @Override
    public double precioFinal() {
        double modificador=0;
        if (getYear().isBefore(Year.of(2012))){
            modificador=-1;
        }
        return modificador + super.precioFinal();
    }

    public Pelicula(String titulo, Persona autor, Formato formato, Year year) {
        super(titulo, autor, formato, year);
    }

    public int getSegundosDuracion() {
        return segundosDuracion;
    }

    public void setSegundosDuracion(int segundosDuracion) {
        this.segundosDuracion = segundosDuracion;
    }

    public Actor getActorPrincipal() {
        return actorPrincipal;
    }

    public void setActorPrincipal(Actor actorPrincipal) {
        this.actorPrincipal = actorPrincipal;
    }

    public Actor getActrizPrincipal() {
        return actrizPrincipal;
    }

    public void setActrizPrincipal(Actor actrizPrincipal) {
        this.actrizPrincipal = actrizPrincipal;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "segundosDuracion=" + segundosDuracion +
                ", actorPrincipal=" + actorPrincipal +
                ", actrizPrincipal=" + actrizPrincipal +
                "} " + super.toString();
    }
}
