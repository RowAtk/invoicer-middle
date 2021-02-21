package com.rowatk.invoicer.respositories;

import com.rowatk.invoicer.models.company.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CompanyRepository<T extends Company, ID extends Number> extends CrudRepository<T, ID> {

}
