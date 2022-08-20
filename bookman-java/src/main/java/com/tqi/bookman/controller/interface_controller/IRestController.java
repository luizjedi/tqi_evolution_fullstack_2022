package com.tqi.bookman.controller.interface_controller;

import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.net.MalformedURLException;

public interface IRestController<Entity> {
    ResponseEntity<Iterable<Entity>> buscarTodos();

    ResponseEntity<Entity> buscarPorId(Long id) throws Exception;

    ResponseEntity<Entity> inserir(Entity entity) throws IOException;

    ResponseEntity<Entity> atualizar(Long id, Entity entity) throws Exception;

    ResponseEntity<Entity> deletar(Long id);
}
