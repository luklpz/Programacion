package com.lukalopez.lib;

public enum Error {
    //Errores sobre la longitud de un número
    VALOR_INMANEJABLE, FUERA_DE_RANGO, FUERA_POR_ARRIBA, FUERA_POR_ABAJO,
    ;


    public static String toString(Error error) {
        switch (error){
            case VALOR_INMANEJABLE -> {
                return "ERROR: El valor se excede de la capacidad máxima o mínima que puede ser almacenada.\n";
            }
            case FUERA_DE_RANGO -> {
                return "ERROR: Valor fuera del rango comprendido entre el mínimo posible (%d) y el máximo posible (%d).\n";
            }
            case FUERA_POR_ABAJO -> {
                return "ERROR: Valor fuera del rango comprendido, el valor ha de ser menor a %d.\n";
            }
            case FUERA_POR_ARRIBA -> {
                return "ERROR: Valor fuera del rango comprendido, el valor ha de ser mayor a %d.\n";
            }
        }
        return "ERROR: Entrada inesperada.\n";
    }
}
