package com.rowatk.invoicer.services;

import com.rowatk.invoicer.models.entity.Seller;
import org.springframework.stereotype.Service;

@Service
public class SellerService extends EntityService<Seller> {

    public SellerService() {
        super("seller");
    }

    @Override
    public Seller add(Seller entity) {
        if(this.repository.count() < 1) {
            return this.repository.save(entity);
        }
        return null;
    }
}
