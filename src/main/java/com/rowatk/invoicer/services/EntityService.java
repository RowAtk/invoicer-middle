package com.rowatk.invoicer.services;

import com.rowatk.invoicer.dto.mappers.EntityMapper;
import com.rowatk.invoicer.dto.model.EntityDTO;
import com.rowatk.invoicer.dto.requests.CreateEntityRequest;
import com.rowatk.invoicer.exception.NoRecordException;
import com.rowatk.invoicer.models.entity.Entity;
import com.rowatk.invoicer.respositories.EntityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

public abstract class EntityService<T extends Entity, D extends EntityDTO> {

    private static final Logger logger = LoggerFactory.getLogger(EntityService.class);

    @Autowired
    protected EntityMapper<T, D> mapper;

    @Autowired
    protected EntityRepository<T, Long> repository;

    private final String type;

    public EntityService(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    // Entity
    public Optional<D> add(D entity) {
        D result = null;
        try {
            result = mapper.entityToDTO(this.repository.save(mapper.dtoToEntity(entity)));
        }
        catch(Exception e) {
            logger.error("Error saving " + this.type + ": " + e.getMessage());
        }
        return Optional.ofNullable(result);
    }

    public D findById(Long id) {
        Optional<T> result = this.repository.findById(id);
        return mapper.entityToDTO(result.orElseThrow((() -> new NoRecordException(this.type, id))));
    }

    public List<D> findAll() {
        return mapper.entitiesToDTOs(this.repository.findAll());
    }

    public void removeById(Long id) {
        logger.info("Attempting to remove " + type + " with id: " + id);
        if(this.repository.existsById(id)) {

            try {
                this.repository.deleteById(id);
                logger.info(type + " " + id + " removed");
            } catch(Exception ex) {
                logger.error("failed to removed " + type + " with id " + id + ": " + ex.getMessage());
            }

        } else {
            throw new NoRecordException(this.type, id);
        }

    }

    public boolean updateById(Long id, D dto) {
        if(this.repository.existsById(id)) {
            T entity = mapper.dtoToEntity(dto);
            entity.setId(id);
            this.repository.save(entity);
            return true;
        }
        return false;
    }

}
