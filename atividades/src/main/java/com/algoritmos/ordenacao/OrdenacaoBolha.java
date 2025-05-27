package com.algoritmos.ordenacao;

/**
 * Implementa o algoritmo de ordenação Bolha (Bubble Sort).
 * Percorre o vetor várias vezes, trocando elementos adjacentes se estiverem fora de ordem.
 */
public class OrdenacaoBolha<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    /**
     * Ordena o vetor usando o algoritmo Bolha.
     */
    @Override
    public void ordenar() {
        T[] info = getInfo();

        // Laço externo controla o número de passagens (n-1)
        for (int i = info.length - 1; i > 0; i--) {
            // Laço interno percorre os elementos até a posição 'i'
            for (int j = 0; j < i; j++) {
                // Compara elementos adjacentes e troca se estiverem fora de ordem
                if (info[j].compareTo(info[j + 1]) > 0) {
                    trocar(j, j + 1);
                }
            }
        }
    }
}
