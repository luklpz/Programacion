package com.lukalopez.lib;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class FH {
    /**
     * Solicita una fecha escrita en formato DMY.
     *
     * @param mensaje Mensaje que se imprime para solicitar la fecha.
     * @return Es el 'LocalDate' que contiene la fecha en formato DMY que se devuelve.
     */
    public static LocalDate solicitarFechaDMY(String mensaje) {
        System.out.println(mensaje);
        String fechaString = Escaner.lector.nextLine();
        return LocalDate.parse(fechaString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    /**
     * Solicita una hora escrita en formato HmS.
     *
     * @param mensaje Mensaje que se imprime para solicitar la hora.
     * @return Es el 'LocalTime' que contiene la hora en formato HmS que devuelve.
     */
    public static LocalTime solicitarHoraHmS(String mensaje) {
        System.out.println(mensaje);
        String horaString = Escaner.lector.nextLine();
        return LocalTime.parse(horaString, DateTimeFormatter.ofPattern("hh:mm:ss"));
    }

    /**
     * Solicita una fecha y una hora escritas en formato DMY HmS.
     *
     * @param mensaje Mensaje que se imprime para solicitar la fecha y la hora.
     * @return Es el 'LocalDateTime' que contiene la fecha y la hora en formato DMY HmS.
     */
    public static LocalDateTime solicitarFechaHoraDMSHmS(String mensaje) {
        System.out.println(mensaje);
        String fechaHoraString = Escaner.lector.nextLine();
        return LocalDateTime.parse(fechaHoraString, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    /**
     * Recibe una fecha y una hora y las formatea en formato DMY HmS.
     *
     * @param fechaHora Fecha y hora que recibe en cualquier formato.
     * @return Devuelve un String de 'fechaHora' en formato DMY HmS.
     */
    public static String formatearFechaHoraDMSHmS(LocalDateTime fechaHora){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return fechaHora.format(formatter);
    }
}
