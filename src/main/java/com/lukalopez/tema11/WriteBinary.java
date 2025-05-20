package com.lukalopez.tema11;

import java.io.*;

public class WriteBinary {
    private static final String FILE_PATH = "C:\\Users\\lukal\\Documents\\FP_DAM\\Programacion\\src\\main\\java\\com\\lukalopez\\tema11\\Cat.bin";
    public static void main(String[] args) {
        if (args.length!=1) {
            //throw new RuntimeException("Debe indicar la ruta del archivo.");
            System.out.println("Debe indicar el número a guardar: ");
            System.exit(-1);
        }
        int numero = 0;
        try {
            numero = Integer.parseInt(args[0]);
        } catch (NumberFormatException nfe){
            System.out.println("Sólo números por favor");
            System.exit(-1);
        }

        File file = new File(FILE_PATH);
        byte b0 = (byte) (numero & 0xFF);
        byte b1 = (byte) (numero & 0x0000FF00>>8);
        byte b2 = (byte) (numero & 0x0000FF00>>16);
        byte b3 = (byte) (numero & 0x0000FF00>>24);

        try (FileOutputStream fos = new FileOutputStream(args[0])) {
            fos.write(numero);
        } catch (FileNotFoundException fnfe) {
            System.out.println("El archivo no existe.");
            System.exit(-1);
        } catch (IOException ioe){
            System.out.println("Error de lectura.");
            System.exit(-1);
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            System.out.println(dis.readInt());
        } catch (IOException io){

        }
    }
}
