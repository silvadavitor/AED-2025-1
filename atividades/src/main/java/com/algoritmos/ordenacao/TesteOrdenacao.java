package com.algoritmos.ordenacao;

import java.util.Arrays;

public class TesteOrdenacao {
    public static void main(String[] args) {
        Integer[] vetorOriginal = {70, 2, 88, 15, 90, 30};

        testar("Bolha", new OrdenacaoBolha<>(), vetorOriginal);
        testar("Bolha Otimizada", new OrdenacaoBolhaOtimizada<>(), vetorOriginal);
        testar("QuickSort", new OrdenacaoQuickSort<>(), vetorOriginal);
        testar("MergeSort", new OrdenacaoMergeSort<>(), vetorOriginal);
    }

    private static void testar(String nome, OrdenacaoAbstract<Integer> algoritmo, Integer[] original) {
        Integer[] copia = Arrays.copyOf(original, original.length);
        algoritmo.setInfo(copia);
        algoritmo.ordenar();
        System.out.println(nome + ": " + Arrays.toString(algoritmo.getInfo()));
    }
}
