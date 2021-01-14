package com.rowatk.invoicer.services;

import com.rowatk.invoicer.dto.mappers.BuyerMapper;
import com.rowatk.invoicer.dto.model.BuyerDTO;
import com.rowatk.invoicer.models.entity.Buyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyerService extends EntityService<Buyer, BuyerDTO>{

    public BuyerService() {
        super("buyer");
    }
}
