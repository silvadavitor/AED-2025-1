package com.algoritmos.arvore.arvoreBI;

import java.util.Arrays;

public class ArvoreBinaria<T> {
    private NoArvoreBinaria<T> raiz;

    // Construtor: cria árvore vazia
    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void setRaiz(NoArvoreBinaria<T> raiz) {
        this.raiz = raiz;
    }

    // Verifica se a árvore está vazia
    public boolean estaVazia() {
        return raiz == null;
    }

    // Verifica se um valor pertence à árvore
    public boolean pertence(T info) {
        return pertence(raiz, info);
    }

    private boolean pertence(NoArvoreBinaria<T> no, T info) {
        if (no == null) {
            return false;
        } else {
            return (no.getInfo() == info)
                || pertence(no.getEsquerda(), info)
                || pertence(no.getDireita(), info);
        }
    }

    // Impressão pré-ordem (estrutura com < >) ---------- PRE ORDEM
    public String toString() {
        return arvorePre(raiz);
    }

    private String arvorePre(NoArvoreBinaria<T> no) {
        if (no == null) {
            return "<>";
        }
        return "<" + no.getInfo() + arvorePre(no.getEsquerda()) + arvorePre(no.getDireita()) + ">";
    }

    // ==========================
    // METODOS NOVOS
    // ==========================
    
    // Metodo pra imprimir a arvore de forma visual hierarquica
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
    
    private void colocarNo(char[][] grid, NoArvoreBinaria<T> no, int level, int l, int r) {
        if (no == null) return;
        int rowNode = level * 2;
        int mid = (l + r) / 2;
    
        String s = no.getInfo().toString();
        grid[rowNode][mid] = s.charAt(0);
    
        if (no.getEsquerda() != null) {
            int ml = (l + mid) / 2;
            grid[rowNode + 1][ml] = '/';
            colocarNo(grid, no.getEsquerda(), level + 1, l, mid - 1);
        }
        if (no.getDireita() != null) {
            int mr = (mid + 1 + r) / 2;
            grid[rowNode + 1][mr] = '\\';
            colocarNo(grid, no.getDireita(), level + 1, mid + 1, r);
        }
    }

    // IMPRESSOES (estrutura com < >) --------------------------------------------------------------------------------

    // Impressao em pos ordem ---------- POS ORDEM
    public String toStringPosOrdem() {
        return arvorePosOrdem(raiz);
    }

    private String arvorePosOrdem(NoArvoreBinaria<T> no) {
        if (no == null) {
            return "<>";
        }
        return "<" + arvorePosOrdem(no.getEsquerda()) + arvorePosOrdem(no.getDireita()) + no.getInfo() + ">";
    }    
    
    // Impressao simétrica ---------- SIMETRICA
    public String toStringSimetrico() {
        return arvoreSimetrica(raiz);
    }

    private String arvoreSimetrica(NoArvoreBinaria<T> no) {
        if (no == null) {
            return "<>";
        }
        return "<" + arvoreSimetrica(no.getEsquerda()) + no.getInfo() + arvoreSimetrica(no.getDireita()) + ">";
    }
        

    // VISITAS COM VIRGULAS --------------------------------------------------------------------------------

    // visita em pre ordem (com vírgulas) ---------- PRE ORDEM
    public String visitaPreOrdem() {
        return visitaPreOrdem(raiz);
    }

    private String visitaPreOrdem(NoArvoreBinaria<T> no) {
        if (no == null) {
            return "";
        }
        return no.getInfo() + "," + visitaPreOrdem(no.getEsquerda()) + visitaPreOrdem(no.getDireita());
    }

    // visita em pos ordem (com vírgulas) ---------- POS ORDEM
    public String visitaPosOrdem() {
        return visitaPosOrdem(raiz);
    }

    private String visitaPosOrdem(NoArvoreBinaria<T> no) {
        if (no == null) {
            return "";
        }
        return visitaPosOrdem(no.getEsquerda()) + visitaPosOrdem(no.getDireita()) + no.getInfo() + ",";
    }

    // visita simétrica (com vírgulas) ---------- SIMETRICA
    public String visitaSimetrica() {
        return visitaSimetrica(raiz);
    }

    private String visitaSimetrica(NoArvoreBinaria<T> no) {
        if (no == null) {
            return "";
        }
        return visitaSimetrica(no.getEsquerda()) + no.getInfo() + "," + visitaSimetrica(no.getDireita());
    }

    // CONTAGENS --------------------------------------------------------------------------------

    // Conta todos os nós da árvore
    public int contarNos() {
        return contarNos(raiz);
    }

    private int contarNos(NoArvoreBinaria<T> no) {
        if (no == null) return 0;
        return 1 + contarNos(no.getEsquerda()) + contarNos(no.getDireita());
    }

    // Contar somente os nós folha, a partir de um nó qualquer (sa) <--- Ex alana
    // public int contarFolhas(NoArvoreBinaria<T> sa){
    //     if (sa == null){
    //         return 0;
    //     }
    //     else if (sa.getEsquerda() == null && sa.getDireita() == null){
    //         return 1;
    //     }
    //     return contarFolhas(sa.getEsquerda()) + contarFolhas(sa.getDireita());
        
    // }

    // Conta o número de folhas (nós sem filhos), a partir da raiz
    public int contarFolhas() {
        return contarFolhas(raiz);
    }

    private int contarFolhas(NoArvoreBinaria<T> no) {
        int cont = 0;
        if (no == null) {
            return 0;
        } else if (no.getDireita() == null && no.getEsquerda() == null) {
            cont++;
        }
        return cont + contarFolhas(no.getEsquerda()) + contarFolhas(no.getDireita());
    }

    // Conta a altura da árvore (altura de árvore vazia = -1)
    public int contarAltura() {
        return contarAltura(raiz);
    }

    private int contarAltura(NoArvoreBinaria<T> no) {
        if (no == null) {
            return -1;
        }
        return 1 + Math.max(contarAltura(no.getEsquerda()), contarAltura(no.getDireita()));
    }

    // Conta número de nós com pelo menos um filho
    public int contarNosComFilhos() {
        return contarNosComFilhos(raiz);
    }

    private int contarNosComFilhos(NoArvoreBinaria<T> no) {
        if (no == null) return 0;
        if (no.getEsquerda() != null || no.getDireita() != null) {
            return 1 + contarNosComFilhos(no.getEsquerda()) + contarNosComFilhos(no.getDireita());
        }
        return contarNosComFilhos(no.getEsquerda()) + contarNosComFilhos(no.getDireita());
    }

    // Conta o número de nós internos (nós que não são folhas).
    public int contarNosInternos() {
         return contarNosInternos(raiz);
     }

    private int contarNosInternos(NoArvoreBinaria<T> no) {
         if (no == null) {
             return 0;
         }
         if (no.getEsquerda() == null && no.getDireita() == null) {
             return 0;
         }
         return 1 + contarNosInternos(no.getEsquerda()) + contarNosInternos(no.getDireita());
     }    

    // Conta o número de nós em um determinado nível da árvore.
    public int contarNosNivel(int nivel) {
        return contarNosNivel(raiz, nivel, 0);
    }

    private int contarNosNivel(NoArvoreBinaria<T> no, int nivel, int nivelAtual) {
        if (no == null) {
            return 0;
        }
        if (nivelAtual == nivel) {
            return 1;
        }
        return contarNosNivel(no.getEsquerda(), nivel, nivelAtual + 1) + contarNosNivel(no.getDireita(), nivel, nivelAtual + 1);
    }

    // METODOS AUXILIARES --------------------------------------------------------------------------------    

    // Verifica se a árvore é degenerada
    public boolean isDegenerada() {
        return isDegenerada(raiz);
    }

    private boolean isDegenerada(NoArvoreBinaria<T> no) {
        if (no == null) return true;
        if (no.getEsquerda() != null && no.getDireita() != null) return false;
        return isDegenerada(no.getEsquerda()) && isDegenerada(no.getDireita());
    }

    // Retorna a altura do no passado
    public int alturaDoNo(T valor) {
        return alturaDoNo(raiz, valor);
    }
    
    private int alturaDoNo(NoArvoreBinaria<T> no, T valor) {
        if (no == null) {
            return -1;
        }
        if (no.getInfo().equals(valor)) {
            return contarAltura(no);
        }
        int alturaEsquerda = alturaDoNo(no.getEsquerda(), valor);
        if (alturaEsquerda != -1) {
            return alturaEsquerda;
        }
        return alturaDoNo(no.getDireita(), valor);
    }

    //Uma árvore binária cheia é aquela em que todos os nós têm 0 ou 2 filhos
    public boolean isCheia() {
        return isCheia(raiz);
    }
    
    private boolean isCheia(NoArvoreBinaria<T> no) {
        if (no == null) {
            return true;
        }
        if ((no.getEsquerda() == null && no.getDireita() != null) || 
            (no.getEsquerda() != null && no.getDireita() == null)) {
            return false;
        }
        return isCheia(no.getEsquerda()) && isCheia(no.getDireita());
    }

    // Verifica se a árvore é balanceada (diferença de altura entre subárvores não pode ser maior que 1)
    public boolean isBalanceada() {
        return isBalanceada(raiz) != -1;
    }

    private int isBalanceada(NoArvoreBinaria<T> no) {
        if (no == null) {
            return 0;
        }
        int alturaEsquerda = isBalanceada(no.getEsquerda());
        int alturaDireita = isBalanceada(no.getDireita());
        if (alturaEsquerda == -1 || alturaDireita == -1 || Math.abs(alturaEsquerda - alturaDireita) > 1) {
            return -1;
        }
        return Math.max(alturaEsquerda, alturaDireita) + 1;
    }

    // Verifica se a árvore é completa (todos os níveis, exceto possivelmente o último, estão completamente preenchidos)
    public boolean isCompleta() {
        return isCompleta(raiz, 0, contarNos());
    }

    private boolean isCompleta(NoArvoreBinaria<T> no, int indice, int totalNos) {
        if (no == null) {
            return true;
        }
        if (indice >= totalNos) {
            return false;
        }
        return isCompleta(no.getEsquerda(), 2 * indice + 1, totalNos) && isCompleta(no.getDireita(), 2 * indice + 2, totalNos);
    }

    // Caminha ate um nó específico e retorna o caminho percorrido.
    public String verificaAteUmNo(T valor) {
        return verificaAteUmNo(raiz, valor, "");
    }
    
    private String verificaAteUmNo(NoArvoreBinaria<T> no, T valor, String caminho) {
        if (no == null) {
            return "";
        }
        if (no.getInfo().equals(valor)) {
            return caminho + no.getInfo();
        }
        String caminhoEsquerda = verificaAteUmNo(no.getEsquerda(), valor, caminho + no.getInfo() + " -> ");
        if (!caminhoEsquerda.isEmpty()) {
            return caminhoEsquerda;
        }
        return verificaAteUmNo(no.getDireita(), valor, caminho + no.getInfo() + " -> ");
    }
}