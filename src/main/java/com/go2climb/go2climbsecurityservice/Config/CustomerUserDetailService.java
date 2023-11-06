package com.go2climb.go2climbsecurityservice.Config;

import com.go2climb.go2climbsecurityservice.Domain.Entity.UserCredential;
import com.go2climb.go2climbsecurityservice.Domain.Persistence.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class CustomerUserDetailService implements UserDetailsService {
    @Autowired
    private UserCredentialRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserCredential> credential=repository.findByName(username);
        return credential.map(CustomerUserDetails::new).orElseThrow(()->new UsernameNotFoundException("user not found with the name: "+ username));
    }
}
