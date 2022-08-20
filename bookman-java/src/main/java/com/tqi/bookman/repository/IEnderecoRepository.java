package com.tqi.bookman.repository;

import com.tqi.bookman.entity.EnderecoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEnderecoRepository extends CrudRepository<EnderecoEntity, String> {
}
