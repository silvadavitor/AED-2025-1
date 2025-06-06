package com.algoritmos.busca.arvore;

public class NoArvoreBinaria<T> {
    private T info;
    private NoArvoreBinaria<T> esquerda;
    private NoArvoreBinaria<T> direita;

    public NoArvoreBinaria(T info) {
        this.info = info;
        this.esquerda = null;
        this.direita = null;
    }
    public NoArvoreBinaria(T info, NoArvoreBinaria<T> esquerda, NoArvoreBinaria<T> direita){
        this.info = info;
        this.esquerda = esquerda;
        this.direita = direita;
    }

    public T getInfo() {
        return info;
    }

    public NoArvoreBinaria<T> getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(NoArvoreBinaria<T> no) {
        this.esquerda = no;
    }

    public NoArvoreBinaria<T> getDireita() {
        return direita;
    }

    public void setDireita(NoArvoreBinaria<T> no) {
        this.direita = no;
    }

}