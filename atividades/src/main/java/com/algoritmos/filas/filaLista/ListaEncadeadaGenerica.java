package com.algoritmos.filas.filaLista;


public class ListaEncadeadaGenerica<T> {
    private NoLista<T> primeiro;
    private NoLista<T> ultimo;
    private int tamanho;

    public int getTamanho() {
        return tamanho;
    }
    
    public ListaEncadeadaGenerica() {
        this.primeiro = null;
        this.tamanho = 0; // Inicializa o tamanho como 0
    }

    public NoLista<T> getPrimeiro() {
        return primeiro;
    }

    public boolean estaVazia() {
        return primeiro == null;
    }

    public void inserir(T valor) {
        NoLista<T> novo = new NoLista<T>();

        novo.setInfo(valor);
        novo.setProximo(this.primeiro);

        if (estaVazia()) {
            ultimo = novo;
        } else {
            ultimo.setProximo(novo);
        }
        ultimo = novo;

        this.primeiro = novo;
        tamanho++; // Incrementa o tamanho
    }

    public void inserirNoFinal(T valor) {
        NoLista<T> novo = new NoLista<T>();

        novo.setInfo(valor);
        novo.setProximo(null);

        if (estaVazia()) {
            primeiro = novo;
        } else {
            ultimo.setProximo(novo);
        }

        ultimo = novo;
        tamanho++; // Incrementa o tamanho
    }

    public void retirar(T valor) {
        NoLista<T> p = this.primeiro;
        NoLista<T> anterior = null;

        // Procura nó que contém o dado a ser removido, guardando o anterior
        while (p != null && !p.getInfo().equals(valor)) {
            anterior = p;
            p = p.getProximo();
        }

        // Se achou o nó, retira-o da lista
        if (p != null) {
            if (p == this.primeiro) {
                this.primeiro = p.getProximo();
            } else {
                anterior.setProximo(p.getProximo());
            }
            tamanho--; // Decrementa o tamanho
        }
    }

    public ListaEncadeadaGenerica<T> criarInvertida(){
        ListaEncadeadaGenerica<T> invertida = new ListaEncadeadaGenerica<T>();
        NoLista<T> p = this.primeiro;
        
        while (p != null){
            invertida.inserir(p.getInfo());
            p = p.getProximo();
        }
        return invertida;
    }

    // ==========================
    // METODOS NOVOS
    // ==========================    

    // Metodo para pegar os elementos
    public T getElemento(int index) {
        if (index < 0 || index >= getTamanho()) {
            throw new IndexOutOfBoundsException("Índice fora dos limites: " + index);
        }

        NoLista<T> atual = getPrimeiro();
        for (int i = 0; i < index; i++) {
            atual = atual.getProximo();
        }

        return atual.getInfo();
    }

//     public void anexar(ListaGenerica<T> l2) {
//         // Se a lista estática estiver vazia, não há nada para anexar
//         if (l2.estaVazia()) {
//             return;
//         }
    
//         // Encontrar o último nó da lista encadeada atual
//         NoLista<T> p = this.primeiro;
//         if (p == null) {
//             // Se a lista encadeada estiver vazia, simplesmente copiar os elementos de l2
//             this.primeiro = new NoLista<T>();
//             this.primeiro.setInfo(l2.obterElemento(0));
//             p = this.primeiro;
//         }
//         while (p.getProximo() != null) {
//             p = p.getProximo();
//         }
    
//         // Percorrer a lista estática e adicionar os elementos ao final da lista encadeada
//         for (int i = 0; i < l2.getTamanho(); i++) {
//             NoLista<T> novo = new NoLista<T>();
//             novo.setInfo(l2.obterElemento(i));
//             p.setProximo(novo);
//             p = novo; // Atualizar p para o novo nó
//         }
    
// }
}


