package com.rowatk.invoicer.services;

import com.rowatk.invoicer.respositories.EntityRepository;
import com.rowatk.invoicer.models.entity.Buyer;
import com.rowatk.invoicer.models.entity.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EntityService {

    @Autowired
    @Qualifier("fakeBuyer")
    private EntityRepository<Buyer, Long> buyerRepository;

    @Autowired
    @Qualifier("fakeSeller")
    private EntityRepository<Seller, Long> sellerRepository;

    // Buyer
    public Long addBuyer(Buyer buyer) {
        return this.buyerRepository.save(buyer).getId();
    }

    public Optional<Buyer> getBuyerById(Long id) {
        return this.buyerRepository.findById(id);
    }

    public Iterable<Buyer> getBuyers() {
        return this.buyerRepository.findAll();
    }

    public boolean removeBuyer(Long id) {
        if(this.buyerRepository.existsById(id)) {
            this.buyerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean updateBuyer(Long id, Buyer buyer) {
        if(this.buyerRepository.existsById(id)) {
            buyer.setId(id);
            this.buyerRepository.save(buyer);
            return true;
        }
        return false;
    }
}
