package com.lukalopez.tema06.EstructurasDinamicas.Ejercicio7;

import com.lukalopez.lib.Random;

import java.time.LocalDateTime;

public class DataGenerator {

    static String[] nombres = {"Paco","Sandra","Anacleto","Bustamante","Gerardo", "Tomas", "Depresion", "Saltamontes"};
    static String[] apellidos = {"Jones", "Udaos", "Don", "Simon","Garcia","Delgado","Anacardo", "Fresco","Queso", "Turbado", "Fuerte"};


    public static Hospital crearHospital(){
        Hospital hospital = new Hospital("MarinaSalud", 5);
        for (int i = 0; i < 5; i++) {
            hospital.setConsultas(crearConsulta(),i);
        }
        return hospital;
    }

    private static ColaConsulta crearConsulta(){
        ColaConsulta consulta = new ColaConsulta(ColaConsulta.seccionesConsulta(Random.randomInt(0,4)),crearMedico());
        for (int i = 0; i < 10; i++) {
            consulta.getPacientes().add(crearPaciente());
        }
        return consulta;
    }

    private static Medico crearMedico(){
        return new Medico(String.valueOf(Random.randomInt(100000,999999)),nombres[Random.randomInt(0,nombres.length-1)], String.format("%s %s",apellidos[Random.randomInt(0,apellidos.length-1)],apellidos[Random.randomInt(0,apellidos.length-1)]));
    }

    public static Paciente crearPaciente(){
        Paciente paciente = new Paciente(String.valueOf(Random.randomInt(10000000,99999999)),nombres[Random.randomInt(0,nombres.length-1)], String.format("%s %s",apellidos[Random.randomInt(0,apellidos.length-1)],apellidos[Random.randomInt(0,apellidos.length-1)]), LocalDateTime.now());
        return paciente;
    }
}
