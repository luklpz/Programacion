package com.lukalopez.tema09.Ejercicio11;

import com.lukalopez.lib.IO;
import com.lukalopez.tema09.Ejercicio11.Grupos.Curso;
import com.lukalopez.tema09.Ejercicio11.Grupos.Grado;
import com.lukalopez.tema09.Ejercicio11.Grupos.Grupo;
import com.lukalopez.tema09.Ejercicio11.Registros.DataBase;

import java.util.ArrayList;

public class CreadorDestructor {

    //*********************************************************************************************\\
    //**********************************          CREAR          **********************************\\
    //*********************************************************************************************\\

    /**
     * Mét0do para crear un nuevo alumno y añadirlo a la base de datos.
     * @return Devuelve el alumno creado tras haberlo guardado.
     */
    public static Alumno nuevoAlumno(){
        boolean valido;
        String nombre;
        String apellidos;
        Asignatura aux;
        int contadorAsignaturas = 0;
        Grupo grupo;

        ArrayList<Asignatura> asignaturas = new ArrayList<>();

        //Realizamos las solicitudes
        do {
            valido = true;
            nombre = IO.solicitarString("Ingrese el nombre del alumno: ");
            apellidos = IO.solicitarString("Ingrese los apellidos del alummo: ");

            //Solicitamos el grupo al que pertenece
            do {
                grupo = CentroEscolar.obtenerGrupo();
                if (grupo == null) {
                    System.out.println("Cancelando . . . Regresando a la solicitud de datos.");
                    if (DataBase.registroGrupos.isEmpty()){
                        System.out.println("No hay grupos, cancelando la creación de alumno.");
                        return null;
                    }
                    valido =false;
                }
            } while (grupo == null);
        } while (!valido);

        System.out.println("Ingrese las asignaturas del alumno, cancele cuando las haya ingresado todas: ");
        do {
            valido = false;
            aux = CentroEscolar.obtenerAsignatura();
            if (aux==null){
                if (DataBase.registroAsignaturas.isEmpty()){
                    System.out.println("No hay asignaturas, cancelando la creación de alumno.");
                    return null;
                }
                if (contadorAsignaturas==0){
                    System.out.println("Se ha de introducir al menos una asignatura.");
                } else {
                    valido = true;
                }
            } else {
                asignaturas.add(aux);
                ++contadorAsignaturas;
            }
        } while (!valido);

        Alumno alumno = new Alumno(nombre,apellidos,grupo,asignaturas);
        DataBase.registroAlumnos.add(alumno);
        return alumno;
    }

    /**
     * Mét0do para crear una nueva asignatura y añadirla a la base de datos.
     * @return Devuelve la asignatura creada tras haberla guardado.
     */
    public static Asignatura nuevaAsignatura(){
        boolean valido;
        String nombre;
        Profesor profesor;

        //Solicitamos el profesor
        do {
            valido = true;
            nombre = IO.solicitarString("Ingrese el nombre de la asignatura: ");

            //Solicitamos el profesor al que pertenece
            do {
                profesor = CentroEscolar.obtenerProfesor();
                if (profesor == null) {
                    if (DataBase.registroProfesores.isEmpty()){
                        System.out.println("No hay profesores, cancelando la creación de asignatura.");
                        return null;
                    }
                    System.out.println("Cancelando . . . Regresando a la solicitud de datos.");
                    valido =false;
                }
            } while (profesor == null);
        } while (!valido);

        Asignatura asignatura = new Asignatura(nombre, profesor);
        DataBase.registroAsignaturas.add(asignatura);
        return asignatura;
    }

    /**
     * Mét0do para crear una nueva aula y añadirla a la base de datos.
     * @return Devuelve el aula creada tras haberla guardado.
     */
    public static Aula nuevaAula(){
        float ancho = IO.solicitarFloat("Ingrese los metros de ancho del aula: ",0,120);
        float alto = IO.solicitarFloat("Ingrese los metros de largo del aula: ",0,120);

        Aula aula = new Aula(ancho, alto);
        DataBase.registroAulas.add(aula);
        return aula;
    }

    /**
     * Mét0do para crear un nuevo profesor y añadirlo a la base de datos.
     * @return Devuelve el profesor creado tras haberlo guardado.
     */
    public static Profesor nuevoProfesor(){
        String dni = IO.solicitarDNI("Ingrese el DNI del profesor: ");
        String nombre = IO.solicitarString("Ingrese el nombre del profesor: ");
        String apellidos = IO.solicitarString("Ingrese los apellidos del profesor: ");
        double sueldo = IO.solicitarDouble("Ingrese el sueldo del profesor: ");

        Profesor profesor = new Profesor(dni, nombre, apellidos, sueldo);
        DataBase.registroProfesores.add(profesor);
        return profesor;
    }

    /**
     * Mét0do para crear un nuevo grupo y añadirlo la base de datos.
     * @return Devuelve el grupo creado tras haberla guardado.
     */
    public static Grupo nuevoGrupo(){
        boolean valido=false;
        Grado grado;
        Curso curso;
        Aula aula=null;
        int plazas=0;
        do {
            grado = Grado.obtenerGrado();
            if (!(grado==null)){
                curso = Curso.obtenerCurso();
                if (!(curso==null)) {
                    plazas = IO.solicitarInt("Ingrese el número de plazas del grupo: ");
                    aula = CentroEscolar.obtenerAula();
                    if (aula==null){
                        if (DataBase.registroAulas.isEmpty()){
                            System.out.println("No hay aulas, cancelando la creación de aulas.");
                            return null;
                        }
                        System.out.println("Cancelando solicitud de aula, reiniciando recogida de datos . . .");
                    } else {
                        valido=true;
                    }
                } else {
                    if (Curso.values().length==0){
                        System.out.println("No hay grados, cancelando la creación de grupo.");
                        return null;
                    }
                    System.out.println("Cancelando solicitud de curso, reiniciando recogida de datos . . .");
                }

            } else {
                if (Grado.values().length==0){
                    System.out.println("No hay grados, cancelando la creación de grupo.");
                    return null;
                }
                System.out.println("Cancelando la creación de un nuevo grupo . . .");
                return null;
            }
        } while(!valido);


        Grupo grupo = new Grupo(grado,curso,plazas,aula);
        DataBase.registroGrupos.add(grupo);
        return grupo;
    }

    //*********************************************************************************************\\
    //**********************************         ELIMINAR        **********************************\\
    //*********************************************************************************************\\

    /**
     * Mét0do para dar de baja a un alumno, eliminandolo de la base de datos.
     * @return Devuelve al alumno que se acaba de eliminar.
     */
    public static Alumno bajaAlumno(){
        Alumno alumno;
        alumno = CentroEscolar.obtenerAlumno();
        if (alumno==null){
            System.out.println("Cancelando solicitud de alumno, reiniciando recogida de datos . . .");
            return null;
        }
        DataBase.registroAlumnos.remove(alumno);
        return alumno;
    }

    /**
     * Mét0do para dar de baja a una asignatura, eliminandola de la base de datos.
     * @return Devuelve al alumno que se acaba de eliminar.
     */
    public static Asignatura bajaAsignatura(){
        Asignatura asignatura;
        asignatura = CentroEscolar.obtenerAsignatura();
        if (asignatura==null){
            System.out.println("Cancelando solicitud de asignatura, reiniciando recogida de datos . . .");
            return null;
        }
        DataBase.registroAsignaturas.remove(asignatura);
        return asignatura;
    }

    /**
     * Mét0do para dar de baja a un aula, eliminandola de la base de datos.
     * @return Devuelve el aula que se acaba de eliminar.
     */
    public static Aula bajaAula(){
        Aula aula;
        aula = CentroEscolar.obtenerAula();
        if (aula==null){
            System.out.println("Cancelando solicitud de aula, reiniciando recogida de datos . . .");
            return null;
        }
        DataBase.registroAulas.remove(aula);
        return aula;
    }

    /**
     * Mét0do para dar de baja a un profesor, eliminandolo de la base de datos.
     * @return Devuelve el profesor que se acaba de eliminar.
     */
    public static Profesor bajaProfesor(){
        Profesor profesor;
        profesor = CentroEscolar.obtenerProfesor();
        if (profesor==null){
            System.out.println("Cancelando solicitud de profesor, reiniciando recogida de datos . . .");
            return null;
        }
        DataBase.registroProfesores.remove(profesor);
        return profesor;
    }

    /**
     * Mét0do para dar de baja a un grupo, eliminandolo de la base de datos.
     * @return Devuelve el grupo que se acaba de eliminar.
     */
    public static Grupo bajaGrupo(){
        Grupo grupo;
        grupo = CentroEscolar.obtenerGrupo();
        if (grupo==null){
            System.out.println("Cancelando solicitud de grupo, reiniciando recogida de datos . . .");
            return null;
        }
        DataBase.registroGrupos.remove(grupo);
        return grupo;
    }
}
