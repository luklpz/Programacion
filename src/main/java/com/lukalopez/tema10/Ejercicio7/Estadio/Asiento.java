package com.lukalopez.tema10.Ejercicio7.Estadio;

import java.util.Objects;

public class Asiento {
    private boolean ocupado;

    public Asiento() {
        this.ocupado = false;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Asiento asiento = (Asiento) o;
        return ocupado == asiento.ocupado;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ocupado);
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public char toChar() {
        if (ocupado){
            return 'x';
        }
        return 'o';
    }
}
