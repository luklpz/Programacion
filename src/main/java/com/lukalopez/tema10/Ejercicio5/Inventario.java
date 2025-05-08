package com.lukalopez.tema10.Ejercicio5;

import java.util.*;

public class Inventario {
    private final static int DEFAULT_CAPACITY = 7;
    private Map<Item,Integer> data;

    public Inventario() {
        this.data = new HashMap<>(DEFAULT_CAPACITY);
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            data.put(null, null);
        }
    }


    public boolean anadirItem(Item item) {
        int huecoVacio=-1;
        Item aux;
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
        }
        return true;
    }
}
