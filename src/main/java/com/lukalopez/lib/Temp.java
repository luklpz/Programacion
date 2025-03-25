package com.lukalopez.lib;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Temp {

    public static void sleep(int timeAmount){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
            System.err.println(ie.getMessage());
            ie.printStackTrace();
        }
    }

    public static void excEscaner(int min, int max){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dime un número: ");
        boolean valido = false;
        try {
            int numero = scanner.nextInt();
            valido = numero >=min && numero<=max;
        } catch (InputMismatchException ime) {
            System.out.println("Solo números por favor");
        } catch (NoSuchElementException nsee){

        } catch (NumberFormatException ise){

        }
    }
}
