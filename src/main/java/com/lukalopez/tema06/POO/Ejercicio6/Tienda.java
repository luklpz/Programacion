package com.lukalopez.tema06.POO.Ejercicio6;

import com.lukalopez.lib.IO;

public class Tienda {

    /**
     * Mét0do para invocar el menú de gestión de la tienda.
     * @return Devuelve un 'String' que contiene el menú de gestión de la tienda listo para imprimir.
     */
    public static String menuTienda(){
        return  "\u001b[1;34m-------------------------------------\n" +
                "|     *************************     |\n" +
                "|    ** \u001b[0mGESTIÓN DE BICICLETAS\u001b[1;34m **    |\n" +
                "|     *************************     |\n" +
                "|       \u001b[0m1.- Añadir bicicleta ...\u001b[1;34m    |\n" +
                "|       \u001b[0m2.- Vender bicicleta ...\u001b[1;34m    |\n" +
                "|       \u001b[0m3.- Consultar bicicleta ...\u001b[1;34m |\n" +
                "|       \u001b[0m4.- Mostrar stock\u001b[1;34m           |\n" +
                "-------------------------------------\n" +
                "        \u001b[0m0.- Salir\u001b[1;34m\n\n" +
                " Opción seleccionada: ";
    }

    public boolean ejecutarMenu(){
        //Definimos las variables
        int respuesta;

        do {
            respuesta = IO.solicitarInt(menuTienda(),0,4);
            switch (respuesta) {
                case 1 -> {

                }
                case 2 -> {

                }
                case 3 -> {

                }
                case 4 -> {

                }
                default -> {}
            }
        } while (respuesta==0);
        return true;
    }

    public static void main(String[] args) {
        System.out.println(menuTienda());
    }
}
