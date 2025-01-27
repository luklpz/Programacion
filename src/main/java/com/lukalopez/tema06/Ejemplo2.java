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

    static Asignatura A1  = new Asignatura("Programacion","1017", Curso.PRIMERO);

    public static void main(String[] args) {
        System.out.printf("Asignatura: %s \nCodigo: %s \nCurso: %s",A1.nombre,A1.codigo,A1.curso);
    }
}
