package com.lukalopez.tema04.Fechas;

import com.lukalopez.lib.Escaner;
import com.lukalopez.lib.FH;
import com.lukalopez.lib.IO;
import java.time.LocalDateTime;

public class Ejercicio5 {

    public static void main(String args[]){
        //Definimos variables
        LocalDateTime fechaHoraSalida,fechaHoraLlegada;
        float velocidadNave;
        final int segundosTrayecto;
        final int distanciaTierraMarteKm =225000000;
        int dias, horas, minutos, segundos;

        //Explicación del programa y solicitar datos
        System.out.println("En este programa  calcularemos la fecha y la hora estimada de llegada a Marte en función de\nuna fecha y hora de salida desde la Tierra y una velocidad constante de la nave espacial.\n");
        fechaHoraSalida= FH.solicitarFechaHoraDMSHmS("Para ello, introduzca a continuación la fecha y hora de salida: (dd/MM/yyyy hh:mm:ss)");
        velocidadNave = IO.solicitarFloat("\nSeguidamente, introduzca la velocidad de la nave en Km/h:",0.001f,1079999999.999f);

        //Cálculo de resultados
        segundosTrayecto=(int)(3600*((distanciaTierraMarteKm/velocidadNave)));
        dias = segundosTrayecto/86400;
        horas = (segundosTrayecto-dias*86400)/3600;
        minutos = (segundosTrayecto-dias*86400-horas*3600)/60;
        segundos = (segundosTrayecto-dias*86400-horas*3600-minutos*60);
        fechaHoraLlegada = fechaHoraSalida.plusSeconds(segundosTrayecto);
        String llegada = FH.formatearFechaHoraDMSHmS(fechaHoraLlegada);

        //Imprimimos resultados
        System.out.printf("\nEl tiempo total del viaje es de: %d días, %d horas, %d minutos, %d segundos.\n",dias,horas,minutos,segundos);
        System.out.printf("La fecha de llegada estimada es: %s\n", llegada);

        //Cerramos el escaner
        Escaner.dispose();
    }
}
