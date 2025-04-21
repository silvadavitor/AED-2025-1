package com.algoritmos.filas.filaLista;

public interface Fila<T> {
    void inserir(T valor);
    boolean estaVazia();
    T peek();
    T retirar();
    void liberar();
}
