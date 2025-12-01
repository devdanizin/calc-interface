package org.devdaniel;

import javax.swing.*;

public class Principal {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculadoraModelo modelo = new CalculadoraModelo();
            CalculadoraVisao visao = new CalculadoraVisao();
            new CalculadoraController(modelo, visao);
            visao.setVisible(true);
        });
    }

}
