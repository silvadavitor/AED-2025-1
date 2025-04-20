package com.algoritmos.filas.FilaLista;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FilaListaTest {

    @Test
    public void testCaso1_EstaVaziaFilaVazia() {
        // Caso 1: Conferir se o método estaVazia() reconhece fila vazia
        FilaLista<Integer> fila = new FilaLista<>();
        assertTrue(fila.estaVazia());
    }

    @Test
    public void testCaso2_EstaVaziaFilaNaoVazia() {
        // Caso 2: Conferir se o método estaVazia() reconhece fila não vazia
        FilaLista<Integer> fila = new FilaLista<>();
        fila.inserir(10);
        assertFalse(fila.estaVazia());
    }

    @Test
    public void testCaso3_EnfileirarEDesenfileirar() {
        // Caso 3: Conferir se os dados são enfileirados e desenfileirados corretamente
        FilaLista<Integer> fila = new FilaLista<>();
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        assertEquals(10, fila.retirar()); // Primeiro a sair é o 10
        assertEquals(20, fila.retirar()); // Depois o 20
        assertEquals(30, fila.retirar()); // Depois o 30
        assertTrue(fila.estaVazia());     // Agora deve estar vazia
    }

    @Test
    public void testCaso4_Peek() {
        // Caso 4: Conferir se o método peek() retorna o início da fila
        FilaLista<Integer> fila = new FilaLista<>();
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        assertEquals(10, fila.peek());   // Deve retornar 10 sem remover
        assertEquals(10, fila.retirar()); // Agora sim remover 10
    }

    @Test
    public void testCaso5_Liberar() {
        // Caso 5: Conferir se o método liberar() remove os elementos da fila
        FilaLista<Integer> fila = new FilaLista<>();
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        fila.liberar(); // Limpa a fila

        assertTrue(fila.estaVazia()); // Deve estar vazia depois de liberar
    }
}
