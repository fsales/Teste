package br.com.calculo.enums;

import br.com.calculo.Expressao;
import br.com.calculo.Soma;
import br.com.calculo.Subtracao;

public enum Operacao {
    Soma("+") {
        @Override
        public Expressao calculo(Expressao numero1, Expressao numero2) {
            return new Soma(numero1, numero2);
        }
    }, Subtracao("-") {
        @Override
        public Expressao calculo(Expressao numero1, Expressao numero2) {
            return new Subtracao(numero1, numero2);
        }
    };
    public final String operador;

    private Operacao(String operador) {
        this.operador = operador;
    }

    public abstract Expressao calculo(Expressao numero1, Expressao numero2);
}
