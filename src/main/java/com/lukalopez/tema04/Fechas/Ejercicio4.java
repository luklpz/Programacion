package com.lukalopez.tema04.Fechas;

import com.lukalopez.lib.Escaner;
import com.lukalopez.lib.FH;

import java.time.LocalDate;
import java.time.MonthDay;

public class Ejercicio4 {
    public enum Signos {
        Acuario,Piscis,Aries,Tauro,Geminis,Cancer,Leo,Virgo,Libra,Escorpio,Ofiuco,Sagitario,Capricornio;
    }

    /**
     * Calcular cuál es tu signo del zodiaco en función de tu fecha de nacimiento.
     *
     * @param fechaNacimiento Es el 'LocalDate' que recibe en formato europeo como fecha de nacimiento.
     * @return Devuelve un valor del enumerado 'Signos' como el zodiaco de la fecha de nacimiento.
     */
    public static Signos calcZodiaco(LocalDate fechaNacimiento){
        MonthDay diaDelMesNacimiento = MonthDay.of(fechaNacimiento.getMonth(),fechaNacimiento.getDayOfMonth());
        if (diaDelMesNacimiento.isBefore(MonthDay.of(3,12))&&diaDelMesNacimiento.isAfter(MonthDay.of(2,17))){
            return Signos.Acuario;
        } else if (diaDelMesNacimiento.isBefore(MonthDay.of(4,17))&&diaDelMesNacimiento.isAfter(MonthDay.of(3,11))) {
            return Signos.Piscis;
        } else if (diaDelMesNacimiento.isBefore(MonthDay.of(5,15))&&diaDelMesNacimiento.isAfter(MonthDay.of(4,16))) {
            return Signos.Aries;
        } else if (diaDelMesNacimiento.isBefore(MonthDay.of(6,22))&&diaDelMesNacimiento.isAfter(MonthDay.of(5,14))) {
            return Signos.Tauro;
        } else if (diaDelMesNacimiento.isBefore(MonthDay.of(7,20))&&diaDelMesNacimiento.isAfter(MonthDay.of(6,21))) {
            return Signos.Geminis;
        } else if (diaDelMesNacimiento.isBefore(MonthDay.of(8,11))&&diaDelMesNacimiento.isAfter(MonthDay.of(7,19))) {
            return Signos.Cancer;
        } else if (diaDelMesNacimiento.isBefore(MonthDay.of(9,17))&&diaDelMesNacimiento.isAfter(MonthDay.of(8,10))) {
            return Signos.Leo;
        } else if (diaDelMesNacimiento.isBefore(MonthDay.of(10,31))&&diaDelMesNacimiento.isAfter(MonthDay.of(9,16))) {
            return Signos.Virgo;
        } else if (diaDelMesNacimiento.isBefore(MonthDay.of(11,23))&&diaDelMesNacimiento.isAfter(MonthDay.of(10,30))) {
            return Signos.Libra;
        } else if (diaDelMesNacimiento.isBefore(MonthDay.of(11,29))&&diaDelMesNacimiento.isAfter(MonthDay.of(11,22))) {
            return Signos.Escorpio;
        } else if (diaDelMesNacimiento.isBefore(MonthDay.of(12,18))&&diaDelMesNacimiento.isAfter(MonthDay.of(11,28))) {
            return Signos.Ofiuco;
        } else if ((diaDelMesNacimiento.isBefore(MonthDay.of(12,32))&&diaDelMesNacimiento.isAfter(MonthDay.of(12,17)))||(diaDelMesNacimiento.isBefore(MonthDay.of(1,21))&&diaDelMesNacimiento.isAfter(MonthDay.of(1,0)))) {
            return Signos.Sagitario;
        } else {
            return Signos.Capricornio;
        }
    }

    public static void main(String args[]){
        LocalDate fechaNacimiento;
        fechaNacimiento = FH.solicitarFechaDMY("¿Cuál es tu fecha de nacimiento? (dd/mm/yyyy)");
        Signos signo = calcZodiaco(fechaNacimiento);
        System.out.printf("Tu signo del zodiaco es %s.",signo);
        Escaner.dispose();
    }

}
