package com.algoritmos.hashmap;

import java.time.LocalDate;

public class Aluno {
    private int matricula;
    private String nome;
    private LocalDate dataNascimento;

    public Aluno(int matricula, String nome, LocalDate dataNascimento) {
        this.matricula = matricula;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
