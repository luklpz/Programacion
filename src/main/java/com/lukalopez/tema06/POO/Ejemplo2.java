package com.lukalopez.tema06.POO;

public class Ejemplo2 {
    public enum Curso{
        PRIMERO,SEGUNDO
    }
    public enum Clase{
        PROGRAMACION, BASEDEDATOS, INGLES
    }

    public static class Asignatura{
        private Clase nombre;
        private final int codigo;
        private Curso curso;

        public Asignatura(Clase nombre, int codigo, Curso curso){
            this.nombre = nombre;
            this.codigo = codigo;
            this.curso = curso;
        }

        public Clase getNombre() {
            return nombre;
        }

        public int getCodigo() {
            return codigo;
        }

        public Curso getCurso() {
            return curso;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("nombre \"");
            switch (nombre){
                case PROGRAMACION -> sb.append("Programación\", ");
                case BASEDEDATOS -> sb.append("Base de Datos\", ");
                case INGLES -> sb.append("Inglés\", ");
                default -> System.err.println("ERROR: Asinganatura inesperada.");
            }
            sb.append("código ").append(codigo).append(", curso ");
            switch (curso){
                case PRIMERO -> sb.append("1. ");
                case SEGUNDO -> sb.append("2. ");
            }
            return sb.toString();
        }
    }
}
