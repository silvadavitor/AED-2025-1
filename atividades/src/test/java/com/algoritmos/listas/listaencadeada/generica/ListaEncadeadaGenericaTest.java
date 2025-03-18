package com.algoritmos.listas.listaencadeada.generica;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ListaEncadeadaGenericaTest {
    private ListaEncadeadaGenerica<Integer> lista = new ListaEncadeadaGenerica<>();

    @Test
    void testListaVazia() {
        assertTrue(lista.estaVazia());
    }

    @Test
    void testListaNaoVazia() {
        lista.inserir(5);
        assertFalse(lista.estaVazia());
    }

    @Test
    void testInclusaoNumero() {
        lista.inserir(5);
        assertNotNull(lista.getPrimeiro());
        assertEquals(5, lista.getPrimeiro().getInfo());
        assertNull(lista.getPrimeiro().getProximo());
    }

    @Test
    void testInclusaoTresNumeros() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        
        assertEquals(3, lista.obterComprimento());
        assertEquals(15, lista.getPrimeiro().getInfo());
        assertEquals(10, lista.getPrimeiro().getProximo().getInfo());
        assertEquals(5, lista.getPrimeiro().getProximo().getProximo().getInfo());
    }

    @Test
    void testBuscarPrimeiraPosicao() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        assertEquals(20, lista.buscar(20).getInfo());
    }

    @Test
    void testBuscarMeioLista() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        assertEquals(15, lista.buscar(15).getInfo());
    }

    @Test
    void testBuscarInexistente() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        assertNull(lista.buscar(50));
    }

    @Test
    void testRetirarPrimeiroElemento() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.retirar(20);
        assertEquals(15, lista.getPrimeiro().getInfo());
    }

    @Test
    void testRetirarMeioLista() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.retirar(15);
        assertNull(lista.buscar(15));
        assertEquals(3, lista.obterComprimento());
    }

    @Test
    void testObterNoPrimeiraPosicao() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        assertEquals(20, lista.obterNo(0).getInfo());
    }

    @Test
    void testObterNoUltimaPosicao() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        assertEquals(5, lista.obterNo(3).getInfo());
    }

    @Test
    void testObterNoPosicaoInvalida() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        assertThrows(IndexOutOfBoundsException.class, () -> lista.obterNo(10));
    }

    @Test
    void testObterComprimentoListaVazia() {
        assertEquals(0, lista.obterComprimento());
    }

    @Test
    void testObterComprimentoListaNaoVazia() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        assertEquals(4, lista.obterComprimento());
    }
}