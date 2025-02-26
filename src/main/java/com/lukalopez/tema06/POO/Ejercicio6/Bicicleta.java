package com.lukalopez.tema06.POO.Ejercicio6;

import java.time.LocalDate;

public class Bicicleta {

    enum Marca{
        MARCA1,MARCA2,MARCA3
    }

    private int referencia;
    private Marca marca;
    private String modelo;
    private double peso;
    private double tamanyoRueda;
    private boolean motor;
    private LocalDate fechaFabricacion;
    private double precio;
    private int numeroExistencias;

    public Bicicleta(int referencia, Marca marca, String modelo, double peso, double tamanyoRueda, boolean motor, LocalDate fechaFabricacion, double precio, int numeroExistencias) {
        this.referencia = referencia;
        this.marca = marca;
        this.modelo = modelo;
        this.peso = peso;
        this.tamanyoRueda = tamanyoRueda;
        this.motor = motor;
        this.fechaFabricacion = fechaFabricacion;
        this.precio = precio;
        this.numeroExistencias = numeroExistencias;
    }
}
