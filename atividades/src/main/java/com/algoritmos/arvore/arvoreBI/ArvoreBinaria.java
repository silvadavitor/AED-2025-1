package com.algoritmos.arvore.arvoreBI;

public class ArvoreBinaria<T> {
    private NoArvoreBinaria<T> raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }
    public void setRaiz(NoArvoreBinaria<T> raiz) {
        this.raiz = raiz;
    }

    public boolean estaVazia(){
        if (raiz == null){
            return true;
        }
        return false;
    }

    public boolean pertence(T info) {
        return pertence(raiz, info);
    }

    private boolean pertence(NoArvoreBinaria<T> no, T info) {
        if (no == null) {
            return false;
        }
        else{
            return (no.getInfo() == info) || pertence(no.getEsquerda(), info) || pertence(no.getDireita(), info);
        }
           
    }

    public String toString() {
        return arvorePre(raiz);
    }

    private String arvorePre(NoArvoreBinaria<T> no) {
        if (no == null) {
            return "<>";
        }
        return "<" + no.getInfo() + arvorePre(no.getEsquerda()) + arvorePre(no.getDireita()) + ">";
    }

    public int contarNos() {
        return contarNos(raiz);
    }

    private int contarNos(NoArvoreBinaria<T> no) {
        if (no == null) {
            return 0;
        }
        return 1 + contarNos(no.getEsquerda()) + contarNos(no.getDireita());
    }

    public boolean isDegenerada(){
        return isDegenerada(raiz);
    }

    private boolean isDegenerada(NoArvoreBinaria<T> no) {
        // se o nó é vazio ta certo
        if (no == null) {
            return true;
        }

        // se o nó tem esquerda e direita = falso
        if (no.getEsquerda() != null && no.getDireita() != null) {
            return false;
        }

        // chama recursivamente os valores do nó esquerda e direira (podem ser vazios)
        return isDegenerada(no.getEsquerda()) && isDegenerada(no.getDireita());
    }






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


    // public int contarNosInternos(NoArvoreBinaria<T> no)
	// Este método deverá contar a quantidade de nós internos que existem numa
	// árvore cuja raiz seja no.
    public int contarNosInternos(NoArvoreBinaria<T> no) {

		if (no.getInfo() != null|| no.getEsquerda() != null || no.getDireita() != null) {
			return 1 + contarNosInternos(no.getEsquerda()) + contarNosInternos(no.getDireita());
		}
		return 0;
	}


    
    // seu eu quiser pegar desde a raiz
    public int contarNosInternos() {

		if (raiz.getInfo() != null|| raiz.getEsquerda() != null || raiz.getDireita() != null) {
			return 1 + contarNosInternos(raiz.getEsquerda()) + contarNosInternos(raiz.getDireita());
		}
		return 0;
	}



    // outros metodos

    public String visitarOrdemSimetrica() {
        return visitarOrdemSimetrica(raiz);
    }


    private String visitarOrdemSimetrica(NoArvoreBinaria<T> no) {
        String visitas = "";
        if (no != null) {
            visitas += visitarOrdemSimetrica(no.getEsquerda());
            visitas += no.getInfo();
            visitas += ",";
            visitas += visitarOrdemSimetrica(no.getDireita());
            return visitas;

        }
        return visitas;
    }



}