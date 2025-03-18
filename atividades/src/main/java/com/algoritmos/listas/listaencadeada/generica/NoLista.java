package com.algoritmos.listas.listaencadeada.generica;

public class NoLista<T> {
    
    private T info;
    private NoLista<T> proximo;

    public void setInfo(T info) {
        this.info = info;
    }
    public void setProximo(NoLista<T> proximo) {
        this.proximo = proximo;
    }
    public T getInfo() {
        return info;
    }
    public NoLista<T> getProximo() {
        return proximo;
    }
}
