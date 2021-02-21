package com.rowatk.invoicer.respositories.fake;

import com.rowatk.invoicer.models.company.User;
import com.rowatk.invoicer.respositories.UserRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("fakeUser")
@ConditionalOnProperty(value = "db.mode", havingValue = "fake")
public class FakeUserRepository extends FakeCompanyRepository<User> implements UserRepository {

    @Override
    public Optional<User> findByUsername(String username) {
        return this.DB.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst();
    }
}
