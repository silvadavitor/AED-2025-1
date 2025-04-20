package com.algoritmos.filas.FilaLista;

public class FilaLista<T> implements Fila<T> {
    private ListaEncadeadaGenerica<T> lista;


    
    @SuppressWarnings("unchecked")
    FilaLista() {
        lista = new ListaEncadeadaGenerica<T>();
    }

    @Override
    public void inserir(T valor) {

        lista.inserirNoFinal(valor);
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public T peek() {
        if (estaVazia()) {
            throw new FilaVaziaException();
        }
        return lista.getPrimeiro().getInfo();
    }

    @Override
    public T retirar() {

        if (estaVazia()) {
            throw new FilaVaziaException();
        }

        T valor = peek();

        lista.retirar(valor);
        return valor;
    }

    @Override
    public void liberar() {
        lista = new ListaEncadeadaGenerica<T>();
    }


    // public FilaVetor<T> criarFilaConcatenada(FilaVetor<T> f2) {
    //     FilaVetor<T> fila = new FilaVetor<T>(limite + f2.limite);
    //     int index = inicio;

    //     for (int i = 0; i < tamanho; i++) {
    //         if (index == limite) index = 0;
    //         fila.inserir(info[index]);
    //         index++;
    //     }

    //     index = f2.inicio;
    //     for (int i = 0; i < f2.tamanho; i++) {
    //         if (index == f2.limite) index = 0;
    //         fila.inserir(f2.info[index]);
    //         index++;
    //     }
    //     return fila;
    // }

    @Override
    public String toString() {
        
        return lista.toString();

}
}