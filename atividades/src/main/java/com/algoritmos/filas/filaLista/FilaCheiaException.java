package com.algoritmos.filas.FilaLista;

public class FilaCheiaException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Error: a fila esta cheia.";
    }
}
