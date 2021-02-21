package com.rowatk.invoicer.respositories.fake;

import com.rowatk.invoicer.models.company.Buyer;
import com.rowatk.invoicer.respositories.BuyerRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@ConditionalOnProperty(value = "db.mode", havingValue = "fake")
public class FakeBuyerRepository extends FakeCompanyRepository<Buyer> implements BuyerRepository {

    @Override
    public List<Buyer> findByUserId(Long userId) {
        return this.DB.stream()
                .filter(buyer -> buyer.getUserId().equals(userId))
                .collect(Collectors.toList());
    }
}
