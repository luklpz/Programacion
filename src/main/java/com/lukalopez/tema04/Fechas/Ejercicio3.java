package com.lukalopez.tema04.Fechas;

import com.lukalopez.lib.FH;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Ejercicio3 {
    public enum Planeta{
        MERCURIO, VENUS, LATIERRA, MARTE, JUPITER, SATURNO, URANO, NEPTUNO;
    }

    /**
     * Programa para calcular tu edad según el planeta de referencia.
     *
     * @param fechaNacimiento Es la fecha de nacimiento sobre la que se calculará la edad.
     * @param planeta Planeta sobre el que se tendrá en cuenta el tiempo de su orbita.
     * @return Devuelve un 'int' como edad del usuario en el planeta seleccionado.
     */
    private static int calcEdadSegunPlaneta(LocalDate fechaNacimiento, Planeta planeta){
        float tiempoOrbita, dias;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate hoy = LocalDate.now();
        hoy.format(formatter);
        tiempoOrbita = switch (planeta) {
            case MERCURIO -> 87.9f;
            case VENUS -> 224.7f;
            case LATIERRA -> 365.25f;
            case MARTE -> 687f;
            case JUPITER ->4333f;
            case SATURNO -> 10759f;
            case URANO -> 30668f;
            case NEPTUNO -> 60182f;
        };
        dias = (float) fechaNacimiento.until(hoy,ChronoUnit.DAYS);
        return (int)(dias/tiempoOrbita);
    }

    /**
     * Imprime un mensaje que se imprime para devolver el menú planetas.
     * @param mensaje Mensaje que se imprime al devolver el menú planetas.
     * @return Devuelve un 'String' que contiene el menú.
     */
    private static String menuPlanetas(String mensaje){
        System.out.print(mensaje);
        return "\n\n *** MENU PLANETAS ***\n 1.- Mercurio\n 2.- Venus\n 3.- La Tierra\n 4.- Marte\n 5.- Júpiter\n 6.- Saturno\n 7.- Urano\n 8.- Neptuno\n*********************\n";
    }

    public static void main(String args[]){
        Scanner lector = new Scanner(System.in);
        int planeta,edad;
        System.out.println(menuPlanetas(""));
        do {
            System.out.println("Introduce el planeta en el que deseas calcular tu edad:");
            planeta = Integer.parseInt(lector.nextLine())-1;
            if (planeta<0||planeta>7){
                System.out.println("Opción no valida, pruebe otra vez: ");
            }
        } while (planeta<0||planeta>7);
        Planeta planetaSeleccionado = Planeta.values()[planeta];
        LocalDate fechaNacimiento = FH.solicitarFecha("¿Cual es su fecha de nacimiento? (dd/mm/yyyy)","dd/MM/yyyy");
        edad = calcEdadSegunPlaneta(fechaNacimiento,planetaSeleccionado);
        System.out.printf("Tienes %d años.",edad);
    }
}
