package com.algoritmos.pilhas.pilhaVetor;

public class PilhaCheiaException extends RuntimeException {
    
    @Override
    public String getMessage() {
        return "Erro: a pilha esta cheia";
    }
}
