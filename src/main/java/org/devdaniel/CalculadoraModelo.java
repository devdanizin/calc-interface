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

    public void limpar() {
        primeiroNumero = 0;
        segundoNumero = 0;
        operadorAtual = "";
    }

    public double calcular() throws ArithmeticException {
        double resultado = 0;

        switch (operadorAtual) {

            case "+": {
                resultado = primeiroNumero + segundoNumero;
                break;
            }
            case "-": {
                resultado = primeiroNumero - segundoNumero;
                break;
            }
            case "*": {
                resultado = primeiroNumero * segundoNumero;
                break;
            }
            case "/": {
                if(segundoNumero == 0) {
                    throw new ArithmeticException("Divisão por zero não e possível.");
                }

                resultado = primeiroNumero / segundoNumero;
                break;
            }
            default: {
                resultado = segundoNumero;
            }
        }

        return resultado;
    }

}