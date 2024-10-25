package com.lukalopez.tema04.Metodos;

public class Ejercicio13 {
    /**
     * Solicita el nombre del usuario, su idioma y lo saluda.
     *
     * @param idioma Idioma en el que se desea saludar: 'CASTELLANO' 'VALENCIANO' 'INGLES'.
     * @param nombre Nombre del individuo a saludar.
     * @return Devuelve un 'String
     */
    private static String saludar(String idioma,String nombre){
        switch (idioma){
            case "CASTELLANO":
                return "Buenos días "+nombre;
            case "VALENCIANO":
                return "Bon dia "+nombre;
            case "INGLES":
                return "Good morning "+nombre;
            default:
                return null;
        }
    }

    public static void main(String args[]){
        System.out.println(saludar("INGLES", "Luka"));
    }
}
