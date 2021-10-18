package com.rowatk.invoicer.dto.mappers;

import com.rowatk.invoicer.dto.model.UserDTO;
import com.rowatk.invoicer.models.company.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends CompanyMapper<User, UserDTO> {
}
