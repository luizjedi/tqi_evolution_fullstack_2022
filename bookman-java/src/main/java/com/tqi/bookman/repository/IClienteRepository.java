package com.tqi.bookman.repository;

import com.tqi.bookman.entity.ClienteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends CrudRepository<ClienteEntity, Long> {
}
