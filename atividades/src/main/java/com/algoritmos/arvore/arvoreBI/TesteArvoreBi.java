package com.algoritmos.arvore.arvoreBI;

public class TesteArvoreBi {
    public static void main(String[] args) {

        // ======================
        // TESTE 1 – ÁRVORE COMPLETA
        // ======================

        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<Integer>();

        // Verifica se a árvore está vazia antes de adicionar os nós
        System.out.println("Está vazia antes de criar os nós e definir raiz:");
        System.out.println(arvore.estaVazia());
        System.out.println("");

        // Criação dos nós
        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<>(6);
        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<>(5);
        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<>(4);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<>(3, no5, no6);
        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<>(2, null, no4);
        NoArvoreBinaria<Integer> no1 = new NoArvoreBinaria<>(1, no2, no3);

        // Define a raiz da árvore
        arvore.setRaiz(no1);

        // Verifica se a árvore ainda está vazia
        System.out.println("Está vazia após criar os nós e definir raiz:");
        System.out.println(arvore.estaVazia());
        System.out.println("");

        // Impressão da árvore em pré-ordem (estrutura com < >)
        System.out.println("ToString:");
        System.out.println(arvore.toString());
        System.out.println("");

        // Teste de pertencimento de elementos
        System.out.println("Pertence 1:");
        System.out.println(arvore.pertence(1));
        System.out.println("");

        System.out.println("Pertence 3:");
        System.out.println(arvore.pertence(3));
        System.out.println("");

        System.out.println("Pertence 6:");
        System.out.println(arvore.pertence(6));
        System.out.println("");

        System.out.println("Pertence 10:");
        System.out.println(arvore.pertence(10));
        System.out.println("");

        // Contagem de nós
        System.out.println("Número nós:");
        System.out.println(arvore.contarNos());
        System.out.println("");

        // Verifica se a árvore é degenerada
        System.out.println("A árvore é degenerada?");
        System.out.println(arvore.isDegenerada());
        System.out.println("");

        // Número de folhas
        System.out.println("Número de folhas:");
        System.out.println(arvore.contarFolhas());
        System.out.println("");

        // Altura da árvore
        System.out.println("Altura da árvore:");
        System.out.println(arvore.contarAltura());
        System.out.println("");

        // Nós internos
        System.out.println("Número de nós internos:");
        System.out.println(arvore.contarNosInternos());
        System.out.println("");

        // Nós com filhos
        System.out.println("Número de nós com pelo menos um filho:");
        System.out.println(arvore.contarNosComFilhos());
        System.out.println("");

        // Impressão simples (in-order)
        System.out.println("In-order simples (toStringSimples):");
        System.out.println(arvore.toStringSimples());
        System.out.println("");

        // Impressão pós-ordem simples
        System.out.println("Pós-ordem simples (toStringSimplesPos):");
        System.out.println(arvore.toStringSimplesPos());
        System.out.println("");


        // ======================
        // TESTE 2 – ÁRVORE DEGENERADA
        // ======================

        System.out.println("\nCriando uma árvore degenerada:");
        ArvoreBinaria<Integer> arvoreDeg = new ArvoreBinaria<>();

        NoArvoreBinaria<Integer> d3 = new NoArvoreBinaria<>(3);
        NoArvoreBinaria<Integer> d2 = new NoArvoreBinaria<>(2, d3, null);
        NoArvoreBinaria<Integer> d1 = new NoArvoreBinaria<>(1, null, d2);

        arvoreDeg.setRaiz(d1);

        // Impressão da estrutura da árvore degenerada
        System.out.println("Estrutura da árvore:");
        System.out.println(arvoreDeg.toString());

        // Verificação de degeneração
        System.out.println("É degenerada?");
        System.out.println(arvoreDeg.isDegenerada());


        // ======================
        // TESTE 3 – IMPRESSÕES VARIADAS (PÓS, SIMÉTRICA)
        // ======================

        ArvoreBinaria<Integer> arvorePos = new ArvoreBinaria<>();

        NoArvoreBinaria<Integer> n80 = new NoArvoreBinaria<>(80);
        NoArvoreBinaria<Integer> n10 = new NoArvoreBinaria<>(10, n80, null);
        NoArvoreBinaria<Integer> n25 = new NoArvoreBinaria<>(25, null, null);
        NoArvoreBinaria<Integer> n20 = new NoArvoreBinaria<>(20, n10, n25);
        NoArvoreBinaria<Integer> n30 = new NoArvoreBinaria<>(30, null, null);
        NoArvoreBinaria<Integer> n70 = new NoArvoreBinaria<>(70, n30, n20);

        arvorePos.setRaiz(n70);

        // Impressão em pré-ordem
        System.out.println("Pré-ordem (toString):");
        System.out.println(arvorePos.toString());

        // Impressão em pós-ordem
        System.out.println("Pós-ordem (arvorePos):");
        System.out.println(arvorePos.arvorePos());

        // Impressão em ordem simétrica (in-order com < >)
        System.out.println("Simétrica (arvoreSimetrica):");
        System.out.println(arvorePos.arvoreSimetrica());

        // Impressão simples in-order
        System.out.println("In-order simples:");
        System.out.println(arvorePos.toStringSimples());

        // Impressão simples pós-ordem
        System.out.println("Pós-ordem simples:");
        System.out.println(arvorePos.toStringSimplesPos());

        // ======================
        // FIM DOS TESTES
        // ======================
    }
}
