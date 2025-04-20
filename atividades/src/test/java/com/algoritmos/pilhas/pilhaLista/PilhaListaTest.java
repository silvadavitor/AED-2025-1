package com.algoritmos.pilhas.pilhaListaEncadeada;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PilhaListaTest {

    @Test
    public void testEstaVaziaComPilhaVazia() {
        // Caso 1: Conferir se o método estaVazia() reconhece pilha vazia
        PilhaLista<Integer> pilha = new PilhaLista<>();
        assertTrue(pilha.estaVazia());
    }

    @Test
    public void testEstaVaziaComPilhaNaoVazia() {
        // Caso 2: Conferir se o método estaVazia() reconhece pilha não vazia
        PilhaLista<Integer> pilha = new PilhaLista<>();
        pilha.push(10);
        assertFalse(pilha.estaVazia());
    }

    @Test
    public void testEmpilharEDesempilharOrdemCorreta() {
        // Caso 3: Conferir se os dados são empilhados e desempilhados corretamente
        PilhaLista<Integer> pilha = new PilhaLista<>();
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        assertEquals(30, pilha.pop());
        assertEquals(20, pilha.pop());
        assertEquals(10, pilha.pop());
        assertTrue(pilha.estaVazia());
    }

    @Test
    public void testPeekRetornaTopoDaPilha() {
        // Caso 4: Conferir se o método peek() retorna o topo da pilha
        PilhaLista<Integer> pilha = new PilhaLista<>();
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        assertEquals(30, pilha.peek());
        assertEquals(30, pilha.pop()); // Confere que o topo era 30
    }

    @Test
    public void testLiberarEsvaziaPilha() {
        // Caso 5: Conferir se o método liberar() remove os elementos da pilha
        PilhaLista<Integer> pilha = new PilhaLista<>();
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        pilha.liberar();

        assertTrue(pilha.estaVazia());
    }
}
