package br.com.calculo;

import br.com.calculo.enums.Operacao;

public class Teste {

   public static void main(String args[]){

       //Expressao a = new Soma(new Numero(2D), new Numero(3D));

       Expressao soma = Operacao.Soma.calculo(new Numero(2D), new Numero(3D));
       Expressao subtracao = Operacao.Subtracao.calculo(soma, new Numero(1D));
       System.out.println("a "+subtracao.calculo());
   }
}
