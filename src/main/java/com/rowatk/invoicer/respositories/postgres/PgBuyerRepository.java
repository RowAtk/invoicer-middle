package com.rowatk.invoicer.respositories.postgres;

import com.rowatk.invoicer.respositories.BuyerRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

@Repository("PgBuyer")
@ConditionalOnProperty(value = "db.mode", havingValue = "pg")
public interface PgBuyerRepository extends BuyerRepository {

}
