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

    public void inserir(int valor) {
        if (tamanho == info.length) {
            redimensionar();
        }
        int i;
        for (i = tamanho; i > 0 && info[i - 1] > valor; i--) { // -1 é para pegar o indice correto do tamanho
            info[i] = info[i - 1]; // Desloca os elementos para a direita. Ex: tamanho = 4 indice 4 recebe valor do indice 3
        }
        info[i] = valor;
        tamanho++;
    }
    /* Exemplo:
    Lista inicial: [10, 20, 30, 40, _, _, _] (tamanho = 4)

    1 Inicializa i = tamanho = 4
    2 Verifica: info[3] (40) > 25, então move 40 → info[4].
    3 Verifica: info[2] (30) > 25, então move 30 → info[3].
    4 Verifica: info[1] (20) < 25, então PARA.
    5 Insere 25 em info[2].

    FINAL: [10, 20, 25, 30, 40, _, _]  // (tamanho = 5)
    */






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
