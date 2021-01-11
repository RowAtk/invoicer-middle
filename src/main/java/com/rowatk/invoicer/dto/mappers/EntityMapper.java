package com.rowatk.invoicer.dto.mappers;

import com.rowatk.invoicer.dto.model.EntityDTO;
import com.rowatk.invoicer.dto.requests.CreateEntityRequest;
import com.rowatk.invoicer.models.entity.Entity;

public interface EntityMapper<MODEL extends Entity, DTO extends EntityDTO> {

    MODEL dtoToBuyer(DTO dto);

    DTO buyerToDTO(MODEL entity);

    DTO requestToDTO(CreateEntityRequest request);

    Iterable<DTO> userListToDTO(Iterable<MODEL> entityList);
}
