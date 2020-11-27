package com.rowatk.invoicer.dao.postgres;

import com.rowatk.invoicer.models.entity.Seller;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PgSellerRepository2 extends CrudRepository<Seller, Integer> {

    @Override
    <S extends Seller> S save(S s);

    @Override
    Optional<Seller> findById(Integer integer);

    @Override
    Iterable<Seller> findAll();

    @Override
    void deleteById(Integer integer);

    @Override
    void deleteAll();
}
