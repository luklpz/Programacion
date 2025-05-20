package com.lukalopez.lib;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Fichero {

    /**
     * Mét0do para leer archivos que contienen texto.
     * @param file Archivo que se desea leer.
     * @return Devuelve un 'String' que contiene el contenido del archivo de texto.
     */
    public static String leerArchivoTexto(File file) {
        StringBuilder contenido = new StringBuilder();
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            int c;
            while ((c = fr.read()) != -1) {
                contenido.append((char) c);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo.");
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                System.err.println("Error al cerrar el file reader.");
            }
        }
        return contenido.toString();
    }

    /**
     * Mét0do para leer archivos que contienen binario.
     * @param file Archivo que se desea leer.
     * @return Devuelve un 'String' que contiene el contenido del archivo de binarios como texto.
     */
    public static String leerArchivoBinario(File file) {
        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] bytes = linea.trim().split("\\s+");
                for (String bin : bytes) {
                    if (bin.length() == 8) {
                        int charCode = Integer.parseInt(bin, 2);
                        sb.append((char) charCode);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al obtener los binarios.");
        }
        return sb.toString();
    }

    /**
     * Mét0do para escribir texto en un archivo.
     * @param file Archivo en el que se desea escribir.
     * @return Devuelve 'true' si la escritura se ha completado satisfactoriamente.
     */
    public static boolean escribirArchivoTexto(String texto, boolean sustituir, File file) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(file, !sustituir);  // si sustituir==false, abrimos en modo append (añadir)
            fw.write(texto);
            return true;
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo.");
            return false;
        } finally {
            try {
                if (fw != null) fw.close();
            } catch (IOException e) {
                System.err.println("Error al cerrar el file writer stream.");
            }
        }
    }

    /**
     * Mét0do para escribir binario en un archivo.
     * @param file Archivo que se desea escribir.
     * @return Devuelve 'true' si la escritura se ha completado satisfactoriamente.
     */
    public static boolean escribirArchivoBinario(String texto,boolean sustituir, File file) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, !sustituir))) {
            for (char c : texto.toCharArray()) {
                StringBuilder binario = new StringBuilder(8);
                for (int i = 7; i >= 0; i--) {
                    int bit = (c >> i) & 1;
                    binario.append(bit);
                }
                bw.write(binario.toString());
                bw.write(' ');
            }
            return true;
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo.");
            return false;
        }
    }
}

