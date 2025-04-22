package com.algoritmos.pilhas.pilhaVetor;

import javax.management.RuntimeErrorException;

public class  PilhaVetor<T> implements Pilha<T>{

    private int limite;
    private int tamanho;
    private Object[] info;


    public PilhaVetor(int limite){
        info = new Object[limite];
        this.limite = limite;
        this.tamanho = 0;
    }

    @Override
    public void push(T valor){
        if(limite == tamanho){
            throw new PilhaCheiaException();
        }

        info[tamanho] = valor;
        tamanho = tamanho + 1;
    }

    @Override
    public T peek(){
        if(estaVazia()){
            throw new PilhaVaziaException();
        }

        return (T) info[tamanho-1];
    }

    @Override
    public T pop(){
        if(estaVazia()){
            throw new PilhaVaziaException();
        }
        T valor;
        valor = peek();

        info[tamanho-1] = null;

        tamanho = tamanho-1;

        return valor;
    }

    @Override
    public boolean estaVazia(){
        if (tamanho == 0){
            return true;
        }
        return false;
    }

    @Override
    public void liberar(){
        tamanho = 0;
        info = new Object[limite];
    }
    
    public String toString() {
        if (tamanho == 0) {
            return "";
        }
        StringBuilder str = new StringBuilder();
        for (int i = tamanho - 1; i >= 0; i--) {  // Começa do topo da pilha
            str.append(info[i]);
            if (i != 0) {  // Adiciona vírgula entre os elementos, mas não após o último
                str.append(",");
            }
        }
        return str.toString();
    }

    // ==========================
    // METODOS NOVOS
    // ==========================

    // da o push no objeto que é varrido da pilha(que foi passada como argumento) para essa nossa pilha 
    public void concatenar(PilhaVetor<T> p){
        if (tamanho + p.tamanho > limite) {
            throw new PilhaCheiaException();
        }
        for (int i = 0; i < p.tamanho; i++) {
            this.push((T)p.info[i]);
        }
    }

    // OUTRO JEITO DE FAZER
    // public void concatenar(PilhaVetor<T> p) throws PilhaCheiaException {

	// 	if (tamanho + p.tamanho > limite) {
	// 		throw new PilhaCheiaException("A pilha está cheia");
	// 	}

	// 	PilhaVetor<T> pilhaP = new PilhaVetor<>(limite - tamanho);

	// 	while (!p.estaVazia()) {
	// 		pilhaP.push(p.pop());
	// 	}

	// 	while (!pilhaP.estaVazia()) {
	// 		this.push(pilhaP.pop());
	// 	}

    // Metodo para inverter a pilha
    public void inverter() {
        PilhaVetor<T> pilhaAux = new PilhaVetor<>(limite);
        while (!estaVazia()) {
            pilhaAux.push(pop());
        }
        while (!pilhaAux.estaVazia()) {
            push(pilhaAux.pop());
        }
    }

    /*// Metodo para inverter a pilha usando recursividade
    public void inverterRecursivo() {
        if (estaVazia()) {
            return;
        }
        T valor = pop();
        inverterRecursivo();
        push(valor);
    }*/

    // Metodo copia
    public PilhaVetor<T> copia() {
        PilhaVetor<T> pilhaCopia = new PilhaVetor<>(limite);
        for (int i = 0; i < tamanho; i++) {
            pilhaCopia.push((T) info[i]);
        }
        return pilhaCopia;
    }

    // Metodo pertence
    public boolean pertence(T valor) {
        for (int i = 0; i < tamanho; i++) {
            if (info[i].equals(valor)) {
                return true;
            }
        }
        return false;
    }

    // Metodo retorna o indice do elemento
    public int indexOf(T valor) {
        for (int i = tamanho - 1; i >= 0; i--) {
            if (info[i].equals(valor)) {
                return tamanho - 1 - i; // Índice relativo ao topo
            }
        }
        return -1;
    }

    // Compara duas pilhas
    public boolean isIgual(PilhaVetor<T> p) {
        if (this.tamanho != p.tamanho) {
            return false;
        }
        for (int i = 0; i < tamanho; i++) {
            if (!info[i].equals(p.info[i])) {
                return false;
            }
        }
        return true;
    }

    // Metodo para retornar uma nova pilha do topo ate a quantidade do parametro (de cima pra baixo)
    //ex: se a pilha tem 5 elementos e o parametro é 3, retorna uma pilha com os 3 primeiros elementos (de cima pra baixo)
    public PilhaVetor<T> subPilha(int n) {
        if (n > tamanho) {
            throw new IllegalArgumentException("Número de elementos maior que o tamanho da pilha");
        }
        PilhaVetor<T> subPilha = new PilhaVetor<>(n);
        for (int i = tamanho - n; i < tamanho; i++) {
            subPilha.push((T) info[i]);
        }
        return subPilha;
    }

}