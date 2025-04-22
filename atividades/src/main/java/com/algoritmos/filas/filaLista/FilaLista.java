package com.algoritmos.filas.filaLista;

import java.util.Comparator;

import com.algoritmos.pilhas.pilhaListaEncadeada.PilhaLista;

public class FilaLista<T> implements Fila<T> {
    private ListaEncadeadaGenerica<T> lista;
    

    // ==========================
    // CONSTRUTOR
    // ==========================

    FilaLista() {
        lista = new ListaEncadeadaGenerica<T>();
    }

    // ==========================
    // MÉTODOS DA INTERFACE FILA
    // ==========================

    // Insere elemento no final da fila
    @Override
    public void inserir(T valor) {
        lista.inserirNoFinal(valor);
    }

    // Verifica se a fila está vazia
    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    // Retorna o primeiro elemento da fila sem removê-lo
    @Override
    public T peek() {
        if (estaVazia()) {
            throw new FilaVaziaException();
        }
        return lista.getPrimeiro().getInfo();
    }

    // Retira o primeiro elemento da fila
    @Override
    public T retirar() {
        if (estaVazia()) {
            throw new FilaVaziaException();
        }

        T valor = peek(); // pega o valor antes de remover
        lista.retirar(valor); // remove o primeiro elemento
        return valor;
    }

    // Libera (esvazia) a fila
    @Override
    public void liberar() {
        lista = new ListaEncadeadaGenerica<T>(); // recria uma nova lista vazia
    }

    // ==========================
    // OUTROS MÉTODOS (COMENTADOS)
    // ==========================

    public FilaLista<T> copiar() {
        FilaLista<T> nova = new FilaLista<>();
        NoLista<T> atual = lista.getPrimeiro();
    
        while (atual != null) {
            nova.inserir(atual.getInfo());
            atual = atual.getProximo();
        }
    
        return nova;
    }

    public void inverter() {
        ListaEncadeadaGenerica<T> invertida = lista.criarInvertida();
        this.lista = invertida;
    }

    // ==========================
    // REPRESENTAÇÃO EM TEXTO
    // ==========================

    // Retorna a representação textual da fila (delegando à lista)
    /*@Override
    public String toString() {
        return lista.toString();
    }*/

    // ==========================
    // METODOS NOVOS
    // ==========================
    
    @Override
    public String toString() {
        StringBuilder retorno = new StringBuilder();
        int tamanho = lista.getTamanho(); 
    
        for (int i = 0; i < tamanho; i++) {
            if (i > 0) {
                retorno.append(",");
            }
            retorno.append(lista.getElemento(i));
        }
    
        return retorno.toString();
    }
    
    // Intercala duas filas, preservando a ordem de cada uma
    // Exemplo: Fila1: 1,2,3 e Fila2: A,B,C -> Resultado: 1,A,2,B,3,C
    public FilaLista<T> intercalar(FilaLista<T> outraFila) {
        FilaLista<T> filaIntercalada = new FilaLista<>();
        NoLista<T> no1 = this.lista.getPrimeiro();
        NoLista<T> no2 = outraFila.lista.getPrimeiro();
        
        while (no1 != null || no2 != null) {
            if (no1 != null) {
                filaIntercalada.inserir(no1.getInfo());
                no1 = no1.getProximo();
            }
            if (no2 != null) {
                filaIntercalada.inserir(no2.getInfo());
                no2 = no2.getProximo();
            }
        }
        
        return filaIntercalada;
    }
    
    // Concatena duas filas, ordenando os ELEMENTOS de acordo com o Comparator fornecido
    // Exemplo: Fila1: 1,3,5 e Fila2: 2,4,6 -> Resultado: 1,2,3,4,5,6
    public FilaLista<T> concatenar(FilaLista<T> outraFila, Comparator<T> comparator) {
        FilaLista<T> filaConcatenada = new FilaLista<>();
        NoLista<T> no1 = this.lista.getPrimeiro();
        NoLista<T> no2 = outraFila.lista.getPrimeiro();
        
        while (no1 != null && no2 != null) {
            if (comparator.compare(no1.getInfo(), no2.getInfo()) <= 0) {
                filaConcatenada.inserir(no1.getInfo());
                no1 = no1.getProximo();
            } else {
                filaConcatenada.inserir(no2.getInfo());
                no2 = no2.getProximo();
            }
        }
        
        while (no1 != null) {
            filaConcatenada.inserir(no1.getInfo());
            no1 = no1.getProximo();
        }
        
        while (no2 != null) {
            filaConcatenada.inserir(no2.getInfo());
            no2 = no2.getProximo();
        }
        
        return filaConcatenada;
    }
    
    // Metodo que encolhe a lista para o tamanho exato da fila atual
    public void encolher() {        
        FilaLista<T> novaFila = new FilaLista<>(); 

        NoLista<T> atual = lista.getPrimeiro();
        while (atual != null) {
            novaFila.inserir(atual.getInfo());
            atual = atual.getProximo();
        }        
        this.lista = novaFila.lista;
    }

    // Aumenta a capacidade da fila circular
    public void aumentarCapacidade(int novaCapacidade) {
        if (novaCapacidade <= 0) {
            throw new IllegalArgumentException("A nova capacidade deve ser maior que zero.");
        }
        
        FilaLista<T> novaFila = new FilaLista<>();
        NoLista<T> atual = lista.getPrimeiro();
        
        while (atual != null && novaFila.lista.getTamanho() < novaCapacidade) {
            novaFila.inserir(atual.getInfo());
            atual = atual.getProximo();
        }
        
        this.lista = novaFila.lista;
    }

    // Inverte os elementos da fila usando uma pilha
    public void inverterComPilha() {
        PilhaLista<T> pilha = new PilhaLista<>();
        NoLista<T> atual = lista.getPrimeiro();
        
        while (atual != null) {
            pilha.push(atual.getInfo()); // Assuming 'push' is the correct method name in PilhaLista
            atual = atual.getProximo();
        }
        
        this.liberar(); // Esvazia a fila original
        
        while (!pilha.estaVazia()) {
            this.inserir(pilha.pop());
        }
    }

    // Empilha os elementos da fila (esvazia a fila no processo)
    public PilhaLista<T> empilhar() {
        PilhaLista<T> pilha = new PilhaLista<>();
        NoLista<T> atual = lista.getPrimeiro();
        
        while (atual != null) {
            pilha.push(atual.getInfo());
            atual = atual.getProximo();
        }
        
        this.liberar(); // Esvazia a fila original
        
        return pilha;
    }

    // Retorna se a fila é igual a outra (mesmo tamanho e elementos na mesma ordem)
    public boolean isIgual(FilaLista<T> outraFila) {
        if (this.lista.getTamanho() != outraFila.lista.getTamanho()) {
            return false;
        }
        
        NoLista<T> no1 = this.lista.getPrimeiro();
        NoLista<T> no2 = outraFila.lista.getPrimeiro();
        
        while (no1 != null && no2 != null) {
            if (!no1.getInfo().equals(no2.getInfo())) {
                return false;
            }
            no1 = no1.getProximo();
            no2 = no2.getProximo();
        }
        
        return true;
    }

    // Metodo para substituir o elemento na fila
    public void substituir(T elementoAntigo, T elementoNovo) {
        NoLista<T> atual = lista.getPrimeiro();
        
        while (atual != null) {
            if (atual.getInfo().equals(elementoAntigo)) {
                atual.setInfo(elementoNovo);
                break; // Para de procurar após a substituição
            }
            atual = atual.getProximo();
        }
    }

    // Método para dividir a fila em duas filas (tentando balancear o tamanho)
    public FilaLista<FilaLista<T>> dividir() {
        FilaLista<FilaLista<T>> filasDivididas = new FilaLista<>();
        FilaLista<T> fila1 = new FilaLista<>();
        FilaLista<T> fila2 = new FilaLista<>();
        
        NoLista<T> atual = lista.getPrimeiro();
        int tamanho = lista.getTamanho();
        
        for (int i = 0; i < tamanho; i++) {
            if (i % 2 == 0) {
                fila1.inserir(atual.getInfo());
            } else {
                fila2.inserir(atual.getInfo());
            }
            atual = atual.getProximo();
        }
        
        filasDivididas.inserir(fila1);
        filasDivididas.inserir(fila2);
        
        return filasDivididas;
    }

    // Conta as ocorrencias de um elemento na fila
    public int contarOcorrencias(T elemento) {
        int contador = 0;
        NoLista<T> atual = lista.getPrimeiro();
        
        while (atual != null) {
            if (atual.getInfo().equals(elemento)) {
                contador++;
            }
            atual = atual.getProximo();
        }
        
        return contador;
    }

    // Nova fila apenas com os intervalos especificos
    public FilaLista<T> filtrarIntervalo(int inicio, int fim) {
        FilaLista<T> filaFiltrada = new FilaLista<>();
        NoLista<T> atual = lista.getPrimeiro();
        int index = 0;
        
        while (atual != null) {
            if (index >= inicio && index <= fim) {
                filaFiltrada.inserir(atual.getInfo());
            }
            atual = atual.getProximo();
            index++;
        }
        
        return filaFiltrada;
    }

    // Método para obter o elemento na posição lógica da fila
    public T getElementoPosicao(int posicao) {
        if (posicao < 0 || posicao >= lista.getTamanho()) {
            throw new IndexOutOfBoundsException("Posição inválida: " + posicao);
        }
        
        NoLista<T> atual = lista.getPrimeiro();
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }
        
        return atual.getInfo();
    }

    // Metodo para ver se e palindroma
    public boolean isPalindroma() {
        FilaLista<T> filaInvertida = this.copiar();
        filaInvertida.inverterComPilha(); // Inverte a fila
        
        NoLista<T> atualOriginal = this.lista.getPrimeiro();
        NoLista<T> atualInvertida = filaInvertida.lista.getPrimeiro();
        
        while (atualOriginal != null && atualInvertida != null) {
            if (!atualOriginal.getInfo().equals(atualInvertida.getInfo())) {
                return false; // Não é palíndroma
            }
            atualOriginal = atualOriginal.getProximo();
            atualInvertida = atualInvertida.getProximo();
        }
        
        return true; // É palíndroma
    }    
}