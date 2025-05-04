package com.lukalopez.tema08;

import javax.swing.*;
import java.awt.*;

public class SelectorResolucion {

    public enum Size{
        HD(1280,720),
        FULL_HD(1920,1080),
        QHD(2560,1440),
        CUATRO_K(3840,2160),
        OCHO_K(7680,4320);

        private final int width;
        private final int heigh;

        Size(int width, int heigh) {
            this.width = width;
            this.heigh = heigh;
        }

        public int getWidth() {
            return width;
        }

        public int getHeigh() {
            return heigh;
        }
    }

    public static void main(String[] args) {
        obtenerSizePantalla();
    }

    public static Size obtenerSizePantalla() {
        // Ajustes básicos de la pantalla
        JFrame frame = new JFrame("Seleccionar resolución");
        frame.setSize(450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // Ponemos las opciones
        JLabel texto = new JLabel("Selecciona tu resolución:");
        panel.add(texto);

        ButtonGroup radioGroup = new ButtonGroup();
        JRadioButton[] botones = new JRadioButton[Size.values().length];

        for (int i = 0; i < Size.values().length; i++) {
            Size size = Size.values()[i];
            botones[i] = new JRadioButton(size.width + "x" + size.heigh);
            radioGroup.add(botones[i]);
            panel.add(botones[i]);
        }

        // Botón para confirmar la selección
        JButton botonConfirmar = new JButton("Confirmar");
        panel.add(botonConfirmar);

        // Agregamos el panel al frame
        frame.add(panel);
        frame.setVisible(true);

        // Para capturar la selección de forma síncrona, usamos un arreglo mutable
        final Size[] seleccion = new Size[1];

        botonConfirmar.addActionListener(e -> {
            for (int i = 0; i < botones.length; i++) {
                if (botones[i].isSelected()) {
                    seleccion[0] = Size.values()[i];
                    break;
                }
            }
            if (seleccion[0] == null) {
                seleccion[0] = Size.HD; // valor por defecto si no se seleccionó nada
            }
            frame.dispose(); // cerrar la ventana
        });

        // Esperar hasta que el usuario confirme (bloqueo simple)
        while (seleccion[0] == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }

        return seleccion[0];
    }
}
