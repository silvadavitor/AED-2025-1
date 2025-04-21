package com.algoritmos.filas.filaVetor;
import com.algoritmos.pilhas.pilhaVetor.PilhaVetor;

public class FilaVetor<T> implements Fila<T> {
    private T info[];
    private int limite;
    private int tamanho;
    private int inicio;

    
    @SuppressWarnings("unchecked")
    FilaVetor(int limite) {
        this.limite = limite;
        info = (T[]) new Object[limite];
        tamanho = 0;
        inicio = 0;
    }

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
        if (tamanho == 0) {
            return true;
        }
        return false;
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

    @Override
    public String toString() {
        String retorno = "";
        int posicao = inicio;

        for (int i = 0; i < tamanho; i++) {
            if (i > 0){
                retorno += ",";
            }
            retorno = retorno + info[posicao];
            posicao = (posicao + 1) % limite;
            
        }
        return retorno;
    }

    public int getLimite() {
        return limite;
    }

    //metodo encolher
    public void encolher(){
        FilaVetor<T> novaFila = new FilaVetor<>(tamanho);
        int index = inicio;
        for (int i = 0; i < tamanho; i++) {
            if (index == limite) index = 0;
            novaFila.inserir(info[index]);
            index++;
        }
        this.info = novaFila.info;   // meu vetor vai ser o vetor que eu criei
        limite = tamanho;            // meu limite vai ser o tamanho que está
        inicio = 0;                  // indice começa do 0 no novo vetor fila
    }

    //OUTRO EXEMPLO
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




    // DESSE JEITO EU ESVAZIO A FILA E EMPILHO NA PILHA
    public void empilhar(FilaVetor<T> fila) {
        PilhaVetor<T> pilha = new PilhaVetor<T>(fila.getTamanho());

        // int tamanhoInicialFila = fila.getTamanho();

        while (!fila.estaVazia()) {
            pilha.push(fila.retirar());
        }

        System.out.println("Conteúdo da pilha: " + pilha.toString());
        System.out.println("Conteúdo da fila: " + fila.toString());
    }


    /* DESSE JEITO EU EMPILHO A FILA SEM RETIRAR NADA DELA
    public void empilhar(FilaVetor<T> fila) {
        PilhaVetor<T> pilha = new PilhaVetor<>(fila.getTamanho());
    
        int index = fila.getInicio();
        for (int i = 0; i < fila.getTamanho(); i++) {
            pilha.push(fila.getInfo()[index]);
            index = (index + 1) % fila.getLimite();
        }
    
        System.out.println("Conteúdo da pilha: " + pilha.toString());
        System.out.println("Conteúdo da fila (original mantida): " + fila.toString());
    }
        */
    

    
    
    public T[] getInfo() {
        return info;
    }

    public void setInfo(T[] info) {
        this.info = info;
    }


    public void setLimite(int limite) {
        this.limite = limite;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }
}
