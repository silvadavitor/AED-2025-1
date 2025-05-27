package com.algoritmos.ordenacao;

/**
 * Classe abstrata base que define a estrutura de qualquer algoritmo de ordenação genérico.
 * Trabalha com vetores do tipo T, onde T precisa implementar a interface Comparable<T>.
 */
public abstract class OrdenacaoAbstract<T extends Comparable<T>> {
    private T[] info; // Vetor a ser ordenado

    /**
     * Define o vetor que será ordenado.
     */
    public void setInfo(T[] info) {
        this.info = info;
    }

    /**
     * Retorna o vetor atual (antes ou depois da ordenação).
     */
    public T[] getInfo() {
        return info;
    }

    /**
     * Troca dois elementos de posição no vetor.
     * @param a índice do primeiro elemento
     * @param b índice do segundo elemento
     */
    protected void trocar(int a, int b) {
        T temp = info[a];
        info[a] = info[b];
        info[b] = temp;
    }

    /**
     * Método abstrato que obriga as subclasses a implementarem sua lógica de ordenação.
     */
    public abstract void ordenar();
}
