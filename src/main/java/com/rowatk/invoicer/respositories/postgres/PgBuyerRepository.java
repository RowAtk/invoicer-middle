package com.rowatk.invoicer.respositories.postgres;

import com.rowatk.invoicer.respositories.EntityRepository;
import com.rowatk.invoicer.models.entity.Buyer;
import org.springframework.stereotype.Repository;

@Repository("PgBuyer")
public interface PgBuyerRepository extends EntityRepository<Buyer, Long> {

}
