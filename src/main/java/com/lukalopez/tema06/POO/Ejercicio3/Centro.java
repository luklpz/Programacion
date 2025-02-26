package com.lukalopez.tema06.POO.Ejercicio3;

import com.lukalopez.lib.FH;
import com.lukalopez.lib.IO;

import java.time.LocalDate;

public class Centro {
    enum Grupo {
        DAM, DAW, ASIR
    }

    static Alumno[] arrayAlumnos = new Alumno[100];
    private static int size = 0;

    /**
     * Mét0do que genera el menú de gestión.
     * @return Devuelve el menú de gestión listo para imprimir.
     */
    private static String menuGestion() {
        return "\n*********************\n** GESTIÓN ALUMNOS **\n*********************\n1. Nuevo alumno...\n2. Baja de alumno...\n3. Consultas...\n------------------------------\n0. Salir\n";
    }



    private static void gestion() {
        System.out.println(menuGestion());
        int opcionMenu = IO.solicitarInt(menuGestion(), 0,3,"ERROR: Entrada invalida.\n");

        do {
            switch (opcionMenu) {
                case 1 -> {
                    int ultimaPosicion = ultimaPosicion();
                    if (ultimaPosicion != -1) {
                        arrayAlumnos[ultimaPosicion] = nuevoAlumno();
                    } else {
                        System.err.println("ERROR: La lista de alumnos está llena");
                    }
                }
                case 2 -> bajaDeAlumno();
                default -> System.out.println("ERROR: Entrada inesperada.");
            }
        } while (true);
    }

    /**
     * Mét0do que devuelve la siguiente posición del array.
     * @return Devuelve el index de la siguiente posicion del array por llenar, en caso de que se haya llenado devuelve -1.
     */
    private static int ultimaPosicion() {
        if (size< arrayAlumnos.length) {
            return size++;
        }
        return -1;
    }

    /********************************************************************************************************************************/

    /**
     * Mét0do para realizar las diferentes solicitudes que se realizan a la hora de crear un alumno.
     * @return Retorna al 'Alumno' inicializado.
     */
    private static Alumno nuevoAlumno() {
        //Solicitamos las variables
        String nia;
        String nombre;
        String apellidos;
        LocalDate fechaDeNacimiento;
        Centro.Grupo grupo;
        String telefonoDeContacto;

        //Solicitamos el NIA
        nia = solicitudNia();
        //Solicitamos el nombre
        nombre = solititudNombre();

        //Solicitamos los apellidos
        apellidos = solicitudApellidos();

        //Solicitamos la fecha de nacimiento
        fechaDeNacimiento = solicitudFechaDeNacimiento();

        //Solicitamos el grupo
        grupo = solicitudGrupo();

        //Solicitamos el telefono de contacto
        telefonoDeContacto = solicitarTelefono();

        return new Alumno(nia, nombre, apellidos, fechaDeNacimiento, grupo, telefonoDeContacto);
    }

    /**
     * Mét0do para solicitar el NIA del alumno.
     * @return Devuelve el nia validado.
     */
    private static String solicitudNia(){
        boolean validado;
        String nia;
        do {
            nia = IO.solicitarString("\nNIA del alumno: ",8,8,"El NIA tiene una longitud de 8 caracteres.");
            validado = IO.solicitarBoolean(String.format("El NIA es \"%s\" ¿Es correcto? (Si/No)\n",nia),"Si","No","ERROR: Respuesta inválida.\n\n");
        } while (!validado);
        return nia;
    }

    /**
     * Mét0do para solicitar el nombre del alumno.
     * @return Devuelve el nombre validado.
     */
    private static String solititudNombre(){
        boolean validado;
        String nombre;
        do {
            nombre = IO.solicitarString("\nNombre del alumno: ",false);
            validado = IO.solicitarBoolean(String.format("El nombre es \"%s\" ¿Es correcto? (Si/No)\n",nombre),"Si","No","ERROR: Respuesta inválida.\n\n");
        } while (!validado);
        return nombre;
    }

    /**
     * Mét0do para solicitar los apellidos del alumno.
     * @return Devuelve los apellidos validados.
     */
    private static String solicitudApellidos(){
        boolean validado;
        StringBuilder apellidos = new StringBuilder();
        do {
            System.out.println();
            apellidos.setLength(0);
            for (int i = 1; i < 3; i++) {
                apellidos.append(IO.solicitarString(String.format("Apellido nº%d del alumno: ", i),false));
                if (i==1){
                    apellidos.append(" ");
                }
            }
            validado = IO.solicitarBoolean(String.format("Los apellidos son \"%s\" ¿Es correcto? (Si/No)\n",apellidos),"Si","No","ERROR: Respuesta inválida.\n\n");
        } while (!validado);
        return apellidos.toString();
    }

    /**
     * Mét0do para solicitar la fecha de nacimiento del alumno.
     * @return Devuelve la fecha de nacimiento validado.
     */
    private static LocalDate solicitudFechaDeNacimiento(){
        boolean validado;
        LocalDate fechaDeNacimiento;
        do {
            fechaDeNacimiento = FH.solicitarFecha("\nFecha de nacimiento del alumno: (DD/MM/YYYY)","dd/MM/yyyy");
            validado = IO.solicitarBoolean(String.format("La fecha de nacimiento es \"%s\" ¿Es correcto? (Si/No)\n",FH.formatearFecha(fechaDeNacimiento,"dd/MM/yyyy")),"Si","No","ERROR: Respuesta inválida.\n\n");
        } while (!validado);
        return fechaDeNacimiento;
    }

    /**
     * Mét0do para solicitar el grupo del alumno.
     * @return Devuelve el grupo validado.
     */
    private static Centro.Grupo solicitudGrupo(){
        boolean validado;
        Centro.Grupo grupo;
        int seleccion;
        do {
            System.out.printf("******\n 1 - %s\n 2 - %s\n 3 - %s\n******\n", Centro.Grupo.DAM, Centro.Grupo.DAW, Centro.Grupo.ASIR);
            seleccion = IO.solicitarInt("\nIngrese el número del grupo al que pertenece el alumno: ");
            switch (seleccion){
                case 1 -> grupo = Centro.Grupo.DAM;
                case 2 -> grupo = Centro.Grupo.DAW;
                case 3 -> grupo = Centro.Grupo.ASIR;
                default -> {
                    System.err.print("ERROR: Entrada inesperarda.");
                    grupo = Centro.Grupo.DAM;
                }
            }
            validado = IO.solicitarBoolean(String.format("El grupo es \"%s\" ¿Es correcto? (Si/No)\n",grupo),"Si","No","ERROR: Respuesta inválida.\n\n");
        } while (!validado);
        return grupo;
    }

    /**
     * Mét0do para solicitar el telefono del alumno.
     * @return Devuelve el telefono validado.
     */
    private static String solicitarTelefono(){
        boolean validado;
        String telefono;
        do {
            telefono = IO.solicitarString("\nIngrese el telefono de contacto del alumno: ",9,9,"El teléfono introducido no es válido.", true);
            validado = IO.solicitarBoolean(String.format("El telefono de contacto es \"%s\" ¿Es correcto? (Si/No)\n",telefono),"Si","No","ERROR: Respuesta inválida.\n\n");
        } while (!validado);
        return telefono;
    }

    //********************************************************************************************************************************/

    /**
     * Mét0do que sirve para dar de baja a un alumno.
     */
    public static void bajaDeAlumno(){
        String nia = solicitudNia();
        for (int i = 0; i < arrayAlumnos.length; i++) {
            if (arrayAlumnos[i].getNia().equals(nia)) {
                arrayAlumnos[i]=null;
                return;
            }
        }
        System.out.println();
    }

    /********************************************************************************************************************************/

    /**
     * Mét0do que genera el menú de consultas.
     * @return Devuelve el menú de consultas listo para imprimir.
     */
    private static String menuConsultas() {
        return "\n***************\n** CONSULTAS **\n***************\n1. Por grupo...\n2. Por edad...\n3. Por nia...\n4. Por apellidos ...\n--------------------\n0. Volver al menú principal\n\n";
    }


    /**
     * Mét0do para gestionar la entrada del usuario
     * @param opcionMenu Es la entrada que previamente ha introducido el usuario.
     */
    private static void consulta(int opcionMenu) {
        switch (opcionMenu) {
            case 1 -> {
                int ultimaPosicion = ultimaPosicion();
                if (ultimaPosicion != -1) {
                    arrayAlumnos[ultimaPosicion] = nuevoAlumno();
                } else {
                    System.err.println("ERROR: La lista de alumnos está llena");
                }
            }
            case 2 -> bajaDeAlumno();
            default -> System.out.println("ERROR: Entrada inesperada.");
        }

    /********************************************************************************************************************************/
    }

    public static void main(String[] args) {
        //Definimos las variables
        int opcionMenu;
        do {
            //Mostramos el menú de gestión
            System.out.println(menuGestion());
            //Recibimos y validamos la elección del usuario
            opcionMenu= IO.solicitarInt("",0,3,"ERROR: Se ha introducido una opción no válida.");

            //Procesamos la entrada
            if (opcionMenu!=0) {
            } else {
                System.out.println("Cerrando programa . . .");
            }
        } while (opcionMenu!=0);
    }
}
