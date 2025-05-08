package com.lukalopez.tema10.Ejercicio7.Entrada;

import com.lukalopez.tema10.Ejercicio7.Config;
import com.lukalopez.tema10.Ejercicio7.Estadio.Partido;

import java.util.Objects;

public class EntradaNormal extends Entrada{

    private final int numeroAsiento;

    public EntradaNormal(Partido partido, int indexZona, int indexFila, int indexColumna) {
        super(partido, indexZona, indexFila, indexColumna);
        this.numeroAsiento = (indexZona*Config.DEFAULT_FILAS*Config.DEFAULT_COLUMNAS) + (indexFila*Config.DEFAULT_COLUMNAS) + indexColumna+1;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EntradaNormal that = (EntradaNormal) o;
        return numeroAsiento == that.numeroAsiento;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numeroAsiento);
    }

    @Override
    public String toString() {
        return "Entrada Nº"+id+
                "\n  Numero del asiento: "+numeroAsiento+
                "\n"+super.toString(2);
    }
}
