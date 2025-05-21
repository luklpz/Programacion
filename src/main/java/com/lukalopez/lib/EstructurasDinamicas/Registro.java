package com.lukalopez.lib.EstructurasDinamicas;

import com.lukalopez.lib.Excepciones.RepeatedEntryException;

import java.util.*;

public class Registro<T> extends ArrayList<T> {

    @Override
    public boolean add(T entrada) throws RepeatedEntryException{
        if (!this.contains(entrada)) {
            return super.add(entrada);
        }
        throw new RepeatedEntryException("La entrada insDgresada ya existe en el registro.");
    }

    @Override
    public void add(int index, T entrada) {
        if (this.contains(entrada)) {
            throw new RepeatedEntryException("La entrada ingresada ya existe en el registro.");
        }
        super.add(index, entrada);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        for (int i = 0; i < size(); i++) {
            sb.append(i+1).append(".\n");
            sb.append(this.get(i)).append("\n\n");
        }
        return sb.toString();
    }
}
