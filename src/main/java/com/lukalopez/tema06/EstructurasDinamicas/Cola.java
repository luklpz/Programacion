package com.lukalopez.tema06.EstructurasDinamicas;

public class Cola {
    //Declaración de las variables.
    private static final double ERROR = Double.NEGATIVE_INFINITY;
    private final static int CAPACIDAD_INICIAL = 10;
    private double[] data;
    private int size;

    /**
     * Constructor para una cola vacía con una capacidad inicial de 10 datos.
     */
    public Cola(){
        this(CAPACIDAD_INICIAL);
    }

    /**
     * Constructor para una cola vacía.
     * @param capacidad Cantidad de datos que soporta la cola inicialmente.
     */
    public Cola(int capacidad){
        data = new double[capacidad];
        size = 0;
    }

    /**
     * Añadir un dato a la cola.
     * @param valor Valor a añadir a la cola.
     * @return Devuelve 'true' si el proceso se ha completado.
     */
    public boolean add(double valor){
        if (isFull()){
            expandir();
        }
        data[size]=valor;
        size++;
        return true;
    }

    /**
     * Retira el elemento superior de la cola y lo lee.
     * @return Devuelve el elemento retirado de la cola.
     */
    public double pop(){
        final double aux;
        if (isEmpty()){
            return ERROR;
        }
        aux = data[0];
        moveToLeft();
        return aux;
    }

    /**
     * Lee el número de elementos que contiene la cola.
     * @return Devuelve el número de elementos que contiene la cola.
     */
    public int size(){
        return size;
    }

    /**
     * Lee el primer elemento de la cola sin retirarlo.
     * @return Devuelve el primer elemento de la cola.
     */
    public double peek(){
        if (isEmpty()){
            return ERROR;
        }
        return data[0];
    }

    /**
     * Comprobación de si la cola no tiene datos.
     * @return Devuelve 'true' si la cola se encuentra vacía.
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * Comprobación de si la cola ha llegado a su tope.
     * @return Devuelve true si la cola no acepta más datos.
     */
    public boolean isFull(){
        return size == data.length;
    }

    /**
     * Duplicar la capacidad de la cola.
     * @return Devuelve 'true' si se ha completado el proceso.
     */
    private boolean expandir(){
        System.out.println("[La cola se ha llenado] -> Expandiendo capacidad de la cola . . .");
        double[] arrayCopia = new double[data.length*2];
        System.arraycopy(data, 0, arrayCopia, 0, size);
        data=arrayCopia;
        return true;
    }

    /**
     * Mét0do para mover a la izquierda una fila de datos, eliminando el que hubiera antes
     */
    private void moveToLeft() {
        for (int i = 0; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cola[");
        for (int i = 0; i < size; i++) {
            sb.append(String.format("%.2f",data[i]));
            if (i!=size-1){
                sb.append("; ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
