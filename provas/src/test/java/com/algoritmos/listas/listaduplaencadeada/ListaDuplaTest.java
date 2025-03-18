package com.algoritmos.listas.listaduplaencadeada;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ListaDuplaTest {

    @Test
    void testInserirElementos() {
        ListaDupla<Integer> lista = new ListaDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        assertEquals("20,15,10,5", lista.toString());
        assertEquals("5,10,15,20", lista.exibirOrdemInversa().toString());
    }

    @Test
    void testBuscarElementoInicio() {
        ListaDupla<Integer> lista = new ListaDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(20, lista.buscar(20).getInfo());
    }

    @Test
    void testBuscarElementoMeio() {
        ListaDupla<Integer> lista = new ListaDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(10, lista.buscar(10).getInfo());
    }

    @Test
    void testRemoverElementoInicio() {
        ListaDupla<Integer> lista = new ListaDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(20);
        assertEquals("15,10,5", lista.toString());
        
        assertEquals("5,10,15", lista.exibirOrdemInversa().toString());
    }


    @Test
    void testRemoverElementoMeio() {
        ListaDupla<Integer> lista = new ListaDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(10);
        assertEquals("20,15,5", lista.toString());
        lista.exibirOrdemInversa();
        assertEquals("5,15,20", lista.exibirOrdemInversa().toString());
    }

    @Test
    void testRemoverElementoFim() {
        ListaDupla<Integer> lista = new ListaDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(5);
        assertEquals("20,15,10", lista.toString());
        lista.exibirOrdemInversa();
        assertEquals("10,15,20", lista.exibirOrdemInversa().toString());
    }

    @Test
    void testLiberarLista() {
        ListaDupla<Integer> lista = new ListaDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.liberar();
        assertTrue(lista.estaVazia());
    }
}
