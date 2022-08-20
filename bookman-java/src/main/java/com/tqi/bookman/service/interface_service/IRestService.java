package com.tqi.bookman.service.interface_service;

import java.io.IOException;

public interface IRestService<Entity> {
    Iterable<Entity> buscarTodos();

    Entity buscarPorId(Long id) throws Exception;

    void inserir(Entity entity) throws IOException;

    void atualizar(Long id, Entity entity) throws Exception;

    void deletar(Long id);
}
