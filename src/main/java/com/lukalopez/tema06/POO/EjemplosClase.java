package com.lukalopez.tema06.POO;

public class EjemplosClase {
    public static class Jugador {
        private String nombre;
        private float portero;
        private float defensa;
        private float pase;
        private float regate;
        private float tiro;
        private float estadoForma;

        private Jugador(String nombre, float portero, float defensa, float pase, float regate, float tiro, float estadoForma) {
            this.nombre = nombre;
            this.portero = portero;
            this.defensa = defensa;
            this.pase = pase;
            this.regate = regate;
            this.tiro = tiro;
            this.estadoForma = estadoForma;
        }

        private Jugador(String nombre){
            this(nombre, 50,50,50,50,50,50);
        }

        public static void entrenar(Jugador idJugador) {
            idJugador.estadoForma++;
            idJugador.tiro++;
        }

        public static void regatear(Jugador idJugador) {
            idJugador.regate++;
        }

        public static void chutar(Jugador idJugador) {
            idJugador.tiro++;
        }

        @Override
        public String toString() {
            return "Jugador{" +
                    "nombre='" + nombre + '\'' +
                    ", portero=" + portero +
                    ", defensa=" + defensa +
                    ", pase=" + pase +
                    ", regate=" + regate +
                    ", tiro=" + tiro +
                    ", estadoForma=" + estadoForma +
                    '}';
        }


    }



    Jugador futbolista1 = new Jugador("nombre", 32,82,87,80,82,95);
    Jugador futbolista2 = new Jugador("nombre");

    public void main(String[] args) {
        System.out.println(futbolista1.estadoForma);
        Jugador.entrenar(futbolista1);
        System.out.println("Entrena:");
        System.out.println(futbolista1.estadoForma);
    }
}
