package com.rowatk.invoicer.services;

import com.rowatk.invoicer.dto.mappers.EntityMapper;
import com.rowatk.invoicer.dto.model.EntityDTO;
import com.rowatk.invoicer.dto.requests.CreateEntityRequest;
import com.rowatk.invoicer.models.entity.Entity;
import com.rowatk.invoicer.respositories.EntityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public abstract class EntityService<T extends Entity, DTO extends EntityDTO> {

    private static final Logger logger = LoggerFactory.getLogger(EntityService.class);

    @Autowired
    protected EntityMapper<T, DTO> mapper;

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
    public Optional<DTO> add(DTO entity) {
        DTO result = null;
        try {
            result = mapper.entityToDTO(this.repository.save(mapper.dtoToEntity(entity)));
        }
        catch(Exception e) {
            logger.error("Error saving " + this.type + ": " + e.getMessage());
        }
        return Optional.ofNullable(result);
    }

    public Optional<DTO> findById(Long id) {
        Optional<T> result = this.repository.findById(id);
        return result.map(entity -> mapper.entityToDTO(entity));
    }

    public Iterable<DTO> findAll() {
        return mapper.entitiesToDTOs(this.repository.findAll());
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

    public boolean updateById(Long id, DTO dto) {
        if(this.repository.existsById(id)) {
            T entity = mapper.dtoToEntity(dto);
            entity.setId(id);
            this.repository.save(entity);
            return true;
        }
        return false;
    }

}
