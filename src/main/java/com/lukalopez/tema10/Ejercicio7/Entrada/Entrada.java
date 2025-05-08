package com.lukalopez.tema10.Ejercicio7.Entrada;

import com.lukalopez.tema10.Ejercicio7.Estadio.Partido;

import java.time.format.DateTimeFormatter;
import java.util.Objects;

public abstract class Entrada {
    protected final int id;
    protected final Partido partido;
    protected final int indexZona;
    protected final int indexFila;
    protected final int indexColumna;

    public Entrada(Partido partido, int indexZona, int indexFila, int indexColumna) {
        this.id = ++partido.ultimaIdTicket;
        this.partido = partido;
        this.indexZona = indexZona;
        this.indexFila = indexFila;
        this.indexColumna = indexColumna;
    }

    public int getId() {
        return id;
    }

    public int getIndexZona() {
        return indexZona;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Entrada entrada = (Entrada) o;
        return getId() == entrada.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    /**
     * Este mét0do es un 'toString' con tabulado.
     * @param espaciado Son los espacios en blanco que serán tabulados al inicio de cada línea.
     * @return Devuelve el 'toString' tabulado.
     */
    public String toString(int espaciado){
        StringBuilder espacios = new StringBuilder(espaciado);
        espacios.append(" ".repeat(Math.max(0, espaciado)));

        return  espacios + "Partido [" + partido.getFechaHora().format(DateTimeFormatter.ofPattern("dd/MM/yyyy  hh:mm")) + "]: " + partido.getEquipoLocal().toString() + " vs " + partido.getEquipoVisitante().toString() + "\n" +
                espacios + "Zona: " + indexZona + "\n" +
                espacios + "Fila: " + indexFila + "\n" +
                espacios + "Columna: " + indexColumna;
    }

    @Override
    public String toString() {
        return toString(0);
    }
}
