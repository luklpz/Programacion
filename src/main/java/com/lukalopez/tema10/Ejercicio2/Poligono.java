package com.lukalopez.tema10.Ejercicio2;

import com.lukalopez.tema10.Ejercicio1.Punto;

import java.util.ArrayList;

public class Poligono {
    private final ArrayList<Punto> puntos;

    public Poligono(ArrayList<Punto> puntos) {
        this.puntos = puntos;
    }

    public void traslada(double x, double y){
        for (Punto aux : puntos){
            aux.setX(aux.getX()+x);
            aux.setY(aux.getY()+y);
        }
    }

    public int numVertices(){
        return puntos.size();
    }

    @Override
    public String toString() {
        return "Poligono{" +
                "puntos=" + puntos +
                '}';
    }

    public double perimetro(){
        double perimetro=0;
        Punto aux = puntos.getLast();
        for (Punto punto : puntos){
            perimetro+=punto.distancia(aux);
            aux=punto;
        }
        return perimetro;
    }

    public static void main(String[] args) {
        Punto punto1 = new Punto(0,0);
        Punto punto2 = new Punto(2,0);
        Punto punto3 = new Punto(2,2);
        Punto punto4 = new Punto(0,2);

        ArrayList<Punto> puntos = new ArrayList<>(4);
        puntos.add(punto1);
        puntos.add(punto2);
        puntos.add(punto3);
        puntos.add(punto4);

        Poligono poligono = new Poligono(puntos);

        System.out.println("Numero de vértices: " + poligono.numVertices());
        System.out.println("Perimetro: " + poligono.perimetro());
        poligono.traslada(4,-3);
        System.out.println("\nNumero de vértices: " + poligono.numVertices());
        System.out.println("Perimetro: " + poligono.perimetro());
    }
}
