package com.go2climb.go2climbsecurityservice.Service;

import com.go2climb.go2climbsecurityservice.Domain.Entity.UserCredential;
import com.go2climb.go2climbsecurityservice.Domain.Persistence.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImp {
    @Autowired
    private UserCredentialRepository userCredentialRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JWTService jwtService;
    //here passsword wuill be encrypt in db
    public String saveUser(UserCredential credential){
        credential.setPassword(passwordEncoder.encode(credential.getPassword()));
        userCredentialRepository.save(credential);
        return "user saved into the system";
    }
    public String generateToken(String username){
        return jwtService.generateToken(username);
    }
    public void validateToken(String token){
        jwtService.validateToken(token);
    }
}
