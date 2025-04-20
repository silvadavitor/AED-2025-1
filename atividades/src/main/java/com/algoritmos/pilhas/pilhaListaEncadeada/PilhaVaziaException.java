package com.algoritmos.pilhas.pilhaListaEncadeada;

public class PilhaVaziaException extends RuntimeException {
    
    @Override
    public String getMessage() {
        return "Erro: a pilha esta vazia";
    }
}
