package com.algoritmos.busca.arvore;

public class ArvoreBinariaBusca<T extends Comparable<T>> extends ArvoreBinariaAbstract<T> {

    public void inserir(T valor) {
        NoArvoreBinaria<T> novo = new NoArvoreBinaria<>(valor);

        if (raiz == null) {
            raiz = novo;
        } else {
            NoArvoreBinaria<T> p = raiz;
            NoArvoreBinaria<T> pai;

            while (true) {
                pai = p;
                if (valor.compareTo(p.getInfo()) < 0) {
                    p = pai.getEsquerda();
                    if (p == null) {
                        pai.setEsquerda(novo);
                        return;
                    }
                } else {
                    p = pai.getDireita();
                    if (p == null) {
                        pai.setDireita(novo);
                        return;
                    }
                }
            }
        }
    }

    public void retirar(T valor) {
        NoArvoreBinaria<T> p = raiz;
        NoArvoreBinaria<T> pai = null;
        boolean filhoEsquerda = true;

        // === Localiza o nó a ser removido ===
        while (p != null && !p.getInfo().equals(valor)) {
            pai = p;
            if (valor.compareTo(p.getInfo()) < 0) {
                filhoEsquerda = true;
                p = p.getEsquerda();
            } else {
                filhoEsquerda = false;
                p = p.getDireita();
            }
        }

        if (p == null) return; // não encontrado

        // === Caso 1: Nó é folha ===
        if (p.getEsquerda() == null && p.getDireita() == null) {
            if (p == raiz) {
                raiz = null;
            } else if (filhoEsquerda) {
                pai.setEsquerda(null);
            } else {
                pai.setDireita(null);
            }
        }

        // === Caso 2: Nó com um único filho ===
        else if (p.getDireita() == null) { // só tem filho à esquerda
            if (p == raiz) {
                raiz = p.getEsquerda();
            } else if (filhoEsquerda) {
                pai.setEsquerda(p.getEsquerda());
            } else {
                pai.setDireita(p.getEsquerda());
            }
        } else if (p.getEsquerda() == null) { // só tem filho à direita
            if (p == raiz) {
                raiz = p.getDireita();
            } else if (filhoEsquerda) {
                pai.setEsquerda(p.getDireita());
            } else {
                pai.setDireita(p.getDireita());
            }
        }

        // === Caso 3: Nó com dois filhos ===
        else {
            NoArvoreBinaria<T> sucessor = extrairSucessor(p);
            if (p == raiz) {
                raiz = sucessor;
            } else if (filhoEsquerda) {
                pai.setEsquerda(sucessor);
            } else {
                pai.setDireita(sucessor);
            }
            sucessor.setEsquerda(p.getEsquerda());
        }
    }


    private NoArvoreBinaria<T> extrairSucessor(NoArvoreBinaria<T> p) {
        NoArvoreBinaria<T> atual = p.getDireita();
        NoArvoreBinaria<T> paiSucessor = p;
        NoArvoreBinaria<T> sucessor = p;

        while (atual != null) {
            paiSucessor = sucessor;
            sucessor = atual;
            atual = atual.getEsquerda();
        }

        // Se sucessor não for filho direto do p
        if (sucessor != p.getDireita()) {
            paiSucessor.setEsquerda(sucessor.getDireita());
            sucessor.setDireita(p.getDireita());
        }

        return sucessor;
    }


    public  NoArvoreBinaria<T> buscar(T valor) {
        NoArvoreBinaria<T> p;

        p = getRaiz();
        while (p != null && !p.getInfo().equals(valor)) {
            if (valor.compareTo(p.getInfo()) < 0) {
                p = p.getEsquerda();
        } else {
            p =  p.getDireita();
        }
    }
        return p;
    }   


    //-------------------------------
    ///NOVO
    public boolean isDegenerada() {
        return isDegenerada(raiz);
    }

    private boolean isDegenerada(NoArvoreBinaria<T> no) {
        if (no == null) return true;

        if (no.getEsquerda() != null && no.getDireita() != null) {
            return false; // dois filhos => não é degenerada
        }

        return isDegenerada(no.getEsquerda()) && isDegenerada(no.getDireita());
    }


    public boolean isCheia() {
        return isCheia(raiz);
    }

    private boolean isCheia(NoArvoreBinaria<T> no) {
        if (no == null) return true;

        boolean temEsq = no.getEsquerda() != null;
        boolean temDir = no.getDireita() != null;

        if (temEsq != temDir) return false; // só 1 filho => não cheia

        return isCheia(no.getEsquerda()) && isCheia(no.getDireita());
    }


    public boolean isBalanceada() {
        return isBalanceada(raiz) != -1;
    }

    private int isBalanceada(NoArvoreBinaria<T> no) {
        if (no == null) return 0;

        int altEsq = isBalanceada(no.getEsquerda());
        if (altEsq == -1) return -1;

        int altDir = isBalanceada(no.getDireita());
        if (altDir == -1) return -1;

        if (Math.abs(altEsq - altDir) > 1) return -1;

        return Math.max(altEsq, altDir) + 1;
    }



}