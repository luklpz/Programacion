package com.lukalopez;

import com.lukalopez.lib.Fichero;


import java.io.File;

public class Main {
    public static void main(String[] args) {
        System.out.println(Fichero.leerArchivoBinario(new File("C:\\Users\\lukal\\Documents\\FP_DAM\\Programacion\\src\\main\\java\\com\\lukalopez\\tema11\\hola.txt")));
    }
}