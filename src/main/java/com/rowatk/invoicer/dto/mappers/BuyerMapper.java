package com.rowatk.invoicer.dto.mappers;

import com.rowatk.invoicer.dto.model.BuyerDTO;
import com.rowatk.invoicer.models.entity.Buyer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BuyerMapper extends EntityMapper<Buyer, BuyerDTO> {
}
