package com.lukalopez.tema06.EstructurasDinamicas.Ejercicio7;

public class Hospital {
    private static final int CONSULTAS_INICIALES = 5;
    private final String nombreHospital;
    private ColaConsulta[] consultas;
    private int size=1;

    /**
     * Constructor del hospital, con 5 consultas por defecto.
     * @param nombre Nombre del hospital.
     */
    public Hospital(String nombre){
        this(nombre,CONSULTAS_INICIALES);
    }

    /**
     * Constructor del hospital
     * @param nombre Nombre del hospital.
     * @param numeroConsultas Número de consultas que tiene el hospital.
     */
    public Hospital(String nombre,int numeroConsultas){
        nombreHospital=nombre;
        consultas = new ColaConsulta[numeroConsultas];
    }

    public String getNombreHospital() {
        return nombreHospital;
    }

    public ColaConsulta getConsultas(int index) {
        return consultas[index];
    }

    public void setConsultas(ColaConsulta consulta, int posicion) {
        size++;
        this.consultas[posicion] = consulta;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nHospital: ").append(nombreHospital).append("\n");
        sb.append("Número de consultas: ").append(consultas.length).append("\n\n");
        for (int i = 0; i < consultas.length; i++) {
            sb.append("  Consulta ").append(i).append("\n  ");
            sb.append(consultas[i].toString()).append("\n\n");
        }
        return sb.toString();
    }
}
