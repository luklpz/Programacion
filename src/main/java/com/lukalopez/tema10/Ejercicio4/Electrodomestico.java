package com.lukalopez.tema10.Ejercicio4;

import java.util.Objects;

public class Electrodomestico {
    public enum Color{
        BLANCO("blanco"), NEGRO("negro"), ROJO("rojo"), AZUL("azul"), GRIS("gris");

        private final String color;

        Color(String color){
            this.color = color;
        }

        public String getColor() {
            return color;
        }
    }
    public enum Consumo{
        A('A'), B('B'), C('C'), D('D'), E('E'), F('F');

        private final char letter;

        Consumo(char letter){
            this.letter = letter;
        }

        public char getLetter() {
            return letter;
        }
    }
    private final double precioBase;
    private final Color color;
    private final Consumo consumoEnergetico;
    private final double peso;

    public Electrodomestico(double precioBase, Color color, Consumo consumoEnergetico, double peso) {
        this.precioBase = precioBase;
        this.color = color;
        this.consumoEnergetico = consumoEnergetico;
        this.peso = peso;
    }

    public Electrodomestico(double precio, double peso){
        this(precio,Color.BLANCO, Consumo.F,peso);
    }

    public Electrodomestico(){
        this(100,Color.BLANCO, Consumo.F,5);
    }

    public

    public double getPrecioBase() {
        return precioBase;
    }

    public Color getColor() {
        return color;
    }

    public Consumo getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public double getPeso() {
        return peso;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Electrodomestico that = (Electrodomestico) o;
        return Double.compare(precioBase, that.precioBase) == 0 && Double.compare(peso, that.peso) == 0 && color == that.color && consumoEnergetico == that.consumoEnergetico;
    }

    @Override
    public int hashCode() {
        return Objects.hash(precioBase, color, consumoEnergetico, peso);
    }

    @Override
    public String toString() {
        return "Electrodomestico{" +
                "precioBase=" + precioBase +
                ", color=" + color +
                ", consumoEnergetico=" + consumoEnergetico +
                ", peso=" + peso +
                '}';
    }
}
