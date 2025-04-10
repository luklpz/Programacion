package com.lukalopez.tema09.Ejercicio11;

public class Asignatura {
    private static int ultimoId=0;
    private final int id;
    private final String nombre;
    private final Profesor profesor;

    public Asignatura(String nombre, Profesor profesor) {
        this.id = ++ultimoId;
        this.nombre = nombre;
        this.profesor = profesor;
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
                espacios + "  Profesor: " + profesor.toString(tabulado) + "\n";
    }

    @Override
    public String toString() {
        return toString(0);
    }
}
