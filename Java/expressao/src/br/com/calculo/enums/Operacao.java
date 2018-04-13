package br.com.calculo.enums;

import br.com.calculo.Expressao;
import br.com.calculo.ExpressaoBase;
import br.com.calculo.Soma;
import br.com.calculo.Subtracao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public enum Operacao {
    Soma("+") {
        @Override
        public Expressao calculo(Expressao numero1, Expressao numero2) {
            return new Soma(numero1, numero2);
        }

        @Override
        public Integer prioridade() {
            return 1;
        }
    }, Subtracao("-") {
        @Override
        public Expressao calculo(Expressao numero1, Expressao numero2) {
            return new Subtracao(numero1, numero2);
        }

        @Override
        public Integer prioridade() {
            return 1;
        }
    }, Divisao("/") {
        @Override
        public Expressao calculo(Expressao numero1, Expressao numero2) {
            return new ExpressaoBase(numero1, numero2) {

                @Override
                public Double calculo() {

                    return new BigDecimal(numero1.calculo().toString()).divide(new BigDecimal(numero2.calculo().toString()), BigDecimal.ROUND_HALF_DOWN).doubleValue();
                }
            };
        }

        @Override
        public Integer prioridade() {
            return 2;
        }
    }, Multiplicacao("*") {
        @Override
        public Expressao calculo(Expressao numero1, Expressao numero2) {
            return new ExpressaoBase(numero1, numero2) {
                @Override
                public Double calculo() {
                    return numero1.calculo() * numero2.calculo();
                }
            };
        }

        @Override
        public Integer prioridade() {
            return 2;
        }
    };

    private static Map<String, Operacao> map = new HashMap<>();

    static {
        for (Operacao op : Operacao.values()) {
            map.put(op.operador, op);
        }
    }


    public final String operador;

    private Operacao(String operador) {
        this.operador = operador;
    }

    public abstract Expressao calculo(Expressao numero1, Expressao numero2);

    public abstract Integer prioridade();

    public static boolean isOperador(String op) {
        return Operacao.map.containsKey(op);
    }

    public static Operacao getOperador(String op) {
        return Operacao.map.get(op);
    }
}
