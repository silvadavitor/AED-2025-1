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


    public ListaDupla<T> exibirOrdemInversa(){
        ListaDupla<T> invertida = new ListaDupla<T>();
        NoListaDupla<T> p = this.primeiro;
        
        while (p != null){
            invertida.inserir(p.getInfo());
            p = p.getProximo();
        }
        return invertida;
    }


    public void liberar(){
        NoListaDupla<T> p = this.primeiro;

        while (p != null){
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
            p = p.getProximo();
        }
    }





    public ListaDupla<T> clone() {
        // Cria uma nova lista vazia que armazenará a cópia
        ListaDupla<T> clone = new ListaDupla<>();
        
        // Ponteiro para percorrer a lista original
        NoListaDupla<T> p = this.primeiro;
        
        // Variável para armazenar o último nó inserido na lista clonada
        NoListaDupla<T> anterior = null;
        
        // Percorre toda a lista original
        while (p != null) {
            // Cria um novo nó para a lista clonada
            NoListaDupla<T> novo = new NoListaDupla<>();
            
            // Copia o valor do nó original para o novo nó
            novo.setInfo(p.getInfo());
            
            // Se a lista clonada ainda estiver vazia, define o primeiro nó
            if (clone.primeiro == null) {
                clone.primeiro = novo;
            } else {
                // Caso contrário, ajusta os ponteiros do nó anterior
                anterior.setProximo(novo);
                novo.setAnterior(anterior);
            }
            
            // Atualiza o nó anterior para o novo nó criado
            anterior = novo;
            
            // Move o ponteiro para o próximo nó da lista original
            p = p.getProximo();
        }
        
        // Retorna a nova lista clonada
        return clone;
    }




}