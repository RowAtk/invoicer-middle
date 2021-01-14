package com.rowatk.invoicer.dto.mappers;

import com.rowatk.invoicer.dto.model.EntityDTO;
import com.rowatk.invoicer.dto.requests.CreateEntityRequest;
import com.rowatk.invoicer.models.entity.Entity;

public interface EntityMapper<MODEL extends Entity, DTO extends EntityDTO> {

    MODEL dtoToEntity(DTO dto);

    DTO entityToDTO(MODEL entity);

    DTO requestToDTO(CreateEntityRequest request);

    Iterable<DTO> entitiesToDTOs(Iterable<MODEL> entityList);

    Iterable<MODEL> dtosToEntities(Iterable<DTO> dtoList);
}
