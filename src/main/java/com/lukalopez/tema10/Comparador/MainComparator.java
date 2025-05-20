package com.lukalopez.tema10.Comparador;

import java.util.ArrayList;
import java.util.List;

public class MainComparator {
    public static void main(String[] args) {
        List<Alumno> alumnos = new ArrayList<>();
        alumnos.add(new Alumno("1234523","Manolo", "Julian","kaubfkSNDKFWLEGBÑ"));
        alumnos.add(new Alumno("8138372","Antonio", "Gimenez","kaubfkSNDKFWLEGBÑ"));
        alumnos.add(new Alumno("9813123","Manuela", "Garcia","kaubfkSNDKFWLEGBÑ"));
        alumnos.add(new Alumno("7574849","Pedro", "Sanchez","kaubfkSNDKFWLEGBÑ"));
        System.out.println(alumnos);
        alumnos.sort(new Alumno.ComparatorApellidos());
        System.out.println(alumnos);
        alumnos.sort(new Alumno.ComparatorNia());
        System.out.println(alumnos);
    }
}
