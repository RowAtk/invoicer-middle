package com.rowatk.invoicer.dto.mappers;

import com.rowatk.invoicer.dto.model.BuyerDTO;
import com.rowatk.invoicer.models.company.Buyer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BuyerMapper extends CompanyMapper<Buyer, BuyerDTO> {
}
