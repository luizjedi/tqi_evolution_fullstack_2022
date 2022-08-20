package com.tqi.bookman.repository;

import com.tqi.bookman.entity.VendaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVendaRepository extends CrudRepository<VendaEntity, Long> {
}
