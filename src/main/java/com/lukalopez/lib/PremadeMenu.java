package com.lukalopez.lib;

import java.time.format.DateTimeFormatter;

public class PremadeMenu {
    private static String menuPrincipal(){
        return """
                *---*----*---*----*---*----*---*
                |        MENU PRINCIPAL        |
                *---*----*---*----*---*----*---*
                |     1. Nuevo partido         |
                |     2. Gestion entradas      |
                |------------------------------|
                |     0. Salir                 |
                *---*----*---*----*---*----*---*
                """;
    }

    private static void ejecutarMenuPrincipal(){
        boolean salir=false;
        do {
            int entrada = 1/*SolicitarInt*/;
            switch (entrada) {
                case 1 -> /*Metodo2*/ System.out.println();
                case 2 -> /*Metodo1*/ System.out.println();
                default -> salir=true;
            }
        } while (!salir);
    }

    private static String miniMenu(){
        return """
                \n¿Cual es la afluencia del partido?
                |-----------------------|
                |   1. Baja afluencia   |
                |   2. Media afluencia  |
                |   3. Alta afluencia   |
                |-----------------------|
                """;
    }

    /**
     * Este mét0do es un 'toString' con tabulado.
     * @param espaciado Son los espacios en blanco que serán tabulados al inicio de cada línea.
     * @return Devuelve el 'toString' tabulado.
     */
    public String toString(int espaciado){
        StringBuilder espacios = new StringBuilder(espaciado);
        espacios.append(" ".repeat(Math.max(0, espaciado)));

        return espacios + "Afluencia: " + "\n" +
                espacios + "Fecha del partido: " + "\n" +
                espacios + "Equipo local: " + "\n" +
                espacios + "Equipo visitante: " + "\n";
    }
}
