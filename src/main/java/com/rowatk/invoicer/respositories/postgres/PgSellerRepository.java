package com.rowatk.invoicer.respositories.postgres;

import com.rowatk.invoicer.respositories.EntityRepository;
import com.rowatk.invoicer.models.entity.Seller;
import org.springframework.stereotype.Repository;

@Repository("PgSeller")
public interface PgSellerRepository extends EntityRepository<Seller, Long> {
}
