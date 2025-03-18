package com.algoritmos.listas;

public class ListaEstatica {
    
    private int tamanho;
    private int[] info;

    public ListaEstatica(){
        tamanho = 0;
        info = new int[10];
    }

    private void redimensionar(){
        int[] novo;
        int novotamanho;
        novotamanho = info.length + 10;
        novo = new int[novotamanho];
        for (int i = 0; i < tamanho; i++) {
            novo[i] = info[i];
        }
        info = novo;
    }
    
    public void inserir(int valor){
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

    public int buscar(int valor){
        for (int i = 0; i < tamanho; i++) {
            if (info[i] == valor){
                return i;
            }
        }
        return -1;
    }

    public void retirar(int valor){
        int posicao;
        posicao = buscar(valor);
        if (posicao == -1){
            return;
        }
        for (int i = posicao; i < tamanho - 1; i++) {
            info[i] = info[i + 1];
        }
        tamanho--;
    }

    public void liberar(){
        tamanho = 0;
        info = new int[10];
    }

    public int obterElemento(int posicao){
        if (posicao < 0 || posicao >= tamanho){
            throw new IndexOutOfBoundsException("Índice ultrapassou os limites: " + posicao);
        }
        return info[posicao];
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


}
