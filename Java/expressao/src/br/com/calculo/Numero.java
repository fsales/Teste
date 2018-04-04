package br.com.calculo;

public class Numero implements Expressao {

    public Double numero;

    public Numero(Double numero) {
        this.numero = numero;
    }

    @Override
    public Double calculo() {
        return numero;
    }
}
