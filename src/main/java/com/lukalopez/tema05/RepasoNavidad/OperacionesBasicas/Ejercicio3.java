package com.lukalopez.tema05.RepasoNavidad.OperacionesBasicas;

import com.lukalopez.lib.IO;

public class Ejercicio3 {
    public static void main(String[] args) {
        //Solicitamos variables
        double precioArticulo = IO.solicitarDouble("Ingrese el precio del artículo (0<x): ", 0, IO.Condicion.MINIMO, "El precio ha de ser superior a 0 y ser un número real.");
        double porcentajeDescuento = IO.solicitarDouble("Ingrese el descuento aplicable (0-100): ", 0, 100, "El descuento ha de estar entre 0 y 100");

        //Realizamos el cálculo e imprimimos el resultado
        System.out.printf("Precio final: %.2f",precioArticulo*porcentajeDescuento/100);
    }
}
