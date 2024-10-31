package com.lukalopez.tema04.Fechas;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Ejercicio2 {
    private static long calcDiasDeVida(LocalDate fechaNacimiento){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate hoy = LocalDate.now();
        hoy.format(formatter);
        ChronoUnit days = ChronoUnit.DAYS;
        return fechaNacimiento.until(hoy, days);
    }

    public static void main(String args[]){
        long edadEnDias;
        Scanner lector = new Scanner(System.in);
        System.out.println("\n¿Cuál es tu fecha de nacimiento? (dd/mm/yyyy)");
        String fechaString = lector.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNacimiento = LocalDate.parse(fechaString, formatter);
        edadEnDias = calcDiasDeVida(fechaNacimiento);
        System.out.printf("Tienes %d dias de vida.", edadEnDias);
    }
}
