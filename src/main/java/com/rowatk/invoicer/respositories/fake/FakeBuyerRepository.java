package com.rowatk.invoicer.respositories.fake;

import com.rowatk.invoicer.models.entity.Buyer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

@Repository
@ConditionalOnProperty(value = "db.mode", havingValue = "fake")
public class FakeBuyerRepository extends FakeEntityRepository<Buyer> {

}
