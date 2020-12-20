package com.rowatk.invoicer.respositories.fake;

import com.rowatk.invoicer.respositories.EntityRepository;
import com.rowatk.invoicer.models.entity.Entity;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class FakeEntityRepository<T extends Entity> implements EntityRepository<T, Long>{
    List<T> DB = new ArrayList<>();

    private long genId() {
        int size = this.DB.size();
        if(size > 0) {
            return this.DB.get(size-1).getId() + 1;
        }
        return 1;
    }

    @Override
    @NonNull
    public <S extends T> S save(S s) {
        s.setId(this.genId());
        this.DB.add(s);
        return s;
    }

    @Override
    @NonNull
    public Optional<T> findById(@NonNull Long id) {
        return this.DB.stream()
                .filter((ent-> ent.getId() == id))
                .findFirst();
    }

    @Override
    public boolean existsById(@NonNull Long id) {
        return this.DB.stream()
                .anyMatch((ent-> ent.getId() == id));
    }

    @Override
    @NonNull
    public Iterable<T> findAll() {
        return this.DB;
    }

    @Override
    public long count() {
        return this.DB.size();
    }

    @Override
    public void deleteById(@NonNull Long id) {
        this.DB.removeIf(ent -> ent.getId() == id);
    }

    @Override
    public void deleteAll() {
        this.DB.clear();
    }

    @Override
    public <S extends T> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Iterable<T> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public void delete(T t) {

    }

    @Override
    public void deleteAll(Iterable<? extends T> iterable) {

    }
}
