package com.tqi.bookman.controller.gestao;

import com.tqi.bookman.controller.interface_controller.IRestController;
import com.tqi.bookman.entity.CompraEntity;
import com.tqi.bookman.service.interface_service.IRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.logging.Logger;

@RestController
@RequestMapping("compras")
public class CompraLivroController implements IRestController<CompraEntity> {

    // Services
    @Autowired
    private IRestService<CompraEntity> service;

    // Atributos
    private Logger logger = Logger.getLogger(CompraLivroController.class.getName());;

    // Get
    @GetMapping("/buscarTodos")
    @Override
    public ResponseEntity<Iterable<CompraEntity>> buscarTodos() {
        logger.info("========== Buscando Todas Compras ==========");
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("/buscarPorId/{id}")
    @Override
    public ResponseEntity<CompraEntity> buscarPorId(Long id) throws Exception {
        logger.info("========== Buscando Compras Por Id ==========");
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    // Post
    @PostMapping("/inserir")
    @Override
    public ResponseEntity<CompraEntity> inserir(@RequestBody CompraEntity compra) throws IOException {
        logger.info("========== Inserindo Nova Compra ==========");
        service.inserir(compra);
        return ResponseEntity.ok(compra);
    }

    // Put
    @PutMapping("/atualizar/{id}")
    @Override
    public ResponseEntity<CompraEntity> atualizar(@PathVariable Long id, @RequestBody CompraEntity compra) throws Exception {
        logger.info("========== Atualizando Compra Por Id ==========");
        service.atualizar(id, compra);
        System.out.println(compra.toString());
        return ResponseEntity.ok(compra);
    }

    // Delete
    @DeleteMapping("/deletar/{id}")
    @Override
    public ResponseEntity<CompraEntity> deletar(@PathVariable Long id) {
        logger.info("========== Deletando Compra Por Id ==========");
        service.deletar(id);
        return ResponseEntity.ok().build();
    }
}
