package com.rowatk.invoicer.dto.mappers;

import com.rowatk.invoicer.dto.model.EntityDTO;
import com.rowatk.invoicer.dto.requests.CreateEntityRequest;
import com.rowatk.invoicer.models.entity.Entity;

import java.util.List;

public interface EntityMapper<MODEL extends Entity, DTO extends EntityDTO> {

    MODEL dtoToEntity(DTO dto);

    DTO entityToDTO(MODEL entity);

    DTO requestToDTO(CreateEntityRequest request);

    List<DTO> entitiesToDTOs(Iterable<MODEL> entityList);

    List<MODEL> dtosToEntities(Iterable<DTO> dtoList);
}
