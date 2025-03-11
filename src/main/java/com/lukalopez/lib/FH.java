package com.lukalopez.lib;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class FH {

//******************************** SOLICITAR DATOS ********************************\\

    /**
     * Solicita una fecha escrita en el formato indicado.
     *
     * @param mensajeIncial Mensaje que se imprime antes de solicitar la fecha.
     * @return Es el 'LocalDate' que contiene la fecha en el formato indicado.
     */
    public static LocalDate solicitarFecha(String mensajeIncial) {
        System.out.print(mensajeIncial);
        String fecha = String.format("%02d/%02d/%d",solicitarDia(), solicitarMes(), solicitarAnyo());
        System.out.println();
        return LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    /**
     * Solicita una hora escrita en el formato indicado.
     *
     * @param mensajeIncial Mensaje que se imprime antes de solicitar la hora.
     * @return Es el 'LocalTime' que contiene la hora en el formato indicado.
     */
    public static LocalTime solicitarHora(String mensajeIncial) {
        System.out.print(mensajeIncial);
        String fecha = String.format("%02d:%02d:%02d",solicitarSegundos(), solicitarMinutos(), solicitarHoras());
        System.out.println();
        return LocalTime.parse(fecha, DateTimeFormatter.ofPattern("ss:mm:hh"));
    }

    /**
     * Solicita una fecha y una hora escritas en el formato indicado.
     *
     * @param mensajeIncial Mensaje que se imprime para solicitar la fecha y la hora.
     * @return Es el 'LocalDateTime' que contiene la fecha y la hora en el formato indicado.
     */
    public static LocalDateTime solicitarFechaHora(String mensajeIncial) {
        System.out.print(mensajeIncial);
        String fecha = String.format("%02d/%02d/%d %02d:%02d:%02d",solicitarDia(),solicitarMes(),solicitarAnyo(),solicitarSegundos(), solicitarMinutos(), solicitarHoras());
        System.out.println();
        return LocalDateTime.parse(fecha, DateTimeFormatter.ofPattern("ss:mm:hh"));
    }


//******************************** FORMATEAR DATOS ********************************\\

    /**
     * Recibe una fecha y la formatea en el formato indicado.
     *
     * @param fecha Fecha que recibe en cualquier formato.
     * @param formato Formato en que se desea devolver la fecha.
     * @return Devuelve un String de 'fecha' en el formato indicado.
     */
    public static String formatearFecha(LocalDate fecha,String formato){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);
        return fecha.format(formatter);
    }

    /**
     * Recibe una hora y la formatea en el formato indicado.
     *
     * @param hora Fecha que recibe en cualquier formato.
     * @param formato Formato en que se desea devolver la hora.
     * @return Devuelve un String de 'hora' en el formato indicado.
     */
    public static String formatearHora(LocalTime hora,String formato){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);
        return hora.format(formatter);
    }

    /**
     * Recibe una fecha y una hora y las formatea en el formato indicado.
     *
     * @param fechaHora Fecha y hora que recibe en cualquier formato.
     * @param formato Formato en que se desea devolver la fecha y la hora.
     * @return Devuelve un String de 'fechaHora' en el formato indicado.
     */
    public static String formatearFechaHora(LocalDateTime fechaHora,String formato){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);
        return fechaHora.format(formatter);
    }



//******************************** SOLICITUD DATOS ********************************\\

    /**
     * Mét0do para solicitar segundos.
     * @return Número de segundos validados.
     */
    private static int solicitarSegundos(){
        return IO.solicitarInt("Introduzca los segundos: ",0,60,Error.FUERA_DE_RANGO.toString());
    }

    /**
     * Mét0do para solicitar minutos.
     * @return Número de minutos validados.
     */
    private static int solicitarMinutos(){
        return IO.solicitarInt("Introduzca los minutos: ",0,60,Error.FUERA_DE_RANGO.toString());
    }

    /**
     * Mét0do para solicitar horas.
     * @return Número de horas validados.
     */
    private static int solicitarHoras(){
        return IO.solicitarInt("Introduzca las horas: ",0,24,Error.FUERA_DE_RANGO.toString());
    }

    /**
     * Mét0do para solicitar dias.
     * @return Número de dias validados.
     */
    private static int solicitarDia(){
        return IO.solicitarInt("Introduzca el dia: ",1,30,Error.FUERA_DE_RANGO.toString());
    }

    /**
     * Mét0do para solicitar meses.
     * @return Número de meses validados.
     */
    private static int solicitarMes(){
        return IO.solicitarInt("Introduzca el mes: ",1,12,Error.FUERA_DE_RANGO.toString());
    }

    /**
     * Mét0do para solicitar un año.
     * @return Numero del año validado.
     */
    private static int solicitarAnyo(){
        return IO.solicitarInt("Introduzca el año: ",Error.VALOR_INMANEJABLE.toString());
    }
}
