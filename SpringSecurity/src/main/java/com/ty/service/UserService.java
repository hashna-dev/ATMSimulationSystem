package com.ty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ty.model.Users;
import com.ty.repo.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo repository;

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    public JWTService service;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public Users register(Users users) {
        users.setPassword(encoder.encode(users.getPassword()));
        return repository.save(users);
    }

    public String verify(Users users) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(users.getUsername(), users.getPassword())
        );

        if (authentication.isAuthenticated()) {
            return "success";
        }
        return "fail";  
    }
}
