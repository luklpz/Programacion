package com.lukalopez.test.Tablero;

import javax.swing.*;
import java.awt.*;

public class PantallaPrincipal extends JFrame {

    public PantallaPrincipal() {
        setTitle("Pantalla Principal");

        // Obtener tamaño de pantalla
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Opción adicional para pantalla completa
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel principal con BoxLayout vertical
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.DARK_GRAY);

        // Espaciado superior (20% de altura)
        panel.add(Box.createVerticalStrut((int) (screenSize.height * 0.2)));

        // Botón Jugar
        JButton btnJugar = new JButton("Jugar");
        configurarBoton(btnJugar, screenSize);
        btnJugar.addActionListener(e -> JOptionPane.showMessageDialog(this, "Iniciar juego..."));
        panel.add(btnJugar);

        // Espaciado entre botones
        panel.add(Box.createVerticalStrut(30));

        // Botón Opciones
        JButton btnOpciones = new JButton("Opciones");
        configurarBoton(btnOpciones, screenSize);
        btnOpciones.addActionListener(e -> JOptionPane.showMessageDialog(this, "Mostrar opciones..."));
        panel.add(btnOpciones);

        // Espaciado entre botones
        panel.add(Box.createVerticalStrut(30));

        // Botón Salir
        JButton btnSalir = new JButton("Salir");
        configurarBoton(btnSalir, screenSize);
        btnSalir.addActionListener(e -> System.exit(0));
        panel.add(btnSalir);

        add(panel);
        setVisible(true);
    }

    private void configurarBoton(JButton boton, Dimension screenSize) {
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        boton.setMaximumSize(new Dimension(screenSize.width / 4, 60));
        boton.setFont(new Font("Arial", Font.BOLD, 24));
        boton.setFocusPainted(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PantallaPrincipal());
    }
}