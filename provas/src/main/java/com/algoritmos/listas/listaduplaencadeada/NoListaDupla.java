package com.algoritmos.listas.listaduplaencadeada;

public class NoListaDupla<T> {
    private T info;
    private NoListaDupla<T> proximo;
    private NoListaDupla<T> anterior;
    

    public NoListaDupla<T> getAnterior() {
        return anterior;
    }
    
    public void setAnterior(NoListaDupla<T> anterior) {
        this.anterior = anterior;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public void setProximo(NoListaDupla<T> proximo) {
        this.proximo = proximo;
    }

    public T getInfo() {
        return info;
    }
    
    public NoListaDupla<T> getProximo() {
        return proximo;
    }
}
