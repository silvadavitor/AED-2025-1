package com.algoritmos.hashmap;

import java.time.LocalDate;

public class TesteMapaDispersao {
    public static void main(String[] args) {
        
        // TESTE 1
        MapaDispersao<Aluno> mapa1 = new MapaDispersao<>(53);

        Aluno obj1 = new Aluno(12000, "Jean", LocalDate.parse("2000-01-01"));

        mapa1.inserir(obj1.getMatricula(), obj1);

        Aluno resultado = mapa1.busca(obj1.getMatricula());
        System.out.println("Mesmo objeto? " + (resultado == obj1)); // deve imprimir true

        System.out.println();
        // ---------------------------------------------------------------------------------

        // TESTE 2 
        MapaDispersao<Aluno> mapa2 = new MapaDispersao<>(53);

        Aluno aluno1 = new Aluno(12000, "Jean", LocalDate.parse("2000-01-01"));
        Aluno aluno2 = new Aluno(14000, "Pedro", LocalDate.parse("1999-01-20"));
        Aluno aluno3 = new Aluno(12500, "Marta", LocalDate.parse("2001-02-18"));
        Aluno aluno4 = new Aluno(13000, "Lucas", LocalDate.parse("1998-11-25"));

        mapa2.inserir(aluno1.getMatricula(), aluno1);
        mapa2.inserir(aluno2.getMatricula(), aluno2);
        mapa2.inserir(aluno3.getMatricula(), aluno3);
        mapa2.inserir(aluno4.getMatricula(), aluno4);
        
        System.out.println("Jean == busca(12000)? " + (mapa2.busca(12000) == aluno1));
        System.out.println("Pedro == busca(14000)? " + (mapa2.busca(14000) == aluno2));
        System.out.println("Marta == busca(12500)? " + (mapa2.busca(12500) == aluno3));
        System.out.println("Lucas == busca(13000)? " + (mapa2.busca(13000) == aluno4));

        System.out.println();
        // ---------------------------------------------------------------------------------

        // TESTE 3
        MapaDispersao<Aluno> mapa3 = new MapaDispersao<>(53);

        Aluno a1 = new Aluno(12000, "Jean", LocalDate.parse("2000-01-01"));
        Aluno a2 = new Aluno(14000, "Pedro", LocalDate.parse("1999-01-20"));
        Aluno a3 = new Aluno(14226, "Marta", LocalDate.parse("2001-02-18"));
        Aluno a4 = new Aluno(17180, "Lucas", LocalDate.parse("1998-11-25"));

        mapa3.inserir(a1.getMatricula(), a1);
        mapa3.inserir(a2.getMatricula(), a2);
        mapa3.inserir(a3.getMatricula(), a3);
        mapa3.inserir(a4.getMatricula(), a4);
        
        System.out.println("Jean == busca(12000)? " + (mapa3.busca(a1.getMatricula()) == a1));
        System.out.println("Pedro == busca(14000)? " + (mapa3.busca(a2.getMatricula()) == a2));
        System.out.println("Marta == busca(14226)? " + (mapa3.busca(a3.getMatricula()) == a3));
        System.out.println("Lucas == busca(17180)? " + (mapa3.busca(a4.getMatricula()) == a4));

        System.out.println();
    }
}

