package com.lukalopez.tema09.Ejercicio4;

import java.util.ArrayList;

public class Cola<T> implements ICola{
    ArrayList<T> arrayList = new ArrayList<>();

    //Que es esto
    @Override
    public boolean add(T  e) {
        arrayList.add(e);
        return true;
    }

    @Override
    public T remove() {
        if (isEmpty()){
            return null;
        }
        T aux = arrayList.getFirst();
        arrayList.remove(size()-1);
        return aux;
    }

    @Override
    public int size() {
        return arrayList.size();
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return arrayList.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return arrayList.isEmpty();
    }
}
