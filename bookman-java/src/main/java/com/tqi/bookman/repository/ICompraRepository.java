package com.tqi.bookman.repository;

import com.tqi.bookman.entity.CompraEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompraRepository extends CrudRepository<CompraEntity, Long> {
}
