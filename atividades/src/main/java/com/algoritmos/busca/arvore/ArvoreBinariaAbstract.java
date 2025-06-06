package com.algoritmos.busca.arvore;

public abstract class ArvoreBinariaAbstract<T> {
    protected NoArvoreBinaria<T> raiz;

    public ArvoreBinariaAbstract() {
        this.raiz = null;
    }

    protected void setRaiz(NoArvoreBinaria<T> raiz) {
        this.raiz = raiz;
    }

    protected NoArvoreBinaria<T> getRaiz() {
        return raiz;
    }

    public boolean estaVazia() {
        return raiz == null;
    }

    public boolean pertence(T info) {
        return buscar(info) != null;
    }

    public abstract NoArvoreBinaria<T> buscar(T info);

    public String toString() {
        return arvorePre(raiz);
    }

    private String arvorePre(NoArvoreBinaria<T> no) {
        if (no == null) return "<>";
        return "<" + no.getInfo() + arvorePre(no.getEsquerda()) + arvorePre(no.getDireita()) + ">";
    }

    public int contarNos() {
        return contarNos(raiz);
    }

    private int contarNos(NoArvoreBinaria<T> no) {
        if (no == null) return 0;
        return 1 + contarNos(no.getEsquerda()) + contarNos(no.getDireita());
    }

    public int contarNosNivel(int nivel) {
        return contarNosNivel(raiz, nivel, 0);
    }

    private int contarNosNivel(NoArvoreBinaria<T> no, int nivel, int atual) {
        if (no == null) return 0;
        if (atual == nivel) return 1;
        return contarNosNivel(no.getEsquerda(), nivel, atual + 1) + contarNosNivel(no.getDireita(), nivel, atual + 1);
    }
}
