package com.lukalopez.tema10.Ejercicio3;

public class CocheCambioAutomatico extends Coche{

    public CocheCambioAutomatico(int[] numeroMarchas, String matricula) {
        super(numeroMarchas, matricula);
    }

    @Override
    public void acelerar(double distancia) {
        if ((getVelocidadActual()+distancia)>getNumeroMarchas()[getMarchaActual()]&&getMarchaActual()!=getNumeroMarchas().length-1){
            double aux = getVelocidadActual()+distancia-getNumeroMarchas()[getMarchaActual()];
            setVelocidadActual(getNumeroMarchas()[getMarchaActual()]);
            cambiarMarcha(getMarchaActual() + 1);
            acelerar(aux);
        } else if ((getVelocidadActual()+distancia)<=getNumeroMarchas()[getMarchaActual()]&&(getVelocidadActual()+distancia)>0) {
            setVelocidadActual(getVelocidadActual()+distancia);
        } else {
            System.err.println("El coche no puede alcancar tanta velocidad, está en su última marcha");
        }
    }

    @Override
    public void frenar(double distancia) {
        if ((getVelocidadActual()-distancia)<=getNumeroMarchas()[getMarchaActual()-1]&&getMarchaActual()!=0){
            double aux = getNumeroMarchas()[getMarchaActual() - 1] - (getVelocidadActual() - distancia);
            cambiarMarcha(getMarchaActual()-1);
            setVelocidadActual(getNumeroMarchas()[getMarchaActual()]);
            frenar(aux);
        } else if ((getVelocidadActual()-distancia)>getNumeroMarchas()[getMarchaActual()-1]) {
            setVelocidadActual(getVelocidadActual()-distancia);
        } else {
            System.err.println("El coche no puede alcancar tanta velocidad, está en su primera marcha");
        }
    }
}
