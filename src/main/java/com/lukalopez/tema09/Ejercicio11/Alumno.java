package com.lukalopez.tema09.Ejercicio11;

import com.lukalopez.tema09.Ejercicio11.Grupos.Grupo;

import java.util.List;
import java.util.Objects;

public class Alumno {
    private static int ultimoId = 0;
    private final int id;
    private final String nombre;
    private final String apellidos;
    private final Grupo grupo;
    private final List<Asignatura> asignaturasCursadas;

    public Alumno(String nombre, String apellidos, Grupo grupo, List<Asignatura> asignaturasCursadas) {
        this.id=++ultimoId;
        this.nombre = nombre;
        this.apellidos = apellidos;

        this.grupo = grupo;
        this.asignaturasCursadas = asignaturasCursadas;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public List<Asignatura> getAsignaturasCursadas() {
        return asignaturasCursadas;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return id == alumno.id && Objects.equals(nombre, alumno.nombre) && Objects.equals(apellidos, alumno.apellidos) && Objects.equals(grupo, alumno.grupo) && Objects.equals(asignaturasCursadas, alumno.asignaturasCursadas);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    /**
     * Hacer un toString dejado un espacio tabulado.
     * @param tabulado Número de espacios que conforman el tabulado.
     * @return Devuelve el 'String' listo para imprimir.
     */
    public String toString(int tabulado){
        StringBuilder espacios = new StringBuilder(tabulado);
        //Me lo ha hecho intelliJ:
        espacios.append(" ".repeat(Math.max(0, tabulado)));

        return nombre + ", " + apellidos + "\n" +
                espacios + "  Identificador: " + id + "\n" +
                espacios + "  Profesor: " + grupo.toString(tabulado) + "\n";
    }

    @Override
    public String toString() {
        return toString(0);
    }
}
