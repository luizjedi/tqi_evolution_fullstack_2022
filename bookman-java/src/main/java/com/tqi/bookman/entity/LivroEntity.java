package com.tqi.bookman.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@Getter
@Entity
public class LivroEntity {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titulo;
    private String autor;
    private String editora;
    private String caminhoImagemLivro;

    private Integer anoPublicacao;

    // Métodos
    @Override
    public String toString() {
        return "=========== Livro ===========" + '\n' +
                "Id: " + id + '\n' +
                "Titulo: " + titulo + '\n' +
                "Autor: " + autor + '\n' +
                "Editora: " + editora + '\n' +
                "Imagem do Livro: " + caminhoImagemLivro + '\n' +
                "Ano de Publicação: " + anoPublicacao + '\n' +
                "=============================";
    }
}
