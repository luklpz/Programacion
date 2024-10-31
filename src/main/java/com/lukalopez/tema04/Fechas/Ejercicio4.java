package com.lukalopez.tema04.Fechas;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.util.Arrays;

public class Ejercicio4 {
    public enum Signos {
        Acuario,Piscis,Aries,Tauro,Geminis,Cancer,Leo,Virgo,Libra,Escorpio,Ofiuco,Sagitario,Capricornio;
    }

    public static Signos calcZodiaco(LocalDate fechaNacimiento){
        MonthDay diaDelMesNacimiento = MonthDay.of(fechaNacimiento.getMonth(),fechaNacimiento.getDayOfMonth());
        if (diaDelMesNacimiento>MonthDay.of())
    }
}
