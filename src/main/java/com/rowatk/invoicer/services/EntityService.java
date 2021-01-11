package com.rowatk.invoicer.services;

import com.rowatk.invoicer.models.entity.Entity;
import com.rowatk.invoicer.respositories.EntityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public abstract class EntityService<T extends Entity> {

    private static final Logger logger = LoggerFactory.getLogger(EntityService.class);

    @Autowired
    protected EntityRepository<T, Long> repository;

    private String type;

    public EntityService(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    // Entity
    public T add(T entity) {
        T result = null;
        try { result = this.repository.save(entity); }
        catch(Exception e) {
            logger.error("Error saving " + this.type + ": " + e.getMessage());
        }
        return result;
    }

    public Optional<T> findById(Long id) {
        return this.repository.findById(id);
    }

    public Iterable<T> findAll() {
        return this.repository.findAll();
    }

    public boolean removeById(Long id) {
        if(this.repository.existsById(id)) {
            this.repository.deleteById(id);
            return true;
        }
        return false;
//        try {
//            logger.info("Attempting to remove entity");
//            this.repository.deleteById(id);
//            logger.info(type + " removed");
//            return true;
//        } catch (Exception e) {
//            logger.error("id non-existent");
//            return false;
//        }
    }

    public boolean updateById(Long id, T entity) {
        if(this.repository.existsById(id)) {
            entity.setId(id);
            this.repository.save(entity);
            return true;
        }
        return false;
    }

}
