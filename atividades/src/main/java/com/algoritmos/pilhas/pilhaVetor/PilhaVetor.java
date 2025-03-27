package com.algoritmos.pilhas.pilhaVetor;

import javax.management.RuntimeErrorException;

public class  PilhaVetor<T> implements Pilha<T>{

    private int limite;
    private int tamanho;
    private T[] info;


    PilhaVetor(int limite){
        info = (T[]) new Object[limite];
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

        return info[tamanho-1];
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
        info = (T[]) new Object[limite];
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


    // da o push no objeto que é varrido da pilha(que foi passada como argumento) para essa nossa pilha 
    public void concatenar(PilhaVetor<T> p){
        if (tamanho + p.tamanho > limite) {
            throw new PilhaCheiaException();
        }
        for (int i = 0; i < p.tamanho; i++) {
            this.push(p.info[i]);
        }
    }


}