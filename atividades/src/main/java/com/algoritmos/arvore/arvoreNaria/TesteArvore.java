package com.algoritmos.arvore.arvoreNaria;

public class TesteArvore {
    public static void main(String[] args) {
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


        /* Criado a arvore com seus nós */

        // Teste1 to string

        System.out.println("To string: ");
        System.out.println(arvore.toString());
        System.out.println("");

        // Teste2 Pertence retorna true para 7
        System.out.println("Pertence 7: ");
        System.out.println(arvore.pertence(7));
        System.out.println("");

        // Teste3 Pertence retorna false para 55
        System.out.println("Pertence 55: ");
        System.out.println(arvore.pertence(55));
        System.out.println("");

        
        // Teste4 contar retorna 10
        System.out.println("Contar: ");
        System.out.println(arvore.contarNos());
        System.out.println("");
    }



}
