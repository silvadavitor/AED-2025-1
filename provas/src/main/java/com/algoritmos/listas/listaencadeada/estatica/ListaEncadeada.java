package com.algoritmos.listas.listaencadeada.estatica;

public class ListaEncadeada {
    private NoLista primeiro;

    public ListaEncadeada() {
        this.primeiro = null;
    }

    public void insere(int valor) {
        NoLista novo = new NoLista();

        novo.setInfo(valor);
        novo.setProximo(this.primeiro);
        this.primeiro = novo;

    }

    public void exibir(){
        NoLista p = this.primeiro;

        while (p != null){
            System.out.println(p.getInfo());
            p = p.getProximo(); // p = p.proximo
        }
    }

    public boolean estaVazia(){
        if (this.primeiro == null){
            return true;
        }
        else{
            return false;
        }
    }

    public NoLista buscar(int valor){
        NoLista p = this.primeiro;

        while (p != null){
            if (p.getInfo() == valor) {
                return p;
            }
            p = p.getProximo();
        }
        return null;
    }

    public void retirar(int valor){
        NoLista p = this.primeiro;
        NoLista anterior = null;

        // procura nó que contém dado a ser removido,
        // guardando o anterior
        while (p != null && p.getInfo() != valor){
            anterior = p;
            p = p.getProximo();
        }

        // Se achou nó, retira-o da lista
        if (p != null){
            if (p == this.primeiro){
                this.primeiro = p.getProximo();
            }
            else{
                anterior.setProximo(p.getProximo());
            }
        }
                }

}
