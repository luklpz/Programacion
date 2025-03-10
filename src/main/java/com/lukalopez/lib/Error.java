package com.lukalopez.lib;

public enum Error {
    //Errores sobre la longitud de un número
    VALOR_INMANEJABLE("ERROR: El valor se excede de la capacidad máxima o mínima que puede ser almacenada.\n"),
    FUERA_DE_RANGO("ERROR: Valor fuera del rango comprendido entre el mínimo posible (%d) y el máximo posible (%d).\n"),
    FUERA_POR_ARRIBA("ERROR: Valor fuera del rango comprendido, el valor ha de ser menor a %d.\n"),
    FUERA_POR_ABAJO("ERROR: Valor fuera del rango comprendido, el valor ha de ser mayor a %d.\n");

    private final String codigo;

    Error(String codigo){
        this.codigo = codigo;
    }
}
