package com.lukalopez.tema10.Ejercicio7;

import com.lukalopez.lib.Random;
import com.lukalopez.tema10.Ejercicio7.Entrada.Entrada;
import com.lukalopez.tema10.Ejercicio7.Entrada.EntradaNormal;
import com.lukalopez.tema10.Ejercicio7.Entrada.EntradaVip;
import com.lukalopez.tema10.Ejercicio7.Estadio.Asiento;
import com.lukalopez.tema10.Ejercicio7.Estadio.Estadio;
import com.lukalopez.tema10.Ejercicio7.Estadio.Partido;
import com.lukalopez.tema10.Ejercicio7.Estadio.Zona;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DataGenerator {

    public static Estadio inicializarEstadio(){
        List<Zona> estadio = new ArrayList<>();
        Zona zona;

        //Zona vip 1
        zona = new Zona(true,Config.PRECIO_ZONA_VIP_1);
        estadio.add(zona);

        //Zona normal 1
        zona = new Zona(false,Config.PRECIO_ZONA_NORMAL_1);
        estadio.add(zona);

        //Zona normal 2
        zona = new Zona(false,Config.PRECIO_ZONA_NORMAL_2);
        estadio.add(zona);

        //Zona normal 3
        zona = new Zona(false,Config.PRECIO_ZONA_NORMAL_3);
        estadio.add(zona);

        //Zona normal 4
        zona = new Zona(false,Config.PRECIO_ZONA_NORMAL_4);
        estadio.add(zona);

        return new Estadio(estadio);
    }

    public static void anyadirDatosIniciales(){
        DataBase.equipos.add(new Equipo("Valencia"));
        DataBase.equipos.add(new Equipo("Betis"));
        DataBase.equipos.add(new Equipo("Madrid"));
        DataBase.equipos.add(new Equipo("Barça"));
        DataBase.registroPartidos.add(new Partido(Partido.Afluencia.BAJA, LocalDateTime.of(2025,8,11,14, 0),DataBase.equipos.get(0),DataBase.equipos.get(1)));
        DataBase.registroPartidos.add(new Partido(Partido.Afluencia.ALTA, LocalDateTime.of(2025,6,21,16,30),DataBase.equipos.get(2),DataBase.equipos.get(3)));

        int indexZona;
        int indexFila;
        int indexColumna;
        boolean valido=false;
        Asiento asiento;
        Partido partido;
        List<Zona> zonas;
        Entrada entrada;
        for (int i = 0; i < 2; i++) {
            partido = DataBase.registroPartidos.get(i);
            zonas = partido.getEstadio().getZonas();
            for (int j = 0; j < 750; j++) {
                do {
                    indexZona= Random.randomInt(0,4);
                    indexFila = Random.randomInt(0,Config.DEFAULT_FILAS-1);
                    indexColumna = Random.randomInt(0,Config.DEFAULT_COLUMNAS-1);
                    asiento = zonas.get(indexZona).obtenerAsiento(indexFila,indexColumna);

                    if (!asiento.isOcupado()){
                        asiento.setOcupado(true);
                        valido=true;
                    }
                } while (!valido);
                if (zonas.get(indexZona).isVip()) {
                    entrada =  new EntradaVip(partido, indexZona, indexFila, indexColumna);
                } else {
                    entrada =  new EntradaNormal(partido, indexZona, indexFila, indexColumna);
                }
                partido.anyadirEntrada(entrada);
                partido.setRecaudacion(partido.getRecaudacion()+partido.getAfluencia().getModificadorPrecio()*zonas.get(indexZona).getPrecioBase());
            }
        }
    }
}
