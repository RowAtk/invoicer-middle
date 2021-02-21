package com.rowatk.invoicer.respositories;

import com.rowatk.invoicer.models.company.User;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface UserRepository extends CompanyRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
