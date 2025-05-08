package com.lukalopez.tema10.Ejercicio4;

import com.lukalopez.lib.Random;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Electrodomestico> miLista = new ArrayList<>(10);

        //Variables necesarias
        Electrodomestico electrodomestico;
        int aux;
        double precioRandom;
        Electrodomestico.Color color;
        int letraRandom;
        char consumoEnergetico;
        double peso;


        //Sumatorios
        double precioTotal=0;
        double precioTeles=0;
        double precioLavadoras=0;

        //Lo llenamos de electrodomesticos
        for (int i = 0; i < 10; i++) {
            precioRandom = Random.randomDouble(10,300);
            color = Electrodomestico.Color.values()[Random.randomInt(0, Electrodomestico.Color.values().length-1)];
            letraRandom = 65+Random.randomInt(0,5);
            consumoEnergetico = (char) letraRandom;
            peso = Random.randomDouble(20,250);


            aux = Random.randomInt(0,2);

            if (aux == 0){
                //Es lavadora
                int carga = Random.randomInt(5,100);
                electrodomestico = new Lavadora(precioRandom,color,consumoEnergetico,peso,carga);
                precioLavadoras+=electrodomestico.precioFinal();

            } else {
                //Es tele
                int pulgadas = Random.randomInt(8,140);
                int random;
                boolean smartTV= Random.randomInt(0, 1) == 0;
                electrodomestico = new Television(precioRandom,color,consumoEnergetico,peso,pulgadas,smartTV);
                precioTeles +=electrodomestico.precioFinal();
            }

            miLista.add(electrodomestico);
            precioTotal+=electrodomestico.precioFinal();
        }

        for (Electrodomestico value : miLista) {
            System.out.println(value.toString());
        }

        System.out.println("\n\nPrecio total de los electrodomesticos: " + precioTotal);
        System.out.println("Precio teles: " + precioTeles);
        System.out.println("Precio lavadoras: " + precioLavadoras);
    }
}
