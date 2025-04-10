package com.lukalopez.tema09.Ejercicio11.Grupos;

import com.lukalopez.lib.IO;

public enum Curso {
    PRIMERO("Primero"), SEGUNDO("Segundo");
    private final String titulo;

    Curso(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Mét0do para que el usuario seleccione un curso.
     * @return Devuelve al profesor seleccionado por el usuario o null si no hay cursos o si se desea cancelar.
     */
    public static Curso obtenerCurso(){
        int entrada;
        StringBuilder sb = new StringBuilder(300);
        sb.append("Ingrese 0 si desea cancelar la operación.\nIngrese el indice del curso que desea seleccionar:\n\n  **** REGISTRO DE CURSOS ****\n");
        for (int i = 0; i < Curso.values().length; i++) {
            sb.append(i+1);
            sb.append(Curso.values()[i].toString()).append("\n");
        }
        String mensajeSolicitud = sb.toString();
        entrada = IO.solicitarInt(mensajeSolicitud, 0, Curso.values().length + 1);
        if (entrada==0){
            return null;
        } else {
            return Curso.values()[entrada-1];
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
