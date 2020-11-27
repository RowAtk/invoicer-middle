package com.rowatk.invoicer.services;

import com.rowatk.invoicer.dao.EntityDao;
import com.rowatk.invoicer.dao.EntityRepository;
import com.rowatk.invoicer.dao.postgres.PgBuyerRepository;
import com.rowatk.invoicer.dao.postgres.PgSellerRepository;
import com.rowatk.invoicer.models.entity.Buyer;
import com.rowatk.invoicer.models.entity.Entity;
import com.rowatk.invoicer.models.entity.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class EntityService {

    private final EntityRepository<Buyer, Integer> buyerRepository;
    private final EntityRepository<Seller, Integer> sellerRepository;

    @Autowired
    public EntityService(
            @Qualifier("PgBuyer") EntityRepository<Buyer, Integer> buyerRepository,
            @Qualifier("PgSeller") EntityRepository<Seller, Integer> sellerRepository) {
        this.buyerRepository = buyerRepository;
        this.sellerRepository = sellerRepository;
    }

    // Buyer
    public int addBuyer(Buyer buyer) {
        return this.buyerRepository.save(buyer).getId();
    }

    public Optional<Buyer> getBuyerById(int id) {
        return this.buyerRepository.findById(id);
    }

    public Iterable<Buyer> getBuyers() {
        return this.buyerRepository.findAll();
    }

    public boolean removeBuyer(int id) {
        if(this.buyerRepository.existsById(id)) {
            this.buyerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean updateBuyer(int id, Buyer buyer) {
        if(this.buyerRepository.existsById(id)) {
            buyer.setId(id);
            this.buyerRepository.save(buyer);
            return true;
        }
        return false;
    }
}
