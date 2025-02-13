package com.lukalopez.tema06.EstructurasDinamicas.Ejercicio7;

import com.lukalopez.lib.EstructurasDinamicas.Cola;

public class ColaConsulta {
    private enum SeccionesConsulta{
        CIRUJIA, PEDIATRIA, SEXOLOGIA, RADIOGRAFIA, ODONTOLOGIA
    }

    public static SeccionesConsulta seccionesConsulta(int index){
        SeccionesConsulta seccion;
        switch (index){
            case 0 -> {
                seccion = SeccionesConsulta.RADIOGRAFIA;
            }
            case 1 -> {
                seccion = SeccionesConsulta.PEDIATRIA;
            }
            case 2 -> {
                seccion = SeccionesConsulta.SEXOLOGIA;
            }
            case 3 -> {
                seccion = SeccionesConsulta.ODONTOLOGIA;
            }
            case 4 -> {
                seccion = SeccionesConsulta.CIRUJIA;
            }
            default -> {
                System.err.println("ERROR: Entrada inesperada.");
                return null;
            }
        }
        return seccion;
    }

    //Declaración de variables
    private final static int CAPACIDAD_INICIAL = 10;
    private Medico medico;
    private SeccionesConsulta seccion;
    private Cola<Paciente> pacientes;
    private int size;

    public ColaConsulta(SeccionesConsulta seccion, Medico medico) {
        this(seccion, medico, CAPACIDAD_INICIAL);
    }

    public ColaConsulta(SeccionesConsulta seccion, Medico medico, int capacidad){
        @SuppressWarnings("unchecked")
        Cola<Paciente> aux= new Cola<>(capacidad);
        this.seccion = seccion;
        this.medico = medico;
        size = 0;
        pacientes = aux;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public SeccionesConsulta getSeccion() {
        return seccion;
    }

    public void setSeccion(SeccionesConsulta seccion) {
        this.seccion = seccion;
    }

    public Cola<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(Cola<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    @Override
    public String toString() {
        return toString(false);
    }

    public String toString(boolean soloConsulta) {
        StringBuilder sb = new StringBuilder();
        sb.append("Consulta de ").append(seccion).append(".\n");
        sb.append("Médico de la consulta: ").append(medico.toString()).append("\n");
        sb.append("Número de pacientes en cola: ").append(pacientes.size()).append("\n");
        if (!soloConsulta) {
            sb.append(pacientes.toString());
        }
        sb.append("\n");
        return sb.toString();
    }
}
