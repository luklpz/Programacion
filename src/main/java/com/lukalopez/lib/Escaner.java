package com.lukalopez.lib;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Escaner {

//******************************** ESCANERES ********************************\\

    /**
     * Utiliza el 'Scanner' estático 'lector' y, en caso de no estar inicializado, lo inicializa.
     * 'lector' lee de System.in
     */
    public final static Scanner lector = new Scanner(System.in);

    /**
     *Mét0do para crear un 'Scanner' estático dentro del 'archivo'.
     *
     * @param archivo Es el archivo que se proporciona.
     * @return Devuelve un 'Scanner' estático dentro de 'archivo'.
     * @throws FileNotFoundException Error que se lanza si no se encuentra archivo.
     */
    private static Scanner lectorFile(File archivo) throws FileNotFoundException {
        return new Scanner(archivo);
    }


//******************************** DISPOSE ********************************\\

    /**
     * Cierra el 'Scanner' llamado 'archivoScanner' en el archivo donde se ha inicializado.
     *
     * @param archivoScanner Es el 'Scanner' creado para leer el archivo.
     * @return Devuelve 'true' si se ha completado el cierre del 'Scanner'
     */
    public static boolean dispose(Scanner archivoScanner) {
        if (archivoScanner != null) {
            archivoScanner.close();
            return true;
        }
        return true;
    }

    /**
     * Cerrar el 'Scanner' estático 'lector'.
     */
    public static boolean dispose(){
        return dispose(lector);
    }

//******************************** LECTURA ********************************\\

    /**
     * Mét0do para obtener el texto que contiene un archivo.
     *
     * @param archivo Es el archivo que se proporciona.
     * @return Devuelve el contenido del archivo como un 'String'.
     * @throws FileNotFoundException Error que se lanza si no se encuentra archivo.
     */
    public static String leerArchivo(File archivo) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        //Abrimos el 'Scanner' en el archivo
        Scanner lectorArchivo = Escaner.lectorFile(archivo);

        // Leemos el archivo línea por línea usando el nuevo Scanner
        while (lectorArchivo.hasNextLine()) {
            sb.append(lectorArchivo.nextLine()).append("\n");
        }

        //Cerramos el 'Scanner' que hemos abierto en el archivo
        dispose(lectorArchivo);

        //Devolvemos el texto
        return sb.toString();
    }
}
