package com.rowatk.invoicer.services;

import com.rowatk.invoicer.dao.EntityDao;
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

    private final EntityDao buyerDao, sellerDao;

    @Autowired
    public EntityService(@Qualifier("fakeBuyer") EntityDao buyerDao, @Qualifier("fakeSeller") EntityDao sellerDao) {
        this.buyerDao = buyerDao;
        this.sellerDao = sellerDao;
    }

    // Buyer
    public boolean addBuyer(Buyer entity) {
        return this.buyerDao.addEntity(entity);
    }

    public boolean removeBuyer(int id) {
        return this.buyerDao.removeEntityById(id);
    }

    public Optional<Entity> getBuyerById(int id) {
        return this.buyerDao.getEntityById(id);
    }

    public List<Entity> getBuyers() {
        return this.buyerDao.getEntities();
    }

    public boolean updateBuyer(int id, Buyer entity) {
        return this.buyerDao.updateEntity(id, entity);
    }


    // Seller
    public boolean addSeller(Seller entity) {
        return this.sellerDao.addEntity(entity);
    }

    public boolean removeSeller(int id) {
        return this.sellerDao.removeEntityById(id);
    }

    public Optional<Entity> getSellerById(int id) {
        return this.sellerDao.getEntityById(id);
    }

    public List<Entity> getSellers() {
        return this.sellerDao.getEntities();
    }

    public boolean updateSeller(int id, Seller entity) {
        return this.sellerDao.updateEntity(id, entity);
    }
}
