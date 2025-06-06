package com.algoritmos.busca;

public class BuscaLinear<T> extends BuscaAbstract {
    
    public int buscar(T valor){
        Object[] dados = getInfo();
        int n = dados.length-1;

        for (int i = 0; i < n; i++) {
            if (dados[i].equals(valor)) {
                return i;
            }
        }
        return -1;
    }
}

