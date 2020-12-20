package com.rowatk.invoicer.respositories.postgres;

import com.rowatk.invoicer.respositories.EntityRepository;
import com.rowatk.invoicer.models.entity.Buyer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

@Repository("PgBuyer")
@ConditionalOnProperty(value = "db.mode", havingValue = "pg")
public interface PgBuyerRepository extends EntityRepository<Buyer, Long> {

}
