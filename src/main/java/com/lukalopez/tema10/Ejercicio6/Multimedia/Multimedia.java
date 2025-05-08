package com.lukalopez.tema10.Ejercicio6.Multimedia;

import com.lukalopez.tema10.Ejercicio6.DataBase.Formato;
import com.lukalopez.tema10.Ejercicio6.Personas.Persona;

import java.time.Year;
import java.util.Objects;

public abstract class Multimedia {

    protected static final double precioBase = 4;

    private String titulo;
    private Persona autor;
    private Formato formato;
    private Year year;

    public Multimedia(String titulo, Persona autor, Formato formato, Year year ) {
        this.titulo = titulo;
        this.autor = autor;
        this.formato = formato;
        this.year = year;
    }

    public double precioFinal(){
        return precioBase;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Persona getAutor() {
        return autor;
    }

    public void setAutor(Persona autor) {
        this.autor = autor;
    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Multimedia that = (Multimedia) o;
        return Objects.equals(titulo, that.titulo) && Objects.equals(autor, that.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, autor, formato, year);
    }

    @Override
    public String toString() {
        return "Multimedia{" +
                "titulo='" + titulo + '\'' +
                ", autor=" + autor +
                ", formato=" + formato +
                ", year=" + year +
                '}';
    }
}
