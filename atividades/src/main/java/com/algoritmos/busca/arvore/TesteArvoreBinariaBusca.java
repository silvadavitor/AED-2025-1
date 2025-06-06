package com.algoritmos.busca.arvore;

public class TesteArvoreBinariaBusca {

    public static void main(String[] args) {
        // CASO 1: inserção normal
        ArvoreBinariaBusca<Integer> arvore1 = new ArvoreBinariaBusca<>();
        int[] valores1 = {50, 30, 70, 40, 25, 75, 65, 35, 60};
        for (int valor : valores1) {
            arvore1.inserir(valor);
        }

        System.out.println("Caso 1:");
        System.out.println(arvore1.toString());
        // Esperado: <50<30<25<><><35<><>>><70<65<60<><>><>><75<><>>>>

        // CASO 2: remover folha
        ArvoreBinariaBusca<Integer> arvore2 = new ArvoreBinariaBusca<>();
        arvore2.inserir(50);
        arvore2.inserir(30);
        arvore2.inserir(25);
        arvore2.inserir(40);
        arvore2.retirar(40);

        System.out.println("Caso 2:");
        System.out.println(arvore2.toString());
        // Esperado: <50<30<25<><>><>>>

        // CASO 3: remover com 1 filho
        ArvoreBinariaBusca<Integer> arvore3 = new ArvoreBinariaBusca<>();
        int[] valores3 = {80, 52, 90, 48, 71, 63, 67};
        for (int v : valores3) arvore3.inserir(v);
        arvore3.retirar(71);

        System.out.println("Caso 3:");
        System.out.println(arvore3.toString());
        // Esperado: <80<52<48<><>>><90<63<><67<><>>>>
    }
}
