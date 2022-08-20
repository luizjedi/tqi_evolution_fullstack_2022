package com.tqi.bookman.service.gestao;

import com.tqi.bookman.entity.CompraEntity;
import com.tqi.bookman.entity.LivroEntity;
import com.tqi.bookman.repository.ICompraRepository;
import com.tqi.bookman.repository.ILivroRepository;
import com.tqi.bookman.service.interface_service.IRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompraLivroService implements IRestService<CompraEntity> {

    // Repositórios
    @Autowired
    private ICompraRepository compraRepository;
    @Autowired
    private ILivroRepository livroRepository;

    // Get
    @Override
    public Iterable<CompraEntity> buscarTodos() {
        return compraRepository.findAll();
    }

    @Override
    public CompraEntity buscarPorId(Long id) throws Exception {
        try {
            Optional<CompraEntity> compra = compraRepository.findById(id);
            return compra.get();
        } catch (Exception e) {
            throw new Exception("Id inexistente!", e.getCause());
        }
    }

    // Post
    @Override
    public void inserir(CompraEntity compra) {
        livroRepository.save(compra.getLivro());
        compraRepository.save(compra);
    }

    // Put
    @Override
    public void atualizar(Long id, CompraEntity compra) throws Exception {
        if (!this.buscarPorId(id).equals(null)) {
            compra.setId(id);
            CompraEntity compraSalva = this.buscarPorId(id);
            LivroEntity livroAtualizado = compraSalva.getLivro();
                livroAtualizado.setId(compraSalva.getLivro().getId());
                livroAtualizado.setTitulo(compra.getLivro().getTitulo());
                livroAtualizado.setAutor(compra.getLivro().getAutor());
                livroAtualizado.setEditora(compra.getLivro().getEditora());
                livroAtualizado.setCaminhoImagemLivro(compra.getLivro().getCaminhoImagemLivro());
                livroAtualizado.setAnoPublicacao(compra.getLivro().getAnoPublicacao());
            livroRepository.save(livroAtualizado);
            compra.setLivro(livroAtualizado);
            compraRepository.save(compra);
        }
    }

    // Delete
    @Override
    public void deletar(Long id) {
        compraRepository.deleteById(id);
    }
}
