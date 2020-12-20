package com.rowatk.invoicer.respositories.fake;

import com.rowatk.invoicer.models.entity.Buyer;
import org.springframework.stereotype.Repository;

@Repository("fakeBuyer")
public class FakeBuyerRepository extends FakeEntityRepository<Buyer> {

}
