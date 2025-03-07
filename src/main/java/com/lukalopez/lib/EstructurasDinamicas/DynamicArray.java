package com.lukalopez.lib.EstructurasDinamicas;

import java.util.Arrays;

/**
 * DynamicArray
 * License: 🅮 Public Domain
 * Ejercicios de Pilas y Colas
 * @author Germán Gascón <ggascon@gmail.com>
 * @version 0.1, 2020-01-30
 * @since 0.1, 2020-01-30
 **/
public class DynamicArray<T> {

    /* Capacidad inicial por defecto del array */
    private final static int DEFAULT_CAPACITY = 10;
    /* Factor de crecimiento */
    private final static float GROW_FACTOR = 2f;
    /* Los datos del array */
    private T[] data;
    /* Número de elementos del array */
    private int size;


    /**
     * Crear un array dinámico con la capacidad inicial por defecto
     */
    public DynamicArray() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Crea un array dinámico con la capacidad inicial indicada
     * @param capacity Capacidad inicial
     */
    public DynamicArray(int capacity) {
        @SuppressWarnings("unchecked")
        T[] aux = (T[]) new Object[capacity];
        data = aux;
        size = 0;
    }

    /**
     * Obtiene el elemento que ocupa el índice index
     * @param index Índice del elemento a obtener
     * @return el valor obtenido o ERROR
     */
    public T get(int index) {
        if (index >= size || index < 0)
            return null;
        return data[index];
    }

    /**
     * Añade el elemento indicado al array
     * @param value Elemento a añadir
     * @return true
     */
    public boolean add(T value) {
        if (isFull())
            expand();
        data[size] = value;
        size++;
        return true;
    }


    /**
     * Mét0do de uso interno para desplazar los elementos a la derecha a partir del índice indicado
     * @param index Índice a partir del cual se desplazarán los elementos
     */
    private void moveToRight(int index) {
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        size++;
    }


    /**
     * Añade el elemento indicado al array en la posición indicada por index
     * @param index Índice donde se añadirá el elemento
     * @param value Elemento a añadir
     * @return true
     */
    public boolean add(int index, T value) {
        if (index >= size || index < 0)
            return false;
        if (isFull())
            expand();
        moveToRight(index);
        data[index] = value;
        return true;
    }

    /**
     * Mét0do de uso interno para desplazar los elementos a la izquierda a partir del índice indicado
     * @param index Índice a partir del cual se desplazarán los elementos
     */
    private void moveToLeft(int index) {
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    /**
     * Elimina del array el elemento que ocupa la posición desplazando una posición a la izquierda
     * todos los elementos que hay a su derecha
     * @param index posición a eliminar
     * @return El valor eliminado
     */
    public T remove(int index) {
        if (index >= size || index < 0)
            return null;
        T valor = data[index];
        moveToLeft(index);
        return valor;
    }

    /**
     * Elimina del array la primera ocurrencia del valor indicado como parámetro desplazando una posición
     * a la izquierda todos los elementos que haya a su derecha
     * @param value valor a eliminar
     * @return true si se ha borrado el elemento, false en caso contrario
     */
    public boolean remove(T value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                moveToLeft(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Establece el valor del elemento con índice index
     * @param index Índice del elemento a modificar
     * @param value Valor que toma el elemento
     * @return true
     */
    public boolean set(int index, T value) {
        if (index >= size || index < 0)
            return false;
        data[index] = value;
        return true;
    }

    /**
     * Mét0do de uso interno para ampliar la capacidad del array según el factor de crecimiento
     */
    private void expand() {
        @SuppressWarnings("unchecked")
        T[] aux = (T[]) new Object[Math.round(data.length * GROW_FACTOR)];
        if (size >= 0) System.arraycopy(data, 0, aux, 0, size);
        data = aux;
    }

    /**
     * Obtiene el número de elementos que hay en el array
     * @return int
     */
    public int size() {
        return size;
    }

    /**
     * Mét0do de uso interno para determinar si el array está lleno
     * @return true si está lleno, false si no lo está
     */
    private boolean isFull() {
        return size == data.length;
    }

    @Override
    @SuppressWarnings("rawtypes")
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DynamicArray that = (DynamicArray) o;

        if (size != that.size) return false;

        // Sólo tenemos en cuenta los elementos del array que están en posiciones válidas
        for (int i = 0; i < size; i++) {
            if (data[i] != that.data[i])
                return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(data);
        result = 31 * result + size;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0; i < size; i++)
            sb.append(data[i]).append(" ");
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
    public DynamicArray clone(){
        DynamicArray aux = new DynamicArray();
        System.arraycopy(data, 0, aux.data, 0, size);
        aux.size=size;
        return aux;
    }

    public int indexOf(Object elemento){
        int contador=-1;
        for (int i = 0; i < size; i++) {
            contador++;
            if (data[i].equals(elemento)) return contador;
        }
        return -1;
    }

    public void trimToSize(){
        @SuppressWarnings("unchecked")
        T[] aux = (T[]) new Object[data.length];
        System.arraycopy(data, 0, aux, 0, size);
        data=aux;
    }

    public boolean swap(int index1, int index2){
        if (index1<0||index2<0||index1>size-1||index2>size-1){
            return false;
        }

        T aux;
        aux=data[index1];
        data[index1]=data[index2];
        data[index2]=aux;
        return true;
    }

    public int getLenght(){
        return data.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }
}
