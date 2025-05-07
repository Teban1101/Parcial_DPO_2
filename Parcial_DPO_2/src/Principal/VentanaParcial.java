package Principal;

import javax.swing.*;
import java.awt.*;

public class VentanaParcial extends JFrame {

    private JTextField campoBase;
    private JTextField campoExponente;
    private JLabel resultadoLabel;

    public VentanaParcial() {
        setTitle("Calculadora del Parcial");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 400);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2, 10, 10));

        // Componentes
        add(new JLabel("Base (b):"));
        campoBase = new JTextField();
        add(campoBase);

        add(new JLabel("Exponente (e):"));
        campoExponente = new JTextField();
        add(campoExponente);

        JButton botonCalcular = new JButton("Calcular Potencia");
        add(botonCalcular);

        resultadoLabel = new JLabel("Resultado: ");
        add(resultadoLabel);

        // Accion de boton
        botonCalcular.addActionListener(e -> calcularPotencia());

        setVisible(true);
    }

    private void calcularPotencia() {
        try {
            int base = Integer.parseInt(campoBase.getText());
            int exponente = Integer.parseInt(campoExponente.getText());

            int resultado = Parcial.potencia(base, exponente);
            resultadoLabel.setText("Resultado: " + resultado);

        } catch (NumberFormatException ex) {
            resultadoLabel.setText("Error: ingrese solo numeros enteros.");
        } catch (IllegalArgumentException | ArithmeticException ex) {
            resultadoLabel.setText("Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaParcial());
    }
}

