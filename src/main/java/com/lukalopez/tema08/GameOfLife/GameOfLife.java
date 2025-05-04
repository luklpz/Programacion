package com.lukalopez.tema08.GameOfLife;

import com.lukalopez.tema08.SelectorResolucion;

import javax.swing.*;

public class GameOfLife {
    public static void main(String[] args) {
        final int MILISECONDS_SLEEP = 100;

        //Solicitamos la resolución
        SelectorResolucion.Size size = SelectorResolucion.Size.HD;

        JFrame ventana = new JFrame("Juego de la Vida");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(size.getWidth(), size.getHeigh());
        ventana.setResizable(false);

        Tablero tablero = new Tablero(size.getWidth(), size.getHeigh());
        ventana.add(tablero);
        ventana.setVisible(true);

        // Bucle principal
        while (true) {
            tablero.evolucionar();
            tablero.repaint();
            try {
                Thread.sleep(MILISECONDS_SLEEP); //Esperamos antes de actualizar.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
