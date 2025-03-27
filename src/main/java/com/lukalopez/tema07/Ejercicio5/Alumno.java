package com.lukalopez.tema07.Ejercicio5;

import java.util.Objects;

public class Alumno {
    private final String nombre;
    private final int edad; //Mala práctica
    private final double altura;

    public Alumno(String nombre, int edad, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getAltura() {
        return altura;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return edad == alumno.edad && Double.compare(altura, alumno.altura) == 0 && Objects.equals(nombre, alumno.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, edad, altura);
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", altura=" + altura +
                '}';
    }

    /**
     * Mét0do para comprobar que alumno es más viejo, en caso de tener la misma edad devuelve 'null'.
     * @param alumno1 Primer alumno para hacer la comprobación.
     * @param alumno2 Segundo alumno para hacer la comprobación.
     * @return Devuelve al alumno más viejo o 'null' en caso de que tengan la misma edad.
     */
    public static Alumno whoIsOlder(Alumno alumno1, Alumno alumno2){
        int edadAlumno1 = alumno1.getEdad();
        int edadAlumno2 = alumno2.getEdad();
        if (edadAlumno1>edadAlumno2){
            return alumno1;
        } else if (edadAlumno2>edadAlumno1) {
            return alumno2;
        } else {
            return null;
        }
    }
}
