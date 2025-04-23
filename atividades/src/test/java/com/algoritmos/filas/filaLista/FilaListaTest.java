package com.algoritmos.filas.filaLista;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

public class FilaListaTest {

    @Test
    public void testCaso1_EstaVaziaFilaVazia() {
        System.out.println("---------------------------------------------------");
        System.out.println("Testando fila vazia com o metodo estaVazia()");
        FilaLista<Integer> fila = new FilaLista<>();
        System.out.println("Fila esta vazia? " + fila.estaVazia());
        assertTrue(fila.estaVazia());
    }

    @Test
    public void testCaso2_EstaVaziaFilaNaoVazia() {
        System.out.println("---------------------------------------------------");
        System.out.println("Testando fila nao vazia com o metodo estaVazia()");
        FilaLista<Integer> fila = new FilaLista<>();
        fila.inserir(10);
        System.out.println("Fila apos inserir 10: " + fila.toString());
        System.out.println("Fila esta vazia? " + fila.estaVazia());
        assertFalse(fila.estaVazia());
    }

    @Test
    public void testCaso3_EnfileirarEDesenfileirar() {
        System.out.println("---------------------------------------------------");
        System.out.println("Testando enfileirar e desenfileirar elementos");
        FilaLista<Integer> fila = new FilaLista<>();
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        System.out.println("Fila apos inserir 10, 20, 30: " + fila.toString());

        assertEquals(10, fila.retirar());
        System.out.println("Fila apos retirar 10: " + fila.toString());

        assertEquals(20, fila.retirar());
        System.out.println("Fila apos retirar 20: " + fila.toString());

        assertEquals(30, fila.retirar());
        System.out.println("Fila apos retirar 30: " + fila.toString());

        assertTrue(fila.estaVazia());
        System.out.println("Fila esta vazia? " + fila.estaVazia());
    }

    @Test
    public void testCaso4_Peek() {
        System.out.println("---------------------------------------------------");
        System.out.println("Testando o metodo peek()");
        FilaLista<Integer> fila = new FilaLista<>();
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        System.out.println("Fila apos inserir 10, 20, 30: " + fila.toString());

        assertEquals(10, fila.peek());
        System.out.println("Elemento no inicio da fila (peek): " + fila.peek());

        fila.retirar();
        System.out.println("Fila apos retirar o primeiro elemento: " + fila.toString());
    }

    @Test
    public void testCaso5_Liberar() {
        System.out.println("---------------------------------------------------");
        System.out.println("Testando o metodo liberar()");
        FilaLista<Integer> fila = new FilaLista<>();
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        System.out.println("Fila antes de liberar: " + fila.toString());

        fila.liberar();
        System.out.println("Fila apos liberar: " + fila.toString());

        assertTrue(fila.estaVazia());
        System.out.println("Fila esta vazia? " + fila.estaVazia());
    }

    @Test
    public void testCaso6_Inverter() {
        System.out.println("---------------------------------------------------");
        System.out.println("Testando o metodo inverter()");
        FilaLista<Integer> fila = new FilaLista<>();
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        System.out.println("Fila antes de inverter: " + fila.toString());

        fila.inverter();
        System.out.println("Fila apos inverter: " + fila.toString());

        assertEquals(30, fila.retirar());
        assertEquals(20, fila.retirar());
        assertEquals(10, fila.retirar());
    }

    @Test
    public void testCaso7_Concatenar() {
        System.out.println("---------------------------------------------------");
        System.out.println("Testando o metodo concatenar()");
        FilaLista<Integer> fila1 = new FilaLista<>();
        fila1.inserir(1);
        fila1.inserir(3);
        fila1.inserir(5);

        FilaLista<Integer> fila2 = new FilaLista<>();
        fila2.inserir(2);
        fila2.inserir(4);
        fila2.inserir(6);

        System.out.println("Fila 1: " + fila1.toString());
        System.out.println("Fila 2: " + fila2.toString());

        FilaLista<Integer> concatenada = fila1.concatenar(fila2, Comparator.naturalOrder());
        System.out.println("Fila concatenada: " + concatenada.toString());

        assertEquals("1,2,3,4,5,6", concatenada.toString());
    }

    @Test
    public void testCaso8_IsPalindroma() {
        System.out.println("---------------------------------------------------");
        System.out.println("Testando o metodo isPalindroma()");
        FilaLista<Integer> fila = new FilaLista<>();
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(10);
        System.out.println("Fila: " + fila.toString());
        System.out.println("E palindroma? " + fila.isPalindroma());
        assertTrue(fila.isPalindroma());

        fila.inserir(30);
        System.out.println("Fila apos inserir 30: " + fila.toString());
        System.out.println("E palindroma? " + fila.isPalindroma());
        assertFalse(fila.isPalindroma());
    }
}