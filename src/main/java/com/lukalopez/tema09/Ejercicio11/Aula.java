package com.lukalopez.tema09.Ejercicio11;

import java.util.Objects;

public class Aula {
    private static int ultimoId=0;
    private final int id;
    private final float ancho;
    private final float largo;
    private final float area;

    public Aula(float ancho, float largo) {
        this.id = ++ultimoId;
        this.ancho = ancho;
        this.largo = largo;
        this.area = ancho*largo;
    }

    public int getId() {
        return id;
    }

    public float getAncho() {
        return ancho;
    }

    public float getLargo() {
        return largo;
    }

    public float getArea() {
        return area;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Aula aula = (Aula) o;
        return id == aula.id && Float.compare(area, aula.area) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, area);
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

        return espacios + "Identificador: " + id +  "\n" +
                espacios + "  Area: " + area + "\n";

    }

    @Override
    public String toString() {
        return toString(0);
    }
}
