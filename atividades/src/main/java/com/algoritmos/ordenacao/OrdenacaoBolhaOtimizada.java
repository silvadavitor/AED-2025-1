package com.algoritmos.ordenacao;

/**
 * Versão otimizada do Bubble Sort.
 * Interrompe a execução se uma passagem for feita sem nenhuma troca.
 */
public class OrdenacaoBolhaOtimizada<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    @Override
    public void ordenar() {
        T[] info = getInfo();
        boolean trocou;

        for (int i = info.length - 1; i > 0; i--) {
            trocou = false;

            for (int j = 0; j < i; j++) {
                if (info[j].compareTo(info[j + 1]) > 0) {
                    trocar(j, j + 1);
                    trocou = true; // Marca que houve troca
                }
            }

            if (!trocou) break; // Se não houve troca, vetor já está ordenado
        }
    }
}
