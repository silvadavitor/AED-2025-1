package com.algoritmos.listas;

public class ListaGenerica<T> {
    
    private int tamanho;
    private Object[] info;

    public ListaGenerica(){
        tamanho = 0;
        info = new Object[10];
    }

    private void redimensionar(){
        Object[] novo;
        int novotamanho;
        novotamanho = info.length + 10;
        novo = new Object[novotamanho];
        for (int i = 0; i < tamanho; i++) {
            novo[i] = info[i];
        }
        info = novo;
    }
    
    public void inserir(T valor){
        if (tamanho == info.length){
            redimensionar();
        }
        info[tamanho] = valor;
        tamanho++;
    }

    public void exibir(){
        for (int i = 0; i < tamanho; i++) {
            System.out.println(info[i]);
        }
    }

    public int buscar(T valor){
        for (int i = 0; i < tamanho; i++) {
            if (info[i].equals(valor)){
                return i;
            }
        }
        return -1;
    }

    public void retirar(T valor){
        int posicao;
        posicao = buscar(valor);
        if (posicao == -1){
            return;
        }
        for (int i = posicao; i < tamanho - 1; i++) {
            info[i] = info[i + 1];
        }
        tamanho--;
        info[tamanho] = null;
    }

    public void liberar(){
        tamanho = 0;
        info = new Object[10];
    }

    public T obterElemento(int posicao){
        if (posicao < 0 || posicao >= tamanho){
            throw new IndexOutOfBoundsException("Índice ultrapassou os limites: " + posicao);
        }
        return (T) info[posicao];
    }


    public boolean estaVazia(){
        if (tamanho == 0){
            return true;
        }
        return false;
    }

    public int getTamanho(){
        return tamanho;
    }

    public String toString(){
        if (tamanho == 0) {
            return "";
        }
        String str = "";
        for (int i = 0; i < tamanho - 1; i++) {
            str += info[i] + ",";
        }
        str += info[tamanho - 1];
        return str;
    }
    public void inverter() {
        for (int i = 0; i < tamanho / 2; i++) {
            Object temp = info[i];
            info[i] = info[(tamanho - 1) - i]; 
            info[(tamanho - 1) - i] = temp;
        }
    }
    /*
    linha 98: -1 é para pegar o ultimo indice 
    (ex: tem 10 elementos mas o indice começa. Portanto uma lista de tamanho 2, vai de 0 a 1 indices)
    e o -i é para ir diminuindo de traz pra frente

    Ele pega o primeiro valor do primeiro indice, salva numa variavel, substitui o valor do primeiro indice pelo ultimo
    e joga no ultimo oque tava no temp (valor do primeiro indice)
    */ 



    public void retirarElementos(int inicio, int fim) {
        int posicaoInicio = buscar(inicio);
        int posicaoFim = buscar(fim);
    
        if (posicaoInicio == -1 || posicaoFim == -1 || posicaoInicio > posicaoFim) {
            throw new IndexOutOfBoundsException("Índices inválidos");
        }
    
        int qtdRemovidos = posicaoFim - posicaoInicio + 1;
    
        for (int i = posicaoInicio; i < tamanho - qtdRemovidos; i++) {
            info[i] = info[i + qtdRemovidos];
        }
    
        for (int i = tamanho - qtdRemovidos; i < tamanho; i++) {
            info[i] = null;
        }
    
        tamanho -= qtdRemovidos;
    }
    

}



