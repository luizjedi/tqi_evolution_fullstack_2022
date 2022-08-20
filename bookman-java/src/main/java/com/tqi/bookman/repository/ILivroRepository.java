package com.tqi.bookman.repository;

import com.tqi.bookman.entity.LivroEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILivroRepository extends CrudRepository<LivroEntity, Long> {
}
