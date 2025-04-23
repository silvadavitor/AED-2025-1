package com.algoritmos.filas.filaVetor;

import org.junit.jupiter.api.Test;

import com.algoritmos.pilhas.pilhaVetor.PilhaVetor;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Comparator;

public class FilaVetorTest {

    @Test
    public void testGetUltimo() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        fila.inserir(1);
        fila.inserir(2);
        fila.inserir(3);
        System.out.println("---------------------------------------------------");
        System.out.println("Ultimo elemento: " + fila.getUltimo());
        assertEquals(3, fila.getUltimo());        
    }

    @Test
    public void testContem() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        fila.inserir(1);
        fila.inserir(2);
        fila.inserir(3);
        System.out.println("---------------------------------------------------");
        System.out.println("Fila contEm 2? " + fila.contem(2));
        System.out.println("Fila contEm 4? " + fila.contem(4));
        assertTrue(fila.contem(2));
        assertFalse(fila.contem(4));
    }

    @Test
    public void testIndexOf() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        fila.inserir(1);
        fila.inserir(2);
        fila.inserir(3);
        System.out.println("---------------------------------------------------");
        System.out.println("Indice do elemento 2: " + fila.indexOf(2));
        System.out.println("Indice do elemento 4: " + fila.indexOf(4));
        assertEquals(1, fila.indexOf(2));
        assertEquals(-1, fila.indexOf(4));
    }

    @Test
    public void testCopiar() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        fila.inserir(1);
        fila.inserir(2);
        fila.inserir(3);
        FilaVetor<Integer> copia = fila.copiar();
        System.out.println("---------------------------------------------------");
        System.out.println("Fila original: " + fila.toString());
        System.out.println("Copia da fila: " + copia.toString());
        assertEquals(fila.toString(), copia.toString());
    }

    @Test
    public void testRotacionarEsquerda() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        fila.inserir(1);
        fila.inserir(2);
        fila.inserir(3);
        System.out.println("---------------------------------------------------");
        System.out.println("Antes de rotacionar a esquerda: " + fila.toString());
        fila.rotacionarEsquerda();
        System.out.println("Depois de rotacionar a esquerda: " + fila.toString());
        assertEquals("2,3,1", fila.toString());
    }

    @Test
    public void testRotacionarDireita() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        fila.inserir(1);
        fila.inserir(2);
        fila.inserir(3);
        System.out.println("---------------------------------------------------");
        System.out.println("Antes de rotacionar a direita: " + fila.toString());
        fila.rotacionarDireita();
        System.out.println("Depois de rotacionar a direita: " + fila.toString());
        assertEquals("3,1,2", fila.toString());
    }

    @Test
    public void testIntercalarContatenando() {
        FilaVetor<Integer> fila1 = new FilaVetor<>(5);
        fila1.inserir(1);
        fila1.inserir(3);
        fila1.inserir(5);

        FilaVetor<Integer> fila2 = new FilaVetor<>(5);
        fila2.inserir(2);
        fila2.inserir(4);
        fila2.inserir(6);

        System.out.println("---------------------------------------------------");
        System.out.println("Fila 1: " + fila1.toString());
        System.out.println("Fila 2: " + fila2.toString());
        FilaVetor<Integer> intercalada = fila1.intercalarContatenando(fila2);
        System.out.println("Fila intercalada: " + intercalada.toString());
        assertEquals("1,2,3,4,5,6", intercalada.toString());
    }

    @Test
    public void testOrdenadoConcatenando() {
        FilaVetor<Integer> fila1 = new FilaVetor<>(5);
        fila1.inserir(1);
        fila1.inserir(3);
        fila1.inserir(5);

        FilaVetor<Integer> fila2 = new FilaVetor<>(5);
        fila2.inserir(2);
        fila2.inserir(4);
        fila2.inserir(6);

        System.out.println("---------------------------------------------------");
        System.out.println("Fila 1: " + fila1.toString());
        System.out.println("Fila 2: " + fila2.toString());
        FilaVetor<Integer> ordenada = fila1.ordenadoConcatenando(fila2, Comparator.naturalOrder());
        System.out.println("Fila ordenada concatenada: " + ordenada.toString());
        assertEquals("1,2,3,4,5,6", ordenada.toString());
    }

    @Test
    public void testCriarFilaConcatenada() {
        FilaVetor<Integer> fila1 = new FilaVetor<>(5);
        fila1.inserir(1);
        fila1.inserir(3);
        fila1.inserir(5);

        FilaVetor<Integer> fila2 = new FilaVetor<>(5);
        fila2.inserir(2);
        fila2.inserir(4);
        fila2.inserir(6);

        System.out.println("---------------------------------------------------");
        System.out.println("Fila 1: " + fila1.toString());
        System.out.println("Fila 2: " + fila2.toString());
        FilaVetor<Integer> concatenada = fila1.criarFilaConcatenada(fila2);
        System.out.println("Fila concatenada: " + concatenada.toString());
        assertEquals("1,3,5,2,4,6", concatenada.toString());
    }
    
    @Test
    public void testEncolher() {
        FilaVetor<Integer> fila = new FilaVetor<>(10);
        fila.inserir(1);
        fila.inserir(2);
        fila.inserir(3);
        System.out.println("---------------------------------------------------");
        System.out.println("Antes de encolher: Limite = " + fila.getLimite() + ", Fila = " + fila.toString());
        fila.encolher();
        System.out.println("Depois de encolher: Limite = " + fila.getLimite() + ", Fila = " + fila.toString());
        assertEquals(3, fila.getLimite());
        assertEquals("1,2,3", fila.toString());
    }

    @Test
    public void testAumentar() {
        FilaVetor<Integer> fila = new FilaVetor<>(3);
        fila.inserir(1);
        fila.inserir(2);
        fila.inserir(3);
        System.out.println("---------------------------------------------------");
        System.out.println("Antes de aumentar: Limite = " + fila.getLimite() + ", Fila = " + fila.toString());
        fila.aumentar(10);
        System.out.println("Depois de aumentar: Limite = " + fila.getLimite() + ", Fila = " + fila.toString());
        assertEquals(10, fila.getLimite());
        assertEquals("1,2,3", fila.toString());
    }

    @Test
    public void testInverter() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        fila.inserir(1);
        fila.inserir(2);
        fila.inserir(3);
        System.out.println("---------------------------------------------------");
        System.out.println("Antes de inverter: " + fila.toString());
        fila.inverter();
        System.out.println("Depois de inverter: " + fila.toString());
        assertEquals("3,2,1", fila.toString());
    }

    @Test
    public void testEmpilhar() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        fila.inserir(1);
        fila.inserir(2);
        fila.inserir(3);
        System.out.println("---------------------------------------------------");
        System.out.println("Fila original: " + fila.toString());
        PilhaVetor<Integer> pilha = fila.empilhar(fila);
        System.out.println("Pilha gerada: " + pilha.toString());
        assertEquals("[3, 2, 1]", pilha.toString());
    }

    @Test
    public void testSubstituir() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        fila.inserir(1);
        fila.inserir(2);
        fila.inserir(3);
        System.out.println("---------------------------------------------------");
        System.out.println("Antes de substituir: " + fila.toString());
        fila.substituir(1, 5);
        System.out.println("Depois de substituir posicao(index) 1 por valor 5: " + fila.toString());
        assertEquals("1,5,3", fila.toString());
    }

    @Test
    public void testisIgual() {
        FilaVetor<Integer> fila1 = new FilaVetor<>(5);
        fila1.inserir(1);
        fila1.inserir(2);
        fila1.inserir(3);

        FilaVetor<Integer> fila2 = new FilaVetor<>(5);
        fila2.inserir(1);
        fila2.inserir(2);
        fila2.inserir(3);

        System.out.println("---------------------------------------------------");
        System.out.println("Fila 1: " + fila1.toString());
        System.out.println("Fila 2: " + fila2.toString());
        assertTrue(fila1.isIgual(fila2));

        fila2.retirar();
        System.out.println("Fila 2 apos retirar um elemento: " + fila2.toString());
        assertFalse(fila1.isIgual(fila2));
    }

    @Test
    public void testDividir() {
        FilaVetor<Integer> fila = new FilaVetor<>(6);
        fila.inserir(1);
        fila.inserir(2);
        fila.inserir(3);
        fila.inserir(4);
        fila.inserir(5);
        fila.inserir(6);

        System.out.println("---------------------------------------------------");
        System.out.println("Fila original: " + fila.toString());
        FilaVetor<Integer>[] filas = fila.dividir();
        System.out.println("Primeira metade: " + filas[0].toString());
        System.out.println("Segunda metade: " + filas[1].toString());
        assertEquals("1,2,3", filas[0].toString());
        assertEquals("4,5,6", filas[1].toString());
    }

    @Test
    public void testContarOcorrencias() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        fila.inserir(1);
        fila.inserir(2);
        fila.inserir(1);
        fila.inserir(3);
        fila.inserir(1);
        System.out.println("---------------------------------------------------");
        System.out.println("Fila: " + fila.toString());
        System.out.println("Ocorrencias do numero 1: " + fila.contarOcorrencias(1));
        assertEquals(3, fila.contarOcorrencias(1));
    }

    @Test
    public void testSubfila() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        fila.inserir(1);
        fila.inserir(2);
        fila.inserir(3);
        fila.inserir(4);
        fila.inserir(5);

        System.out.println("---------------------------------------------------");
        System.out.println("Fila original: " + fila.toString());
        FilaVetor<Integer> subfila = fila.subfila(1, 3);
        System.out.println("Subfila (Indices 1 a 3): " + subfila.toString());
        assertEquals("2,3,4", subfila.toString());
    }

    @Test
    public void testIsPalindroma() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        fila.inserir(1);
        fila.inserir(2);
        fila.inserir(3);
        fila.inserir(2);
        fila.inserir(1);
        System.out.println("---------------------------------------------------");
        System.out.println("Fila: " + fila.toString());
        System.out.println("E palIndroma? " + fila.isPalindroma());
        assertTrue(fila.isPalindroma());

        fila.retirar();
        System.out.println("Apos retirar um elemento: " + fila.toString());
        System.out.println("E palIndroma? " + fila.isPalindroma());
        assertFalse(fila.isPalindroma());
    }
}