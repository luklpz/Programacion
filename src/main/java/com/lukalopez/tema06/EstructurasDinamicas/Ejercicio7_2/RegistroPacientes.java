package com.lukalopez.tema06.EstructurasDinamicas.Ejercicio7_2;

public class RegistroPacientes {
    private final static int CAPACIDAD_INICIAL = 30;
    private final static float FACTOR_DE_CRECIMIENTO = 2f;
    private Paciente[] data;
    private int size;

    /**
     * Crear un array dinámico con la capacidad inicial por defecto.
     */
    public RegistroPacientes() {
        this.data = new Paciente[CAPACIDAD_INICIAL];
    }

    /**
     * Crear un array dinámico con una capacidad personalizada inicial.
     * @param CAPACIDAD Capacidad con la que se generará el array de pacientes.
     */
    public RegistroPacientes(final int CAPACIDAD) {
        this.data = new Paciente[CAPACIDAD];
    }

    /**
     * Obtiene el elemento que ocupa el índice index
     * @param index Índice del elemento a obtener
     * @return el valor obtenido o null
     */
    public Paciente get(int index) {
        if (index >= size || index < 0)
            return null;
        return data[index];
    }

    /**
     * Mét0do para ampliar la capacidad del array según el factor de crecimiento
     */
    private void expand() {
        Paciente[] aux = new Paciente[Math.round(data.length * FACTOR_DE_CRECIMIENTO)];
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
     * Mét0do para determinar si el array está lleno
     * @return true si está lleno, false si no lo está
     */
    private boolean isFull() {
        return size == data.length;
    }

    /**
     * Añade el elemento indicado al array
     * @param value Elemento a añadir
     * @return true
     */
    public boolean add(Paciente value) {
        if (isFull())
            expand();
        data[size] = value;
        size++;
        return true;
    }

    /**
     * Comprobación de si el registro no tiene datos.
     * @return Devuelve 'true' si el registro se encuentra vacío.
     */
    public boolean isEmpty(){
        return size == 0;
    }
}
