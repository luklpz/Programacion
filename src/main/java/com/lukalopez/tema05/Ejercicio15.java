package com.lukalopez.tema05;

public class Ejercicio15 {

    private static String rectangulo(int anchura, int altura, char contenido){
        StringBuilder figura = new StringBuilder();
        for (int i=0;i<altura;i++){
            for (int j=0;j<anchura;j++){
                figura.append(contenido);
            }
            figura.append('\n');
        }
        return figura.toString();
    }

    public static void main(String args[]){
        System.out.println(rectangulo(10,4,'0'));
    }
}
