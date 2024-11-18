package com.lukalopez.tema05;

public class Ejercicio14 {
    /**
     * Metodo para imprimir un contador del 0 al 9999 teniendo en cuenta un número como excepcion para cambiarlo por un caracter
     *
     * @param numeroExcepcion Número excepción.
     * @param charSustituto Caracter por el que sustituir el número.
     * @return Devuelve un String que contiene t0do el contador.
     */
    private static String contadorConExcepcion(int numeroExcepcion, char charSustituto){
        StringBuilder contador = new StringBuilder();
        StringBuilder textoContador = new StringBuilder();
        textoContador.ensureCapacity(60000);
        String stringSustituto = String.valueOf(charSustituto);
        String stringNumeroExcepcion = String.valueOf(numeroExcepcion);

        for (int i=0;i<10;i++){
            for (int j=0;j<10;j++){
                for (int k=0;k<10;k++){
                    for (int l=0;l<10;l++){
                        contador.delete(0,contador.length());
                        contador.append(i).append('-').append(j).append('-').append(k).append('-').append(l);
                        contador.replace(0,contador.length(),contador.toString().replaceAll(stringNumeroExcepcion,stringSustituto));
                        System.out.println(contador);
                        textoContador.append(contador).append('\n');
                    }
                }
            }
        }
        return textoContador.toString();
    }



    public static void main(String args[]){
        String contador;
        contador = contadorConExcepcion(2,'X');
    }
}
