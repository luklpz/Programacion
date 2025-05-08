package com.lukalopez.tema10.Ejercicio4;

import java.util.Objects;

public abstract class Electrodomestico {
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
        A('A',100), B('B',80), C('C',60), D('D',50), E('E',30), F('F',10);

        private final char letter;
        private final double incrementoDePrecio;

        Consumo(char letter, double incrementoDePrecio){
            this.letter = letter;
            this.incrementoDePrecio = incrementoDePrecio;
        }

        public char getLetter() {
            return letter;
        }

        public double getIncrementoDePrecio() {
            return incrementoDePrecio;
        }
    }

    private final double precioBase;
    private final Color color;
    private final Consumo consumoEnergetico;
    private final double peso;

    public Electrodomestico(double precioBase, Color color, char consumoEnergetico, double peso) {
        this.precioBase = precioBase;
        this.color = color;
        this.consumoEnergetico = comprobarConsumoEnergetico(consumoEnergetico);
        this.peso = peso;
    }

    public Electrodomestico(double precio, double peso){
        this(precio,Color.BLANCO, 'F',peso);
    }

    public Electrodomestico(){
        this(100,Color.BLANCO, 'F',5);
    }

    /**
     * Mét0do para comprobar si la letra indicada para el consumo energético es correcta.
     *  TIPOS DE CONSUMO: A <-> F
     * @param letra Es la letra que se desea convertir a tipo de consumo.
     *
     * @return Devuelve el tipo de consumo según la letra, en caso de que se haya
     * introducido una letra incorrecta se devolverá el 'Consumo' por defecto (Consumo.F).
     */
    public Consumo comprobarConsumoEnergetico(char letra){
        Consumo consumo = Consumo.F;
        letra = Character.toUpperCase(letra);
        for (int i = 0; i < Consumo.values().length; i++) {
            if (letra==Consumo.values()[i].getLetter()){
                consumo = Consumo.values()[i];
            }
        }
        return consumo;
    }

    /**
     * Mét0do para comprobar si el color indicado es correcto.
     *  COLORES:
     *      - Blanco
     *      - Negro
     *      - Rojo
     *      - Azul
     *      - Gris
     * @param color Es el color que se desea convertir a 'Color'.
     *
     * @return Devuelve el 'Color', en caso de que se haya introducido
     * un color incorrecto se devolverá el 'Color' por defento (Color.BLANCO).
     */
    public Color comprobarColor(String color){
        Color defaultColor = Color.BLANCO;
        color = color.toLowerCase();
        for (int i = 0; i < Color.values().length; i++) {
            if (color.equals(Color.values()[i].getColor())){
                defaultColor = Color.values()[i];
            }
        }
        return defaultColor;
    }

    /**
     * Calcula el precio final del electrodoméstico según su peso y su tipo de consumo energético.
     * @return Devuelve el precio final del electrodoméstico, devuelve '-1' en caso de que su peso sea 0 o negativo.
     */
    protected double precioFinal(){
        double sumatorio = precioBase+consumoEnergetico.getIncrementoDePrecio();
        double incremento;
        if (peso<=0){
            return -1;
        } else if (peso<20) {
            incremento = 10;
        } else if (peso<50) {
            incremento = 50;
        } else if (peso<80) {
            incremento = 80;
        } else {
            incremento = 100;
        }
        return sumatorio+incremento;
    }

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
        return "\n      Electrodomestico{" +
                "\n     precioBase=" + precioBase +
                "\n     , color=" + color +
                "\n     , consumoEnergetico=" + consumoEnergetico +
                "\n     , peso=" + peso +
                '}';
    }
}
