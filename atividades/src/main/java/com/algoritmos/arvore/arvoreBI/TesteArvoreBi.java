package com.algoritmos.arvore.arvoreBI;

public class TesteArvoreBi {
    public static void main(String[] args) {

        // ======================
        // TESTE 1 – ÁRVORE COMPLETA
        // ======================

        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();

        // Criação dos nós
        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<>(6);
        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<>(5);
        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<>(4);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<>(3, no5, no6);
        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<>(2, null, no4);
        NoArvoreBinaria<Integer> no1 = new NoArvoreBinaria<>(1, no2, no3);

        // Define a raiz da árvore
        arvore.setRaiz(no1);

        // Imprime a estrutura da árvore
        System.out.println("------------------------------------------------------");
        System.out.println("Estrutura da Árvore Completa:");
        arvore.imprimirArvoreVisual();
        System.out.println("");

        // ======================
        // TESTES DOS NOVOS MÉTODOS
        // ======================

        // Teste: Verificar se a árvore é cheia
        System.out.println("A árvore é cheia?");
        System.out.println(arvore.isCheia());
        System.out.println("");

        // Teste: Verificar se a árvore é balanceada
        System.out.println("A árvore é balanceada?");
        System.out.println(arvore.isBalanceada());
        System.out.println("");

        // Teste: Verificar se a árvore é completa
        System.out.println("A árvore é completa?");
        System.out.println(arvore.isCompleta());
        System.out.println("");

        // Teste: Caminho até um nó específico
        System.out.println("Caminho até o nó 6:");
        System.out.println(arvore.verificaAteUmNo(6));
        System.out.println("");

        System.out.println("Caminho até o nó 4:");
        System.out.println(arvore.verificaAteUmNo(4));
        System.out.println("");

        // Teste: Altura de um nó específico
        System.out.println("Altura do nó 3:");
        System.out.println(arvore.alturaDoNo(3));
        System.out.println("");

        System.out.println("Altura do nó 2:");
        System.out.println(arvore.alturaDoNo(2));
        System.out.println("");

        // Teste: Contar o número de nós internos
        System.out.println("Número de nós internos:");
        System.out.println(arvore.contarNosInternos());
        System.out.println("");

        // Teste: Contar o número de folhas
        System.out.println("Número de folhas:");
        System.out.println(arvore.contarFolhas());
        System.out.println("");

        // Teste: Contar o número de nós em um nível específico
        System.out.println("Número de nós no nível 2:");
        System.out.println(arvore.contarNosNivel(2));
        System.out.println("");

        // Teste: Contar o número de nós com pelo menos um filho
        System.out.println("Número de nós com pelo menos um filho:");
        System.out.println(arvore.contarNosComFilhos());
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

        // Imprime a estrutura da árvore
        System.out.println("------------------------------------------------------");
        System.out.println("Estrutura da Árvore Degenerada:");
        arvoreDeg.imprimirArvoreVisual();
        System.out.println("");

        // Verificação de degeneração
        System.out.println("A árvore é degenerada?");
        System.out.println(arvoreDeg.isDegenerada());
        System.out.println("");

        // ======================
        // TESTE 3 – ÁRVORE VARIADA
        // ======================

        ArvoreBinaria<Integer> arvoreVar = new ArvoreBinaria<>();

        NoArvoreBinaria<Integer> n80 = new NoArvoreBinaria<>(80);
        NoArvoreBinaria<Integer> n10 = new NoArvoreBinaria<>(10, n80, null);
        NoArvoreBinaria<Integer> n25 = new NoArvoreBinaria<>(25, null, null);
        NoArvoreBinaria<Integer> n20 = new NoArvoreBinaria<>(20, n10, n25);
        NoArvoreBinaria<Integer> n30 = new NoArvoreBinaria<>(30, null, null);
        NoArvoreBinaria<Integer> n70 = new NoArvoreBinaria<>(70, n30, n20);

        arvoreVar.setRaiz(n70);

        // Teste: Impressão em pré-ordem
        System.out.println("Impressão em pré-ordem:");
        System.out.println(arvoreVar.toString());
        System.out.println("");

        // Teste: Impressão em pós-ordem
        System.out.println("Impressão em pós-ordem:");
        System.out.println(arvoreVar.toStringPosOrdem());
        System.out.println("");

        // Teste: Impressão em ordem simétrica
        System.out.println("Impressão em ordem simétrica:");
        System.out.println(arvoreVar.toStringSimetrico());
        System.out.println("");

        // Teste: Visita em pré-ordem
        System.out.println("Visita em pré-ordem:");
        System.out.println(arvoreVar.visitaPreOrdem());
        System.out.println("");

        // Teste: Visita em pós-ordem
        System.out.println("Visita em pós-ordem:");
        System.out.println(arvoreVar.visitaPosOrdem());
        System.out.println("");

        // Teste: Visita em ordem simétrica
        System.out.println("Visita em ordem simétrica:");
        System.out.println(arvoreVar.visitaSimetrica());
        System.out.println("");
        
    }
}