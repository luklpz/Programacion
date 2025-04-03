package com.lukalopez.tema09.Ejercicio3;

import java.util.ArrayList;

public class Pila<T> implements IPila {

     private final ArrayList<T> arrayList = new ArrayList<>();

    @Override
    public T push(T e) {
        arrayList.add(e);
        return e;
    }

    @Override
    public T pop() {
        if (isEmpty()){
            return null;
        }
        T aux = arrayList.getLast();
        arrayList.remove(size()-1);
        return aux;
    }

    @Override
    public int size() {
        return arrayList.size();
    }

    @Override
    public T top() {
        if (isEmpty()){
            return null;
        }
        return arrayList.getLast();
    }

    @Override
    public boolean isEmpty() {
        return arrayList.isEmpty();
    }
}
