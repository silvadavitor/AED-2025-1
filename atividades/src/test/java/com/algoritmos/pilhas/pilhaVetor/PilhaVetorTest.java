package com.algoritmos.pilhas.pilhaVetor;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PilhaVetorTest {

    @Test
    public void testEstaVaziaPilhaVazia() {
        // Teste 1: Conferir se o método estaVazia() reconhece pilha vazia
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5); // Cria uma pilha de inteiros com capacidade de 5
        assertTrue(pilha.estaVazia());
    }

    @Test
    public void testEstaVaziaPilhaNaoVazia() {
        // Teste 2: Conferir se o método estaVazia() reconhece pilha não vazia
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);
        pilha.push(10);
        assertFalse(pilha.estaVazia());
    }

    @Test
    public void testEmpilharEDesempilhar() {
        // Teste 3: Conferir se os dados são empilhados e desempilhados corretamente
        PilhaVetor<Integer> pilha = new PilhaVetor<>(10);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        assertEquals(30, pilha.pop());
        assertEquals(20, pilha.pop());
        assertEquals(10, pilha.pop());
        assertTrue(pilha.estaVazia());
    }

    @Test
    public void testPilhaCheiaException() {
        // Teste 4: Conferir se a exceção PilhaCheiaException é lançada ao tentar exceder a capacidade da pilha
        PilhaVetor<Integer> pilha = new PilhaVetor<>(3);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        assertThrows(PilhaCheiaException.class, () -> {
            pilha.push(40);
        });
    }

    @Test
    public void testPilhaVaziaException() {
        // Teste 5: Conferir se a exceção PilhaVaziaException é lançada ao tentar desempilhar de uma pilha vazia
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);
        assertThrows(PilhaVaziaException.class, () -> {
            pilha.pop();
        });
    }

    @Test
    public void testPeek() {
        // Teste 6: Conferir se o método peek() retorna o topo da pilha
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        assertEquals(30, pilha.peek());
    }

    @Test
    public void testLiberar() {
        // Teste 7: Conferir se o método liberar() remove os elementos da pilha
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        pilha.liberar();
        assertTrue(pilha.estaVazia());
    }

    @Test
    public void testConcatenar() {
        // Teste 8: Conferir a concatenação de pilhas
        PilhaVetor<Integer> pilha1 = new PilhaVetor<>(5);
        pilha1.push(10);
        pilha1.push(20);
        pilha1.push(30);

        PilhaVetor<Integer> pilha2 = new PilhaVetor<>(5);
        pilha2.push(40);
        pilha2.push(50);

        pilha1.concatenar(pilha2);

        // Usando toString para verificar a concatenação
        assertEquals("50,40,30,20,10", pilha1.toString());
    }
}
