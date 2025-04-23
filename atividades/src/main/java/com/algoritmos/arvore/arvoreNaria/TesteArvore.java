package com.algoritmos.arvore.arvoreNaria;

public class TesteArvore {
    public static void main(String[] args) {

        // ======================
        // TESTE 1 – ÁRVORE COMPLETA
        // ======================

        NoArvore<Integer> no5 = new NoArvore<>(5);
        NoArvore<Integer> no6 = new NoArvore<>(6);
        NoArvore<Integer> no7 = new NoArvore<>(7);

        NoArvore<Integer> no2 = new NoArvore<>(2);
        no2.inserirFilho(no7);
        no2.inserirFilho(no6);
        no2.inserirFilho(no5);

        NoArvore<Integer> no8 = new NoArvore<>(8);
        NoArvore<Integer> no3 = new NoArvore<>(3);
        no3.inserirFilho(no8);

        NoArvore<Integer> no10 = new NoArvore<>(10);
        NoArvore<Integer> no9 = new NoArvore<>(9);
        NoArvore<Integer> no4 = new NoArvore<>(4);
        no4.inserirFilho(no10);
        no4.inserirFilho(no9);

        NoArvore<Integer> no1 = new NoArvore<>(1);
        no1.inserirFilho(no4);
        no1.inserirFilho(no3);
        no1.inserirFilho(no2);

        Arvore<Integer> arvore = new Arvore<>();
        arvore.setRaiz(no1);

        // Imprime a estrutura da árvore
        System.out.println("------------------------------------------------------");
        System.out.println("Estrutura da Árvore Completa:");
        arvore.imprimirArvoreVisual();
        System.out.println("");

        // ======================
        // TESTES DOS MÉTODOS
        // ======================

        // Teste: Contar o número total de nós
        System.out.println("Número total de nós:");
        System.out.println(arvore.contarNos());
        System.out.println("");

        // Teste: Verificar se um valor pertence à árvore
        System.out.println("Pertence 7?");
        System.out.println(arvore.pertence(7)); // true
        System.out.println("");

        System.out.println("Pertence 55?");
        System.out.println(arvore.pertence(55)); // false
        System.out.println("");

        // Teste: Contar o número de filhos diretos de um nó
        System.out.println("Número de filhos diretos de 1:");
        System.out.println(arvore.contarFilhos(1)); // 3
        System.out.println("");

        System.out.println("Número de filhos diretos de 4:");
        System.out.println(arvore.contarFilhos(4)); // 2
        System.out.println("");

        System.out.println("Número de filhos diretos de 2:");
        System.out.println(arvore.contarFilhos(2)); // 3
        System.out.println("");

        // Teste: Caminho até um nó específico
        System.out.println("Caminho até o nó 7:");
        System.out.println(arvore.verificaAteUmNo(7)); // 1 -> 2 -> 7
        System.out.println("");

        System.out.println("Caminho até o nó 8:");
        System.out.println(arvore.verificaAteUmNo(8)); // 1 -> 3 -> 8
        System.out.println("");

        // Teste: Altura da árvore
        System.out.println("Altura da árvore:");
        System.out.println(arvore.contarAltura()); // 3
        System.out.println("");

        // Teste: Contar o número de folhas
        System.out.println("Número de folhas:");
        System.out.println(arvore.contarFolhas()); // 6
        System.out.println("");

        // Teste: Contar o número de nós com pelo menos um filho
        System.out.println("Número de nós com pelo menos um filho:");
        System.out.println(arvore.contarNosComFilhos()); // 4
        System.out.println("");

        // Teste: Contar o número de nós em um nível específico
        System.out.println("Número de nós no nível 2:");
        System.out.println(arvore.contarNosNivel(2)); // 6
        System.out.println("");

        // ======================
        // TESTE 2 – ÁRVORE VAZIA
        // ======================

        Arvore<Integer> arvoreVazia = new Arvore<>();
        System.out.println("------------------------------------------------------");
        System.out.println("Estrutura da Árvore Vazia:");
        arvoreVazia.imprimirArvoreVisual();
        System.out.println("");

        System.out.println("Número total de nós na árvore vazia:");
        System.out.println(arvoreVazia.contarNos()); // 0
        System.out.println("");

        System.out.println("Altura da árvore vazia:");
        System.out.println(arvoreVazia.contarAltura()); // -1
        System.out.println("");

        System.out.println("Número de folhas na árvore vazia:");
        System.out.println(arvoreVazia.contarFolhas()); // 0
        System.out.println("");

        // ======================
        // TESTE 3 – ÁRVORE DEGENERADA
        // ======================

        System.out.println("TESTE 3 – ÁRVORE DEGENERADA");

        // Criação de uma árvore degenerada
        NoArvore<Integer> noDeg5 = new NoArvore<>(5);
        NoArvore<Integer> noDeg4 = new NoArvore<>(4);
        noDeg4.inserirFilho(noDeg5);
        NoArvore<Integer> noDeg3 = new NoArvore<>(3);
        noDeg3.inserirFilho(noDeg4);
        NoArvore<Integer> noDeg2 = new NoArvore<>(2);
        noDeg2.inserirFilho(noDeg3);
        NoArvore<Integer> noDeg1 = new NoArvore<>(1);
        noDeg1.inserirFilho(noDeg2);

        Arvore<Integer> arvoreDegenerada = new Arvore<>();
        arvoreDegenerada.setRaiz(noDeg1);

        // Imprime a estrutura da árvore degenerada
        System.out.println("------------------------------------------------------");
        System.out.println("Estrutura da Árvore Degenerada:");
        arvoreDegenerada.imprimirArvoreVisual();
        System.out.println("");

        // Teste: Número total de nós
        System.out.println("Número total de nós:");
        System.out.println(arvoreDegenerada.contarNos()); // 5
        System.out.println("");

        // Teste: Altura da árvore
        System.out.println("Altura da árvore:");
        System.out.println(arvoreDegenerada.contarAltura()); // 4
        System.out.println("");

        // Teste: Número de folhas
        System.out.println("Número de folhas:");
        System.out.println(arvoreDegenerada.contarFolhas()); // 1
        System.out.println("");

        // Teste: Número de nós com pelo menos um filho
        System.out.println("Número de nós com pelo menos um filho:");
        System.out.println(arvoreDegenerada.contarNosComFilhos()); // 4
        System.out.println("");

        // Teste: Caminho até o nó 5
        System.out.println("Caminho até o nó 5:");
        System.out.println(arvoreDegenerada.verificaAteUmNo(5)); // 1 -> 2 -> 3 -> 4 -> 5
        System.out.println("");

        System.out.println("------------------------------------------------------");
        System.out.println("TESTE  – Contar Folhas em Árvore N-ária:");
        Arvore<String> arvoreNA = new Arvore<>();

        NoArvore<String> noA = new NoArvore<>("A");
        NoArvore<String> noB = new NoArvore<>("B");
        NoArvore<String> noC = new NoArvore<>("C");
        NoArvore<String> noD = new NoArvore<>("D");
        NoArvore<String> noE = new NoArvore<>("E");

        // Monta os filhos da raiz A
        noA.setPrimeiro(noB);     // B é o primeiro filho
        noB.setProximo(noC);      // C é irmão à direita de B
        noC.setProximo(noD);      // D é irmão à direita de C

        // C tem um filho E
        noC.setPrimeiro(noE);

        arvoreNA.setRaiz(noA);

        // Impressão visual da árvore
        System.out.println("Estrutura da Árvore N-ária:");
        arvoreNA.imprimirArvoreVisual();

        int folhas = arvoreNA.contarFolhas();
        System.out.println("Esperado (3 folhas: B, D, E): 3");
        System.out.println("Resultado: " + folhas);
        System.out.println("");

    }
}