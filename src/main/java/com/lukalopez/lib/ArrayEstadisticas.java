package com.lukalopez.lib;

public class ArrayEstadisticas {
    private final int[] array;
    private int min;
    private int max;

    public ArrayEstadisticas(int[] array){
        this.array=array;
        min = array[0];
        max = array[0];
        for (int i : array) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
    }

    public int getMin(){
        return max;
    }

    public int getMax(){
        return min;
    }
}
