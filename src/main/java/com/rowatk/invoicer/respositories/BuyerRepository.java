package com.rowatk.invoicer.respositories;

import com.rowatk.invoicer.models.company.Buyer;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface BuyerRepository extends CompanyRepository<Buyer, Long> {

    List<Buyer> findByUserId(Long userId);
}
