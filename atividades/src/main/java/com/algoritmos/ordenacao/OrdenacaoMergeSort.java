package com.algoritmos.ordenacao;


/**
 * Implementa o algoritmo MergeSort.
 * Divide o vetor em partes e depois intercala os vetores ordenados.
 */
public class OrdenacaoMergeSort<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    @Override
    public void ordenar() {
        int n = getInfo().length - 1;
        mergeSort(0, n);
    }


    /**
     * Método recursivo para dividir o vetor em dois.
     */
    private void mergeSort(int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(inicio, meio);
            mergeSort(meio + 1, fim);
            merge(inicio, fim, meio);
        }
    }


    /**
     * Junta dois subvetores ordenados em um único vetor ordenado.
     */
    private void merge(int inicio, int fim, int meio) {
        T[] info = getInfo();

        int tamEsquerda = meio - inicio + 1;
        T[] esquerda = (T[]) new Comparable[tamEsquerda];

        for (int i = 0; i < tamEsquerda; i++) {
            esquerda[i] = info[inicio + i];
        }

        int tamDireita = fim - meio;
        T[] direita = (T[]) new Comparable[tamDireita];

        for (int i = 0; i < tamDireita; i++) {
            direita[i] = info[meio + 1 + i];
        }

        int cEsq = 0;
        int cDir = 0;
        int i;

        // Aqui usamos 'i' como o índice do vetor original info[]
        for (int i = inicio; i <= fim; i++) {
            if (cEsq < tamEsquerda && cDir < tamDireita) {
                if (esquerda[cEsq].compareTo(direita[cDir]) < 0) {
                    info[i] = esquerda[cEsq];
                    cEsq = cEsq + 1;
                } else {
                    info[i] = direita[cDir];
                    cDir = cDir + 1;
                }
            } else {
                break;
            }
        }

        // Continua copiando o restante da esquerda
        while (cEsq < tamEsquerda) {
            info[i] = esquerda[cEsq];
            cEsq = cEsq + 1;
            i = i + 1;
        }

        // Continua copiando o restante da direita
        while (cDir < tamDireita) {
            info[i] = direita[cDir];
            cDir = cDir + 1;
            i = i + 1;
        }
    }

}

