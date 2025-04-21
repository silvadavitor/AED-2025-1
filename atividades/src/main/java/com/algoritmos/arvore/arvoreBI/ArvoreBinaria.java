package com.algoritmos.arvore.arvoreBI;

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

    // Impressão pré-ordem (estrutura com < >)
    public String toString() {
        return arvorePre(raiz);
    }

    private String arvorePre(NoArvoreBinaria<T> no) {
        if (no == null) {
            return "<>";
        }
        return "<" + no.getInfo() + arvorePre(no.getEsquerda()) + arvorePre(no.getDireita()) + ">";
    }

    // Impressão pós-ordem (estrutura com < >)
    public String arvorePos() {
        return arvorePos(raiz);
    }

    private String arvorePos(NoArvoreBinaria<T> no) {
        if (no == null) {
            return "<>";
        }
        return "<" + arvorePos(no.getEsquerda()) + arvorePos(no.getDireita()) + no.getInfo() + ">";
    }

    // Impressão simétrica (estrutura com < >)
    public String arvoreSimetrica() {
        return arvoreSimetrica(raiz);
    }

    private String arvoreSimetrica(NoArvoreBinaria<T> no) {
        if (no == null) {
            return "<>";
        }
        return "<" + arvoreSimetrica(no.getEsquerda()) + no.getInfo() + arvoreSimetrica(no.getDireita()) + ">";
    }

    // Impressão simétrica simples (ex: 30,70,80)
    public String toStringSimples() {
        return toStringSimples(raiz).replaceAll(",$", "");
    }

    private String toStringSimples(NoArvoreBinaria<T> no) {
        if (no == null) return "";
        return toStringSimples(no.getEsquerda()) + no.getInfo() + "," + toStringSimples(no.getDireita());
    }

    // Impressão pós-ordem simples (ex: 80,10,25,20,70)
    public String toStringSimplesPos() {
        return toStringSimplesPos(raiz).replaceAll(",$", "");
    }

    private String toStringSimplesPos(NoArvoreBinaria<T> no) {
        if (no == null) return "";
        return toStringSimplesPos(no.getEsquerda()) + toStringSimplesPos(no.getDireita()) + no.getInfo() + ",";
    }

    // Visita em ordem simétrica (com vírgulas)
    public String toStringSimplesSimetrico() {
        return visitarOrdemSimetrica(raiz);
    }

    private String visitarOrdemSimetrica(NoArvoreBinaria<T> no) {
        if (no != null) {
            return visitarOrdemSimetrica(no.getEsquerda()) + no.getInfo() + "," + visitarOrdemSimetrica(no.getDireita());
        }
        return "";
    }

    // Conta todos os nós da árvore
    public int contarNos() {
        return contarNos(raiz);
    }

    private int contarNos(NoArvoreBinaria<T> no) {
        if (no == null) return 0;
        return 1 + contarNos(no.getEsquerda()) + contarNos(no.getDireita());
    }

    // Conta o número de folhas (nós sem filhos)
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

    // Verifica se a árvore é degenerada
    public boolean isDegenerada() {
        return isDegenerada(raiz);
    }

    private boolean isDegenerada(NoArvoreBinaria<T> no) {
        if (no == null) return true;
        if (no.getEsquerda() != null && no.getDireita() != null) return false;
        return isDegenerada(no.getEsquerda()) && isDegenerada(no.getDireita());
    }

    // Alternativo para verificação de árvore degenerada
    public boolean eDegenerada() {
        return eDegenerada(raiz);
    }

    private boolean eDegenerada(NoArvoreBinaria<T> no) {
        if (no == null) return true;
        if (no.getEsquerda() == null && no.getDireita() == null) return true;
        if (no.getEsquerda() != null && no.getDireita() != null) return false;
        return eDegenerada(no.getEsquerda()) && eDegenerada(no.getDireita());
    }

    // Conta nós internos a partir da raiz
    public int contarNosInternos() {
        if (raiz.getInfo() != null || raiz.getEsquerda() != null || raiz.getDireita() != null) {
            return 1 + contarNosInternos(raiz.getEsquerda()) + contarNosInternos(raiz.getDireita());
        }
        return 0;
    }

    // Conta nós internos a partir de um nó qualquer
    public int contarNosInternos(NoArvoreBinaria<T> no) {
        if (no.getInfo() != null || no.getEsquerda() != null || no.getDireita() != null) {
            return 1 + contarNosInternos(no.getEsquerda()) + contarNosInternos(no.getDireita());
        }
        return 0;
    }

    
    // ------------------------------
    // MÉTODOS COMENTADOS (NÃO ALTERADOS)
    // ------------------------------

    // // Conta o número de nós na árvore binária.
    // public int contarNos() {
    //     return contarNos(raiz);
    // }

    // private int contarNos(NoArvoreBinaria<T> no) {
    //     if (no == null) {
    //         return 0;
    //     }
    //     return 1 + contarNos(no.getEsq()) + contarNos(no.getDir());
    // }

    // // Conta o número de folhas (nós sem filhos).
    // public int contarFolhas() {
    //     return contarFolhas(raiz);
    // }

    // private int contarFolhas(NoArvoreBinaria<T> no) {
    //     if (no == null) {
    //         return 0;
    //     }
    //     if (no.getEsq() == null && no.getDir() == null) {
    //         return 1;
    //     }
    //     return contarFolhas(no.getEsq()) + contarFolhas(no.getDir());
    // }

    // // Conta o número de nós internos (nós que não são folhas).
    // public int contarNosInternos() {
    //     return contarNosInternos(raiz);
    // }

    // private int contarNosInternos(NoArvoreBinaria<T> no) {
    //     if (no == null) {
    //         return 0;
    //     }
    //     if (no.getEsq() == null && no.getDir() == null) {
    //         return 0;
    //     }
    //     return 1 + contarNosInternos(no.getEsq()) + contarNosInternos(no.getDir());
    // }
}
