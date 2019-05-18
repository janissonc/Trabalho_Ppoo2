package com.exemplo.biblioteca.dao;

import com.exemplo.biblioteca.entidades.Livro;
import java.util.ArrayList;
import java.util.List;

public class LivrosDao {

    private static final List<Livro> livros = new ArrayList<>();

    static {
        livros.add(new Livro("Java - Como Programar - 10ª Ed", "Paul Deitel", 968));
        livros.add(new Livro("PHP na Prática", "Júlia Silva  ", 312));
        livros.add(new Livro("Building Reactive Microservices in Java", "Clement Escoffier", 83));
        livros.add(new Livro("Migrating to Microservice Databases", "Edson Yanaga", 72));
    }

    public List<Livro> buscaTodosLivros() {
        return livros;
    }

    public List<Livro> buscaLivroPorTitulo(String titulo) {
        List<Livro> livrosARetornar = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                livrosARetornar.add(livro);
            }
        }
        return livrosARetornar;
    }

    public void adicionaLivro(Livro livro) {
        livros.add(livro);
    }

    public void removeLivro(Livro livro) {
        livros.remove(livro);
    }
}
