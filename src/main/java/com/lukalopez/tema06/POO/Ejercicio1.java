package com.lukalopez.tema06.POO;

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

        public String getModelo() {
            return modelo;
        }

        public void setModelo(String modelo) {
            this.modelo = modelo;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public boolean isMetalizado() {
            return metalizado;
        }

        public void setMetalizado(boolean metalizado) {
            this.metalizado = metalizado;
        }

        public String getMatricula() {
            return matricula;
        }

        public void setMatricula(String matricula) {
            this.matricula = matricula;
        }

        public Tipo getTipo() {
            return tipo;
        }

        public void setTipo(Tipo tipo) {
            this.tipo = tipo;
        }

        public int getAnyoDeFabricacion() {
            return anyoDeFabricacion;
        }

        public void setAnyoDeFabricacion(int anyoDeFabricacion) {
            this.anyoDeFabricacion = anyoDeFabricacion;
        }

        public boolean isaTodoRiesgo() {
            return aTodoRiesgo;
        }

        public void setaTodoRiesgo(boolean aTodoRiesgo) {
            this.aTodoRiesgo = aTodoRiesgo;
        }
    }

    static Coche coche1 = new Coche("verde","123456A",2005);
    static Coche coche2 = new Coche("amarillo","974917H",2001);

    public static void main(String[] args) {
        System.out.println(coche1.toString());
        coche1.setAnyoDeFabricacion(1999);
        System.out.println(coche1.toString());
    }
}

