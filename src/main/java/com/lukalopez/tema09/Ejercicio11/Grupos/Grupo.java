package com.lukalopez.tema09.Ejercicio11.Grupos;

import com.lukalopez.tema09.Ejercicio11.Asignatura;
import com.lukalopez.tema09.Ejercicio11.Aula;

import java.util.ArrayList;
import java.util.Objects;

public class Grupo {
    private static int ultimoId=0;
    private final int id;
    private final Grado grado;
    private final Curso curso;
    private final String nombre;
    private final int plazas;
    private final Aula aulaPrincipal;

    public Grupo(Grado grado, Curso curso, int plazas, Aula aulaPrincipal) {
        this.id = ++ultimoId;
        this.grado = grado;
        this.curso = curso;
        this.nombre = curso.toString() + " de " + grado.toString();
        this.plazas = plazas;
        this.aulaPrincipal = aulaPrincipal;
    }

    public int getId() {
        return id;
    }

    public Grado getGrado() {
        return grado;
    }

    public Curso getCurso() {
        return curso;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPlazas() {
        return plazas;
    }

    public Aula getAulaPrincipal() {
        return aulaPrincipal;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Grupo grupo = (Grupo) o;
        return id == grupo.id && plazas == grupo.plazas && grado == grupo.grado && curso == grupo.curso && Objects.equals(aulaPrincipal, grupo.aulaPrincipal);
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

        return espacios + nombre + "\n" +
                espacios + "  Identificador: " + id + "\n" +
                espacios + "  Plazas designadas: " + plazas + "\n" +
                espacios + "  Aula: " + aulaPrincipal + "\n";
    }

    @Override
    public String toString() {
        return toString(0);
    }
}
