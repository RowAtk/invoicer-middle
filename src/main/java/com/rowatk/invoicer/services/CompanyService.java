package com.rowatk.invoicer.services;

import com.rowatk.invoicer.dto.mappers.CompanyMapper;
import com.rowatk.invoicer.dto.model.CompanyDTO;
import com.rowatk.invoicer.exception.NoRecordException;
import com.rowatk.invoicer.exception.RecordCreationException;
import com.rowatk.invoicer.models.company.Company;
import com.rowatk.invoicer.respositories.CompanyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public abstract class CompanyService<T extends Company, D extends CompanyDTO> {

    private static final Logger logger = LoggerFactory.getLogger(CompanyService.class);

    @Autowired
    protected CompanyMapper<T, D> mapper;

    @Autowired
    protected CompanyRepository<T, Long> repository;

    private final String type;

    public CompanyService(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    // Entity
    public D add(D entity) {
        D result = null;
        try {
            result = mapper.entityToDTO(this.repository.save(mapper.dtoToEntity(entity)));
        }
        catch(Exception e) {
            logger.error("Error saving " + this.type + ": " + e.getMessage());
            throw new RecordCreationException("Error registering user", e);
        }
        return result;
    }

    public D findById(Long id) {
        Optional<T> result = this.repository.findById(id);
        return mapper.entityToDTO(result.orElseThrow((() -> new NoRecordException(this.type, "id", String.valueOf(id)))));
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
            throw new NoRecordException(this.type, "id", String.valueOf(id));
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
