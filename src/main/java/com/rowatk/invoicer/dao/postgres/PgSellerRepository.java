package com.rowatk.invoicer.dao.postgres;

import com.rowatk.invoicer.dao.EntityRepository;
import com.rowatk.invoicer.models.entity.Entity;
import com.rowatk.invoicer.models.entity.Seller;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("PgSeller")
public interface PgSellerRepository extends EntityRepository<Seller, Integer> {
}
