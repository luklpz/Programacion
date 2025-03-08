package com.lukalopez.tema06.EstructurasDinamicas.Ejercicio7;

import com.lukalopez.lib.FH;
import com.lukalopez.lib.IO;

import java.time.LocalDateTime;

public class Main {

    public static Hospital hospital;

    private static boolean menuHospital(){
        boolean cerrar;
        int respuesta;
        do {
            String menu = "=== HOSPITAL ===\n" +
                    "1. Añadir paciente\n" +
                    "2. Atender siguiente paciente\n" +
                    "3. Mostrar estado de las colas\n" +
                    "4. Salir\n";
            respuesta = IO.solicitarInt(menu, 1, 4, "Se ha intruducido una opción inválida.");
            cerrar = procesarRespuesta(respuesta);
        }while(!cerrar);
        return true;
    }

    private static String getColas(boolean soloConsulta){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb.append(String.format("Consulta %d: %s\n",i+1,hospital.getConsultas(i).toString(soloConsulta)));
        }
        return sb.toString();
    }

    private static boolean procesarRespuesta(int respuestaMenuHospital){
        final String mensajeError= "Se ha introducido una entrada invalida.";
        switch (respuestaMenuHospital){
            case 1 -> {
                //Declaramos las variables
                Paciente paciente;
                int respuesta;
                String nombre;
                String apellidos;
                String sip;
                LocalDateTime horaFechaCita;

                //Imprimimos las colas
                System.out.println(getColas(true));

                //Creamos el paciente con la información que solicitamos al usuario
                respuesta = IO.solicitarInt("¿A que consulta deseas ingresar?\n",1,5,mensajeError);
                System.out.println("Preparando la consulta...");
                sip = String.valueOf(IO.solicitarInt("Intruduzca el número SIP (número de 8 caracteres): ",10000000,99999999,mensajeError));
                nombre = IO.solicitarString("Introduzca el nombre del usuario: ",false);
                apellidos = IO.solicitarString("Introduzca los apellidos del usuario: ",false);
                horaFechaCita = FH.solicitarFechaHora("Ingrese la fecha y la hora de la cita:");

                //Procesamos las respuestas
                return false;
            }
            case 2 -> {
                //Declaramos las variables
                int respuesta;

                //Imprimimos las colas
                System.out.println(getColas(true));

                //Creamos el paciente con la información que solicitamos al usuario
                respuesta = IO.solicitarInt("¿A que consulta deseas ingresar?\n",1,5,mensajeError);
                System.out.println("Preparando la consulta...");

                System.out.printf("´Siguiente paciente:\n%s\n\n\n",hospital.getConsultas(respuesta-1).getPacientes().pop().toString());
                System.out.printf("Estado actual de la cola: %s\n",hospital.getConsultas(respuesta-1).toString());
                return false;
            }
            case 3 -> {
                System.out.println(getColas(false));
                return false;
            }
            default -> {}
        }
        return true;
    }

    public static void main(String[] args) {

        //Primero creamos le hospital
        hospital = DataGenerator.crearHospital();

        //A continuación mostramos el menú y solicitamos una respuesta
        menuHospital();


    }
}
