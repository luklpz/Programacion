package com.lukalopez.tema06.POO.Ejercicio3;

import com.lukalopez.tema06.POO.Ejercicio3.utils.Lib;
import net.datafaker.Faker;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Locale;

/**
 * La implementación de CentroEducativo podemos abordarla con dos estrategias bien diferenciadas:
 * - Opción A) Al borrar un alumno, trasladamos el último a la posición del alumno borrado y
 *   decrementamos el contador de alumnos. Esta opción es útil si no necesitamos el que array
 *   de alumnos esté ordenado.
 *   * Ventajas: borrado e inserción rápidos
 *   * Desventajas: no es posible optimizar las búsquedas al no tener ordenado el array
 * - Opción B) Al borrar un alumno marcamos su posición como null, pero debemos tener en cuenta que
 *   pueden existir elementos del array a null.
 *   * Ventajas: borrado rápido.
 *   * Desventajas: búsqueda e inserción lentas. Una posible mejora es llevar la cuenta de los elementos
 *     efectivos que hay en el array.
 * - Opción C) Mantenemos ordenado el array basándonos en el nia. Al borrar un alumno desplazamos
 *   todos los que queden a la derecha del alumno borrado una posición hacia la izquierda.
 *   * Ventajas: búsquedas rápidas que podrán será óptima si se búsca por nia
 *   * Desventajas: borrado e inserción más lento al tener que mantener el orden del array.
 *  En este caso implementamos la opción C)
 **/
public class CentroEducativoC {
    public static final int MIN_NIA = 0;
    public static final int MAX_NIA = 1999999;
    public static final int MIN_TELEFONO = 0;
    public static final int MAX_TELEFONO = 999999999;

    private final String codigo;
    private final Alumno[] alumnos;
    private int contadorAlumnos;
    private final Grupo[] grupos;

    public CentroEducativoC(String codigo, int maxAlumnos, int maxGrupos) {
        this.codigo = codigo;
        alumnos = new Alumno[maxAlumnos];
        contadorAlumnos = 0;
        grupos = new Grupo[maxGrupos];
        if (Config.DEBUG) {
            generarDatosAleatorios(8);
        }
    }

    /**
     * Crea cantidadAlumnos aleatorios para poder realizar pruebas
     * No confundir con testing
     * @param cantidadAlumnos
     */
    private void generarDatosAleatorios(int cantidadAlumnos) {
        generarGruposAleatorios();
        generarAlumnosAleatorios(cantidadAlumnos);
    }

    /**
     * Crea grupos aleatorios
     */
    private void generarGruposAleatorios() {
        for (int i = 0; i < grupos.length; i++) {
            grupos[i] = new Grupo(i, "GRUPO " + i);
        }
    }

    private void generarAlumnosAleatorios(int nAlumnos) {
        for (int i = 0; i < nAlumnos; i++) {
            Alumno a = alumnoAleatorio();
            nuevoAlumno(a.getNia(), a.getNombre(), a.getApellidos(), a.getFechaNacimiento(), a.getGrupo(), a.getTelefono());
        }
    }

    private Alumno alumnoAleatorio() {
        Faker faker = new Faker(new Locale("ES"));
        String nia = String.valueOf(Lib.random(1000000, 1099999));
        String nombre = faker.name().firstName();
        String apellido1 = faker.name().lastName();
        String apellido2 = faker.name().lastName();
        LocalDate fechaActual = LocalDate.now();
        int anyoActual = fechaActual.getYear();
        LocalDate fechaNacimiento = LocalDate.of(Lib.random(anyoActual - 30, anyoActual - 20), Lib.random(1, 12), Lib.random(1,28));
        Grupo grupo = grupos[Lib.random(0, grupos.length-1)];
        String telefono = String.valueOf(Lib.random(965700000, 965799999));
        return new Alumno(nia, nombre, apellido1 + " " + apellido2, fechaNacimiento, grupo, telefono);
    }

    public String getCodigo() {
        return codigo;
    }

    /**
     * Da de alumno un nuevo alumno con los datos indicados manteniendo ordenado el array
     * @param nia Nia
     * @param nombre Nombre
     * @param apellidos Los apellidos
     * @param fechaNacimiento Fecha nacimiento
     * @param grupo Grupo
     * @param telefono Teléfono
     * @return True si se ha añadido el alumno, False en caso contrario
     */
    public boolean nuevoAlumno(String nia, String nombre, String apellidos, LocalDate fechaNacimiento, Grupo grupo, String telefono) {
        // En esta implementación (B) sabemos que la primera posición libre el la apuntada por el contadorAlumnos
        if (contadorAlumnos < alumnos.length) {
            // Buscamos la posición donde debemos insertar el alumno
            int i = 0;
            while (alumnos[i] != null && Integer.parseInt(alumnos[i].getNia()) < Integer.parseInt(nia) && i < contadorAlumnos) {
                i++;
            }
            // i contiene la posición donde debemos insertar el alumno
            // Ahora hay que hacer hueco desplazando los que están a la derecha
            hacerEspacio(i);
            alumnos[i] = new Alumno(nia, nombre, apellidos, fechaNacimiento, grupo, telefono);
            contadorAlumnos++;
            return true;
        }
        return false;
    }

    public boolean bajaAlumno(String nia) {
        int pos = buscarPosicionAlumno(nia);
        if (pos >= 0) {
            desplazar(pos);
            contadorAlumnos--;
            alumnos[contadorAlumnos] = null;
            return true;
        }
        return false;
    }

    /**
     * Desplaza los elementos del array alumnos una posición a la derecha a partir de la posición pos
     * @param pos Posición a partir de la cual se desplazarán los elementos
     */
    private void hacerEspacio(int pos) {
        if (pos < contadorAlumnos) {
            for (int i = contadorAlumnos; i > pos; i--) {
                alumnos[i] = alumnos[i - 1];
            }
        }
    }

    /**
     * Desplaza los elementos del array alumnos una posición a la izquierda a partir de la posición pos
     * @param pos Posición a partir de la cual se desplazarán los elementos
     */
    private void desplazar(int pos) {
        if (pos < contadorAlumnos) {
            for (int i = pos; i < contadorAlumnos; i++) {
                alumnos[i] = alumnos[i + 1];
            }
        }
    }

    /**
     * Busca un alumno por Nia
     * Esta versión mantiene el array ordenado por nia, por tanto podemos optimizar la búsqueda
     * @param nia
     * @return Si lo encuentra devuelve el alumno, en caso contrario devuelve null
     */
    public Alumno buscarAlumnoPorNia(String nia) {
        int posicion = buscarPosicionAlumno(nia);
        return posicion >= 0 ? alumnos[posicion] : null;
    }

    /**
     * Busca un alumno por Nia
     * @param nia
     * @return Si lo encuentra devuelve su posición, en caso contrario devuelve -1
     */
    private int buscarPosicionAlumno(String nia) {
        for (int i = 0; i < contadorAlumnos; i++) {
            String alumnoNia = alumnos[i].getNia();
            if (alumnoNia.equals(nia)) {
                return i;
            }
            // Como el array está ordenado, si el nia del alumno es mayor que el nia buscado sabemos que no está
            if (Integer.parseInt(alumnoNia) > Integer.parseInt(nia)) {
                return -1;
            }
        }
        return -1;
    }

    /**
     * Busca alumnos por Grupo
     * @param codigoGrupo
     * @return Un array con los alumnos que ha encontrado, null si no ha encontrado
     */
    public Alumno[] buscarAlumnosPorGrupo(int codigoGrupo) {
        Alumno[] alumnosGrupo = null;
        /* Lo ideal sería hacerlo con ArrayLists pero aún no los hemos visto */
        /* Calculamos primero cuantos alumnos hay que coincidan con el criterio de búsqueda */
        int nAlumnos = 0;
        for (int i = 0; i < contadorAlumnos; i++) {
            if (alumnos[i].getGrupo().getCodigo() == codigoGrupo) {
                nAlumnos++;
            }
        }
        if (nAlumnos > 0) {
            alumnosGrupo = new Alumno[nAlumnos];
            int cont = 0;
            /* Una vez sabemos el número de alumnos los asignamos al vector */
            for (int i = 0; i < contadorAlumnos; i++) {
                if (alumnos[i].getGrupo().getCodigo() == codigoGrupo) {
                    alumnosGrupo[cont] = alumnos[i];
                    // si quisiéramos devolver una copia en lugar de los originales haríamos:
                    // alumnosGrupo[cont] = new Alumno(alumnos[i]);
                    cont++;
                }
            }
        }
        return alumnosGrupo;
    }

    /**
     * Busca alumnos por Edad
     * @param edad
     * @return Un array con los alumnos que ha encontrado, null si no ha encontrado
     */
    public Alumno[] buscarAlumnosPorEdad(int edad) {
        Alumno[] alumnosEdad = null;
        /* Lo ideal sería hacerlo con ArrayLists pero aún no los hemos visto */
        /* Calculamos primero cuantos alumnos hay que coincidan con el criterio de búsqueda */
        int nAlumnos = 0;
        for (int i = 0; i < contadorAlumnos; i++) {
            if (alumnos[i].getEdad() == edad) {
                nAlumnos++;
            }
        }
        if (nAlumnos > 0) {
            alumnosEdad = new Alumno[nAlumnos];
            int cont = 0;
            /* Una vez sabemos el número de alumnos los asignamos al vector */
            for (int i = 0; i < contadorAlumnos; i++) {
                if (alumnos[i].getEdad() == edad) {
                    alumnosEdad[cont] = alumnos[i];
                    // si quisiéramos devolver una copia en lugar de los originales haríamos:
                    // alumnosEdad[cont] = new Alumno(alumnos[i]);
                    cont++;
                }
            }
        }
        return alumnosEdad;
    }

    /**
     * Busca alumnos por Apellidos
     * @param apellidos
     * @return Un array con los alumnos que ha encontrado, null si no ha encontrado
     */
    public Alumno[] buscarAlumnosPorApellidos(String apellidos) {
        Alumno[] alumnosApellidos = null;
        /* Lo ideal sería hacerlo con ArrayLists pero aún no los hemos visto */
        /* Calculamos primero cuantos alumnos hay que coincidan con el criterio de búsqueda */
        int nAlumnos = 0;
        //Convertimos a minúsculas
        apellidos = apellidos.toLowerCase();
        for (int i = 0; i < contadorAlumnos; i++) {
            if (alumnos[i].getApellidos().toLowerCase().contains(apellidos)) {
                nAlumnos++;
            }
        }
        if (nAlumnos > 0) {
            alumnosApellidos = new Alumno[nAlumnos];
            int cont = 0;
            /* Una vez sabemos el número de alumnos los asignamos al vector */
            for (int i = 0; i < contadorAlumnos; i++) {
                if (alumnos[i].getApellidos().toLowerCase().contains(apellidos)) {
                    alumnosApellidos[cont] = alumnos[i];
                    // si quisiéramos devolver una copia en lugar de los originales haríamos:
                    // alumnosApellidos[cont] = new Alumno(alumnos[i]);
                    cont++;
                }
            }
        }
        return alumnosApellidos;
    }

    /**
     * Busca el grupo código codigo
     * @param codigo
     * @return grupo o null
     */
    public Grupo buscarGrupoPorCodigo(int codigo) {
        /* Buscamos que el código que ha introducido el usuario corresponde a un grupo válido */
        /* En caso afirmativo lo asignamos */
        for (Grupo grupo : grupos) {
            if (grupo.getCodigo() == codigo) {
                return grupo;
            }
        }
        return null;
    }

    public String listadoAlumnos() {
        StringBuilder sb = new StringBuilder();
        // Mostrar todos los alumnos
        for (int i = 0; i < contadorAlumnos; i++) {
            if (alumnos[i] != null) {
                sb.append(alumnos[i].toString()).append("\n");
            }
        }
        return sb.toString();
    }

    public String listadoGrupos() {
        StringBuilder sb = new StringBuilder();
        for (Grupo grupo : grupos) {
            sb.append(grupo.toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof CentroEducativoC that)) return false;

        return codigo.equals(that.codigo);
    }

    @Override
    public int hashCode() {
        return codigo.hashCode();
    }

    @Override
    public String toString() {
        return "CentroEducativoC{" +
                "codigo='" + codigo + '\'' +
                ", alumnos=" + Arrays.toString(alumnos) +
                ", grupos=" + Arrays.toString(grupos) +
                '}';
    }
}
