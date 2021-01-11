package com.rowatk.invoicer.dto.mappers;

import com.rowatk.invoicer.dto.model.SellerDTO;
import com.rowatk.invoicer.models.entity.Seller;
import org.mapstruct.Mapper;

@Mapper
public interface SellerMapper extends EntityMapper<Seller, SellerDTO> {
}
