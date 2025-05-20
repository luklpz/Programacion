package com.lukalopez.tema11;

import java.io.*;

public class CatWithBuffer {
    public static void main(String[] args) {
        if (args.length!=1) {
            //throw new RuntimeException("Debe indicar la ruta del archivo.");
            System.out.println("Debe indicar la ruta del archivo.");
            System.exit(-1);
        }
        String rutaArchivo = args[0];
        File file = new File(rutaArchivo);
        try (
                FileReader fileReader = new FileReader(file);
                BufferedReader br = new BufferedReader(fileReader)

        ) {
            String linea;
            while ((linea = br.readLine()) != null){
                System.out.println(linea);
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("El archivo no existe.");
            System.exit(-1);
        } catch (IOException ioe){
            System.out.println("Error de lectura.");
            System.exit(-1);
        }
    }
}
