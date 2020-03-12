package com.fexample.fhub.facade.security;

import com.fexample.fhub.dao.model.classes.User.User;
import com.fexample.fhub.facade.interfaces.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// import lombok.extern.slf4j.Slf4j;

@Service("JwtUserDetailsService")
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(username + " not found.");
        }
        JwtUser jwtUser = JwtUserFactory.create(user);
        return jwtUser;
    }
}
