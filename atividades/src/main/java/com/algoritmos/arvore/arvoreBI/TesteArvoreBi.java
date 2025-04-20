package com.algoritmos.arvore.arvoreBI;

public class TesteArvoreBi {
    public static void main(String[] args) {
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<Integer>();

        // Criou a arvore vazia
        System.out.println("Está vazia antes de criar os nós e definir raiz:");
        System.out.println(arvore.estaVazia());
        System.out.println("");

        //Cria os nós
        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<>(6);
        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<>(5);
        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<>(4);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<>(3, no5, no6);
        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<>(2, null, no4);
        NoArvoreBinaria<Integer> no1 = new NoArvoreBinaria<>(1, no2, no3);

        //Define a Raiz no1
        arvore.setRaiz(no1);

        //Testa arvore vazia depois de adicionar nos
        System.out.println("Está vazia após criar os nós e definir raiz:");
        System.out.println(arvore.estaVazia());
        System.out.println("");


        System.out.println("ToString:");
        System.out.println(arvore.toString());
        System.out.println("");

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


        System.out.println("Número nós:");
        System.out.println(arvore.contarNos());
        System.out.println("");

        
        System.out.println("A árvore é degenerada?");
        System.out.println(arvore.isDegenerada());
        System.out.println("");

        System.out.println("\nCriando uma árvore degenerada:");
        ArvoreBinaria<Integer> arvoreDeg = new ArvoreBinaria<>();

        NoArvoreBinaria<Integer> d3 = new NoArvoreBinaria<>(3);
        NoArvoreBinaria<Integer> d2 = new NoArvoreBinaria<>(2, d3, null);
        NoArvoreBinaria<Integer> d1 = new NoArvoreBinaria<>(1, null, d2);

        arvoreDeg.setRaiz(d1);

        System.out.println("Estrutura da árvore:");
        System.out.println(arvoreDeg.toString());

        System.out.println("É degenerada?");
        System.out.println(arvoreDeg.isDegenerada());


    }
}