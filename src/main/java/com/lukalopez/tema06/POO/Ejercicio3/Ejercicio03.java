package com.lukalopez.tema06.POO.Ejercicio3;

import com.lukalopez.lib.Excepciones.InvalidEmptyException;
import com.lukalopez.lib.IO;
import com.lukalopez.tema06.POO.Ejercicio3.Exceptions.DuplicatedUniqueEntryException;
import com.lukalopez.tema06.POO.Ejercicio3.Exceptions.NumberValueOutOfBoundsException;
import com.lukalopez.tema06.POO.Ejercicio3.utils.Ansi;
import com.lukalopez.tema06.POO.Ejercicio3.utils.Lib;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


/**
 * <p>Tema 6 POO</p>
 * <p>Ejercicio 3</p>
 * <p>
 * Crea un programa para gestionar alumnos. De cada alumno se desea saber:
 * </p>
 * <p>
 * a) nia (número de identificación del alumno)
 * </p>
 * <p>
 * b) nombre
 * </p>
 * <p>
 * c) apellidos
 * </p>
 * <p>
 * d) fecha de nacimiento
 * </p>
 * <p>
 * e) grupo al que pertenece
 * </p>
 * <p>
 * e) teléfono de contacto
 * </p>
 * <p>
 * El programa deberá presentar un menú que permita gestionar alumnos similar al siguiente:
 * </p>
 * <pre>
 *     *********************
 *     ** GESTIÓN ALUMNOS **
 *     *********************
 *     1. Nuevo alumno …
 *     2. Baja de alumno …
 *     3. Consultas …
 *     ---------------------
 *     0. Salir
 * </pre>
 * <pre>
 *    ◦ Nuevo alumno. Solicitará los datos del alumno, los validará y lo creará. ¡CUIDADO! No puede haber dos alumnos con el mismo nia.
 *    ◦ Baja de alumno. Solicitará el nia del alumno, si el nia corresponde a un alumno existente en el sistema, solicitará un mensaje de confirmación para borrarlo, en caso de confirmación positiva finalmente será borrado.
 *    ◦ Buscar alumnos. Mostrará el siguiente submenú:
 *      ***************
 *      ** CONSULTAS **
 *      ***************
 *      1. Por grupo …
 *      2. Por edad ...
 *      3. Por nia ...
 *      4. Por apellidos …
 *      --------------------
 *      0. Volver al menú principal
 * </pre>
 * <p>Puedes ver enunciado completo del ejercicio en el boletín</p>
 * <p>License: 🅮 Public Domain</p>
 * @author Germán Gascón <ggascon@gmail.com>
 * @version 0.4, 2025-01-18
 * @since 0.1
 */
public class Ejercicio03 {
    private static final int MAX_ALUMNOS = 100;
    private static final int MAX_GRUPOS = 10;
    private final Scanner lector;
    private final CentroEducativoC centroEducativo;

    public Ejercicio03() {
        lector = new Scanner(System.in);
        int opcion;
        centroEducativo = new CentroEducativoC("46000001", MAX_ALUMNOS, MAX_GRUPOS);
        do {
            opcion = menuPrincipal();
            switch (opcion) {
                case 1 -> nuevoAlumno();
                case 2 -> bajaAlumno();
                case 3 -> consultas();
                case 0 -> System.out.println("Hasta pronto!");
            }
        } while (opcion != 0);
    }

    private void nuevoAlumno() {
        boolean validado = false;
        int nia = 0;
        String nombre = null;
        String apellidos = null;
        String fechaNacimientoString;
        LocalDate fechaNacimiento = null;
        Grupo grupo = null;
        long telefono = 0;
        Ansi.clearScreen();
        System.out.println("*** NUEVO ALUMNO ***" );
        String entrada;
        do {
            try {
                System.out.println("Nia: ");
                entrada = lector.nextLine();
                IO.isBlankCheck(entrada);
                nia = Integer.parseInt(entrada);

                validado = nia > CentroEducativoC.MIN_NIA && nia < CentroEducativoC.MAX_NIA;
                if (!validado) {
                    throw new NumberValueOutOfBoundsException(String.format("Nia debe estar comprendido en el rango [%d, %d]\n", CentroEducativoC.MIN_NIA, CentroEducativoC.MAX_NIA));

                }
                /* Comprobamos que dicho NIA no esté duplicado */
                validado = centroEducativo.buscarAlumnoPorNia(String.valueOf(nia)) == null;
                if (!validado) {
                    throw new DuplicatedUniqueEntryException("El nia introducido ya corresponde a un alumno.\nIntroduzca otro por favor");
                }
            } catch (NumberValueOutOfBoundsException nvoobe) {
                System.out.println(nvoobe.getMessage());
                Lib.pause();
            } catch (InvalidEmptyException iee){
                System.out.println(iee.getMessage());
                Lib.pause();
            } catch (NumberFormatException nfe){
                System.out.println(nfe.getMessage());
                Lib.pause();
            } catch (DuplicatedUniqueEntryException duee){
                System.out.println(duee.getMessage());
                Lib.pause();
            }
        } while (!validado);

        do {
            try {
                System.out.println("Nombre: ");
                nombre = lector.nextLine();
                IO.isBlankCheck(nombre);
                validado = nombre.length() > 2;
                if (!validado) {
                    throw new NumberValueOutOfBoundsException("Nombre debe tener almenos 2 caracteres");
                }
            } catch(InvalidEmptyException iee){
                System.out.println(iee.getMessage());
                Lib.pause();
            } catch (NumberValueOutOfBoundsException nvoobe){
                System.out.println(nvoobe.getMessage());
                Lib.pause();
            }
        } while (!validado);

        do {
            try {
                System.out.println("Apellidos: ");
                apellidos = lector.nextLine();
                IO.isBlankCheck(apellidos);
                validado = apellidos.length() > 2;
                if (!validado) {
                    throw new NumberValueOutOfBoundsException("Apellidos debe tener almenos 2 caracteres");
                }
            } catch(InvalidEmptyException iee){
                System.out.println(iee.getMessage());
                Lib.pause();
            } catch (NumberValueOutOfBoundsException nvoobe){
                System.out.println(nvoobe.getMessage());
                Lib.pause();
            }
        } while (!validado);

        do {
            try {
                System.out.println("Fecha nacimiento (dd-mm-yyyy): ");
                fechaNacimientoString = lector.nextLine();
                IO.isBlankCheck(fechaNacimientoString);

                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                fechaNacimiento = LocalDate.parse(fechaNacimientoString, dateTimeFormatter);
                validado = true;
            } catch(InvalidEmptyException iee){
                System.out.println(iee.getMessage());
                Lib.pause();
            } catch (DateTimeParseException dtpe) {
                validado = false;
                System.out.println("El formato de la fecha de nacimiento no es válido. Recuerde (dd-mm-yyyy).");
                Lib.pause();
            }
        } while (!validado);

        do {
            try {
                mostrarGrupos();
                System.out.println("Código del grupo: ");
                entrada = lector.nextLine();
                IO.isBlankCheck(entrada);
                int codigo = Integer.parseInt(entrada);
                /* Buscamos que el código que ha introducido el usuario corresponde a un grupo válido */
                /* En caso afirmativo lo asignamos */
                grupo = centroEducativo.buscarGrupoPorCodigo(codigo);
                validado = grupo != null;
                if (!validado) {
                    throw new NumberValueOutOfBoundsException("El código de grupo indicado corresponde a ningún grupo");
                }
            } catch (InvalidEmptyException iee){
                System.out.println(iee.getMessage());
            } catch (NumberValueOutOfBoundsException nvoobe){
                System.out.println(nvoobe.getMessage());
            } catch (NumberFormatException nfe){
                System.out.println(nfe.getMessage());
            }
        } while (!validado);

        do {
            try {
                System.out.println("Teléfono: ");
                entrada = lector.nextLine();
                IO.isBlankCheck(entrada);
                telefono = Long.parseLong(entrada);
                /* Para facilitar la introducción de datos permitimos poner números pequeños como teléfono */
                validado = telefono > CentroEducativoC.MIN_TELEFONO && telefono < CentroEducativoC.MAX_TELEFONO;
                if (!validado){
                    throw new NumberValueOutOfBoundsException(String.format("El telefono debe estar comprendido en el rango [%d, %d]\n",CentroEducativoC.MIN_TELEFONO,CentroEducativoC.MAX_TELEFONO));
                }
            } catch (NumberValueOutOfBoundsException nvoobe){
                System.out.println(nvoobe.getMessage());
            } catch (InvalidEmptyException iee) {
                System.out.println(iee.getMessage());
            } catch (NumberFormatException nfe){
                System.out.println(nfe.getMessage());
            }
        } while (!validado);

        // Hemos validado todos los datos, podemos proceder a dar de alta el alumno
        if (centroEducativo.nuevoAlumno(String.valueOf(nia), nombre, apellidos, fechaNacimiento, grupo, String.valueOf(telefono))) {
            System.out.println("Alumno guardado correctamente");
        } else {
            System.out.println("Imposible añadir el alumno.");
            System.out.println("El array de alumnos está lleno");
        }
        Lib.pause();
    }

    private void bajaAlumno() {
        String nia;
        Ansi.clearScreen();
        System.out.println("*** BAJA ALUMNO ***" );
        nia =IO.solicitarString("Nia: ");
        if (centroEducativo.bajaAlumno(nia)) {
            System.out.println("Alumno borrado correctamente");
        } else {
            System.out.println("No existe ningún alumno con el nia " + nia);
        }
        Lib.pause();
    }

    private void consultas() {
        int opcion;
        do {
            opcion = menuConsultas();
            switch (opcion) {
                case 1 -> {
                    //Por grupo
                    buscarAlumnosPorGrupo();
                    Lib.pause();
                }
                case 2 -> {
                    //Por edad
                    buscarAlumnosPorEdad();
                    Lib.pause();
                }
                case 3 -> {
                    //Por nia
                    buscarAlumnoPorNia();
                    Lib.pause();
                }
                case 4 -> {
                    //Por apellidos
                    buscarAlumnosPorApellidos();
                    Lib.pause();
                }
                case 5 -> {
                    mostrarAlumnos();
                    Lib.pause();
                }
            }
        } while (opcion != 0);
    }

    private void mostrarGrupos() {
        System.out.println("Grupos disponibles");
        System.out.println(centroEducativo.listadoGrupos());
    }

    private void buscarAlumnosPorGrupo() {
        int codigo;
        Alumno[] alumnosGrupo;
        mostrarGrupos();
        System.out.println("Código del grupo: ");
        codigo = Integer.parseInt(lector.nextLine());
        alumnosGrupo = centroEducativo.buscarAlumnosPorGrupo(codigo);
        if (alumnosGrupo != null) {
            for (Alumno alumno : alumnosGrupo) {
                System.out.println(alumno.toString());
            }
        } else {
            System.out.println("No se han encontrado alumnos del grupo con código " + codigo);
        }
    }

    private void buscarAlumnosPorEdad() {
        int edad;
        Alumno[] alumnosEdad;
        System.out.println("Edad: ");
        edad = Integer.parseInt(lector.nextLine());
        alumnosEdad = centroEducativo.buscarAlumnosPorEdad(edad);
        if (alumnosEdad != null) {
            for (Alumno alumno : alumnosEdad) {
                System.out.println(alumno.toString());
            }
        } else {
            System.out.println("No se han encontrado alumnos que tengan " + edad + " años");
        }
    }

    private void buscarAlumnoPorNia() {
        String nia;
        System.out.println("Nia: ");
        nia = lector.nextLine();
        Alumno alumno = centroEducativo.buscarAlumnoPorNia(nia);
        if (alumno != null) {
            System.out.println(alumno);
        } else {
            System.out.println("No se ha encontrado ningún alumno con el nia " + nia);
        }
    }

    private void buscarAlumnosPorApellidos() {
        String apellidos;
        Alumno[] alumnosApellidos;
        System.out.println("Apellidos: ");
        apellidos = lector.nextLine();
        alumnosApellidos = centroEducativo.buscarAlumnosPorApellidos(apellidos);
        if (alumnosApellidos != null) {
            for (Alumno alumno : alumnosApellidos) {
                System.out.println(alumno.toString());
            }
        } else {
            System.out.println("No se han encontrado alumnos que tengan " + apellidos + " como apellidos");
        }
    }

    private void mostrarAlumnos() {
        System.out.println("Alumnos disponibles: ");
        System.out.println(centroEducativo.listadoAlumnos());
    }

    private int menuPrincipal() {
        int opcion = -1;
        String entrada;
        do {
            try {
                Ansi.clearScreen();
                System.out.println("*********************");
                System.out.println("** GESTIÓN ALUMNOS **");
                System.out.println("*********************");
                System.out.println("1. Nuevo alumno...");
                System.out.println("2. Baja de alumno...");
                System.out.println("3. Consultas...");
                System.out.println("---------------------");
                System.out.println("0. Salir\n");
                System.out.println("Elija una opción: ");

                entrada = lector.nextLine();
                IO.isBlankCheck(entrada);
                opcion = Integer.parseInt(entrada);
                if (opcion < 0 || opcion > 3) {
                    throw new NumberValueOutOfBoundsException("Elija una opción del menú [0-3]");
                }
            } catch (NumberValueOutOfBoundsException nvoobe){
                System.out.println(nvoobe.getMessage());
                Lib.pause();
            } catch (NumberFormatException nfe){
                System.out.println("Solo se aceptan números.");
            } catch (InvalidEmptyException iee) {
                System.out.println(iee.getMessage());
            }
        } while (opcion < 0 || opcion > 3);
        return opcion;
    }

    private int menuConsultas() {
        int opcion = -1;
        do {
            Ansi.clearScreen();
            System.out.println("***************");
            System.out.println("** CONSULTAS **");
            System.out.println("****************");
            System.out.println("1. Por grupo...");
            System.out.println("2. Por edad...");
            System.out.println("3. Por nia...");
            System.out.println("4. Por apellidos...");
            // Aunque no lo pide el ejercicio, añadimos la opción de mostrar todos para facilitar las pruebas
            System.out.println("5. Mostrar todos...");
            System.out.println("----------------");
            System.out.println("0. Volver al menú principal\n");
            System.out.println("Elija una opción: ");
            opcion = Integer.parseInt(lector.nextLine());
            if (opcion < 0 || opcion > 5) {
                System.out.println("Elija una opción del menú [0-5]");
                Lib.pause();
            }
        } while (opcion < 0 || opcion > 5);
        return opcion;
    }
}
