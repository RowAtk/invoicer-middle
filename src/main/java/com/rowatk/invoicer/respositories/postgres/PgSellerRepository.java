package com.rowatk.invoicer.respositories.postgres;

import com.rowatk.invoicer.respositories.EntityRepository;
import com.rowatk.invoicer.models.entity.Seller;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

@Repository("PgSeller")
@ConditionalOnProperty(value = "db.mode", havingValue = "pg")
public interface PgSellerRepository extends EntityRepository<Seller, Long> {
}
