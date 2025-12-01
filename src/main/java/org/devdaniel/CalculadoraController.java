package org.devdaniel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraController implements ActionListener{

    private final CalculadoraModelo modelo;
    private final CalculadoraVisao visao;
    private boolean novoNumero = true;

    public CalculadoraController(CalculadoraModelo modelo, CalculadoraVisao visao) {
        this.modelo = modelo;
        this.visao = visao;
        visao.registrarControlador(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
          String textoBotao = e.getActionCommand();

          if(textoBotao.matches("[0-9]")){
              if(visao.lerVisor().equals("0") || novoNumero){
                  visao.atualizarVisor(textoBotao);
              } else {
                  visao.atualizarVisor(visao.lerVisor() + textoBotao);
              }

              novoNumero = false;
              return;
          }

          if(textoBotao.equals(",")){
              if(!visao.lerVisor().contains(",")){
                  visao.atualizarVisor(visao.lerVisor() + ",");
              }
              return;
          }

          if(textoBotao.equals("C")){
              modelo.limpar();
              visao.atualizarVisor("0");
              novoNumero = true;
              return;
          }

          if(textoBotao.equals("CE")){
              visao.atualizarVisor("0");
              novoNumero = true;
              return;
          }

          if(textoBotao.equals("<-")){
              String atual = visao.lerVisor();
              if(atual.length() > 1){
                  visao.atualizarVisor(atual.substring(0, atual.length() - 1));
              } else {
                  visao.atualizarVisor("0");
                  novoNumero = true;
              }
              return;
          }

          if(textoBotao.matches("[+\\-*/]")) {
              double valor = Double.parseDouble(visao.lerVisor().replaceAll(",", "."));
              modelo.definirPrimeiro(valor);
              modelo.definirOperador(textoBotao);
              novoNumero = true;
              return;
          }

          if(textoBotao.equals("=")) {
              double segundo = Double.parseDouble(visao.lerVisor().replace(",", "."));
              modelo.definirSegundo(segundo);
              try {
                  double resultado = modelo.calcular();
                  String txt = Double.toString(resultado);

                  txt = txt.replace(".", ",");

                  if (txt.endsWith(",0")) {
                      txt = txt.substring(0, txt.length() - 2);
                  }

                  visao.atualizarVisor(txt);

              } catch(ArithmeticException ex) {
                  visao.atualizarVisor("Erro");
              }

              novoNumero = true;
              modelo.definirOperador("");
              return;
        }
    }
}