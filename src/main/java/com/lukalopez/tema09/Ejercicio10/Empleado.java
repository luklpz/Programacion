package com.lukalopez.tema09.Ejercicio10;

import com.lukalopez.lib.FH;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Empleado extends Persona {
    private static int lastID=0;
    private final int id;
    private final String pasaporte;
    private double sueldo;
    private final ArrayList<Persona> hijos;

    public Empleado(String nombre, String apellidos, LocalDate fechaNacimiento, String pasaporte, double sueldo, ArrayList<Persona> hijos) {
        super(nombre, apellidos, fechaNacimiento);
        this.id = generarSiguienteId();
        this.pasaporte = pasaporte;
        this.sueldo = sueldo;
        this.hijos = hijos;
    }

    /**
     * Mét0do para generar el siguiente id de forma autonumérica.
     * @return Devuelve el siguiente id en cola.
     */
    private int generarSiguienteId(){
        return ++lastID;
    }

    public int getId() {
        return id;
    }

    public String getPasaporte() {
        return pasaporte;
    }

    public double getSueldo() {
        return sueldo;
    }

    public ArrayList<Persona> getHijos() {
        return hijos;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Empleado empleado = (Empleado) o;
        return Objects.equals(pasaporte, empleado.pasaporte);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pasaporte);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("    ").append(id).append(". ").append(getNombre()).append(", ").append(getApellidos());
        sb.append("\n      Documento de identidad: ").append(getPasaporte());
        sb.append("\n      Fecha de nacimiento: ").append(FH.formatearFecha(getFechaNacimiento(),"dd/MM/yyyy"));
        sb.append("\n      Sueldo: ").append(getSueldo());
        sb.append("\n      Numero de hijos: ").append((hijos.size()+1)).append("\n");
        for (int i = 0; i < hijos.size(); i++) {
            sb.append("        Hijo ").append(i+1).append(" ").append(hijos.get(i)).append("\n");
        }
        return sb.toString();
    }
}
