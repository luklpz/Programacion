package com.lukalopez;

import java.util.Random;


public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        int zero=0;
        int uno=0;
        int dos=0;
        int tres=0;

        int aux;

        for (int i = 0; i < 1000; i++) {
            aux = random.nextInt(0,3);
            switch (aux){
                case 0 -> zero++;
                case 1 -> uno++;
                case 2 -> dos++;
                case 3 -> tres++;
            }
        }
        System.out.print("Zero: "+zero+"\nUno: "+uno+"\nDos: " + dos + "\nTres: " + tres);
    }
}