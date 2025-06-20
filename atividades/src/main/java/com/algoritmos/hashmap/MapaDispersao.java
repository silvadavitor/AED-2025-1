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
    //-----------------------------------------------------
    // NOVO

    public void ajustarTamanhoSeNecessario() {
        double fatorAtual = calcularFatorCarga();
        int novoTamanho = info.length;
        double FATOR_DESEJADO = 0.75;
        double FATOR_MAXIMO = 0.9;
        double FATOR_MINIMO = 0.5;
        int TAMANHO_MINIMO = 4;

        if (fatorAtual > FATOR_MAXIMO) {
            novoTamanho = info.length * 2;
        } else if (fatorAtual < FATOR_MINIMO && info.length > TAMANHO_MINIMO) {
            novoTamanho = Math.max(TAMANHO_MINIMO, info.length / 2);
        }

        if (novoTamanho != info.length) {
            System.out.println("Realocando: tamanho antigo = " + info.length + ", novo = " + novoTamanho);
            realocarMapa(novoTamanho);
        }
    }


    public void realocarMapa(int tamanhoNovo) {
        ListaEncadeadaGenerica<NoMapa<T>>[] velho = info;
        info = new ListaEncadeadaGenerica[tamanhoNovo];
        totalElementos = 0; // importante: resetar o total para evitar duplicidade na contagem

        for (int i=0; i<velho.length; i++) {
            if (velho[i] != null) {
                NoLista<NoMapa<T>> p = velho[i].getPrimeiro();
                while (p!=null) {
                    NoMapa<T> elemento = p.getInfo();
                    inserir(elemento.getChave(), elemento.getValor());
                    p = p.getProximo();
                }
            }
        }

    }


    public int contarColisoes() {
        int colisoes = 0;
        for (ListaEncadeadaGenerica<NoMapa<T>> lista : info) {
            if (lista != null && lista.tamanho() > 1) {
                colisoes += lista.tamanho() - 1;
            }
        }
        return colisoes;
    }
}