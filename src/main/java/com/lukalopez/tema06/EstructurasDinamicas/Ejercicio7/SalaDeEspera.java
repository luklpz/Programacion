package com.lukalopez.tema06.EstructurasDinamicas.Ejercicio7;

import com.lukalopez.lib.EstructurasDinamicas.Cola;

public class SalaDeEspera {


    //Declaración de variables
    private final static int CAPACIDAD_INICIAL = 10;
    private Medico medico;
    private Cola pacientes;
    private int size;

    public SalaDeEspera( Medico medico) {
        this(medico, CAPACIDAD_INICIAL);
    }

    public SalaDeEspera(Medico medico, int capacidad){
        Cola aux= new Cola(capacidad);
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

    public Cola getPacientes() {
        return pacientes;
    }

    public void setPacientes(Cola pacientes) {
        this.pacientes = pacientes;
    }

    @Override
    public String toString() {
        return toString(false);
    }

    public String toString(boolean soloConsulta) {
        StringBuilder sb = new StringBuilder();
        sb.append(" - SALA DE ESPERA - ").append(".\n");
        sb.append("Médico de la consulta: ").append(medico.toString()).append("\n");
        sb.append("Número de pacientes en cola: ").append(pacientes.size()).append("\n");
        if (!soloConsulta) {
            sb.append(pacientes.toString());
        }
        sb.append("\n");
        return sb.toString();
    }
}
