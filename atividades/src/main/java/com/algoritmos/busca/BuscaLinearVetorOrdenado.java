package com.algoritmos.busca;

public class BuscaLinearVetorOrdenado<T extends Comparable<T>> extends BuscaAbstract {
    
    public int buscar(T valor){
        Object[] dados = getInfo();
        int n = dados.length-1;

        for (int i = 0; i < n; i++) {
            

            if (dados[i].equals(valor)) {
                return i;
            }
            else{
               if (valor.compareTo((T) dados[i]) < 0) {
                break;
               }
            }
        }
        return -1;
    }
}
