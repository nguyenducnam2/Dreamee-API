package org.dreameeapi.repository;

import org.dreameeapi.entity.User;
import org.dreameeapi.registration.token.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Integer> {

    Optional<VerificationToken> findByToken(String token);
}
