package com.rowatk.invoicer.dao.postgres;

import com.rowatk.invoicer.models.entity.Buyer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PgBuyerRepository2 extends CrudRepository<Buyer, Integer> {

    @Override
    <S extends Buyer> S save(S s);

    @Override
    Optional<Buyer> findById(Integer integer);

    @Override
    Iterable<Buyer> findAll();

    @Override
    void deleteById(Integer integer);

    @Override
    void deleteAll();
}
