package com.tqi.bookman.controller.cadastro;

import com.tqi.bookman.entity.LivroEntity;
import com.tqi.bookman.service.interface_service.IRestService;
import com.tqi.bookman.util.GeradorDeLivro;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.util.List;

@ExtendWith(SpringExtension.class)
class CadastroLivroControllerTest {

    // Injeção da Controller testada
    @InjectMocks
    private CadastroLivroController cadastroLivroMock;

    @Mock
    private IRestService<LivroEntity> serviceLivrosMock;

    // Mockando o service
    @BeforeEach
    void listarLivros() {
        List<LivroEntity> livros = List.of(GeradorDeLivro.criarLivroValido());
        BDDMockito.when(serviceLivrosMock.buscarTodos()).thenReturn(livros);
    }

    void buscarLivro() throws Exception {
        LivroEntity livro = GeradorDeLivro.criarLivroValido();
        BDDMockito.when(serviceLivrosMock.buscarPorId(1L)).thenReturn(livro);
    }

    void atualizarLivro() throws Exception {
        LivroEntity livro = GeradorDeLivro.criarLivroAtualizado();
        BDDMockito.when(serviceLivrosMock.buscarPorId(1L)).thenReturn(livro);
    }

    // Testes
    @Test
    @DisplayName("Retorna a lista de livros cadastrados com sucesso")
    void buscarTodos_RetornaListaDeLivrosCadastrados_ComSucesso() {
        String nomeEsperado = GeradorDeLivro.criarLivroValido().getTitulo();

        Iterable<LivroEntity> livrosMock = cadastroLivroMock.buscarTodos().getBody();

        Assertions.assertThat(livrosMock).isNotNull();

        Assertions.assertThat(livrosMock)
                .hasSize(1)
                .isNotEmpty();

        Assertions.assertThat(livrosMock.iterator().next().getTitulo()).isEqualTo(nomeEsperado);
    }

    @Test
    @DisplayName("Retorna o livro cadastrado pelo id com sucesso")
    void buscarPorId_RetornaLivroCadastradoPorId_ComSucesso() throws Exception {
        this.buscarLivro();
        LivroEntity livroEsperado = GeradorDeLivro.criarLivroValido();

        LivroEntity livroMockado = cadastroLivroMock.buscarPorId(1L).getBody();

        Assertions.assertThat(livroMockado).isNotNull();
        Assertions.assertThat(livroMockado.getId()).isEqualTo(livroEsperado.getId());
        Assertions.assertThat(livroMockado.getCaminhoImagemLivro()).isEqualTo(livroEsperado.getCaminhoImagemLivro());
        Assertions.assertThat(livroMockado.getAnoPublicacao()).isEqualTo(livroEsperado.getAnoPublicacao());
        Assertions.assertThat(livroMockado.getTitulo()).isEqualTo(livroEsperado.getTitulo());
        Assertions.assertThat(livroMockado.getAutor()).isEqualTo(livroEsperado.getAutor());
        Assertions.assertThat(livroMockado.getEditora()).isEqualTo(livroEsperado.getEditora());
    }

    @Test
    @DisplayName("Retorna novo livro inserido com sucesso")
    void inserir_RetornaNovoLivroInserido_ComSucesso() throws IOException {
        LivroEntity novoLivro = GeradorDeLivro.criarLivroValido();

        LivroEntity livroInserido = cadastroLivroMock.inserir(GeradorDeLivro.criarNovoLivroValido()).getBody();

        Assertions.assertThat(livroInserido).isNotNull();
        Assertions.assertThat(livroInserido.getCaminhoImagemLivro()).isEqualTo(novoLivro.getCaminhoImagemLivro());
        Assertions.assertThat(livroInserido.getAnoPublicacao()).isEqualTo(novoLivro.getAnoPublicacao());
        Assertions.assertThat(livroInserido.getTitulo()).isEqualTo(novoLivro.getTitulo());
        Assertions.assertThat(livroInserido.getAutor()).isEqualTo(novoLivro.getAutor());
        Assertions.assertThat(livroInserido.getEditora()).isEqualTo(novoLivro.getEditora());
    }

    @Test
    @DisplayName("Retorna o livro atualizado com sucesso")
    void atualizar_RetornaLivroAtualizado_ComSucesso() throws Exception {
        this.atualizarLivro();

        LivroEntity livroEsperado = GeradorDeLivro.criarLivroAtualizado();

        LivroEntity livroAtualizado = cadastroLivroMock.atualizar(1L, GeradorDeLivro.criarLivroAtualizado()).getBody();

        Assertions.assertThat(livroAtualizado).isNotNull();
        Assertions.assertThat(livroAtualizado.getCaminhoImagemLivro()).isEqualTo(livroEsperado.getCaminhoImagemLivro());
        Assertions.assertThat(livroAtualizado.getAnoPublicacao()).isEqualTo(livroEsperado.getAnoPublicacao());
        Assertions.assertThat(livroAtualizado.getTitulo()).isEqualTo(livroEsperado.getTitulo());
        Assertions.assertThat(livroAtualizado.getAutor()).isEqualTo(livroEsperado.getAutor());
        Assertions.assertThat(livroAtualizado.getEditora()).isEqualTo(livroEsperado.getEditora());
    }

    @Test
    @DisplayName("Retorna um livro nulo se deletado com sucesso")
    void deletar_RetornaLivroNuloSeDeletado_ComSucesso() {
        LivroEntity livroBuscado = cadastroLivroMock.buscarTodos().getBody().iterator().next();
        LivroEntity livroDeletado = cadastroLivroMock.deletar(livroBuscado.getId()).getBody();

        Assertions.assertThat(livroDeletado).isNull();
    }
}