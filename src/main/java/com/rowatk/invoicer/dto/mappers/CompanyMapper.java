package com.rowatk.invoicer.dto.mappers;

import com.rowatk.invoicer.dto.model.CompanyDTO;
import com.rowatk.invoicer.dto.requests.CreateEntityRequest;
import com.rowatk.invoicer.models.company.Company;

import java.util.List;

public interface CompanyMapper<MODEL extends Company, DTO extends CompanyDTO> {

    MODEL dtoToEntity(DTO dto);

    DTO entityToDTO(MODEL entity);

    DTO requestToDTO(CreateEntityRequest request);

    List<DTO> entitiesToDTOs(Iterable<MODEL> entityList);

    List<MODEL> dtosToEntities(Iterable<DTO> dtoList);
}
