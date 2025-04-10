package com.lukalopez.tema09.Ejercicio11.Registros;

import com.lukalopez.tema09.Ejercicio11.Alumno;
import com.lukalopez.tema09.Ejercicio11.Grupos.Grupo;

import java.util.HashMap;

public class RegistroGrupos extends HashMap<Grupo, Alumno> {
    public RegistroGrupos(int initialCapacity) {
        super(initialCapacity);
    }

    //dar de baja a un alumno de un grupo
    //dar de alta a un alumno de un grupo
    //borrar un grupo
}
