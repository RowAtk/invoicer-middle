package com.rowatk.invoicer.respositories;

import com.rowatk.invoicer.models.entity.Entity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface EntityRepository<T extends Entity, ID extends Number> extends CrudRepository<T, ID> {

}
