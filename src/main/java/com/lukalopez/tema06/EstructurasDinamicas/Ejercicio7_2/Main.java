package com.lukalopez.tema06.EstructurasDinamicas.Ejercicio7_2;

import com.lukalopez.lib.Escaner;
import com.lukalopez.lib.FH;
import com.lukalopez.lib.IO;

import java.time.LocalDate;

public class Main {

    private static RegistroPacientes registro = new RegistroPacientes();
    private static Historico historial = new Historico();


    public static void main(String[] args) {
        ejecutarMenu();
    }

    /*********************************************METODOS*********************************************/

    private static boolean ejecutarMenu(){
        final String MENU = menuUrgencias();
        boolean cerrar=false;
        int respuesta;

        do {
            respuesta = IO.solicitarInt(MENU,0,4,"ERROR: Entrada invalida, introduzca una opción válida.\n");
            System.out.println("\n");
            cerrar = gestionarRespuesta(respuesta);
        } while(!cerrar);
        return true;
    }

    private static String menuUrgencias(){
        return "*********************\n" +
                "**    URGENCIAS    **\n" +
                "**********************\n" +
                "1. Nuevo paciente …\n" +
                "2. Atender paciente …\n" +
                "3. Consultas …\n" +
                "4. Alta médica …\n" +
                "----------------------\n" +
                "0. Salir\n";
    }

    private static boolean gestionarRespuesta(int respuesta){
        switch (respuesta){
            //Cerrar
            case 0 -> {
                System.out.println("Cerrando programa...");
                Escaner.dispose();
                return false;
            }

            //Nuevo paciente
            case 1 -> {
                int sip = solicitarSip();
                if (!(buscarPorSip(sip)==null)){
                    System.err.printf("El paciente con sip \'%d\' ya existe.\n",sip);
                } else {
                    registro.add(crearPaciente(sip));
                }
                return false;
            }

            //Atender paciente
            case 2 -> {
                historial.atenderPaciente(solicitarSip());
            }

            //Consultas
            case 3 -> {

            }

            //Alta médica
            case 4 -> {
                historial.darDeAlta();
            }

            default -> {
                System.err.println("ERROR: Entrada inesperada.");
            }
        }
        return false;
    }

    public static Paciente buscarPorSip(final int SIP_REQUERIDO){
        Paciente auxPaciente;

        //Comprobamos si el array de pacientes está vacío
        if (registro.isEmpty()){
            return null;
        }

        //Recorremos el array de pacientes en busca de uno que tenga el sip requerido
        for (int i = 0; i < registro.size(); i++) {
            if (registro.get(i).getSip()==SIP_REQUERIDO){
                return registro.get(i);
            }
        }

        return null;
    }

    private static Paciente crearPaciente(final int sip) {
        final String nombre;
        final String primerApellido;
        final String segundoApellido;
        final LocalDate fechaNacimiento;
        final Sexo sexo;

        nombre = solicitarNombre();
        primerApellido = solicitarPrimerApellido();
        segundoApellido = solicitarSegundoApellido();
        fechaNacimiento = solicitarFechaNacimiento();
        sexo = solicitarSexo();
        System.out.println("\n");

        return new Paciente(sip, nombre,primerApellido,segundoApellido,fechaNacimiento,sexo);
    }

    /*******************************************SOLICITUDES*******************************************/

    public static int solicitarSip(){
        int sip;
        sip = IO.solicitarInt("Intruduzca el número SIP: ",100000000,199999999,"ERROR: El SIP ha de tener una longitud de 9 caracteres numericos.\n\n");
        return sip;
    }

    private static String solicitarNombre(){
        String nombre;
        nombre = IO.solicitarString("Introduzca el nombre del paciente: ",false);
        return nombre;
    }

    private static String solicitarPrimerApellido(){
        String primerApellido;
        primerApellido = IO.solicitarString("Introduzca el primer apellido del paciente: ",false);
        return primerApellido;
    }

    private static String solicitarSegundoApellido(){
        String segundoApellido;
        segundoApellido = IO.solicitarString("Introduzca el segundo apellido del paciente: ",false);
        return segundoApellido;
    }

    private static LocalDate solicitarFechaNacimiento(){
        LocalDate fechaNacimiento;
        fechaNacimiento = FH.solicitarFecha("Introduzca la fecha de nacimiento del paciente:");
        return fechaNacimiento;

    }

    private static Sexo solicitarSexo(){
        int respuesta;
        Sexo sexo;
        respuesta = IO.solicitarInt("Seleccione el sexo del paciente:\n   1.Masculino\n   2.Femenino\n   ",1,2,"ERROR: Se ha introducido una entrada invalida.\n\n");
        switch (respuesta){
            case 1 -> sexo = Sexo.MASCULINO;
            case 2 -> sexo = Sexo.FEMENINO;
            default -> {
                System.err.println("ERROR: Entrada inesperada.");
                sexo = Sexo.ERROR;
            }
        }
        return sexo;
    }
}
