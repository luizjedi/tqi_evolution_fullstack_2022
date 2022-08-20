package com.tqi.bookman.service.cadastro;

import com.tqi.bookman.entity.LivroEntity;
import com.tqi.bookman.repository.ILivroRepository;
import com.tqi.bookman.service.interface_service.IRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CadastroLivroService implements IRestService<LivroEntity> {

    // Repositórios
    @Autowired
    private ILivroRepository repository;

    // Get
    @Override
    public Iterable<LivroEntity> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public LivroEntity buscarPorId(Long id) throws Exception {
        try {
            Optional<LivroEntity> livro = repository.findById(id);
            return livro.get();
        } catch (Exception e) {
            throw new Exception("Id inexistente!", e.getCause());
        }
    }

    // Post
    @Override
    public void inserir(LivroEntity livro) {
        repository.save(livro);
    }

    // Put
    @Override
    public void atualizar(Long id, LivroEntity livro) throws Exception {
        if (!this.buscarPorId(id).equals(null)) {
            livro.setId(id);
            repository.save(livro);
        }
    }

    // Delete
    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
