package com.rowatk.invoicer.dao.postgres;

import com.rowatk.invoicer.dao.EntityRepository;
import com.rowatk.invoicer.models.entity.Buyer;
import com.rowatk.invoicer.models.entity.Entity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("PgBuyer")
public interface PgBuyerRepository extends EntityRepository<Buyer, Integer> {

}
