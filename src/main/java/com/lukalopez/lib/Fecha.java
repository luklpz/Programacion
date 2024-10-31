package com.lukalopez.lib;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Fecha {
    /**
     * Solicita una fecha escrita en formato europeo.
     *
     * @param mensaje Mensaje que se imprime para solicitar la fecha.
     * @return Es la fecha en formato europeo que se devuelve.
     */
    public static LocalDate solicitarFormatoEuropeo(String mensaje) {
        System.out.println(mensaje);
        String fechaString = Escaner.lector.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha = LocalDate.parse(fechaString, formatter);
        return fecha;
    }
}
