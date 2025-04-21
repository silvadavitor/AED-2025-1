package com.algoritmos.filas.filaLista;

import com.algoritmos.pilhas.pilhaVetor.PilhaVetor;

public class FilaLista<T> implements Fila<T> {
    private ListaEncadeadaGenerica<T> lista;

    // ==========================
    // CONSTRUTOR
    // ==========================

    FilaLista() {
        lista = new ListaEncadeadaGenerica<T>();
    }

    // ==========================
    // MÉTODOS DA INTERFACE FILA
    // ==========================

    // Insere elemento no final da fila
    @Override
    public void inserir(T valor) {
        lista.inserirNoFinal(valor);
    }

    // Verifica se a fila está vazia
    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    // Retorna o primeiro elemento da fila sem removê-lo
    @Override
    public T peek() {
        if (estaVazia()) {
            throw new FilaVaziaException();
        }
        return lista.getPrimeiro().getInfo();
    }

    // Retira o primeiro elemento da fila
    @Override
    public T retirar() {
        if (estaVazia()) {
            throw new FilaVaziaException();
        }

        T valor = peek(); // pega o valor antes de remover
        lista.retirar(valor); // remove o primeiro elemento
        return valor;
    }

    // Libera (esvazia) a fila
    @Override
    public void liberar() {
        lista = new ListaEncadeadaGenerica<T>(); // recria uma nova lista vazia
    }

    // ==========================
    // OUTROS MÉTODOS (COMENTADOS)
    // ==========================

    public FilaLista<T> copiar() {
        FilaLista<T> nova = new FilaLista<>();
        NoLista<T> atual = lista.getPrimeiro();
    
        while (atual != null) {
            nova.inserir(atual.getInfo());
            atual = atual.getProximo();
        }
    
        return nova;
    }

    public void inverter() {
        ListaEncadeadaGenerica<T> invertida = lista.criarInvertida();
        this.lista = invertida;
    }

    // ==========================
    // REPRESENTAÇÃO EM TEXTO
    // ==========================

    // Retorna a representação textual da fila (delegando à lista)
    @Override
    public String toString() {
        return lista.toString();
    }
}
