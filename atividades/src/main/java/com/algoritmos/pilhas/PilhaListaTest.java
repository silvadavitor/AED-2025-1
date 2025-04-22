package com.algoritmos.pilhas.pilhaLista;

import org.junit.jupiter.api.Test;

import com.algoritmos.pilhas.pilhaListaEncadeada.PilhaLista;

import static org.junit.jupiter.api.Assertions.*;

public class PilhaListaTest {

    @Test
    public void testEstaVaziaComPilhaVazia() {
        System.out.println("---------------------------------------------------");
        System.out.println("Testando pilha vazia com o metodo estaVazia()");
        PilhaLista<Integer> pilha = new PilhaLista<>();
        System.out.println("Pilha esta vazia? " + pilha.estaVazia());
        assertTrue(pilha.estaVazia());
    }

    @Test
    public void testEstaVaziaComPilhaNaoVazia() {
        System.out.println("---------------------------------------------------");
        System.out.println("Testando pilha nao vazia com o metodo estaVazia()");
        PilhaLista<Integer> pilha = new PilhaLista<>();
        pilha.push(10);
        System.out.println("Pilha apos inserir 10: " + pilha.toString());
        System.out.println("Pilha esta vazia? " + pilha.estaVazia());
        assertFalse(pilha.estaVazia());
    }

    @Test
    public void testEmpilharEDesempilharOrdemCorreta() {
        System.out.println("---------------------------------------------------");
        System.out.println("Testando empilhar e desempilhar elementos");
        PilhaLista<Integer> pilha = new PilhaLista<>();
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        System.out.println("Pilha apos inserir 10, 20, 30: " + pilha.toString());

        assertEquals(30, pilha.pop());
        System.out.println("Pilha apos retirar 30: " + pilha.toString());

        assertEquals(20, pilha.pop());
        System.out.println("Pilha apos retirar 20: " + pilha.toString());

        assertEquals(10, pilha.pop());
        System.out.println("Pilha apos retirar 10: " + pilha.toString());

        assertTrue(pilha.estaVazia());
        System.out.println("Pilha esta vazia? " + pilha.estaVazia());
    }

    @Test
    public void testPeekRetornaTopoDaPilha() {
        System.out.println("---------------------------------------------------");
        System.out.println("Testando o metodo peek()");
        PilhaLista<Integer> pilha = new PilhaLista<>();
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        System.out.println("Pilha apos inserir 10, 20, 30: " + pilha.toString());

        assertEquals(30, pilha.peek());
        System.out.println("Elemento no topo da pilha (peek): " + pilha.peek());
    }

    @Test
    public void testLiberarEsvaziaPilha() {
        System.out.println("---------------------------------------------------");
        System.out.println("Testando o metodo liberar()");
        PilhaLista<Integer> pilha = new PilhaLista<>();
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        System.out.println("Pilha antes de liberar: " + pilha.toString());

        pilha.liberar();
        System.out.println("Pilha apos liberar: " + pilha.toString());

        assertTrue(pilha.estaVazia());
        System.out.println("Pilha esta vazia? " + pilha.estaVazia());
    }

    @Test
    public void testInverter() {
        System.out.println("---------------------------------------------------");
        System.out.println("Testando o metodo inverter()");
        PilhaLista<Integer> pilha = new PilhaLista<>();
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        System.out.println("Pilha antes de inverter: " + pilha.toString());

        pilha.inverter();
        System.out.println("Pilha apos inverter: " + pilha.toString());

        assertEquals(10, pilha.pop());
        assertEquals(20, pilha.pop());
        assertEquals(30, pilha.pop());
    }

    @Test
    public void testCopia() {
        System.out.println("---------------------------------------------------");
        System.out.println("Testando o metodo copia()");
        PilhaLista<Integer> pilha = new PilhaLista<>();
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        System.out.println("Pilha original: " + pilha.toString());

        PilhaLista<Integer> copia = pilha.copia();
        System.out.println("Copia da pilha: " + copia.toString());

        assertEquals(30, copia.pop());
        assertEquals(20, copia.pop());
        assertEquals(10, copia.pop());
        assertTrue(copia.estaVazia());
    }

    @Test
    public void testPertence() {
        System.out.println("---------------------------------------------------");
        System.out.println("Testando o metodo pertence()");
        PilhaLista<Integer> pilha = new PilhaLista<>();
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        System.out.println("Pilha: " + pilha.toString());

        assertTrue(pilha.pertence(20));
        System.out.println("Elemento 20 pertence a pilha? " + pilha.pertence(20));

        assertFalse(pilha.pertence(40));
        System.out.println("Elemento 40 pertence a pilha? " + pilha.pertence(40));
    }

    @Test
    public void testIndexOf() {
        System.out.println("---------------------------------------------------");
        System.out.println("Testando o metodo indexOf()");
        PilhaLista<Integer> pilha = new PilhaLista<>();
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        System.out.println("Pilha: " + pilha.toString());

        assertEquals(0, pilha.indexOf(30));
        System.out.println("Indice do elemento 30: " + pilha.indexOf(30));

        assertEquals(1, pilha.indexOf(20));
        System.out.println("Indice do elemento 20: " + pilha.indexOf(20));

        assertEquals(2, pilha.indexOf(10));
        System.out.println("Indice do elemento 10: " + pilha.indexOf(10));

        assertEquals(-1, pilha.indexOf(40));
        System.out.println("Indice do elemento 40: " + pilha.indexOf(40));
    }

    @Test
    public void testIsIgual() {
        System.out.println("---------------------------------------------------");
        System.out.println("Testando o metodo isIgual()");
        PilhaLista<Integer> pilha1 = new PilhaLista<>();
        pilha1.push(10);
        pilha1.push(20);
        pilha1.push(30);
        System.out.println("Pilha 1: " + pilha1.toString());

        PilhaLista<Integer> pilha2 = new PilhaLista<>();
        pilha2.push(10);
        pilha2.push(20);
        pilha2.push(30);
        System.out.println("Pilha 2: " + pilha2.toString());

        assertTrue(pilha1.isIgual(pilha2));
        System.out.println("As pilhas sao iguais? " + pilha1.isIgual(pilha2));

        pilha2.pop();
        System.out.println("Pilha 2 apos remover o topo: " + pilha2.toString());
        assertFalse(pilha1.isIgual(pilha2));
        System.out.println("As pilhas sao iguais? " + pilha1.isIgual(pilha2));
        
    }
}