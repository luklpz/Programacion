package com.lukalopez.tema10.Ejercicio7.Estadio;

import java.util.List;
import java.util.Objects;

public class Estadio {

    private final List<Zona> zonas;

    public Estadio(List<Zona> estadio) {
        this.zonas = estadio;
    }

    public List<Zona> getZonas() {
        return zonas;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Estadio estadio1 = (Estadio) o;
        return Objects.equals(zonas, estadio1.zonas);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(zonas);
    }

    /**
     * Este mét0do es un 'toString' con tabulado.
     * @param espaciado Son los espacios en blanco que serán tabulados al inicio de cada línea.
     * @return Devuelve el 'toString' tabulado.
     */
    public String toString(int espaciado){
        StringBuilder sb = new StringBuilder(espaciado);
        sb.append(" ".repeat(Math.max(0, espaciado)));

        String espacios = sb.toString();
        sb.setLength(0);

        for (int i = 0; i < zonas.size(); i++) {
            sb.append(espacios).append("\u001B[0;36mZONA Nº").append(i+1).append("\u001B[0m\n");
            sb.append(espacios).append(zonas.get(i).toString(espaciado)).append("\n");
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        return toString(0);
    }
}
