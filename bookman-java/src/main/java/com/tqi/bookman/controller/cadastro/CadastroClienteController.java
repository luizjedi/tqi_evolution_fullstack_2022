package com.tqi.bookman.controller.cadastro;

import com.google.gson.Gson;
import com.tqi.bookman.controller.interface_controller.IRestController;
import com.tqi.bookman.entity.ClienteEntity;
import com.tqi.bookman.entity.EnderecoEntity;
import com.tqi.bookman.service.interface_service.IRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Logger;

@RestController
@RequestMapping("clientes")
public class CadastroClienteController implements IRestController<ClienteEntity> {

    // Services
    @Autowired
    private IRestService<ClienteEntity> service;

    // Atributos
    private Logger logger = Logger.getLogger(CadastroClienteController.class.getName());;

    // Get
    @GetMapping
    @Override
    public ResponseEntity<Iterable<ClienteEntity>> buscarTodos() {
        logger.info("========== Buscando Todos clientes ==========");
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<ClienteEntity> buscarPorId(Long id) throws Exception {
        logger.info("========== Buscando Cliente Por Id ==========");
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    // Post
    @PostMapping(value = "/", produces = "application/json")
    @Override
    public ResponseEntity<ClienteEntity> inserir(@RequestBody ClienteEntity cliente) throws IOException {
        logger.info("========== Inserindo Novo Cliente ==========");
        EnderecoEntity endereco = this.consultarCep(cliente.getCepEndereco().getCep());
        cliente.setCepEndereco(endereco);
        service.inserir(cliente);
        return ResponseEntity.ok(cliente);
    }

    // Put
    @PutMapping("/{id}")
    @Override
    public ResponseEntity<ClienteEntity> atualizar(@PathVariable Long id, @RequestBody ClienteEntity cliente) throws Exception {
        logger.info("========== Atualizando Cliente Por Id ==========");
        EnderecoEntity endereco = this.consultarCep(cliente.getCepEndereco().getCep());
        cliente.setCepEndereco(endereco);
        service.atualizar(id, cliente);
        System.out.println(cliente.toString());
        return ResponseEntity.ok(cliente);
    }

    // Delete
    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<ClienteEntity> deletar(@PathVariable Long id) {
        logger.info("========== Deletando Cliente Por Id ==========");
        service.deletar(id);
        return ResponseEntity.ok().build();
    }

    // Métodos

    /* Início

       Consumindo Api Externa de Endereços "viaCep"*/
    private EnderecoEntity consultarCep(String cep) throws IOException {
        URL url = new URL("https://viacep.com.br/ws/" + cep + "/json/");
        URLConnection connection = url.openConnection();
        InputStream inputStream = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));

        String endereco = "";
        StringBuilder jsonEndereco = new StringBuilder();

        while ((endereco = reader.readLine()) != null) {
            jsonEndereco.append(endereco);
        }
        EnderecoEntity enderecoEntity = new Gson().fromJson(jsonEndereco.toString(), EnderecoEntity.class);

        return enderecoEntity;
    } /* Fim */
}
