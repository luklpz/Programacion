package com.lukalopez.tema11;

import java.io.*;

public class CatConBuffer {
    private static final String FILE_PATH = "C:\\Users\\lukal\\Documents\\FP_DAM\\Programacion\\src\\main\\java\\com\\lukalopez\\tema11\\Cat.txt";
    public static void main(String[] args) {
        if (args.length!=1) {
            //throw new RuntimeException("Debe indicar la ruta del archivo.");
            System.out.println("Debe indicar el texto aa guardar");
            System.exit(-1);
        }
        File file = new File(FILE_PATH);
        boolean append = file.exists();
        String texto  = args[0];
        try (
                FileWriter fileWriter = new FileWriter(file, append);
                BufferedWriter bw = new BufferedWriter(fileWriter)
        ) {
            bw.write(texto);
        } catch (FileNotFoundException fnfe) {
            System.out.println("El archivo no existe.");
            System.exit(-1);
        } catch (IOException ioe){
            System.out.println("Error de lectura.");
            System.exit(-1);
        }
    }
}
