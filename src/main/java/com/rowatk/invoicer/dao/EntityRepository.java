package com.rowatk.invoicer.dao;

import com.rowatk.invoicer.models.entity.Buyer;
import com.rowatk.invoicer.models.entity.Entity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface EntityRepository<T extends Entity, Integer> extends CrudRepository<T, Integer> {

    @Override
    <S extends T> S save(S s);

    @Override
    <S extends T> Iterable<S> saveAll(Iterable<S> iterable);

    @Override
    Optional<T> findById(Integer integer);

    @Override
    boolean existsById(Integer integer);

    @Override
    Iterable<T> findAll();

    @Override
    Iterable<T> findAllById(Iterable<Integer> iterable);

    @Override
    long count();

    @Override
    void deleteById(Integer integer);

    @Override
    void delete(T t);

    @Override
    void deleteAll(Iterable<? extends T> iterable);

    @Override
    void deleteAll();
}
