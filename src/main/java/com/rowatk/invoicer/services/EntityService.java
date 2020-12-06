package com.rowatk.invoicer.services;

import com.rowatk.invoicer.dao.EntityRepository;
import com.rowatk.invoicer.models.entity.Buyer;
import com.rowatk.invoicer.models.entity.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EntityService {

    private final EntityRepository<Buyer, Integer> buyerRepository;
    private final EntityRepository<Seller, Integer> sellerRepository;

    @Autowired
    public EntityService(
            @Qualifier("fakeBuyer") EntityRepository<Buyer, Integer> buyerRepository,
            @Qualifier("fakeSeller") EntityRepository<Seller, Integer> sellerRepository) {
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
