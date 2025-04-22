package com.algoritmos.arvore.arvoreNaria;

import java.util.Arrays;

import com.algoritmos.arvore.arvoreBI.NoArvoreBinaria;

public class Arvore<T> {
    private NoArvore<T> raiz;

    public Arvore() {
        this.raiz = null;
    }

    public NoArvore<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NoArvore<T> raiz) {
        this.raiz = raiz;
    }

    public boolean pertence(T info){
        if(raiz == null){
            return false;
        }
        else{
            return pertence(raiz, info);
        }
    }

    private boolean pertence(NoArvore<T> no, T info){
        if(no.getInfo().equals(info)){
            return true;
        }
        else{
            NoArvore<T> p;
            p = no.getPrimeiro();
            while (p != null) {
                if(pertence(p, info)){
                    return true;
                }
                p = p.getProximo();
            }
        }
            return false;
    }

    public String toString(){ // Impressao em pre ordem ---------- PRE ORDEM
        if(this.raiz == null){
            return "";
        }
        else{
            return obterRepresentacaoTextual(this.raiz);
        }
    }
    
    private String obterRepresentacaoTextual(NoArvore<T> no){
        NoArvore<T> p;
        String s = "<";
        s = s + no.getInfo();

        p = no.getPrimeiro();
        while (p != null) {
            s = s + obterRepresentacaoTextual(p);
            p = p.getProximo();
        }
    s = s + ">";
    return s;
    }

    // ==========================
    // METODOS NOVOS
    // ==========================

    // HIERARQUIA DA ARVORE --------------------------------------------------
    
    // Metodos pra imprimir a arvore de forma visual hierarquica
    public void imprimirArvoreVisual() {
        if (raiz == null) {
            System.out.println("Árvore vazia.");
            return;
        }
        int h = contarAltura(raiz) + 1;
        int rows = 2 * h - 1;
        int cols = (1 << (h + 1)) - 1;
    
        char[][] grid = new char[rows][cols];
        for (int i = 0; i < rows; i++)
            Arrays.fill(grid[i], ' ');
    
        colocarNo(grid, raiz, 0, 0, cols - 1);
    
        for (char[] linha : grid) {
            System.out.println(new String(linha));
        }
    }
    
    private void colocarNo(char[][] grid, NoArvore<T> no, int level, int l, int r) {
        if (no == null) return;
    
        int rowNode = level * 2;
        int mid = (l + r) / 2;
    
        String s = no.getInfo().toString();
        grid[rowNode][mid] = s.charAt(0);
    
        NoArvore<T> filho = no.getPrimeiro();
        int numFilhos = contarFilhosDiretos(no);
        int intervalo = (r - l) / Math.max(1, numFilhos);
    
        int posicaoAtual = l;
        while (filho != null) {
            int midFilho = posicaoAtual + intervalo / 2;
            grid[rowNode + 1][midFilho] = '|';
            colocarNo(grid, filho, level + 1, posicaoAtual, posicaoAtual + intervalo - 1);
            posicaoAtual += intervalo;
            filho = filho.getProximo();
        }
    }

    // Conta o número de filhos diretos de um nó específico
    public int contarFilhos(T valor) {
        NoArvore<T> no = buscarNo(raiz, valor);
        if (no == null) {
            return 0; // Retorna 0 se o nó não for encontrado
        }
        return contarFilhosDiretos(no);
    }

    private int contarFilhosDiretos(NoArvore<T> no) {
        int cont = 0;
        NoArvore<T> p = no.getPrimeiro();
        while (p != null) {
            cont++;
            p = p.getProximo();
        }
        return cont;
    }

    // Conta número de nos filho
    private NoArvore<T> buscarNo(NoArvore<T> no, T valor) {
        if (no == null) {
            return null;
        }
        if (no.getInfo().equals(valor)) {
            return no;
        }
        NoArvore<T> p = no.getPrimeiro();
        while (p != null) {
            NoArvore<T> resultado = buscarNo(p, valor);
            if (resultado != null) {
                return resultado;
            }
            p = p.getProximo();
        }
        return null;
    }

    // IMPRESSOES (estrutura com < >) --------------------------------------------------------------------------------

    // Impressao em pos ordem ---------- POS ORDEM
    public String toStringPosOrdem() {
        return arvorePosOrdem(raiz);
    }

    private String arvorePosOrdem(NoArvore<T> no) {
        if (no == null) {
            return "<>";
        }
        String s = "<";
        NoArvore<T> p = no.getPrimeiro();
        while (p != null) {
            s = s + arvorePosOrdem(p);
            p = p.getProximo();
        }
        return s + no.getInfo() + ">";
    }

    // Impressao simétrica ---------- SIMETRICA
    public String toStringSimetrico() {
        return arvoreSimetrica(raiz);
    }

    private String arvoreSimetrica(NoArvore<T> no) {
        if (no == null) {
            return "<>";
        }
        String s = "<";
        NoArvore<T> p = no.getPrimeiro();
        while (p != null) {
            s = s + arvoreSimetrica(p);
            p = p.getProximo();
        }
        return s + no.getInfo() + ">";
    }

    // VISITAS COM VIRGULAS --------------------------------------------------------------------------------

    // visita em pre ordem (com vírgulas) ---------- PRE ORDEM
    public String visitaPreOrdem() {
        return visitaPreOrdem(raiz);
    }

    private String visitaPreOrdem(NoArvore<T> no) {
        if (no == null) {
            return "";
        }
        String s = no.getInfo() + ",";
        NoArvore<T> p = no.getPrimeiro();
        while (p != null) {
            s = s + visitaPreOrdem(p);
            p = p.getProximo();
        }
        return s;
    }

    // visita em pos ordem (com vírgulas) ---------- POS ORDEM
    public String visitaPosOrdem() {
        return visitaPosOrdem(raiz);
    }

    private String visitaPosOrdem(NoArvore<T> no) {
        if (no == null) {
            return "";
        }
        String s = "";
        NoArvore<T> p = no.getPrimeiro();
        while (p != null) {
            s = s + visitaPosOrdem(p);
            p = p.getProximo();
        }
        return s + no.getInfo() + ",";
    }

    // visita simétrica (com vírgulas) ---------- SIMETRICA
    public String visitaSimetrica() {
        return visitaSimetrica(raiz);
    }

    private String visitaSimetrica(NoArvore<T> no) {
        if (no == null) {
            return "";
        }
        String s = "";
        NoArvore<T> p = no.getPrimeiro();
        while (p != null) {
            s = s + visitaSimetrica(p);
            p = p.getProximo();
        }
        return s + no.getInfo() + ",";
    }

    // CONTAGENS --------------------------------------------------------------------------------
    
    // Conta no total da arvore
    public int contarNos(){
        if(this.raiz == null){
            return 0;
        }
        else{
            return contarNos(this.raiz);
        }
    }

    private int contarNos(NoArvore<T> no){
        NoArvore<T> p;
        int cont = 1;
        p = no.getPrimeiro();
        while (p != null) {
            cont = cont + contarNos(p);
            p = p.getProximo();
        }
        return cont;
    }

    /* OU

    private int contarNos(NoArvore<T> no) {
        if (no == null) {
            return 0;
        }
        return 1 + contarNos(no.getPrimeiro()) + contarNos(no.getProximo());
    }
        
    */ 
    
    // Conta o número de folhas (nós sem filhos)
    public int contarFolhas() {
        return contarFolhas(raiz);
    }

    private int contarFolhas(NoArvore<T> no) {
        int cont = 0;
        if (no == null) {
            return 0;
        } else if (no.getPrimeiro() == null) {
            cont++;
        }
        NoArvore<T> p = no.getPrimeiro();
        while (p != null) {
            cont += contarFolhas(p);
            p = p.getProximo();
        }
        return cont;
    }


    // Conta a altura da árvore (altura de árvore vazia = -1)
    public int contarAltura() {
        return contarAltura(raiz);
    }

    private int contarAltura(NoArvore<T> no) {
        if (no == null) {
            return -1;
        }
        int alturaMaxima = -1;
        NoArvore<T> p = no.getPrimeiro();
        while (p != null) {
            int alturaAtual = contarAltura(p);
            if (alturaAtual > alturaMaxima) {
                alturaMaxima = alturaAtual;
            }
            p = p.getProximo();
        }
        return 1 + alturaMaxima;
    }
    
    // Conta número de nós com pelo menos um filho
    public int contarNosComFilhos() {
        return contarNosComFilhos(raiz);
    }

    private int contarNosComFilhos(NoArvore<T> no) {
        if (no == null) return 0;
        if (no.getPrimeiro() != null) {
            return 1 + contarNosComFilhos(no.getPrimeiro()) + contarNosComFilhos(no.getProximo());
        }
        return contarNosComFilhos(no.getPrimeiro()) + contarNosComFilhos(no.getProximo());
    }

    // Conta o número de nós internos (nós que não são folhas).
    public int contarNosInternos() {
         return contarNosInternos(raiz);
    }

    private int contarNosInternos(NoArvore<T> no) {
         if (no == null) {
             return 0;
         }
         if (no.getPrimeiro() == null) {
             return 0;
         }
         return 1 + contarNosInternos(no.getPrimeiro()) + contarNosInternos(no.getProximo());
    }

    // Conta o número de nós em um determinado nível da árvore.
    public int contarNosNivel(int nivel) {
        return contarNosNivel(raiz, nivel, 0);
    }

    private int contarNosNivel(NoArvore<T> no, int nivel, int nivelAtual) {
        if (no == null) {
            return 0;
        }
        if (nivelAtual == nivel) {
            return 1;
        }
        int cont = 0;
        NoArvore<T> p = no.getPrimeiro();
        while (p != null) {
            cont += contarNosNivel(p, nivel, nivelAtual + 1);
            p = p.getProximo();
        }
        return cont;
    }

    // Verifica se a árvore é degenerada\
    public boolean isDegenerada() {
        return isDegenerada(raiz);
    }

    private boolean isDegenerada(NoArvore<T> no) {
        if (no == null) {
            return true;
        }
        if (no.getPrimeiro() == null) {
            return true;
        }
        NoArvore<T> p = no.getPrimeiro();
        while (p != null) {
            if (p.getProximo() != null) {
                return false;
            }
            p = p.getProximo();
        }
        return isDegenerada(no.getPrimeiro());
    }

    // Retorna a altura do nó passado
    public int alturaDoNo(T valor) {
        return alturaDoNo(raiz, valor);
    }
    
    private int alturaDoNo(NoArvore<T> no, T valor) {
        if (no == null) {
            return -1;
        }
        if (no.getInfo().equals(valor)) {
            return contarAltura(no);
        }
        NoArvore<T> p = no.getPrimeiro();
        while (p != null) {
            int altura = alturaDoNo(p, valor);
            if (altura != -1) {
                return altura;
            }
            p = p.getProximo();
        }
        return -1;
    }

    // Verifica se a árvore é cheia (todos os nós têm o mesmo número de filhos)
    public boolean isCheia() {
        return isCheia(raiz);
    }

    private boolean isCheia(NoArvore<T> no) {
        if (no == null) {
            return true;
        }
        int numFilhos = 0;
        NoArvore<T> p = no.getPrimeiro();
        while (p != null) {
            numFilhos++;
            p = p.getProximo();
        }
        if (numFilhos == 0) {
            return true;
        }
        p = no.getPrimeiro();
        while (p != null) {
            if (!isCheia(p)) {
                return false;
            }
            p = p.getProximo();
        }
        return true;
    }

    // Verifica se a árvore é completa (todos os níveis, exceto possivelmente o último, estão completamente preenchidos)
    public boolean isCompleta() {
        return isCompleta(raiz, 0, contarNos());
    }   

    private boolean isCompleta(NoArvore<T> no, int index, int totalNos) {
        if (no == null) {
            return true;
        }
        if (index >= totalNos) {
            return false;
        }
        return isCompleta(no.getPrimeiro(), 2 * index + 1, totalNos) && isCompleta(no.getProximo(), 2 * index + 2, totalNos);
    }

    // Caminha ate um nó específico e retorna o caminho percorrido.
    public String verificaAteUmNo(T valor) {
        return verificaAteUmNo(raiz, valor, "");
    }

    private String verificaAteUmNo(NoArvore<T> no, T valor, String caminho) {
        if (no == null) {
            return "";
        }
        if (no.getInfo().equals(valor)) {
            return caminho + no.getInfo();
        }
        NoArvore<T> p = no.getPrimeiro();
        while (p != null) {
            String resultado = verificaAteUmNo(p, valor, caminho + no.getInfo() + " -> ");
            if (!resultado.isEmpty()) {
                return resultado;
            }
            p = p.getProximo();
        }
        return "";
    }


}