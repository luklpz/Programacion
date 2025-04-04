package com.lukalopez.lib.EstructurasDinamicas;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Pila<T> implements Iterable<T>, Iterator<T> {
    //Declaración de las variables.
    private final static int CAPACIDAD_INICIAL = 10;
    private T[] data;
    private int size;
    private int contador;

    /**
     * Constructor para una pila vacía con una capacidad inicial de 10 datos.
     */
    public Pila(){
        this(CAPACIDAD_INICIAL);
    }

    /**
     * Constructor para una pila vacía.
     * @param capacidad Cantidad de datos que soporta la pila inicialmente.
     */
    public Pila(int capacidad){
        @SuppressWarnings("unchecked")
        T[] aux = (T[]) new Object[capacidad];
        data = aux;
        size = 0;
        contador=0;
    }

    /**
     * Añadir un dato a la pila.
     * @param valor Valor a añadir a la pila.
     * @return Devuelve 'true' si el proceso se ha completado.
     */
    public boolean push(T valor){
        if (isFull()){
            expandir();
        }
        data[size]=valor;
        size++;
        contador++;
        return true;
    }

    /**
     * Retira el elemento superior de la pila y lo lee.
     * @return Devuelve el elemento retirado de la pila.
     */
    public T pop(){
        if (isEmpty()){
            return null;
        }
        size--;
        return data[size];
    }

    /**
     * Lee el número de elementos que contiene la pila.
     * @return Devuelve el número de elementos que contiene la pila.
     */
    public int size(){
        return size;
    }

    /**
     * Lee el último elemento de la pila sin retirarlo.
     * @return Devuelve el último elemento de la pila.
     */
    public T top(){
        if (isEmpty()){
            return null;
        }
        return data[size-1];
    }

    /**
     * Comprobación de si la pila no tiene datos.
     * @return Devuelve 'true' si la pila se encuentra vacía.
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * Comprobación de si la pila ha llegado a su tope.
     * @return Devuelve true si la pila no acepta más datos.
     */
    public boolean isFull(){
        return size == data.length;
    }

    /**
     * Duplicar la capacidad de la pila.
     * @return Devuelve 'true' si se ha completado el proceso.
     */
    private boolean expandir(){
        @SuppressWarnings("unchecked")
        T[] aux = (T[]) new Object[data.length * 2];
        if (size >= 0) System.arraycopy(data, 0, aux, 0, size);
        data = aux;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i!=size-1){
                sb.append("; ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    //******************************** ADDON ********************************\\

    public boolean clear(){
        for (int i = 0; i < size; i++) {
            data[i]=null;
        }
        size=0;
        return true;
    }

    @SuppressWarnings("rawtypes")
    public Pila clone(){
        Pila<T> aux = new Pila<T>();
        System.arraycopy(data, 0, aux.data, 0, size);
        aux.size=size;
        return aux;
    }

    @SuppressWarnings("rawtypes")
    public Pila peek(int n){
        if (n>size+1){
            System.err.printf("ERROR: No se pueden devolver más números de los que hay en la pila\nNúmeros en la pila: %d\n",size);
            return null;
        }
        if (size==0){
            return null;
        }
        Pila<T> aux = new Pila();
        for (int i = size-n; i < size; i++) {
            aux.push(data[i]);
        }
        return aux;
    }

    public int search(T elemento){
        int contador=-1;
        for (int i = size-1; i > -1; i--) {
            contador++;
            if (data[i].equals(elemento)) return contador;
        }
        return -1;
    }

    public void reverse(){
        @SuppressWarnings("unchecked")
        T[] aux = (T[]) new Object[data.length];
        for (int i = 0; i < size; i++) {
            aux[i]=data[size-i-1];
        }
        data = aux;
    }
    @Override
    public Iterator iterator() {
        contador=-1;
        return this;
    }

    @Override
    public boolean hasNext() {
        if (contador!=0){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public T next() {
        if (!hasNext()){
            throw new NoSuchElementException();
        } else {
            contador--;
            return data[contador];
        }
    }
}
