package com.lukalopez.tema10.Ejercicio3;

public class CocheCambioAutomatico extends Coche{

    public CocheCambioAutomatico(int[] numeroMarchas, String matricula) {
        super(numeroMarchas, matricula);
    }

    @Override
    public void acelerar(double distancia) {
        final double velocidadObjetivo = getVelocidadActual()+distancia;
        final double velocidadMaximaMarcha = getNumeroMarchas()[getMarchaActual()];

        //Si supera la velocidad maxima y no está en la ultima marcha
        if (velocidadObjetivo>velocidadMaximaMarcha&&getMarchaActual()!=getNumeroMarchas().length-1){
            //Cambiamos la velocidad y la marcha
            double aux = velocidadObjetivo-velocidadMaximaMarcha;
            setVelocidadActual(velocidadMaximaMarcha);
            cambiarMarcha(getMarchaActual() + 1);
            //Volvemos a llamar al mét0do con lo que sobra
            acelerar(aux);

        } else if ((getVelocidadActual()+distancia)<=getNumeroMarchas()[getMarchaActual()]&&(getVelocidadActual()+distancia)>0) {
            setVelocidadActual(velocidadObjetivo);
        } else {
            System.err.println("El coche no puede alcancar tanta velocidad, está en su última marcha");
        }
    }

    @Override
    public void frenar(double distancia) {
        final double velocidadObjetivo = getVelocidadActual()-distancia;
        final double velocidadMinimaMarcha = getNumeroMarchas()[getMarchaActual()-1];

        //Si supera la velocidad maxima de la marcha por debajo y no está en la primera marcha
        if (velocidadObjetivo<=velocidadMinimaMarcha&&getMarchaActual()!=0){
            //Cambiamos la velocidad y la marcha
            double aux = velocidadMinimaMarcha - (velocidadObjetivo);
            setVelocidadActual(velocidadMinimaMarcha);
            cambiarMarcha(getMarchaActual()-1);
            //Volvemos a llamar al mét0do con lo que sobra
            frenar(aux);

        } else if (velocidadObjetivo>velocidadMinimaMarcha) {
            setVelocidadActual(velocidadObjetivo);
        } else {
            System.err.println("El coche no puede alcancar tanta velocidad, está en su primera marcha");
        }
    }
}
