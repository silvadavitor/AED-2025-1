package com.algoritmos.listas.listaduplaencadeada;


public class ListaDupla<T> {
    private NoListaDupla<T> primeiro;
    
    public ListaDupla() {
        this.primeiro = null;
    }

    public NoListaDupla<T> getPrimeiro() {
        return primeiro;
    }

    public void inserir(T valor) {
        NoListaDupla<T> novo = new NoListaDupla<T>();

        novo.setInfo(valor);
        novo.setProximo(this.primeiro);
        novo.setAnterior(null);
        if (this.primeiro != null){
            this.primeiro.setAnterior(novo);
        }
        this.primeiro = novo;

    }
    public void exibir(){
        NoListaDupla<T> p = this.primeiro;

        while (p != null){
            System.out.println(p.getInfo());
            p = p.getProximo(); // p = p.proximo
        }
    }

    public boolean estaVazia(){
        if (this.primeiro == null){
            return true;
        }
        else{
            return false;
        }
    }

    public NoListaDupla<T> buscar(T valor){
        NoListaDupla<T> p = this.primeiro;

        while (p != null){
            if (p.getInfo().equals(valor)) {
                return p;
            }
            p = p.getProximo();
        }
        return null;
    }

    public void retirar(T valor){
        NoListaDupla<T> p = buscar(valor);

        if(p != null)
        if (primeiro == p){
            primeiro = p.getProximo();
        }
        else{
            p.getAnterior().setProximo(p.getProximo());
        }
        if (p.getProximo() != null){
            p.getProximo().setAnterior(p.getAnterior());
        }

    }

    public String toString(){
        String string = "";
        NoListaDupla<T> p = this.primeiro;

        while (p != null) {
            string += (string.isEmpty() ? "" : ",") + p.getInfo();
            p = p.getProximo();
        }

        return string;
    }


    public void exibirOrdemInversa(){
        ListaDupla<T> invertida = new ListaDupla<T>();
        NoListaDupla<T> p = this.primeiro;
        
        while (p != null){
            System.out.println((p.getInfo()));
            p = p.getProximo();
        }
    }


    public void liberar(){
        NoListaDupla<T> p = this.primeiro;

        while (p != null){
            p.setAnterior(null);
            NoListaDuola save = p.getProximo();
            p.setProximo(null);
            
        }
        primeiro = null;
    }


    public NoListaDupla<T> buscarUltimo() {
        NoListaDupla<T> p = this.primeiro;
    
        if (p == null) {
            return null; 
        }
    
        while (p.getProximo() != null) {
            p = p.getProximo();
        }
    
        return p;
    }



    public ListaDupla<T> clone() {
        ListaDupla<T> clone = new ListaDupla<>();
        
        NoListaDupla<T> p = this.primeiro;
        
        NoListaDupla<T> anterior = null;
        
        while (p != null) {
            NoListaDupla<T> novo = new NoListaDupla<>();
            
            novo.setInfo(p.getInfo());
            
            if (clone.primeiro == null) {
                clone.primeiro = novo;
            } else {
                anterior.setProximo(novo);
                novo.setAnterior(anterior);
            }
            anterior = novo;
            p = p.getProximo();
        }
                return clone;
    }




}