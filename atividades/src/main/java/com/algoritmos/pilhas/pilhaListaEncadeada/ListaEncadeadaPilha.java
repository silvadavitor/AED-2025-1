package com.algoritmos.pilhas.pilhaListaEncadeada;


public class ListaEncadeadaPilha<T> {
    private NoLista<T> primeiro;
    private int tamanho;

    public int getTamanho() {
        return tamanho;
    }

    public ListaEncadeadaPilha() {
        this.primeiro = null;
        this.tamanho = 0; // Inicializa tamanho como 0
    }

    public NoLista<T> getPrimeiro() {
        return primeiro;
    }

    public void inserir(T valor) {
        NoLista<T> novo = new NoLista<T>();

        novo.setInfo(valor);
        novo.setProximo(this.primeiro);
        this.primeiro = novo;
        this.tamanho++; // Incrementa tamanho ao inserir
    }

    public void exibir() {
        NoLista<T> p = this.primeiro;

        while (p != null) {
            System.out.println(p.getInfo());
            p = p.getProximo();
        }
    }

    public boolean estaVazia() {
        return this.primeiro == null;
    }

    public NoLista<T> buscar(T valor) {
        NoLista<T> p = this.primeiro;

        while (p != null) {
            if (p.getInfo().equals(valor)) {
                return p;
            }
            p = p.getProximo();
        }
        return null;
    }

    public void retirar(T valor) {
        NoLista<T> p = this.primeiro;
        NoLista<T> anterior = null;

        // Procura nó que contém dado a ser removido, guardando o anterior
        while (p != null && !p.getInfo().equals(valor)) {
            anterior = p;
            p = p.getProximo();
        }

        // Se achou nó, retira-o da lista
        if (p != null) {
            if (p == this.primeiro) {
                this.primeiro = p.getProximo();
            } else {
                anterior.setProximo(p.getProximo());
            }
            this.tamanho--; // Decrementa tamanho ao retirar
        }
    }

    public int obterComprimento() {
        return this.tamanho; // Retorna diretamente o tamanho
    }

    public NoLista<T> obterNo(int idx) {
        if (idx < 0 || idx >= tamanho) {
            throw new IndexOutOfBoundsException("Fora dos limites.");
        }
        NoLista<T> p = getPrimeiro();
        while (p != null && 0 < idx) {
            idx--;
            p = p.getProximo();
        }
        return p;
    }

    public String toString() {
        String string = "";
        NoLista<T> p = this.primeiro;
        while (p != null) {
            string = string + p.getInfo() + ",";
            p = p.getProximo();
        }
        return string;
    }

    public ListaEncadeadaPilha<T> criarInvertida() {
        ListaEncadeadaPilha<T> invertida = new ListaEncadeadaPilha<T>();
        NoLista<T> p = this.primeiro;

        while (p != null) {
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

