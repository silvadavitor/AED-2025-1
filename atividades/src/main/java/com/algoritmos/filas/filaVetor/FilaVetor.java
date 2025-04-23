package com.algoritmos.filas.filaVetor;

import java.util.Comparator;

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
        return info[inicio]; // Retorna o primeiro elemento da fila
    }

    @Override
    public T retirar() {
        if (estaVazia()) {
            throw new FilaVaziaException();
        }

        T valor = peek();
        inicio = (inicio + 1) % limite; // Move o início para o próximo elemento        
        tamanho--;
        return valor;
    }

    @Override
    public void liberar() {
        while (!estaVazia()) {
            retirar();
            // info[inicio] = null; // Opcional: Limpa a referência do elemento retirado
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
            // inserir(retirar()); // Outra forma de fazer a rotação 
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
    // METODOS NOVOS
    // ==========================
    
    // Intercala duas filas, preservando a ordem de cada uma
    // Exemplo: Fila1: 1,2,3 e Fila2: A,B,C -> Resultado: 1,A,2,B,3,C
    public FilaVetor<T> intercalarContatenando(FilaVetor<T> outra) {
        FilaVetor<T> resultado = new FilaVetor<>(this.tamanho + outra.tamanho);    
        
        FilaVetor<T> f1 = this.copiar(); // preserva original
        FilaVetor<T> f2 = outra.copiar();
    
        while (!f1.estaVazia() || !f2.estaVazia()) {
            if (!f1.estaVazia()) resultado.inserir(f1.retirar());
            if (!f2.estaVazia()) resultado.inserir(f2.retirar());
        }
    
        return resultado;
    }

    // Concatena duas filas, ordenando os ELEMENTOS de acordo com o Comparator fornecido
    // Exemplo: Fila1: 1,3,5 e Fila2: 8,4,6 -> Resultado: 1,8,3,4,5,6
    public FilaVetor<T> ordenadoConcatenando(FilaVetor<T> outra, Comparator<T> comparator) {
        FilaVetor<T> resultado = new FilaVetor<>(this.tamanho + outra.tamanho);

        FilaVetor<T> f1 = this.copiar();
        FilaVetor<T> f2 = outra.copiar();

        while (!f1.estaVazia() && !f2.estaVazia()) {
            if (comparator.compare(f1.peek(), f2.peek()) <= 0) {
                resultado.inserir(f1.retirar());
            } else {
                resultado.inserir(f2.retirar());
            }
        }

        while (!f1.estaVazia()) {
            resultado.inserir(f1.retirar());
        }
        while (!f2.estaVazia()) {
            resultado.inserir(f2.retirar());
        }

        return resultado;
    }
    
    // Cria uma nova fila concatenando duas existentes
    // Exemplo: Fila1: 1,3,5 e Fila2: 2,4,6 -> Resultado: 1,3,5,2,4,6
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

    // // Encolhe o vetor para o tamanho exato da fila atual usando metodo inserir
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

    // OUTRO EXEMPLO DE ENCOLHER SE NÃO PODER USAR O !!! METODO INSERIR !!!     <----- EX ALANA 
    // public void encolher() {
    //     T[] novo = (T[]) new Object[this.tamanho];

    //     for (int i = 0; i < tamanho; i++) {
    //         novo[i] = info[(inicio + i) % limite];
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
    /* // 1 - outro metodo de inverter (não recomendado)
    public void inverter() {        
        // Booblesort para inverter a fila (não recomendado)                   
        if (!estaVazia()) {
            for (int i = 0; i < tamanho - 1; i++) {
                for (int j = 0; j < tamanho - i - 1; j++) {
                    rotacionarDireita();
                }
            }
         }
    }  

    // 2 - inverter usando rotacionar
    public void rotacionar(int n) {
        if (estaVazia()) return;

        n = n % tamanho;
        if (n < 0) {
            n += tamanho; // Converte rotações negativas para positivas
        }

        for (int i = 0; i < n; i++) {
            rotacionarEsquerda();
        }
    }
         
    // 3 - Inverte a fila sem usar pilha (não recomendado)
    public void inverter() {
    if (estaVazia()) return;
        for (int i = 0; i < tamanho / 2; i++) {
            // Calculate the logical positions of the elements to be swapped
            int pos1 = (inicio + i) % limite;
            int pos2 = (inicio + tamanho - 1 - i) % limite;

            // Swap the elements at pos1 and pos2
            T temp = info[pos1];
            info[pos1] = info[pos2];
            info[pos2] = temp;
        }
    }
    */

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

    // Retorna se a fila é igual a outra (mesmo tamanho e elementos na mesma ordem)
    public boolean isIgual(FilaVetor<T> outra) {
        if (this.tamanho != outra.tamanho) {
            return false;
        }
        int pos1 = this.inicio;
        int pos2 = outra.inicio;
        for (int i = 0; i < this.tamanho; i++) {
            if (!this.info[pos1].equals(outra.info[pos2])) {
                return false;
            }
            pos1 = (pos1 + 1) % this.limite;
            pos2 = (pos2 + 1) % outra.limite;
        }
        return true;
    }

    // Metodo para substituir o elemento na fila
    public void substituir(int posicao, T novoValor) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida.");
        }
        int index = (inicio + posicao) % limite;
        info[index] = novoValor;
    }

    // Método para dividir a fila em duas filas (tentando balancear o tamanho)
    public FilaVetor<T>[] dividir() {
        if (tamanho <= 1) {
            throw new IllegalArgumentException("A fila não pode ser dividida, pois possui menos de 2 elementos.");
        }

        int tamanho1 = tamanho / 2;
        int tamanho2 = tamanho - tamanho1;

        FilaVetor<T>[] filas = new FilaVetor[2];
        filas[0] = new FilaVetor<>(tamanho1);
        filas[1] = new FilaVetor<>(tamanho2);

        for (int i = 0; i < tamanho1; i++) {
            filas[0].inserir(this.retirar());
        }
        for (int i = 0; i < tamanho2; i++) {
            filas[1].inserir(this.retirar());
        }

        return filas;
    }

    // Conta as ocorrencias de um elemento na fila
    public int contarOcorrencias(T valor) {
        int contador = 0;
        int pos = inicio;
        for (int i = 0; i < tamanho; i++) {
            if (info[pos].equals(valor)) {
                contador++;
            }
            pos = (pos + 1) % limite;
        }
        return contador;
    }

    // Nova fila apenas com os intervalos especificos
    public FilaVetor<T> subfila(int inicio, int fim) {
        if (inicio < 0 || fim >= tamanho || inicio > fim) {
            throw new IndexOutOfBoundsException("Intervalo inválido.");
        }
    
        FilaVetor<T> subfila = new FilaVetor<>(fim - inicio + 1);
        for (int i = inicio; i <= fim; i++) {
            subfila.inserir(getElemento(i));
        }
        return subfila;
    }

    // Método para obter o elemento na posição lógica da fila
    public T getElemento(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida.");
        }
        int index = (inicio + posicao) % limite;
        return info[index];
    }

    // Metodo para ver se e palindroma
    public boolean isPalindroma() {
        if (estaVazia()) {
            return false;
        }

        int pos1 = inicio;
        int pos2 = (inicio + tamanho - 1) % limite;

        for (int i = 0; i < tamanho / 2; i++) {
            if (!info[pos1].equals(info[pos2])) {
                return false;
            }
            pos1 = (pos1 + 1) % limite;
            pos2 = (pos2 - 1 + limite) % limite;
        }
        return true;
    }

}