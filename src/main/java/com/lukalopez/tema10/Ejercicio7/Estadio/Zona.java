package com.lukalopez.tema10.Ejercicio7.Estadio;

import java.util.Arrays;
import java.util.Objects;

import static com.lukalopez.tema10.Ejercicio7.Config.DEFAULT_COLUMNAS;
import static com.lukalopez.tema10.Ejercicio7.Config.DEFAULT_FILAS;

public class Zona {

    private final boolean vip;
    private final float precioBase;
    private final Asiento[][] asientosZona;

    public Zona(boolean vip, float precioBase) {
        this.vip=vip;
        this.precioBase = precioBase;
        this.asientosZona = new Asiento[DEFAULT_FILAS][DEFAULT_COLUMNAS];
        for (int i = 0; i < DEFAULT_FILAS; i++) {
            for (int j = 0; j < DEFAULT_COLUMNAS; j++) {
                asientosZona[i][j] = new Asiento();
            }
        }
    }

    public boolean isVip() {
        return vip;
    }

    public float getPrecioBase() {
        return precioBase;
    }

    /**
     * Calcular el número de asientos disponibles en esta zona.
     * @return Devuelve el número de asientos disponibles en la zona.
     */
    public int asientosDisponibles(){
        int contador=0;
        for (Asiento[] asientos : asientosZona) {
            for (Asiento asiento : asientos) {
                if (!asiento.isOcupado()) {
                    ++contador;
                }
            }
        }
        return contador;
    }

    /**
     * Mét0do para obtener el asiento que se ubica en la posición indicada.
     * @param fila Fila en la que se encuentra el asiento deseado.
     * @param columna Columna en la que se encuentra el asiento deseado.
     * @return Devuelve el asiento que se encuentra en la posición indicada.
     */
    public Asiento obtenerAsiento(int fila, int columna){
        return asientosZona[fila][columna];
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Zona zona = (Zona) o;
        return isVip() == zona.isVip() && Float.compare(getPrecioBase(), zona.getPrecioBase()) == 0 && Objects.deepEquals(asientosZona, zona.asientosZona);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isVip(), getPrecioBase(), Arrays.deepHashCode(asientosZona));
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

        sb.append(espacios).append("\u001B[0;35m ESPACIO PARA ");
        if (!vip){
            sb.append("\u001B[0;31mNO \u001B[0;35m");
        }
        sb.append("VIPS\n\u001B[0m");
        sb.append(espacios).append(" Precio base: ").append(String.format("\u001B[0;33m%.2f",precioBase)).append("€\u001B[0;0m\n");
        sb.append(espacios).append("|----").append("-".repeat(Math.max(0, DEFAULT_COLUMNAS*4))).append("-|\n");
        sb.append(espacios).append("|      ");
        for (int i = 0; i < DEFAULT_COLUMNAS-1; i++) {
            sb.append(String.format("%-4d",i+1));
        }
        sb.append(String.format("%-3d",DEFAULT_COLUMNAS)).append("|\n");

        for (int i = 0; i < DEFAULT_FILAS; i++) {
            sb.append(espacios).append("| ").append(String.format("%-3d",i+1));
            for (int j = 0; j < DEFAULT_COLUMNAS; j++) {
                sb.append("   ");
                if (asientosZona[i][j].toChar() == 'o'){
                    sb.append(String.format("\u001B[0;32m%c\u001B[0m",asientosZona[i][j].toChar()));
                } else {
                    sb.append(String.format("\u001B[0;31m%c\u001B[0m",asientosZona[i][j].toChar()));
                }
            }
            sb.append(" |\n");
        }

        sb.append(espacios).append("|----").append("-".repeat(Math.max(0, DEFAULT_COLUMNAS*4))).append("-|\n");
        return sb.toString();
    }

    @Override
    public String toString() {
        return toString(0);
    }
}
