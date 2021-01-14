package com.rowatk.invoicer.services;

import com.rowatk.invoicer.dto.mappers.BuyerMapper;
import com.rowatk.invoicer.dto.mappers.SellerMapper;
import com.rowatk.invoicer.dto.model.SellerDTO;
import com.rowatk.invoicer.models.entity.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SellerService extends EntityService<Seller, SellerDTO> {

    public SellerService() {
        super("seller");
    }

    @Override
    public Optional<SellerDTO> add(SellerDTO dto) {
        SellerDTO result = null;
        if(this.repository.count() < 1) {
            result = mapper.entityToDTO(this.repository.save(mapper.dtoToEntity(dto)));
        }
        return Optional.ofNullable(result);
    }
}
