package com.go2climb.go2climbsecurityservice.Domain.Persistence;

import com.go2climb.go2climbsecurityservice.Domain.Entity.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserCredentialRepository extends JpaRepository<UserCredential, Long> {
    Optional<UserCredential> findByName(String username);

}
