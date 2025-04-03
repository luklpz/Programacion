package com.lukalopez.tema09.Ejercicio3;

import java.util.ArrayList;

public class Pila<T> implements IPila<T> {

     private final ArrayList<T> data;

    public Pila() {
        this.data =  new ArrayList<>();
    }

    @Override
    public T push(T e) {
        data.add(e);
        return e;
    }

    @Override
    public T pop() {
        if (isEmpty()){
            return null;
        }
        T aux = data.getLast();
        data.remove(size()-1);
        return aux;
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public T top() {
        if (isEmpty()){
            return null;
        }
        return data.getLast();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }
}
