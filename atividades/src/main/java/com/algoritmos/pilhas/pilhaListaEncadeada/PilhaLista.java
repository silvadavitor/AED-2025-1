package com.algoritmos.pilhas.pilhaListaEncadeada;

import javax.management.RuntimeErrorException;

public class  PilhaLista<T> implements Pilha<T>{

    private ListaEncadeadaPilha<T> lista;

    public PilhaLista() {
        lista = new ListaEncadeadaPilha<T>();
    }

    @Override
    public void push(T valor){
        lista.inserir(valor);
    }

    @Override
    public T peek() {
        if (estaVazia()) {
            throw new PilhaVaziaException();
        }

        return lista.getPrimeiro().getInfo();
    }

    @Override
    public T pop() {
        T valor = peek();
        lista.retirar(valor);

        return valor;
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public void liberar() {
        while (!estaVazia()) {
            pop();
        }
    }

    public String toString() {
        return lista.toString();
    }


}