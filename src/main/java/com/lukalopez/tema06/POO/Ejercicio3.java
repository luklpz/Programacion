package com.lukalopez.tema06.POO;

import com.lukalopez.lib.FH;
import com.lukalopez.lib.IO;

import java.time.LocalDate;

public class Ejercicio3 {
    private enum Grupo {
        DAM, DAW, ASIR
    }

    public static class Alumno {
        private String nia;
        private String nombre;
        private String apellidos;
        private LocalDate fechaNacimiento;
        private Grupo grupo;
        private String telefono;

        public Alumno(String nia, String nombre, String apellidos, LocalDate fechaNacimiento, Grupo grupo, String telefono) {
            this.nia = nia;
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.fechaNacimiento = fechaNacimiento;
            this.grupo = grupo;
            this.telefono = telefono;
        }

        public String getNia() {
            return nia;
        }

        public void setNia(String nia) {
            this.nia = nia;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellidos() {
            return apellidos;
        }

        public void setApellidos(String apellidos) {
            this.apellidos = apellidos;
        }

        public LocalDate getFechaNacimiento() {
            return fechaNacimiento;
        }

        public void setFechaNacimiento(LocalDate fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
        }

        public Grupo getGrupo() {
            return grupo;
        }

        public void setGrupo(Grupo grupo) {
            this.grupo = grupo;
        }

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        @Override
        public String toString() {
            return "Alumno:" +
                    "\n  NIA = " + nia +
                    "\n  Nombre = " + nombre +
                    "\n  Apellidos = " + apellidos +
                    "\n  Fecha de nacimiento = " + fechaNacimiento +
                    "\n  Grupo = " + grupo +
                    "\n  Telefono = " + telefono +
                    '\n';
        }
    }

    protected static Alumno[] arrayAlumnos = new Alumno[100];

    /********************************************************************************************************************************\

     /**
     * Mét0do que genera el menú de gestión.
     * @return Devuelve el menú de gestión listo para imprimir.
     */
    private static String menuGestion() {
        return "\n*********************\n** GESTIÓN ALUMNOS **\n*********************\n1. Nuevo alumno...\n2. Baja de alumno...\n3. Consultas...\n------------------------------\n0. Salir\n";
    }

    /**
     * Mét0do que genera el menú de consultas.
     *
     * @return Devuelve el menú de consultas listo para imprimir.
     */
    private static String menuConsultas() {
        return "\n***************\n** CONSULTAS **\n***************\n1. Por grupo...\n2. Por edad...\n3. Por nia...\n4. Por apellidos ...\n--------------------\n0. Volver al menú principal\n\n";
    }

    private static void gestion(int opcionMenu) {
        switch (opcionMenu) {
            case 1 -> {
                int ultimaPosicion = ultimaPosicion();
                if (ultimaPosicion != -1) {
                    arrayAlumnos[ultimaPosicion] = nuevoAlumno();
                } else {
                    System.err.println("ERROR: La lista de alumnos está llena");
                }
            }
            case 2 ->bajaDeAlumno();
            //case 3
            default -> System.out.println("ERROR: Entrada inesperada.");
        }
    }

    private static int ultimaPosicion() {
        for (int i = 0; i < arrayAlumnos.length; i++) {
            if (arrayAlumnos[i] == null) {
                return i;
            }
        }
        return -1;
    }

    /********************************************************************************************************************************/

    private static Alumno nuevoAlumno() {
        //Solicitamos las variables
        String nia;
        String nombre;
        String apellidos;
        LocalDate fechaDeNacimiento;
        Grupo grupo;
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

    private static String solicitudNia(){
        boolean validado;
        String nia;
        do {
            nia = IO.solicitarString("\nNIA del alumno: ",8,8,"El NIA tiene una longitud de 8 caracteres.");
            validado = IO.solicitarBoolean(String.format("El NIA es \"%s\" ¿Es correcto? (Si/No)\n",nia),"Si","No","ERROR: Respuesta inválida.\n\n");
        } while (!validado);
        return nia;
    }

    private static String solititudNombre(){
        boolean validado;
        String nombre;
        do {
            nombre = IO.solicitarString("\nNombre del alumno: ",false);
            validado = IO.solicitarBoolean(String.format("El nombre es \"%s\" ¿Es correcto? (Si/No)\n",nombre),"Si","No","ERROR: Respuesta inválida.\n\n");
        } while (!validado);
        return nombre;
    }

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

    private static LocalDate solicitudFechaDeNacimiento(){
        boolean validado;
        LocalDate fechaDeNacimiento;
        do {
            fechaDeNacimiento = FH.solicitarFecha("\nFecha de nacimiento del alumno: (DD/MM/YYYY)","dd/MM/yyyy");
            validado = IO.solicitarBoolean(String.format("La fecha de nacimiento es \"%s\" ¿Es correcto? (Si/No)\n",FH.formatearFecha(fechaDeNacimiento,"dd/MM/yyyy")),"Si","No","ERROR: Respuesta inválida.\n\n");
        } while (!validado);
        return fechaDeNacimiento;
    }

    private static Grupo solicitudGrupo(){
        boolean validado;
        Grupo grupo;
        int seleccion;
        do {
            System.out.printf("******\n 1 - %s\n 2 - %s\n 3 - %s\n******\n",Grupo.DAM,Grupo.DAW,Grupo.ASIR);
            seleccion = IO.solicitarInt("\nIngrese el número del grupo al que pertenece el alumno: ");
            switch (seleccion){
                case 1 -> grupo = Grupo.DAM;
                case 2 -> grupo = Grupo.DAW;
                case 3 -> grupo = Grupo.ASIR;
                default -> {
                    System.err.print("ERROR: Entrada inesperarda.");
                    grupo = Grupo.DAM;
                }
            }
            validado = IO.solicitarBoolean(String.format("El grupo es \"%s\" ¿Es correcto? (Si/No)\n",grupo),"Si","No","ERROR: Respuesta inválida.\n\n");
        } while (!validado);
        return grupo;
    }

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
    public static void bajaDeAlumno(){
        String nia = solicitudNia();
        for (int i = 0; i < arrayAlumnos.length; i++) {
            if (arrayAlumnos[i].nia.equals(nia)) {
                arrayAlumnos[i]=null;
                return;
            }
        }
        System.out.println();
    }
    //********************************************************************************************************************************/

    /********************************************************************************************************************************/
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
                gestion(opcionMenu);
            } else {
                System.out.println("Cerrando programa . . .");
            }
        } while (opcionMenu!=0);
    }
}
