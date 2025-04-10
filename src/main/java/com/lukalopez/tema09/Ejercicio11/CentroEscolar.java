package com.lukalopez.tema09.Ejercicio11;

import com.lukalopez.lib.IO;
import com.lukalopez.tema09.Ejercicio11.Grupos.Grupo;
import com.lukalopez.tema09.Ejercicio11.Registros.DataBase;

import java.util.NoSuchElementException;
import java.util.Objects;

import static com.lukalopez.tema09.Ejercicio11.CreadorDestructor.*;

public class CentroEscolar {

    public static void main(String[] args) {
        ejecutarMenuPrincipal();
    }
    /**
     * Mét0do para obtener el menú principal.
     * @return Devuelve un 'String' que contiene al menú principal.
     */
    private static String menuPrincipal(){
        return """
                ****************************
                *------CENTRO ESCOLAR------*
                ****************************
                *   1. Gestionar datos     *
                *   2. Realizar consulta   *
                *   0. Cerrar              *
                ****************************
                """;
    }

    /**
     * Mét0do para ejecutar el menú principal.
     */
    private static void ejecutarMenuPrincipal(){
        boolean cerrar = false;
        int entrada;
        do {
            entrada = IO.solicitarInt(menuPrincipal(), 0, 2);
            switch (entrada) {
                case 0 -> cerrar = true;
                case 1 -> ejecutarMenuGestion();
                case 2 -> ejecutarMenuConsulta();
                default -> throw new NoSuchElementException("Se ha introducido una entrada inesperada en el menú principal.");
            }
        } while (!cerrar);
    }

    //*********************************************************************************************\\
    //***********************************    ZONA DE GESTIÓN    ***********************************\\
    //*********************************************************************************************\\


    /**
     * Mét0do para obtener el menú de gestión.
     * @return Devuelve un 'String' que contiene al menú de gestión.
     */
    private static String menuGestion(){
        return """
                ****************************
                *-----GESTIÓN DE DATOS-----*
                ****************************
                *   1. Nuevo registro      *
                *   2. Dar de baja         *
                *   0. Volver              *
                ****************************
                """;
    }

    /**
     * Mét0do para ejecutar el menú de gestión.
     */
    private static void ejecutarMenuGestion(){
        boolean cerrar = false;
        int entrada;
        do {
            entrada = IO.solicitarInt(menuGestion(), 0, 2);
            switch (entrada) {
                case 0 -> cerrar = true;
                case 1-> ejecutarMenuCreacionDeTipo();
                case 2 -> ejecutarMenuBajaDeTipo();
                default -> throw new NoSuchElementException("Se ha introducido una entrada inesperada en el menú de gestión.");
            }
        } while (!cerrar);
    }

    /**
     * Mét0do para obtener el menú de selección de tipo de dato.
     * @return Devuelve un 'String' que contiene al menú de selección de tipo de dato.
     */
    private static String menuSeleccionDeTipo(){
        return """
                ****************************
                *----SELECCIÓN DE TIPOS----*
                ****************************
                *   1. Alumno              *
                *   2. Asignatura          *
                *   3. Aula                *
                *   4. Profesor            *
                *   5. Grupo               *
                *   0. Volver              *
                ****************************
                """;
    }

    /**
     * Mét0do para ejecutar el menú de creación de tipo.
     */
    private static void ejecutarMenuCreacionDeTipo(){
        boolean cerrar = false;
        int entrada;
        do {
            entrada = IO.solicitarInt(menuSeleccionDeTipo(), 0, 5);
            switch (entrada) {
                case 0 -> cerrar = true;
                case 1 -> nuevoAlumno();
                case 2 -> nuevaAsignatura();
                case 3 -> nuevaAula();
                case 4 -> nuevoProfesor();
                case 5 -> nuevoGrupo();
                default -> throw new NoSuchElementException("Se ha introducido una entrada inesperada en el menú principal.");
            }
        } while (!cerrar);
    }

    /**
     * Mét0do para ejecutar el menú de baja de tipo.
     */
    private static void ejecutarMenuBajaDeTipo(){
        boolean cerrar = false;
        int entrada;
        do {
            entrada = IO.solicitarInt(menuSeleccionDeTipo(), 0, 5);
            switch (entrada) {
                case 0 -> cerrar = true;
                case 1 -> bajaAlumno();
                case 2 -> bajaAsignatura();
                case 3 -> bajaAula();
                case 4 -> bajaProfesor();
                case 5 -> bajaGrupo();
                default -> throw new NoSuchElementException("Se ha introducido una entrada inesperada en el menú principal.");
            }
        } while (!cerrar);
    }

    /*          NO PuEDO MAS
    private static void ejecutarMenuModificacionDeTipo(){
        boolean cerrar = false;
        int entrada;
        do {
            entrada = IO.solicitarInt(menuSeleccionDeTipo(), 0, 5);
            switch (entrada) {
                case 0 -> cerrar = true;
                case 1 -> modificarAlumno();
                case 2 -> modificarAsignatura();
                case 3 -> modificarAula();
                case 4 -> modificarProfesor();
                case 5 -> modificarGrupo();
                default -> throw new NoSuchElementException("Se ha introducido una entrada inesperada en el menú principal.");
            }
        } while (!cerrar);
    }*/

    //*********************************************************************************************\\
    //**********************************    ZONA DE CONSULTAS    **********************************\\
    //*********************************************************************************************\\

    /**
     * Mét0do para ejecutar el menú de consultas.
     */
    private static void ejecutarMenuConsulta(){
        Object object=null;
        boolean cerrar = false;
        int entrada;
        do {
            entrada = IO.solicitarInt(menuSeleccionDeTipo(), 0, 5);
            switch (entrada) {
                case 0 -> cerrar = true;
                case 1 -> object = obtenerAlumno();
                case 2 -> object = obtenerAsignatura();
                case 3 -> object = obtenerAula();
                case 4 -> object = obtenerProfesor();
                case 5 -> object = obtenerGrupo();
                default -> throw new NoSuchElementException("Se ha introducido una entrada inesperada en el menú principal.");
            }
            if (object==null){
                System.out.println();
                System.out.println("No hay entradas para ese tipo . . .");
            }
        } while (!cerrar);
    }

    /**
     * Mét0do para que el usuario seleccione un alumno.
     * @return Devuelve al alumno seleccionado por el usuario o null si no hay alumnos o si se desea cancelar.
     */
    public static Alumno obtenerAlumno(){
        if (DataBase.registroAlumnos.isEmpty()){
            return null;
        }

        int entrada;
        StringBuilder sb = new StringBuilder(300);
        sb.append("Ingrese 0 si desea cancelar la operación.\nIngrese el indice del alumno que desea seleccionar:\n\n  **** REGISTRO DE ALUMNOS ****\n");
        for (int i = 0; i < DataBase.registroAlumnos.size(); i++) {
            sb.append(i+1);
            sb.append(DataBase.registroAlumnos.get(i).toString(2));
        }
        String mensajeSolicitud = sb.toString();

        entrada = IO.solicitarInt(mensajeSolicitud, 0, DataBase.registroAlumnos.size() + 1);
        if (entrada==0){
            return null;
        } else {
            return DataBase.registroAlumnos.get(entrada-1);
        }
    }

    /**
     * Mét0do para que el usuario seleccione una asignatura.
     * @return Devuelve la asignatura seleccionada por el usuario o null si o hay asignaturas o si se desea cancelar.
     */
    public static Asignatura obtenerAsignatura(){
        if (DataBase.registroAsignaturas.isEmpty()){
            return null;
        }

        int entrada;
        StringBuilder sb = new StringBuilder(300);
        sb.append("Ingrese 0 si desea cancelar la operación.\nIngrese el indice de la asignatura que desea seleccionar:\n\n  **** REGISTRO DE ASIGNATURAS ****\n");
        for (int i = 0; i < DataBase.registroAsignaturas.size(); i++) {
            sb.append(i+1);
            sb.append(DataBase.registroAsignaturas.get(i).toString(2));
        }
        String mensajeSolicitud = sb.toString();
        entrada = IO.solicitarInt(mensajeSolicitud, 0, DataBase.registroAsignaturas.size() + 1);
        if (entrada==0){
            return null;
        } else {
            return DataBase.registroAsignaturas.get(entrada-1);
        }
    }

    /**
     * Mét0do para que el usuario seleccione un aula.
     * @return Devuelve el aula seleccionada por el usuario o null si no hay aulas o si se desea cancelar.
     */
    public static Aula obtenerAula(){
        if (DataBase.registroAulas.isEmpty()){
            return null;
        }

        int entrada;
        StringBuilder sb = new StringBuilder(300);
        sb.append("Ingrese 0 si desea cancelar la operación.\nIngrese el indice del aula que desea seleccionar:\n\n  **** REGISTRO DE AULAS ****\n");
        for (int i = 0; i < DataBase.registroAulas.size(); i++) {
            sb.append(i+1);
            sb.append(DataBase.registroAulas.get(i).toString(2));
        }
        String mensajeSolicitud = sb.toString();
        entrada = IO.solicitarInt(mensajeSolicitud, 0, DataBase.registroAulas.size() + 1);
        if (entrada==0){
            return null;
        } else {
            return DataBase.registroAulas.get(entrada-1);
        }
    }

    /**
     * Mét0do para que el usuario seleccione un profesor.
     * @return Devuelve al profesor seleccionado por el usuario o null si no hay profesores o si se desea cancelar.
     */
    public static Profesor obtenerProfesor(){
        if (DataBase.registroProfesores.isEmpty()){
            return null;
        }

        int entrada;
        StringBuilder sb = new StringBuilder(300);
        sb.append("Ingrese 0 si desea cancelar la operación.\nIngrese el indice del profesor que desea seleccionar:\n\n  **** REGISTRO DE PROFESORES ****\n");
        for (int i = 0; i < DataBase.registroProfesores.size(); i++) {
            sb.append(i+1);
            sb.append(DataBase.registroProfesores.get(i).toString(2));
        }
        String mensajeSolicitud = sb.toString();
        entrada = IO.solicitarInt(mensajeSolicitud, 0, DataBase.registroProfesores.size() + 1);
        if (entrada==0){
            return null;
        } else {
            return DataBase.registroProfesores.get(entrada-1);
        }
    }

    /**
     * Mét0do para que el usuario seleccione un grupo.
     * @return Devuelve al profesor seleccionado por el usuario o null si no hay grupos o si se desea cancelar.
     */
    public static Grupo obtenerGrupo(){
        if (DataBase.registroGrupos.isEmpty()){
            return null;
        }

        int entrada;
        StringBuilder sb = new StringBuilder(300);
        sb.append("Ingrese 0 si desea cancelar la operación.\nIngrese el indice del grupo que desea seleccionar:\n\n  **** REGISTRO DE GRUPOS ****\n");
        for (int i = 0; i < DataBase.registroGrupos.size(); i++) {
            sb.append(i+1);
            sb.append(DataBase.registroGrupos.get(i).toString(2));
        }
        String mensajeSolicitud = sb.toString();
        entrada = IO.solicitarInt(mensajeSolicitud, 0, DataBase.registroGrupos.size() + 1);
        if (entrada==0){
            return null;
        } else {
            return DataBase.registroGrupos.get(entrada-1);
        }
    }
}
