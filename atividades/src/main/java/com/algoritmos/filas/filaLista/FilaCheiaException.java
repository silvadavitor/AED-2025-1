package com.algoritmos.filas.filaLista;

public class FilaCheiaException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Error: a fila esta cheia.";
    }
}
