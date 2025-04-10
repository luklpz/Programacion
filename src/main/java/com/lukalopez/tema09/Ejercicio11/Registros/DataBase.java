package com.lukalopez.tema09.Ejercicio11.Registros;

import com.lukalopez.tema09.Ejercicio11.Alumno;
import com.lukalopez.tema09.Ejercicio11.Asignatura;
import com.lukalopez.tema09.Ejercicio11.Aula;
import com.lukalopez.tema09.Ejercicio11.Grupos.Grupo;
import com.lukalopez.tema09.Ejercicio11.Profesor;

import java.util.ArrayList;

public class DataBase {
    public static ArrayList<Grupo> registroGrupos = new ArrayList<>(Config.DEFAULT_REGISTRO_GRUPOS_LENGTH);
    public static ArrayList<Alumno> registroAlumnos = new ArrayList<>(Config.DEFAULT_REGISTRO_ALUMNOS_LENGTH);
    public static ArrayList<Aula> registroAulas = new ArrayList<>(Config.DEFAULT_REGISTRO_AULAS_LENGTH);
    public static ArrayList<Profesor> registroProfesores = new ArrayList<>(Config.DEFAULT_REGISTRO_PROFESORES_LENGTH);
    public static ArrayList<Asignatura> registroAsignaturas = new ArrayList<>(Config.DEFAULT_REGISTRO_ASIGNATURAS_LENGTH);
}
