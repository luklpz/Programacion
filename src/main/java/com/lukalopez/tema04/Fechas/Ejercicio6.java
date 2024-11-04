package com.lukalopez.tema04.Fechas;

import com.lukalopez.lib.FH;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Timer;
import java.util.TimerTask;

public class Ejercicio6 {

    /**
     * Calcula la diferencia de tiempo entre dos fechas.
     *
     * @param fecha1 Primera fecha que recibe como 'LocalDateTime'.
     * @param fecha2 Segunda fecha que recibe como 'LocalDateTime'.
     * @return Devuelve un 'LocalDateTime' que retiene el tiempo que separa las dos fechas.
     */
    private static LocalDateTime calcDiferenciaEntreLDT(LocalDateTime fecha1, LocalDateTime fecha2){
        if (fecha1.isBefore(fecha2)){
            fecha2 = fecha2.minusYears(fecha1.getYear());
            fecha2 = fecha2.minusMonths(fecha1.getMonthValue());
            fecha2 = fecha2.minusDays(fecha1.getDayOfMonth());
            fecha2 = fecha2.minusMinutes(fecha1.getHour());
            fecha2 = fecha2.minusSeconds(fecha1.getSecond());
            return fecha2;
        }
        else {
            fecha1 = fecha1.minusYears(fecha2.getYear());
            fecha1 = fecha1.minusMonths(fecha2.getMonthValue());
            fecha1 = fecha1.minusDays(fecha2.getDayOfMonth());
            fecha1 = fecha1.minusMinutes(fecha2.getHour());
            fecha1 = fecha1.minusSeconds(fecha2.getSecond());
            return fecha1;
        }
    }

    public static void main(String args[]){
        Timer reloj = new Timer();
        reloj.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                int anyo;
                //Establecemos los valores
                LocalDateTime fechaHoraActual, fechaHoraAnyoNuevo, diferenciaFechas;

                fechaHoraActual = LocalDateTime.now();
                anyo = fechaHoraActual.getYear();
                fechaHoraAnyoNuevo = LocalDateTime.of(anyo, Month.DECEMBER,31,23,59,59);
                diferenciaFechas = calcDiferenciaEntreLDT(fechaHoraActual,fechaHoraAnyoNuevo);
                String fechaHoraActualString = FH.formatearFechaHoraDMSHmS(fechaHoraActual);

                //Imprimimos las horas
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.printf("%s\nRestante para año nuevo: %d meses, %d días, %d horas, %d minutos y %d segundos.\n",fechaHoraActualString, diferenciaFechas.getMonthValue(), diferenciaFechas.getDayOfMonth(),diferenciaFechas.getHour(), diferenciaFechas.getMinute(), diferenciaFechas.getSecond());
            }
        }, 0, 1000);
    }
}
