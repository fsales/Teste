package br.com.calculo;

import br.com.calculo.enums.Operacao;

import java.util.ArrayList;
import java.util.List;

public class Teste {

    public static void main(String args[]) {

        //Expressao a = new Soma(new Numero(2D), new Numero(3D));

        // Expressao soma = Operacao.Soma.calculo(new Numero(2D), new Numero(3D));
        //Expressao subtracao = Operacao.Subtracao.calculo(soma, new Numero(1D));
        //System.out.println("a "+subtracao.calculo());

        //String op = "3*2-2/2"; // 5
        String op = "10*2-10/2+9";
        LogicaPolonesaReversa l = new LogicaPolonesaReversa();
        List<String> stackExpressaoReversa = l.logicaReversa(op);
        stackExpressaoReversa.forEach(System.out::print);

        List<Numero> numeros = new ArrayList<Numero>();
        List<Expressao> expressoes = new ArrayList<>();

       /* Expressao expressao = null;
        for (String exp : stackExpressaoReversa) {
            if (!Operacao.isOperador(exp)) {
                numeros.add(new Numero(Double.parseDouble(exp)));
            } else {
                Operacao operador = Operacao.getOperador(exp);
                if (expressoes.size() < 2) {
                    expressao = operador.calculo(numeros.get(0), numeros.get(1));
                    expressoes.add(expressao);
                    numeros.clear();
                } else {
                    expressao = operador.calculo(new Numero(expressoes.get(0).calculo()), new Numero(expressoes.get(1).calculo()));
                    expressoes.clear();

                }

            }
        }

        System.out.println(expressao.calculo());*/
    }
}
