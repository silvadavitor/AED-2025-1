package com.algoritmos.arvore.arvoreNaria;

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

    public String toString(){
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

    

}
