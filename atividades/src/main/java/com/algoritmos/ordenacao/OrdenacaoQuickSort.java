package com.algoritmos.ordenacao;

/**
 * Implementa o algoritmo QuickSort (dividir e conquistar).
 * Escolhe um pivô e organiza os menores à esquerda e maiores à direita, recursivamente.
 */
public class OrdenacaoQuickSort<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    @Override
    public void ordenar() {
        quickSort(0, getInfo().length - 1);
    }

    /**
     * Método recursivo principal do QuickSort.
     */
    private void quickSort(int inicio, int fim) {
        if (inicio < fim) {
            int pivo = particionar(inicio, fim); // Define a posição do pivô
            quickSort(inicio, pivo - 1); // Ordena a metade esquerda
            quickSort(pivo + 1, fim);    // Ordena a metade direita
        }
    }

    /**
     * Particiona o vetor em dois lados com base no pivô.
     */
    private int particionar(int inicio, int fim) {
        T[] info = getInfo();
        T pivo = info[inicio];
        int a = inicio + 1;
        int b = fim;

        while (true) {
            // Avança 'a' até encontrar um valor >= ao pivô
            while (a <= fim && info[a].compareTo(pivo) < 0) a++;
            // Retrocede 'b' até encontrar um valor <= ao pivô
            while (b >= inicio && info[b].compareTo(pivo) > 0) b--;

            if (a >= b) break;

            trocar(a, b); // Troca os elementos que estão fora de lugar
        }

        trocar(inicio, b); // Coloca o pivô na posição correta
        return b;
    }
}

