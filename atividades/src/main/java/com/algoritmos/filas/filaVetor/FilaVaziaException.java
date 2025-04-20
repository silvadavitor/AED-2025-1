package com.algoritmos.filas.filaVetor;

public class FilaVaziaException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Erro: a lista esta vazia";
    }
}
