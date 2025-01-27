package com.lukalopez.tema06;

public class Ejercicio1 {
    private enum Tipo{
        MINI,UTILITARIO, FAMILIAR,DEPORTIVO
    }


    public static class Coche{
        private String modelo;
        private String color;
        private boolean metalizado;
        private String matricula;
        private Tipo tipo;
        private int anyoDeFabricacion;
        private boolean aTodoRiesgo;


        public Coche(String modelo, String color, boolean metalizado, String matricula,  Tipo tipo, int anyoDeFabricacion, boolean aTodoRiesgo){
            this.modelo = modelo;
            this.color = color;
            this.metalizado = metalizado;
            this.matricula = matricula;
            this.tipo = tipo;
            this.anyoDeFabricacion = anyoDeFabricacion;
            this.aTodoRiesgo = aTodoRiesgo;
        }

        /**
         * Constructor para crear coches urbanos de tipo mini sin seguro a t0do riesgo.
         *
         * @param color Color del automovil.
         * @param matricula Matricula del coche.
         * @param anyoDeFabricacion Año de fabricación del vehiculo.
         */
        public Coche(String color, String matricula, int anyoDeFabricacion){
            this("Urbano",color,true,matricula,Tipo.MINI,anyoDeFabricacion,false);
        }

        @Override
        public String toString() {
            return "Coche{" +
                    "modelo='" + modelo + '\'' +
                    ", color='" + color + '\'' +
                    ", metalizado=" + metalizado +
                    ", matricula='" + matricula + '\'' +
                    ", tipo=" + tipo +
                    ", anyoDeFabricacion=" + anyoDeFabricacion +
                    ", aTodoRiesgo=" + aTodoRiesgo +
                    '}';
        }
    }

    Coche coche1 = new Coche("verde","1234567A",2005);
}

