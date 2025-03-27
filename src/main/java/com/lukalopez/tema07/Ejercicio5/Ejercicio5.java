package com.lukalopez.tema07.Ejercicio5;

import com.lukalopez.lib.IO;

public class Ejercicio5 {
    public static void main(String[] args) {
        //Creamos a los alumnos
        Alumno alumno1 = new Alumno(IO.solicitarString("Ingrese el nombre del alumno: "), IO.solicitarInt("Ingrese la edad del alumno: ",0,110),IO.solicitarDouble("Ingrese la altura del alumno: ",0.1,2.5));
        Alumno alumno2 = new Alumno(IO.solicitarString("Ingrese el nombre del alumno: "), IO.solicitarInt("Ingrese la edad del alumno: ",0,110),IO.solicitarDouble("Ingrese la altura del alumno: ",0.1,2.5));

        //Obtenemos al alumno con mayor edad
        Alumno mayor = Alumno.whoIsOlder(alumno1, alumno2);
        if (mayor==null){
            System.out.println("Ambos alumnos tienen la misma edad.");
        } else {
            System.out.printf("%s es el mayor con %d años.", mayor.getNombre(), mayor.getEdad());
        }
    }
}
