package org.devdaniel;

public class CalculadoraModelo {

    private double primeiroNumero;
    private double segundoNumero;
    private String operadorAtual;

    public CalculadoraModelo() {
        this.primeiroNumero = 0;
        this.segundoNumero = 0;
        this.operadorAtual = "";
    }

    public void definirPrimeiro(double primeiroNumero) {
        this.primeiroNumero = primeiroNumero;
    }

    public void definirSegundo(double segundoNumero) {
        this.segundoNumero = segundoNumero;
    }

    public void definirOperador(String operadorAtual) {
        this.operadorAtual = operadorAtual;
    }


}
