package com.lukalopez.tema08;

import javax.swing.*;

public class Ejercicio3 {
    public static void main(String[] args) {
        JFrame window = new JFrame("Ejercicio3");
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel label = new JLabel("Bienvenido al mundo de las interfaces gráficas");
        label.setBounds(20,20,300,50);
        panel.add(label);
        window.setContentPane(panel);
        window.setVisible(true);
    }
}
