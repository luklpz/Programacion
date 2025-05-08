package com.lukalopez.tema10.Ejercicio5;

public abstract class Item {
    public enum Stack{
        UNO(1), DIECISEIS(16), SESENTA_Y_CUATRO(64);

        private final int capacidad;

        Stack(int capacidad) {
            this.capacidad = capacidad;
        }

        public int getCapacidad() {
            return capacidad;
        }
    }
}
