package br.com.calculo;

import br.com.calculo.enums.Operacao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LogicaPolonesaReversa {

    public List<String> logicaReversa(String expressao) {
        Stack<Operacao> pilharOperador = new Stack<Operacao>();
        List<String> listaNotacao = new LinkedList<String>();
        boolean isOldOperador = Boolean.FALSE;
        for (char exp : expressao.toCharArray()) {
            String expTemp = String.valueOf(exp);
            if (Operacao.isOperador(expTemp)) { // verifica se e um operador
                Operacao op = Operacao.getOperador(expTemp);
                if (pilharOperador.isEmpty()) { // se a pilha estiver vazia adiciona o operador
                    pilharOperador.push(op);
                } else {
                    if (pilharOperador.peek().prioridade() > op.prioridade()) { // testa se a prioridade do operador atual e menor que a prioridade do ultimo operador da lista
                        // desempilha os operadores ediciona na nova expressao
                        while (!pilharOperador.isEmpty()) {
                            listaNotacao.add(pilharOperador.pop().operador);
                        }

                        pilharOperador.push(op); // adiciona o operador atual na pilha
                    } else if (pilharOperador.peek().prioridade() < op.prioridade()) { // testa se a prioridade da pilha e menor que a prioridade do operador
                        pilharOperador.push(op);
                    } else {
                        listaNotacao.add(pilharOperador.pop().toString());
                        pilharOperador.push(op);
                    }

                }
                isOldOperador = Boolean.TRUE;
            } else {

                if (isOldOperador == false && !listaNotacao.isEmpty()) {
                    expTemp = ((LinkedList<String>) listaNotacao).getLast() + expTemp;
                    ((LinkedList<String>) listaNotacao).removeLast();
                }

                listaNotacao.add(expTemp);
                isOldOperador = Boolean.FALSE;
            }
        }


        while (!pilharOperador.isEmpty()) {
            listaNotacao.add(pilharOperador.pop().operador);
        }

        return listaNotacao;
    }
}
