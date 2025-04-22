package com.algoritmos.pilhas.pilhaListaEncadeada;
import javax.management.RuntimeErrorException;
import com.algoritmos.pilhas.pilhaVetor.PilhaCheiaException;

public class PilhaLista<T> implements Pilha<T> {

    private ListaEncadeadaPilha<T> lista;

    public PilhaLista() {
        lista = new ListaEncadeadaPilha<>();
    }

    @Override
    public void push(T valor) {
        lista.inserir(valor);
    }

    @Override
    public T peek() {
        if (estaVazia()) {
            throw new PilhaVaziaException();
        }
        return lista.getPrimeiro().getInfo();
    }

    @Override
    public T pop() {
        T valor = peek();
        lista.retirar(valor);
        return valor;
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public void liberar() {
        while (!estaVazia()) {
            pop();
        }
    }

    @Override
    public String toString() {
        return lista.toString();
    }

    // ==========================
    // MÉTODOS NOVOS
    // ==========================

    // Método para inverter a pilha
    public void inverter() {
        PilhaLista<T> pilhaAux = new PilhaLista<>();

        // Transferir elementos para a pilha auxiliar
        while (!estaVazia()) {
            pilhaAux.push(pop());
        }

        // Restaurar a pilha original
        while (!pilhaAux.estaVazia()) {
            push(pilhaAux.pop());
        }
    }
    
    // Método para copiar a pilha
    public PilhaLista<T> copia() {
        PilhaLista<T> pilhaCopia = new PilhaLista<>();
        PilhaLista<T> pilhaAux = new PilhaLista<>();

        // Transferir elementos para uma pilha auxiliar para preservar a ordem
        while (!estaVazia()) {
            pilhaAux.push(pop());
        }

        // Copiar elementos para a nova pilha e restaurar a original
        while (!pilhaAux.estaVazia()) {
            T valor = pilhaAux.pop();
            push(valor);
            pilhaCopia.push(valor);
        }

        return pilhaCopia;
    }

    // Método para verificar se um valor pertence à pilha
    public boolean pertence(T valor) {
        PilhaLista<T> pilhaAux = new PilhaLista<>();
        boolean encontrado = false;

        while (!estaVazia()) {
            T elemento = pop();
            if (elemento.equals(valor)) {
                encontrado = true;
            }
            pilhaAux.push(elemento);
        }

        // Restaurar a pilha original
        while (!pilhaAux.estaVazia()) {
            push(pilhaAux.pop());
        }

        return encontrado;
    }

    // Método para retornar o índice de um elemento
    public int indexOf(T valor) {
        PilhaLista<T> pilhaAux = new PilhaLista<>();
        int index = -1;
        int contador = 0;

        while (!estaVazia()) {
            T elemento = pop();
            if (elemento.equals(valor)) {
                index = contador;
            }
            pilhaAux.push(elemento);
            contador++;
        }

        // Restaurar a pilha original
        while (!pilhaAux.estaVazia()) {
            push(pilhaAux.pop());
        }

        return index;
    }

    // Método para comparar duas pilhas
    public boolean isIgual(PilhaLista<T> p) {
        PilhaLista<T> pilhaAux1 = this.copia();
        PilhaLista<T> pilhaAux2 = p.copia();

        while (!pilhaAux1.estaVazia() && !pilhaAux2.estaVazia()) {
            if (!pilhaAux1.pop().equals(pilhaAux2.pop())) {
                return false;
            }
        }

        return pilhaAux1.estaVazia() && pilhaAux2.estaVazia();
    }

    // Método para retornar uma subpilha
    public PilhaLista<T> subPilha(int n) {
        if (n > lista.getTamanho()) {
            throw new IllegalArgumentException("Numero de elementos maior que o tamanho da pilha");
        }

        PilhaLista<T> subPilha = new PilhaLista<>();
        PilhaLista<T> pilhaAux = new PilhaLista<>();

        // Transferir os elementos para uma pilha auxiliar
        for (int i = 0; i < n; i++) {
            pilhaAux.push(pop());
        }

        // Transferir os elementos para a subpilha e restaurar a original
        while (!pilhaAux.estaVazia()) {
            T valor = pilhaAux.pop();
            subPilha.push(valor);
            push(valor);
        }

        return subPilha;
    }
}