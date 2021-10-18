package com.rowatk.invoicer.respositories.postgres;

import com.rowatk.invoicer.respositories.ItemRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

@Repository("pgItem")
@ConditionalOnProperty(value = "db.mode", havingValue = "pg")
public interface PgItemRepository extends ItemRepository {
}
