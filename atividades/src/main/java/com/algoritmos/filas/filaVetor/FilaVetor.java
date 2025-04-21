package com.algoritmos.filas.filaVetor;

import com.algoritmos.pilhas.pilhaVetor.PilhaVetor;

public class FilaVetor<T> implements Fila<T> {
    private T info[];
    private int limite;
    private int tamanho;
    private int inicio;

    // ==========================
    // CONSTRUTOR
    // ==========================

    @SuppressWarnings("unchecked")
    FilaVetor(int limite) {
        this.limite = limite;
        info = (T[]) new Object[limite];
        tamanho = 0;
        inicio = 0;
    }

    // ==========================
    // MÉTODOS DA INTERFACE FILA
    // ==========================

    @Override
    public void inserir(T valor) {
        if (tamanho == limite) {
            throw new FilaCheiaException();
        }

        int posicaoInserir = (inicio + tamanho) % limite;
        info[posicaoInserir] = valor;
        tamanho++;
    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public T peek() {
        if (estaVazia()) {
            throw new FilaVaziaException();
        }
        return info[inicio];
    }

    @Override
    public T retirar() {
        if (estaVazia()) {
            throw new FilaVaziaException();
        }

        T valor = peek();
        inicio = (inicio + 1) % limite;
        tamanho--;
        return valor;
    }

    @Override
    public void liberar() {
        while (!estaVazia()) {
            retirar();
        }
    }

    // ==========================
    // MÉTODOS UTILITÁRIOS
    // ==========================

    // Retorna o último elemento da fila (sem remover)
    public T getUltimo() {
        if (estaVazia()) {
            throw new FilaVaziaException();
        }
        int pos = (inicio + tamanho - 1) % limite;
        return info[pos];
    }

    // Verifica se a fila contém um determinado valor
    public boolean contem(T valor) {
        int pos = inicio;
        for (int i = 0; i < tamanho; i++) {
            if (info[pos].equals(valor)) {
                return true;
            }
            pos = (pos + 1) % limite;
        }
        return false;
    }

    // Retorna o índice (lógico) do valor na fila, ou -1 se não existir
    public int indexOf(T valor) {
        int pos = inicio;
        for (int i = 0; i < tamanho; i++) {
            if (info[pos].equals(valor)) {
                return i;
            }
            pos = (pos + 1) % limite;
        }
        return -1;
    }

    // Retorna uma cópia da fila atual
    public FilaVetor<T> copiar() {
        FilaVetor<T> nova = new FilaVetor<>(limite);
        int pos = inicio;
        for (int i = 0; i < tamanho; i++) {
            nova.inserir(info[pos]);
            pos = (pos + 1) % limite;
        }
        return nova;
    }

    // Rotaciona a fila para a esquerda (primeiro elemento vai para o fim)
    public void rotacionarEsquerda() {
        if (!estaVazia()) {
            T primeiro = retirar();
            inserir(primeiro);
        }
    }

    // Rotaciona a fila para a direita (último elemento vai para o início)
    public void rotacionarDireita() {
        if (estaVazia()) return;

        int posUltimo = (inicio + tamanho - 1) % limite;
        T ultimo = info[posUltimo];

        // Move o início circularmente para trás
        inicio = (inicio - 1 + limite) % limite;
        info[inicio] = ultimo;
        // Nota: tamanho permanece o mesmo
    }  

    @Override
    public String toString() {
        String retorno = "";
        int posicao = inicio;

        for (int i = 0; i < tamanho; i++) {
            if (i > 0) {
                retorno += ",";
            }
            retorno += info[posicao];
            posicao = (posicao + 1) % limite;
        }
        return retorno;
    }

    // Retorna a capacidade máxima da fila
    public int getLimite() {
        return limite;
    }

    // Retorna o número de elementos atualmente na fila
    public int getTamanho() {
        return tamanho;
    }

    public int getInicio() {
        return inicio;
    }

    public T[] getInfo() {
        return info;
    }

    public void setInfo(T[] info) {
        this.info = info;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    // ==========================
    // OPERAÇÕES SOBRE A FILA
    // ==========================
    
    public FilaVetor<T> intercalarCom(FilaVetor<T> outra) {
        FilaVetor<T> resultado = new FilaVetor<>(this.tamanho + outra.tamanho);
    
        int i = 0, j = 0;
        FilaVetor<T> f1 = this.copiar(); // preserva original
        FilaVetor<T> f2 = outra.copiar();
    
        while (!f1.estaVazia() || !f2.estaVazia()) {
            if (!f1.estaVazia()) resultado.inserir(f1.retirar());
            if (!f2.estaVazia()) resultado.inserir(f2.retirar());
        }
    
        return resultado;
    }
    
    // Cria uma nova fila concatenando duas existentes
    public FilaVetor<T> criarFilaConcatenada(FilaVetor<T> f2) {
        FilaVetor<T> fila = new FilaVetor<T>(limite + f2.limite);
        int index = inicio;

        for (int i = 0; i < tamanho; i++) {
            if (index == limite) index = 0;
            fila.inserir(info[index]);
            index++;
        }

        index = f2.inicio;
        for (int i = 0; i < f2.tamanho; i++) {
            if (index == f2.limite) index = 0;
            fila.inserir(f2.info[index]);
            index++;
        }
        return fila;
    }

    // Encolhe o vetor para o tamanho exato da fila atual
    public void encolher() {
        FilaVetor<T> novaFila = new FilaVetor<>(tamanho);
        int index = inicio;

        for (int i = 0; i < tamanho; i++) {
            if (index == limite) index = 0;
            novaFila.inserir(info[index]);
            index++;
        }

        this.info = novaFila.info;
        limite = tamanho;
        inicio = 0;
    }

    // OUTRO EXEMPLO DE ENCOLHER (comentado)
    // public void encolher() {
    //     T[] novo = (T[]) new Object[tamanho];
    //     int posicao = inicio;

    //     for (int i = 0; i < tamanho; i++) {
    //         novo[i] = info[posicao];
    //         posicao = (posicao + 1) % limite;
    //     }
    //     this.inicio = 0;
    //     this.info = novo;
    //     this.limite = tamanho;
    // }

    // Aumenta a capacidade da fila circular
    public void aumentar(int novoLimite) {
        if (novoLimite <= limite) {
            throw new IllegalArgumentException("Novo limite deve ser maior que o atual.");
        }

        T[] novo = (T[]) new Object[novoLimite];
        int posicao = inicio;

        for (int i = 0; i < tamanho; i++) {
            novo[i] = info[posicao];
            posicao = (posicao + 1) % limite;
        }

        this.info = novo;
        this.limite = novoLimite;
        this.inicio = 0;
    }

    // Inverte os elementos da fila usando uma pilha
    public void inverter() {
        PilhaVetor<T> pilha = new PilhaVetor<>(tamanho);
        while (!estaVazia()) {
            pilha.push(retirar());
        }
        while (!pilha.estaVazia()) {
            inserir(pilha.pop());
        }
    }

    // Empilha os elementos da fila (esvazia a fila no processo)
    public PilhaVetor<T> empilhar(FilaVetor<T> fila) {
        PilhaVetor<T> pilha = new PilhaVetor<T>(fila.getTamanho());

        // int tamanhoInicialFila = fila.getTamanho();

        while (!fila.estaVazia()) {
            pilha.push(fila.retirar());
        }

        return pilha;
    }

    /* EMPILHA SEM MODIFICAR A FILA (comentado)
    public PilhaVetor<T> empilhar(FilaVetor<T> fila) {
        PilhaVetor<T> pilha = new PilhaVetor<>(fila.getTamanho());

        int index = fila.getInicio();
        for (int i = 0; i < fila.getTamanho(); i++) {
            pilha.push(fila.getInfo()[index]);
            index = (index + 1) % fila.getLimite();
        }

        return pilha;
    }
    */
}
