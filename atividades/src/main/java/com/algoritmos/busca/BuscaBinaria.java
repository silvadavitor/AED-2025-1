package com.algoritmos.busca;


public class BuscaBinaria<T extends Comparable<T>> extends BuscaAbstract{

    public int buscar(T valor) {
        Object[] info = getInfo();
        int n = info.length;
        int inicio = 0;
        int fim = n - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            int comparacao = valor.compareTo((T)getInfo()[meio]);
            if (comparacao < 0) {
                fim = meio - 1; 
            } else {
                if (comparacao > 0) {
                    inicio = meio + 1;
                } else {
                    return meio; 
                }
            }
        }
        return -1; 
    }
}
