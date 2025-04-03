package com.lukalopez.tema09.Ejercicio2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ArrayListEstadisticas implements IEstadisticas{
    private ArrayList<Double> arrayList = new ArrayList<>();

    public ArrayListEstadisticas(ArrayList<Double> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public double minimo() {
        double aux=arrayList.getFirst();
        for (double valor : arrayList) {
            if (valor > aux){
                aux = valor;
            }
        }
        return aux;
    }

    @Override
    public double maximo() {
        double aux=arrayList.getFirst();
        for (double valor : arrayList) {
            if (valor < aux){
                aux = valor;
            }
        }
        return aux;
    }

    @Override
    public double sumatorio() {
        double aux=arrayList.getFirst();
        for (double valor : arrayList) {
            aux+=valor;
        }
        return aux;
    }

    @Override
    public double media() {
        return this.sumatorio()/this.arrayList.size();
    }

    @Override
    public double moda() {

        Map<Double, Integer> mapa = new HashMap<>();
        for (double valor : arrayList) {
            if (!mapa.containsKey(valor)){
                mapa.put(valor, 1);
            } else {
                mapa.put(valor, mapa.get(valor)+1);
            }
        }
        double valor=arrayList.getFirst();
        int max=0;
        for (Map.Entry<Double, Integer> entry : mapa.entrySet()){
            if (entry.getValue()>max){
                max=entry.getValue();
                valor=entry.getKey();
            }
        }
        return valor;
    }
}
