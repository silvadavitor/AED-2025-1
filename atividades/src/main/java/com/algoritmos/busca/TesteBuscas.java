package com.algoritmos.busca;

public class TesteBuscas {
    public static void main(String[] args) {
        // Dados de entrada comuns aos testes
        Integer[] dados = {0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        // Teste 1: BuscaLinear - buscar(20) → índice 2
        BuscaLinear<Integer> buscaLinear = new BuscaLinear<>();
        buscaLinear.setInfo(dados);
        int resultado1 = buscaLinear.buscar(20);
        System.out.println("Teste 1 (BuscaLinear): " + resultado1); // Esperado: 2

        // Teste 2: BuscaLinearVetorOrdenado - buscar(40) → índice 4
        BuscaLinearVetorOrdenado<Integer> buscaLinearOrd = new BuscaLinearVetorOrdenado<>();
        buscaLinearOrd.setInfo(dados);
        int resultado2 = buscaLinearOrd.buscar(40);
        System.out.println("Teste 2 (BuscaLinearVetorOrdenado): " + resultado2); // Esperado: 4

        // Teste 3: BuscaBinaria - buscar(70) → índice 7
        BuscaBinaria<Integer> buscaBinaria = new BuscaBinaria<>();
        buscaBinaria.setInfo(dados);
        int resultado3 = buscaBinaria.buscar(70);
        System.out.println("Teste 3 (BuscaBinaria): " + resultado3); // Esperado: 7

        // Teste 4: BuscaBinaria - buscar(75) → não encontrado → -1
        int resultado4 = buscaBinaria.buscar(75);
        System.out.println("Teste 4 (BuscaBinaria): " + resultado4); // Esperado: -1
    }
}
