package com.algoritmos.pilhas.pilhaListaEncadeada;

public interface Pilha<T> {

    void push(T valor);
    T pop();
    T peek();
    boolean estaVazia();
    void liberar();
    
}