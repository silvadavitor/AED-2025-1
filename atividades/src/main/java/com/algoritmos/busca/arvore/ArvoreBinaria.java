package com.algoritmos.busca.arvore;

public class ArvoreBinaria<T> extends ArvoreBinariaAbstract<T> {

    public ArvoreBinaria() {
        super();
    }

    @Override
    public NoArvoreBinaria<T> buscar(T info) {
        return buscar(raiz, info);
    }

    private NoArvoreBinaria<T> buscar(NoArvoreBinaria<T> no, T info) {
        if (no == null) return null;

        if (no.getInfo().equals(info)) return no;

        NoArvoreBinaria<T> esq = buscar(no.getEsquerda(), info);
        if (esq != null) return esq;

        return buscar(no.getDireita(), info);
    }

    public void setRaiz(NoArvoreBinaria<T> raiz) {
        super.setRaiz(raiz);
    }
}
