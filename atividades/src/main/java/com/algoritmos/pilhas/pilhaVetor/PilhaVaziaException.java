package com.algoritmos.pilhas.pilhaVetor;

public class PilhaVaziaException extends RuntimeException {
    
    @Override
    public String getMessage() {
        return "Erro: a pilha esta vazia";
    }
}
