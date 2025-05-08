package com.lukalopez.tema10.Ejercicio4;

import java.util.Objects;

public class Television extends Electrodomestico {
    private static final int DEFAULT_PULGADAS = 20;
    private static final boolean DEFAULT_SMART_TV = false;

    private final int pulgadas;
    private final boolean smartTV;

    public Television(){
        this.pulgadas = DEFAULT_PULGADAS;
        this.smartTV = DEFAULT_SMART_TV;
    }

    public Television(int pulgadas, boolean smartTV) {
        this.pulgadas = pulgadas;
        this.smartTV = smartTV;
    }

    public Television(double precio, double peso) {
        super(precio, peso);
        this.pulgadas = DEFAULT_PULGADAS;
        this.smartTV = DEFAULT_SMART_TV;
    }

    public Television(double precioBase, Color color, char consumoEnergetico, double peso, int pulgadas, boolean smartTV) {
        super(precioBase, color, consumoEnergetico, peso);
        this.pulgadas = pulgadas;
        this.smartTV = smartTV;
    }

    public int getPulgadas() {
        return pulgadas;
    }

    public boolean isSmartTV() {
        return smartTV;
    }

    @Override
    public double precioFinal(){
        double precio = super.precioFinal();
        if (pulgadas>40){
            precio*=1.3;
        }
        if (smartTV){
            precio+=50;
        }
        return precio;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Television that = (Television) o;
        return pulgadas == that.pulgadas && smartTV == that.smartTV;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pulgadas, smartTV);
    }

    @Override
    public String toString() {
        return "\nTelevision{" +
                "\n , pulgadas=" + pulgadas +
                "\n , smartTV=" + smartTV +
                "\n , precioFinal="+ precioFinal()+
                "} " + super.toString();
    }
}
