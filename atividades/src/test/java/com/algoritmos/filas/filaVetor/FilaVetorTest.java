package com.algoritmos.filas.filaVetor;

import org.junit.jupiter.api.Test;

import com.algoritmos.pilhas.pilhaVetor.PilhaVetor;

import static org.junit.jupiter.api.Assertions.*;

public class FilaVetorTest {

    @Test
    public void testEstaVaziaFilaVazia() {
        // Teste 1: Conferir se o método estaVazia() reconhece fila vazia
        FilaVetor<Integer> fila = new FilaVetor<>(5); // Cria uma fila de inteiros com capacidade de 5
        assertTrue(fila.estaVazia());
    }

    @Test
    public void testEstaVaziaFilaNaoVazia() {
        // Teste 2: Conferir se o método estaVazia() reconhece fila não vazia
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        fila.inserir(10);
        assertFalse(fila.estaVazia());
    }

    @Test
    public void testEnfileirarEDesenfileirar() {
        // Teste 3: Conferir se os dados são enfileirados e desenfileirados corretamente
        FilaVetor<Integer> fila = new FilaVetor<>(10);
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        assertEquals(10, fila.retirar());
        assertEquals(20, fila.retirar());
        assertEquals(30, fila.retirar());
        assertTrue(fila.estaVazia());
    }

    @Test
    public void testFilaCheiaException() {
        // Teste 4: Conferir se a exceção FilaCheiaException é lançada ao tentar exceder a capacidade da fila
        FilaVetor<Integer> fila = new FilaVetor<>(3);
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        assertThrows(FilaCheiaException.class, () -> {
            fila.inserir(40);
        });
    }

    @Test
    public void testFilaVaziaException() {
        // Teste 5: Conferir se a exceção FilaVaziaException é lançada ao tentar desenfileirar de uma fila vazia
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        assertThrows(FilaVaziaException.class, () -> {
            fila.retirar();
        });
    }

    @Test
    public void testPeek() {
        // Teste 6: Conferir se o método peek() retorna o início da fila
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        assertEquals(10, fila.peek());
    }

    @Test
    public void testLiberar() {
        // Teste 7: Conferir se o método liberar() remove os elementos da fila
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        fila.liberar();
        assertTrue(fila.estaVazia());
    }

    @Test
    public void testConcatenar() {
        // Teste 8: Conferir a concatenação de filas
        FilaVetor<Integer> fila1 = new FilaVetor<>(5);
        fila1.inserir(10);
        fila1.inserir(20);
        fila1.inserir(30);

        FilaVetor<Integer> fila2 = new FilaVetor<>(5);
        fila2.inserir(40);
        fila2.inserir(50);

        FilaVetor<Integer> filaConcatenada = fila1.criarFilaConcatenada(fila2);

        // Usando toString para verificar a concatenação
        assertEquals("10,20,30,40,50", filaConcatenada.toString());
    }

    @Test
    public void testEncolher() {
        FilaVetor<Integer> fila = new FilaVetor<>(10); // Capacidade maior que o necessário
        fila.inserir(1);
        fila.inserir(2);
        fila.inserir(3);

        System.out.println("Antes de encolher:");
        System.out.println("toString(): " + fila.toString());
        System.out.println("Limite: " + fila.getLimite());

        // Remove um elemento para mudar o início da fila (simula circularidade)
        fila.retirar(); // remove 1

        fila.encolher(); // agora a fila deve ter exatamente tamanho == 2 e início == 0

        System.out.println("Depois de encolher:");
        System.out.println("toString(): " + fila.toString());
        System.out.println("Limite: " + fila.getLimite());

        // Confere o comportamento após encolher
        assertEquals("2,3", fila.toString());
        assertEquals(2, fila.getLimite()); // verifica se o vetor foi realmente reduzido
    }

    // teste para o metodo empilhar
    @Test
    public void testEmpilhar() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        fila.inserir(1);
        fila.inserir(2);
        fila.inserir(3);

        System.out.println("Fila antes de empilhar:");
        System.out.println(fila.toString());

        // Cria uma pilha e empilha os elementos da fila
        PilhaVetor<Integer> pilha = fila.empilhar(fila);
        
        System.out.println("Pilha após empilhar a fila:");
        System.out.println(pilha.toString());
    }

    // teste para o metodo aumentar
    @Test
    public void testAumentar() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        fila.inserir(1);
        fila.inserir(2);
        fila.inserir(3);

        System.out.println("Antigo limite: " + fila.getLimite());
        System.out.println("Fila antes de aumentar:");
        System.out.println(fila.toString());


        // Aumenta a capacidade da fila
        fila.aumentar(10);

        System.out.println("Fila após aumentar:");
        System.out.println(fila.toString());
        System.out.println("Novo limite: " + fila.getLimite());
    }
    
    // teste para o metodo inverter
    @Test
    public void testInverter() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        fila.inserir(5);
        fila.inserir(3);
        fila.inserir(2);

        System.out.println("Fila antes de inverter:");
        System.out.println(fila.toString());

        // Inverte a fila
        fila.inverter();

        System.out.println("Fila após inverter:");
        System.out.println(fila.toString());
    }



}
