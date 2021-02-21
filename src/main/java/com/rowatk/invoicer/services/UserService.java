package com.rowatk.invoicer.services;

import com.rowatk.invoicer.dto.model.UserDTO;
import com.rowatk.invoicer.exception.NoRecordException;
import com.rowatk.invoicer.models.company.User;
import com.rowatk.invoicer.respositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService extends CompanyService<User, UserDTO> {

    public UserService() {
        super("User");
    }

    public UserDTO findByUsername(String username) {
        Optional<User> user = ((UserRepository) this.repository).findByUsername(username);
        return mapper.entityToDTO(user.orElseThrow(() -> new NoRecordException(this.getType(), "username", username)));
    }
}
