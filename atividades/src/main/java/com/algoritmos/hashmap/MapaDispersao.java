package com.algoritmos.hashmap;


public class MapaDispersao<T>{
    private ListaEncadeadaGenerica<NoMapa<T>>[] info;
    private int totalElementos;

    public MapaDispersao(int tamanho){
        this.info = new ListaEncadeadaGenerica[tamanho];
    }

    private int calcularHash(int chave){
        return chave % info.length;
    }

    public void inserir(int chave, T valor){
        int indice = calcularHash(chave);

        if (info[indice] == null){
            info[indice] = new ListaEncadeadaGenerica<>();
        }

        NoMapa<T> noMapa = new NoMapa<>();
        noMapa.setChave(chave);
        noMapa.setValor(valor);

        info[indice].inserir(noMapa);
        totalElementos += 1;
    }

    public T busca(int chave){
        int indice = calcularHash(chave);

        if (info[indice] != null){
            NoMapa<T> noMapa = new NoMapa<>(); // crio o nó mapa com a chave para procura na lista
            noMapa.setChave(chave);

            NoLista<NoMapa<T>> no = info[indice].buscar(noMapa); // cria o noLista baseado no noMapa pra buscar
            if (no != null){
                return no.getInfo().getValor(); // se achar retorna o valor
            }
        }
        return null;
    }

    public void remover(int chave){
        int indice = calcularHash(chave);

        if (info[indice] != null){
            NoMapa<T> noMapa = new NoMapa<>();
            noMapa.setChave(chave);
            info[indice].retirar(noMapa);
            totalElementos -= 1;
        }
    }

    public double calcularFatorCarga(){
        return (double) totalElementos / info.length;

    }

}