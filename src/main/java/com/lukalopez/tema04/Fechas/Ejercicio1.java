package com.lukalopez.tema04.Fechas;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Ejercicio1 {
    /**
     * Recibe la fecha de nacimiento del usuario y devuelve su edad
     *
     * @param fechaNacimiento Fecha que se recibe, corresponde a una fecha de nacimiento.
     * @return Devuelve la edad del usuario en función de su fecha de nacimiento.
     */
    private static int calcEdad(LocalDate fechaNacimiento){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate hoy = LocalDate.now();
        hoy.format(formatter);
        Period periodo = Period.between(fechaNacimiento,hoy);
        return periodo.getYears();
    }

    public static void main(String args[]){
        int edad;
        Scanner lector = new Scanner(System.in);
        System.out.println("\n¿Cuál es tu fecha de nacimiento? (dd/mm/yyyy)");
        String fechaString = lector.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNacimiento = LocalDate.parse(fechaString, formatter);
        edad = calcEdad(fechaNacimiento);
        System.out.printf("Tienes %d años.", edad);
    }
}
