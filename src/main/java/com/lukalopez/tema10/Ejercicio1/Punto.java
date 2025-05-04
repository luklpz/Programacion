package com.lukalopez.tema10.Ejercicio1;

import java.util.Objects;

public class Punto {
    private double x;
    private double y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Punto() {
        new Punto(0,0);
    }

    public double distancia(Punto punto){
        final double DX = Math.abs(this.x-punto.x);
        final double DY = Math.abs(this.y-punto.y);
        return Math.sqrt(DX*DX+DY*DY);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Punto punto = (Punto) o;
        return Double.compare(x, punto.x) == 0 && Double.compare(y, punto.y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Punto{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
