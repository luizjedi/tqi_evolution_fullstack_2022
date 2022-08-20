package com.tqi.bookman.controller.cadastro;

import com.tqi.bookman.controller.interface_controller.IRestController;
import com.tqi.bookman.entity.LivroEntity;
import com.tqi.bookman.service.interface_service.IRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.logging.Logger;

@RestController
@RequestMapping("livros")
public class CadastroLivroController implements IRestController<LivroEntity> {

    // Services
    @Autowired
    private IRestService<LivroEntity> service;

    // Atributos
    private Logger logger = Logger.getLogger(CadastroLivroController.class.getName());

    // Get
    @GetMapping("/buscarTodos")
    @Override
    public ResponseEntity<Iterable<LivroEntity>> buscarTodos() {
        logger.info("========== Buscando Todos Livros ==========");
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("/buscarPorId/{id}")
    @Override
    public ResponseEntity<LivroEntity> buscarPorId(Long id) throws Exception {
        logger.info("========== Buscando Livro Por Id ==========");
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    // Post
    @PostMapping("/inserir")
    @Override
    public ResponseEntity<LivroEntity> inserir(@RequestBody LivroEntity livro) throws IOException {
        logger.info("========== Inserindo Novo Livro ==========");
        service.inserir(livro);
        return ResponseEntity.ok(livro);
    }

    // Put
    @PutMapping("/atualizar/{id}")
    @Override
    public ResponseEntity<LivroEntity> atualizar(@PathVariable Long id, @RequestBody LivroEntity livro) throws Exception {
        logger.info("========== Atualizando Livro Por Id ==========");
        service.atualizar(id, livro);
        System.out.println(livro.toString());
        return ResponseEntity.ok(livro);
    }

    // Delete
    @DeleteMapping("/deletar/{id}")
    @Override
    public ResponseEntity<LivroEntity> deletar(@PathVariable Long id) {
        logger.info("========== Deletando Livro Por Id ==========");
        service.deletar(id);
        return ResponseEntity.ok().build();
    }
}
