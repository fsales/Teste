package br.com.calculo;

public class Subtracao extends ExpressaoBase  {

    public Subtracao(Expressao expresao1, Expressao expressao2) {
        super(expresao1, expressao2);
    }

    @Override
    public Double calculo() {
        return expresao1.calculo() - expressao2.calculo();
    }
}
