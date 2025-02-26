package com.lukalopez;

import com.lukalopez.tema06.POO.Ejemplo2;

public class Main {
    public static void main(String[] args) {
        Ejemplo2.Asignatura asignatura = new Ejemplo2.Asignatura(Ejemplo2.Clase.PROGRAMACION, 1017, Ejemplo2.Curso.PRIMERO);
        System.out.println(asignatura);
    }
}
