package com.rowatk.invoicer.services;

import com.rowatk.invoicer.models.entity.Buyer;
import org.springframework.stereotype.Service;

@Service
public class BuyerService extends EntityService<Buyer>{
    public BuyerService() {
        super("buyer");
    }
}
