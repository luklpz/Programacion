package com.lukalopez.tema09.Ejercicio4;

import java.util.ArrayList;

public class Cola<T> implements ICola<T>{
    private final ArrayList<T> data;

    public Cola() {
        this.data = new ArrayList<>();
    }

    @Override
    public boolean add(T e) {
        data.add(e);
        return true;
    }

    @Override
    public T remove() {
        if (isEmpty()){
            return null;
        }
        T aux = data.getFirst();
        data.remove(size()-1);
        return aux;
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return data.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }
}
