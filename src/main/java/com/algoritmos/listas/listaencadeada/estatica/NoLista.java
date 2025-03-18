package com.algoritmos.listas.listaencadeada.estatica;

public class NoLista {
    private int info;
    private NoLista proximo;

    public void setInfo(int info) {
        this.info = info;
    }
    public void setProximo(NoLista proximo) {
        this.proximo = proximo;
    }
    public int getInfo() {
        return info;
    }
    public NoLista getProximo() {
        return proximo;
    }
}
