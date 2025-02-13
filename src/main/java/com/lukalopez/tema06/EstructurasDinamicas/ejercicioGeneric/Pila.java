package com.lukalopez.tema06.EstructurasDinamicas.ejercicioGeneric;

public class Pila<T> {
    //Declaración de las variables.
    private static final double ERROR = Double.NEGATIVE_INFINITY;
    private final static int CAPACIDAD_INICIAL = 10;
    private T[] data;
    private int size;

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
            sb.append(String.format("%.2f",data[i]));
            if (i!=size-1){
                sb.append("; ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
