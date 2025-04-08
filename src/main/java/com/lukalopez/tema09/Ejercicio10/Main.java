package com.lukalopez.tema09.Ejercicio10;

import com.lukalopez.lib.Escaner;
import com.lukalopez.lib.FH;
import com.lukalopez.lib.IO;
import javax.naming.InvalidNameException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Main {
    private static List<Empleado> registroEmpleados = new ArrayList<>();

    public static <registroEmpleados> void main(String[] args) {
        ejecutarMenu();
        Escaner.dispose();
    }

    /**
     * Mét0do para obtener el menú principal.
     * @return Devuelve un 'String' que contiene el menú principal.
     */
    private static String getMenu(){
        return """
                *********************
                * GESTIÓN EMPLEADOS *
                *********************
                1. Nuevo empleado
                2. Nuevo hijo
                3. Modificar sueldo
                4. Borrar empleado
                5. Borrar hijo
                6. Consultas
                ---------------------
                0. Salir
                """;
    }

    /**
     * Mét0do para ejecutar el menú principal.
     */
    private static void ejecutarMenu(){
        boolean cerrar = false;
        int entrada;
        do {
            entrada = IO.solicitarInt(getMenu(),0,6);
            switch (entrada){
                case 1 -> {
                    Empleado empleado = nuevoEmpleado();
                    if (empleado==null){
                        System.out.println("El empleado introducido ya existe.");
                    } else {
                        registroEmpleados.add(empleado);
                    }
                }
                case 2 -> {
                    int indice = obtenerIndiceEmpleado();
                    if (indice==-1){
                        System.out.println();
                        break;
                    }
                    Empleado empleado = registroEmpleados.get(indice);
                    ArrayList<Persona> hijos = empleado.getHijos();
                    hijos.add(nuevoHijo());
                }
                case 3 -> {
                    int indice = obtenerIndiceEmpleado();
                    if (indice==-1){
                        System.out.println();
                        break;
                    }
                    Empleado empleado = registroEmpleados.get(indice);
                    empleado.setSueldo(IO.solicitarDouble("Introduce el nuevo sueldo del empleado: "));
                }
                case 4 -> {
                    int indice = obtenerIndiceEmpleado();
                    if (indice==-1){
                        System.out.println();
                        break;
                    }
                    Empleado empleado = registroEmpleados.get(indice);
                    registroEmpleados.remove(empleado);
                }
                case 5 -> {
                    int indice = obtenerIndiceEmpleado();
                    if (indice==-1){
                        System.out.println();
                        break;
                    }
                    Empleado empleado = registroEmpleados.get(indice);
                    System.out.println();
                    int indiceHijo = IO.solicitarInt("Introduzca el indice del hijo",1,empleado.getHijos().size()+1);
                    ArrayList<Persona> hijos = empleado.getHijos();
                    hijos.remove(indiceHijo-1);
                }
                case 6 -> System.out.println();
                case 0 -> cerrar=true;
                default -> throw new NoSuchElementException("Se ha introducido una entrada inesperada en el menú principal.");
            }
        } while (!cerrar);
    }

    //****************************** MÉTODOS MENÚ ******************************\\

    /**
     * Mét0do para que el usuario ingrese los datos de un nuevo empleado.
     * @return Devuelve 'null' si el empleado ya existe o devuelve al empleado validado.
     */
    private static Empleado nuevoEmpleado(){
        final String NOMBRE = IO.solicitarString("Ingrese el nombre del empleado: ",2, IO.Condicion.MINIMO);
        final String APELLIDOS = IO.solicitarString("Ingrese los apellidos del empleado: ",2,IO.Condicion.MINIMO);
        final LocalDate FECHA_NACIMIENTO = FH.solicitarFecha("A continuación ingrese la fecha de nacimiento del empleado:\n");
        final String DOCUMENTO = solicitarDocumento();
        final double SUELDO = IO.solicitarDouble("Ingrese el sueldo del empleado: ",0, IO.Condicion.MINIMO);
        final int NUMERO_HIJOS = IO.solicitarInt("Ingrese el número de hijos que tiene el empleado: ",0, IO.Condicion.MINIMO);
        final ArrayList<Persona> HIJOS = new ArrayList<>(NUMERO_HIJOS);
        for (int i = 0; i < NUMERO_HIJOS; i++) {
            HIJOS.add(nuevoHijo());
        }
        Empleado empleado = new Empleado(NOMBRE,APELLIDOS,FECHA_NACIMIENTO,DOCUMENTO,SUELDO,HIJOS);
        if (registroEmpleados.contains(empleado)){
            empleado=null;
        }
        return empleado;
    }

    /**
     * Mét0do para que el usuario ingrese los datos de un nuevo hijo.
     * @return Devuelve al hijo validado.
     */
    private static Persona nuevoHijo() {
        final String NOMBRE = IO.solicitarString("Ingrese el nombre del empleado: ", 2, IO.Condicion.MINIMO);
        final String APELLIDOS = IO.solicitarString("Ingrese los apellidos del empleado: ", 2, IO.Condicion.MINIMO);
        final LocalDate FECHA_NACIMIENTO = FH.solicitarFecha("A continuación ingrese la fecha de nacimiento del empleado:\n");
        return new Persona(NOMBRE, APELLIDOS, FECHA_NACIMIENTO);
    }

    /**
     * Mét0do para seleccionar a un empleado.
     * @return Devuelve el índice en el que se encuentra el empleado seleccionado.
     */
    private static int obtenerIndiceEmpleado(){
        StringBuilder sb = new StringBuilder();
        sb.append("- LISTA DE EMPLEADOS:\n");
        sb.append("   -1. VOLVER");
        for (int i = 0; i < registroEmpleados.size(); i++) {
            sb.append(registroEmpleados.get(i).toString());
            sb.append("\n");
        }
        return IO.solicitarInt(sb.toString(),-1,registroEmpleados.size());
    }

    //*********************************************************************************\\
    //****************************** SOLICITAR DOCUMENTO ******************************\\
    //*********************************************************************************\\

    /**
     * Mét0do para obtener el menú de documentos.
     * @return Devuelve un 'String' que contiene el menú de documentos.
     */
    private static String menuDocumento(){
        return """
                Ingrese el tipo de documentación del empleado:
                    1. Pasaporte
                    2. NIF
                    3. NIE
                """;
    }

    /**
     * Mét0do para solicitar el documento del empleado, se puede elegir si introducir un pasaporte, un NIE o un NIF.
     * @return Devuelve el documento como un 'String' ya validado.
     */
    public static String solicitarDocumento(){
        final int TIPO_DOCUMENTO = IO.solicitarInt(menuDocumento(),1,3);
        switch (TIPO_DOCUMENTO){
            case 1 -> {
                return solicitarPasaporte();
            }
            case 2 -> {
                return solicitarNIF();
            }
            case 3 -> {
                return solicitarNIE();
            }
            default -> throw new NoSuchElementException("Se ha introducido una entrada inesperada en el menú del documento.");
        }
    }

    /**
     * Mét0do para solicitar un pasaporte verificando el formato.
     * @return Devuelve un pasaporte verificado.
     */
    private static String solicitarPasaporte(){
        boolean cerrar=false;
        String pasaporte=null;
        do {
            try {
                pasaporte = IO.solicitarString("Ingrese el pasaporte del empleado (LLLNNNNNN): ",9,9).toUpperCase();
                for (int i = 0; i < pasaporte.length(); i++) {
                    if (i<4) {
                        if (!Character.isLetter(pasaporte.charAt(i))){
                            throw new InvalidNameException("El formato es incorrecto, los tres primeros caracteres han de ser letras.");
                        }
                    } else {
                        if (!Character.isDigit(pasaporte.charAt(i))){
                            throw new InvalidNameException("El formato es incorrecto, los seis últimos caracteres han de ser números.");
                        }
                    }
                }
                cerrar=true;
            } catch (InvalidNameException ine) {
                System.out.println(ine.getMessage());
            }
        } while (!cerrar);
        return pasaporte;
    }

    /**
     * Mét0do para solicitar un NIF verificando el formato.
     * @return Devuelve un NIF verificado.
     */
    private static String solicitarNIF(){
        boolean cerrar=false;
        String nif=null;
        do {
            try {
                nif = IO.solicitarString("Ingrese el NIF del empleado (NNNNNNNNL): ",9,9).toUpperCase();
                for (int i = 0; i < nif.length(); i++) {
                    if (i<9) {
                        if (!Character.isDigit(nif.charAt(i))){
                            throw new InvalidNameException("El formato es incorrecto, los ocho primeros caracteres han de ser números.");
                        }
                    } else {
                        if (!Character.isLetter(nif.charAt(i))){
                            throw new InvalidNameException("El formato es incorrecto, el último caracter ha de ser una letra.");
                        }
                    }
                }
                cerrar=true;
            } catch (InvalidNameException ine) {
                System.out.println(ine.getMessage());
            }
        } while (!cerrar);
        return nif;
    }

    /**
     * Mét0do para solicitar un NIE verificando el formato.
     * @return Devuelve un NIE verificado.
     */
    private static String solicitarNIE(){
        boolean cerrar=false;
        char aux;
        String nie=null;
        do {
            try {
                nie = IO.solicitarString("Ingrese el NIE del empleado (LNNNNNNNL): ",9,9).toUpperCase();
                for (int i = 0; i < nie.length(); i++) {
                    if (i==1){
                        aux = nie.charAt(i);
                        if (aux!='X'&&aux!='Y'&&aux!='Z'){
                            throw new InvalidNameException("El formato es incorrecto, el primer caracter tiene que ser una de las siguientes letras: X - Y - Z");
                        }
                    } else if (i<9) {
                        if (!Character.isDigit(nie.charAt(i))){
                            throw new InvalidNameException("El formato es incorrecto, todo han de ser números excepto el primer y el último caracter.");
                        }
                    } else {
                        if (!Character.isLetter(nie.charAt(i))){
                            throw new InvalidNameException("El formato es incorrecto, el último caracter ha de ser una letra.");
                        }
                    }
                }
                cerrar=true;
            } catch (InvalidNameException ine) {
                System.out.println(ine.getMessage());
            }
        } while (!cerrar);
        return  nie;
    }
}
