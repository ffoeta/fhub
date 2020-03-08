package com.fexample.fhub.dao.dto.User;

import com.fexample.fhub.facade.interfaces.dto.DtoEntity;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsDto implements DtoEntity<UserDetails> {
    @Override
    public UserDetailsDto fromModel(UserDetails userDetails) {

        return this;
    }

    @Override
    public UserDetails toModel() {
        return null;
    }
}
