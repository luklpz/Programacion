package com.lukalopez.lib;
import java.util.Scanner;

public class Escaner {
    public static Scanner lector = new Scanner(System.in);
    public static void dispose(){
        lector.close();
    }
}
