package com.lukalopez.tema10.Ejercicio4;

import java.util.Objects;

public class Lavadora extends Electrodomestico{
    private static final int DEFAULT_CARGA = 5;
    private final int carga;

    public Lavadora(){
        this(DEFAULT_CARGA);
    }

    public Lavadora(int carga) {
        this.carga = carga;
    }

    public Lavadora(double precioBase, Color color, char consumoEnergetico, double peso, int carga) {
        super(precioBase, color, consumoEnergetico, peso);
        this.carga = carga;
    }

    public Lavadora(double precio, double peso) {
        super(precio, peso);
        this.carga = 5;
    }



    public int getCarga() {
        return carga;
    }

    @Override
    public double precioFinal(){
        double precio = super.precioFinal();
        if (carga>30){
            precio+=50;
        }
        return precio;
    }

    @Override
    public String toString() {
        return "\nLavadora{" +
                "\n , carga=" + carga +
                "\n , precioFinal="+ precioFinal()+
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Lavadora lavadora = (Lavadora) o;
        return carga == lavadora.carga;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), carga);
    }
}
