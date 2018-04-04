package br.com.calculo;

public abstract class ExpressaoBase implements  Expressao {
        protected Expressao expresao1;
        protected Expressao expressao2;

        public ExpressaoBase(Expressao expresao1, Expressao expressao2){
            this.expresao1 = expresao1;
            this.expressao2 = expressao2;
        }

}
