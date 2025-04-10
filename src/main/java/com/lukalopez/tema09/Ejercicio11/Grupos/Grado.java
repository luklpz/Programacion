package com.lukalopez.tema09.Ejercicio11.Grupos;

import com.lukalopez.lib.IO;

public enum Grado {
    DAM("DAM","Desarrollo de Aplicaciones Multiplataforma"),
    DAW("DAW","Desarrollo de Aplicaciones Web"),
    ASIR("ASIR","Administración de Sistemas Informaticos en Red"),
    TPCC("TPCC","Técnico en Peluquería y Cosmética Capilar");

    private final String titulo;
    private final String nombreCompleto;

    Grado(String titulo, String nombreCompleto) {
        this.titulo = titulo;
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreCompleto(){
        return nombreCompleto;
    }

    /**
     * Mét0do para que el usuario seleccione un grupo.
     * @return Devuelve al profesor seleccionado por el usuario o null si no hay grupos o si se desea cancelar.
     */
    public static Grado obtenerGrado(){
        int entrada;
        StringBuilder sb = new StringBuilder(300);
        sb.append("Ingrese 0 si desea cancelar la operación.\nIngrese el indice del grado que desea seleccionar:\n\n  **** REGISTRO DE GRADOS ****\n");
        for (int i = 0; i < Grado.values().length; i++) {
            sb.append(i+1);
            sb.append(Grado.values()[i].toString()).append("\n");
        }
        String mensajeSolicitud = sb.toString();
        entrada = IO.solicitarInt(mensajeSolicitud, 0, Grado.values().length + 1);
        if (entrada==0){
            return null;
        } else {
            return Grado.values()[entrada-1];
        }
    }

    public String toString(int tabulado) {

        return " ".repeat(Math.max(0, tabulado)) + titulo;
    }

    @Override
    public String toString() {
        return titulo;
    }
}
