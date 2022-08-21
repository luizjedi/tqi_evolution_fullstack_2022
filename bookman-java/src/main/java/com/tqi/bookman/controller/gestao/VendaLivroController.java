package com.tqi.bookman.controller.gestao;

import com.tqi.bookman.controller.cadastro.CadastroClienteController;
import com.tqi.bookman.controller.interface_controller.IRestController;
import com.tqi.bookman.entity.VendaEntity;
import com.tqi.bookman.service.interface_service.IRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.logging.Logger;

@RestController
@RequestMapping("vendas")
public class VendaLivroController implements IRestController<VendaEntity> {

    // Controllers
    @Autowired
    private CadastroClienteController cliente;

    // Services
    @Autowired
    private IRestService<VendaEntity> service;

    // Atributos
    private Logger logger = Logger.getLogger(VendaLivroController.class.getName());
    ;

    // Get
    @GetMapping("/buscarTodos")
    @Override
    public ResponseEntity<Iterable<VendaEntity>> buscarTodos() {
        logger.info("========== Buscando Todas Vendas ==========");
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("/buscarPorId/{id}")
    @Override
    public ResponseEntity<VendaEntity> buscarPorId(Long id) throws Exception {
        logger.info("========== Buscando Vendas Por Id ==========");
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    // Post
    @PostMapping("/inserir")
    @Override
    public ResponseEntity<VendaEntity> inserir(@RequestBody VendaEntity venda) throws IOException {
        logger.info("========== Inserindo Nova Venda ==========");
        cliente.inserir(venda.getCliente());
        service.inserir(venda);
        return ResponseEntity.ok(venda);
    }

    // Put
    @PutMapping("/atualizar/{id}")
    @Override
    public ResponseEntity<VendaEntity> atualizar(@PathVariable Long id, @RequestBody VendaEntity venda) throws Exception {
        logger.info("========== Atualizando Compra Por Id ==========");
        service.atualizar(id, venda);
        System.out.println(venda.toString());
        return ResponseEntity.ok(venda);
    }

    // Delete
    @DeleteMapping("/deletar/{id}")
    @Override
    public ResponseEntity<VendaEntity> deletar(@PathVariable Long id) {
        logger.info("========== Deletando Venda Por Id ==========");
        service.deletar(id);
        return ResponseEntity.ok().build();
    }
}
