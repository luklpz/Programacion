package com.lukalopez.tema08.GameOfLife;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Tablero extends JPanel {
    public static final int TAMANO_CELDA = 2;

    private final int filas;
    private final int columnas;
    private final int tamanoCelda;

    //Estado actual de las células, true si la célula de esa celda está viva.
    private boolean[][] celdas;

    //Array auxiliar para calcular el estado de la siguiente generación de células.
    private boolean[][] siguiente;
    private final BufferedImage buffer;

    public Tablero(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.tamanoCelda = TAMANO_CELDA;
        this.celdas = new boolean[filas][columnas];
        this.siguiente = new boolean[filas][columnas];
        this.buffer = new BufferedImage(columnas * tamanoCelda, filas * tamanoCelda, BufferedImage.TYPE_INT_ARGB);

        //Inicializamos las celdas de forma aleatoria
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                celdas[i][j] = Math.random() < 0.2;
            }
        }
        setPreferredSize(new Dimension(columnas * TAMANO_CELDA, filas * TAMANO_CELDA));
    }

    public void evolucionar() {
        //Rellenamos el array de la siguiente generación
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                int vivas = contarVecinas(i, j);
                if (celdas[i][j]) {
                    siguiente[i][j] = vivas == 2 || vivas == 3;
                } else {
                    siguiente[i][j] = vivas == 3;
                }
            }
        }

        //Actualizamos el array de las celdas al siguiente
        boolean[][] aux = celdas;
        celdas = siguiente;
        siguiente = aux;
    }

    private int contarVecinas(int x, int y) {
        int total = 0;
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0){
                    continue;
                }
                int nx = (x + dx + filas) % filas;
                int ny = (y + dy + columnas) % columnas;
                if (celdas[nx][ny]) total++;
            }
        }
        return total;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = buffer.createGraphics();
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, buffer.getWidth(), buffer.getHeight());

        g2.setColor(Color.BLACK);
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (celdas[i][j]) {
                    g2.fillRect(j * tamanoCelda, i * tamanoCelda, tamanoCelda, tamanoCelda);
                }
            }
        }

        g.drawImage(buffer, 0, 0, null);
    }
}
