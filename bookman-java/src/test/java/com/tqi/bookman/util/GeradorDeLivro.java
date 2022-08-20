package com.tqi.bookman.util;

import com.tqi.bookman.entity.LivroEntity;

public class GeradorDeLivro {

    public static LivroEntity criarNovoLivroValido() {
        LivroEntity livro = new LivroEntity();
        livro.setTitulo("Hamlet");
        livro.setEditora("Panda Books");
        livro.setAnoPublicacao(1599);
        livro.setAutor("William Shakespeare");
        livro.setCaminhoImagemLivro("hamlet.png");
        return livro;
    }

    public static LivroEntity criarLivroDeletado() {
        LivroEntity livro = new LivroEntity();
        livro.setId(null);
        livro.setTitulo(null);
        livro.setEditora(null);
        livro.setAnoPublicacao(null);
        livro.setAutor(null);
        livro.setCaminhoImagemLivro(null);
        return livro;
    }

    public static LivroEntity criarLivroValido() {
        LivroEntity livro = new LivroEntity();
        livro.setId(1L);
        livro.setTitulo("Hamlet");
        livro.setEditora("Panda Books");
        livro.setAnoPublicacao(1599);
        livro.setAutor("William Shakespeare");
        livro.setCaminhoImagemLivro("hamlet.png");
        return livro;
    }

    public static LivroEntity criarLivroAtualizado() {
        LivroEntity livro = new LivroEntity();
        livro.setId(1L);
        livro.setTitulo("Hamlet atualizado");
        livro.setEditora("Panda Books");
        livro.setAnoPublicacao(1602);
        livro.setAutor("William Shakespeare atualizado");
        livro.setCaminhoImagemLivro("home/hamlet.png");
        return livro;
    }
}