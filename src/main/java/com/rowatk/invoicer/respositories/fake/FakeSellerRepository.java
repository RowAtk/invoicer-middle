package com.rowatk.invoicer.respositories.fake;

import com.rowatk.invoicer.models.entity.Seller;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

@Repository("fakeSeller")
@ConditionalOnProperty(value = "db.mode", havingValue = "fake")
public class FakeSellerRepository extends FakeEntityRepository<Seller> {


}
