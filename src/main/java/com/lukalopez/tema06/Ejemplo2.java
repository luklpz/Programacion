package com.lukalopez.tema06;

public class Ejemplo2 {
    private enum Curso{
        PRIMERO,SEGUNDO
    }
    public static class Asignatura{
        private String nombre;
        private String codigo;
        private Curso curso;

        public Asignatura(String nombre, String codigo, Curso curso){
            this.nombre = nombre;
            this.codigo = codigo;
            this.curso = curso;
        }

    }

}
