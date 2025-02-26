package com.lukalopez.tema06.POO;

import java.util.Objects;

public class Ejercicio1 {
    public enum Tipo{
        MINI,UTILITARIO, FAMILIAR,DEPORTIVO
    }

    /**
     * Mét0do para crear un objeto coche.
     *
     * @param modelo 'String' Modelo del coche.
     * @param color 'String' Color del coche.
     * @param metalizado 'Boolean' El coche es metalizado.
     * @param tipo 'Tipo' Tipo de coche.
     * @param anyoDeFabricacion 'int' Año de fabricación.
     * @param aTodoRiesgo 'boolean' Seguro a t0do riesgo.
     * @return Devuelve un objeto coche.
     */
    public static Coche crearCoche(String modelo, String color, boolean metalizado,  Tipo tipo, int anyoDeFabricacion, boolean aTodoRiesgo){
        if (Coche.numeroMatricula==9999&&Coche.letrasMatricula.equals("ZZZ")){
            System.err.println("ERROR: Máximo de coches alcanzados, no se pueden crear más vehiculos.");
            return null;
        }
        return new Coche(modelo, color, metalizado, tipo, anyoDeFabricacion, aTodoRiesgo);
    }

    public static class Coche{
        private final String modelo;
        private String color;
        private boolean metalizado;
        private final String matricula;
        private final Tipo tipo;
        private final int anyoDeFabricacion;
        private boolean aTodoRiesgo;

        private static int numeroMatricula=-1;
        private static String letrasMatricula="AAA";


        /**
         * Mét0do que sirve para generar una matricula siguiendo el orden de matriculas previamente creadas.
         *
         * @return Devuelve la matricula que le corresponde al siguiente coche por crearse.
         */
        private String crearMatricula(){

            //Comprobamos si el número supera el límite
            if (numeroMatricula<9999){
                numeroMatricula++;

            } else {
                StringBuilder sb = new StringBuilder();

                //Inicializamos el StringBuilder con las letras de la matricula anterior
                sb.append(letrasMatricula);

                //Volvemos a poner los números a 0
                numeroMatricula=0;

                //Cogemos como caracter auxiliar la tercera letra
                char aux;
                aux=sb.charAt(2);

                //Verificamos si la tercera letra supera el límite
                if (aux<90){
                    aux++;
                    sb.replace(2,3,String.valueOf(aux));

                } else {
                    //Cogemos como caracter auxiliar la segunda letra
                    aux=sb.charAt(1);
                    sb.replace(2,3,"A");

                    //Verificamos si la segunda letra supera el límite
                    if (aux<90){
                        aux++;
                        sb.replace(1,2,String.valueOf(aux));

                    } else {
                        //Cogemos como caracter auxiliar la primera letra
                        aux=sb.charAt(0);
                        sb.replace(1,2,"A");

                        aux++;
                        sb.replace(0,1,String.valueOf(aux));
                    }
                }

                //Preguntar a German error
                letrasMatricula=sb.toString();
                return String.format("%1$04d-",numeroMatricula)+sb;
            }

            return String.format("%1$04d-",numeroMatricula)+letrasMatricula;
        }


        private Coche(String modelo, String color, boolean metalizado,  Tipo tipo, int anyoDeFabricacion, boolean aTodoRiesgo){
            this.modelo = modelo;
            this.color = color;
            this.metalizado = metalizado;
            this.matricula = crearMatricula();
            this.tipo = tipo;
            this.anyoDeFabricacion = anyoDeFabricacion;
            this.aTodoRiesgo = aTodoRiesgo;
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

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Coche coche = (Coche) o;
            return metalizado == coche.metalizado && anyoDeFabricacion == coche.anyoDeFabricacion && aTodoRiesgo == coche.aTodoRiesgo && Objects.equals(modelo, coche.modelo) && Objects.equals(color, coche.color) && Objects.equals(matricula, coche.matricula) && tipo == coche.tipo;
        }

        @Override
        public int hashCode() {
            return Objects.hash(modelo, color, metalizado, matricula, tipo, anyoDeFabricacion, aTodoRiesgo);
        }

        public String getModelo() {
            return modelo;
        }

        public String getColor() {
            return color;
        }

        public boolean isMetalizado() {
            return metalizado;
        }

        public String getMatricula() {
            return matricula;
        }

        public Tipo getTipo() {
            return tipo;
        }

        public int getAnyoDeFabricacion() {
            return anyoDeFabricacion;
        }

        public boolean isaTodoRiesgo() {
            return aTodoRiesgo;
        }

        public int getNumeroMatricula() {
            return numeroMatricula;
        }

        public String getLetrasMatricula() {
            return letrasMatricula;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public void setMetalizado(boolean metalizado) {
            this.metalizado = metalizado;
        }

        public void setaTodoRiesgo(boolean aTodoRiesgo) {
            this.aTodoRiesgo = aTodoRiesgo;
        }


    }


    public static void main(String[] args) {
        Coche coche1;
        coche1 = crearCoche("Modelo","Morao",false,Tipo.DEPORTIVO,2002,false);
        System.out.println(coche1.getMatricula());

        Coche coche2;
        coche2 = crearCoche("Modelo","Morao",false,Tipo.DEPORTIVO,2005,false);
        System.out.println(coche2.getMatricula());

        Coche coche3;
        coche3 = crearCoche("Modelo","Morao",false,Tipo.DEPORTIVO,2003,false);
        System.out.println(coche3.getMatricula());

        Coche coche4;
        coche4 = crearCoche("Modelo","Morao",false,Tipo.DEPORTIVO,2001,false);
        System.out.println(coche4.getMatricula());
    }
}

