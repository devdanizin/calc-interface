package org.devdaniel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculadoraVisao extends JFrame {

    private final JTextField txtVisor;
    private final JPanel painelBotao;

    public CalculadoraVisao() {
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        txtVisor = new JTextField("0");
        txtVisor.setHorizontalAlignment(JTextField.RIGHT);
        txtVisor.setFont(new Font("Arial", Font.BOLD, 30));
        txtVisor.setEditable(false);
        txtVisor.setBackground(Color.WHITE);
        painelBotao = new JPanel(new GridLayout(5, 4, 5, 5));
        painelBotao.setBackground(Color.LIGHT_GRAY);
        String[] rotulos = {
                "CE", "C", "<-", "/",
                "7", "8", "9", "*",
                "4", "5", "6", "-",
                "1", "2", "3", "+",
                "0", ",", "=", " ",
        };

        for(String txt : rotulos) {
            JButton b = new JButton(txt);
            b.setFont(new Font("Arial", Font.BOLD, 30));
            if(txt.equals("")) {
                b.setEnabled(false);
            }

            painelBotao.add(b);
        }

        setLayout(new BorderLayout(5, 5));
        add(txtVisor, BorderLayout.NORTH);
        add(painelBotao, BorderLayout.CENTER);
    }

    public void registrarControlador(ActionListener e) {
        for(Component c : painelBotao.getComponents()) {
            if(c instanceof JButton btn) {
                btn.addActionListener(e);
            }
        }
    }

    public void atualizarVisor(String text) {
        txtVisor.setText(text);
    }

    public String lerVisor() {
        return txtVisor.getText();
    }

}