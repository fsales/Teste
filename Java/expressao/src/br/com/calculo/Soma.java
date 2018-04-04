package br.com.calculo;

public class Soma extends ExpressaoBase implements  Expressao {

    public Soma(Expressao expresao1, Expressao expressao2) {
        super(expresao1, expressao2);
    }

    /***
     *
     * @return
     */
    @Override
    public Double calculo() {
        return expresao1.calculo() + expressao2.calculo();
    }
}
