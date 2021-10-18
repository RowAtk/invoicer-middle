package com.rowatk.invoicer.respositories.postgres;

import com.rowatk.invoicer.respositories.UserRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

@Repository("pgUser")
@ConditionalOnProperty(value = "db.mode", havingValue = "pg")
public interface PgUserRepository extends UserRepository {
}
