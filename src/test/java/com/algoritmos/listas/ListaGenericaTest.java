package com.algoritmos.listas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ListaGenericaTest {

    @Test
    void testInverterlistaPar() {
        ListaGenerica<Integer> lista = new ListaGenerica<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.inverter();
        assertEquals("20,15,10,5", lista.toString());
    }

    @Test
    void testInverterlistaImpar() {
        ListaGenerica<Integer> lista = new ListaGenerica<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.inserir(25);
        lista.inverter();
        assertEquals("25,20,15,10,5", lista.toString());
    }

    @Test
    void testInverterListaStrings() {
        ListaGenerica<String> lista = new ListaGenerica<>();
        lista.inserir("A");
        lista.inserir("B");
        lista.inserir("C");
        lista.inserir("D");
        lista.inserir("E");

        lista.inverter();

        assertEquals("E,D,C,B,A", lista.toString());
    }
}