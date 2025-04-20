package com.algoritmos.arvore.arvoreNaria;

public class NoArvore<T> {
    private T info;
    private NoArvore<T> Primeiro;
    private NoArvore<T> Proximo;

    public NoArvore(T info){
        this.info = info;
        this.Primeiro = null;
        this.Proximo = null;
    }


    public void inserirFilho(NoArvore<T> sa){
        sa.Proximo = this.Primeiro;
        this.Primeiro = sa;
    }


    
    public T getInfo() {
        return info;
    }
    
    public void setInfo(T info) {
        this.info = info;
    }


    public NoArvore<T> getPrimeiro() {
        return Primeiro;
    }

    public void setPrimeiro(NoArvore<T> Primeiro) {
        this.Primeiro = Primeiro;
    }

    public NoArvore<T> getProximo() {
        return Proximo;
    }

    public void setProximo(NoArvore<T> Proximo) {
        this.Proximo = Proximo;
    }
}


