package com.softuni.petselect.service.impl;

import com.softuni.petselect.model.entity.ResetPasswordTokenEntity;
import com.softuni.petselect.model.entity.UserEntity;
import com.softuni.petselect.repository.TokenRepository;
import com.softuni.petselect.service.TokenService;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.Duration;
import java.time.Instant;
import java.util.Base64;
import java.util.List;
import java.util.Random;

@Service
public class TokenServiceImpl implements TokenService {

    private final TokenRepository tokenRepository;

    public TokenServiceImpl(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Override
    public String getPasswordResetToken(UserEntity user) {
        ResetPasswordTokenEntity passwordResetToken = new ResetPasswordTokenEntity();

        Random r = new SecureRandom();
        byte[] bytes = new byte[20];
        r.nextBytes(bytes);

        String token = Base64.getUrlEncoder().encodeToString(bytes);

        passwordResetToken.setToken(token);
        passwordResetToken.setCreatedOn(Instant.now());
        passwordResetToken.setUser(user);

        this.tokenRepository.save(passwordResetToken);

        return token;
    }

    @Override
    public boolean isValidPasswordResetToken(String token) {

        ResetPasswordTokenEntity resetPasswordToken = tokenRepository
                .findByToken(token)
                .orElse(null);

        if (resetPasswordToken == null) {
            return false;
        } else if (resetPasswordToken.isExpired()) {
            return false;
        } else {
            resetPasswordToken.setExpired(true);

            ResetPasswordTokenEntity expiredToken = tokenRepository.save(resetPasswordToken);

            long elapsedTimeSeconds = Duration.between(Instant.now(), expiredToken.getCreatedOn()).abs().toSeconds();

            return elapsedTimeSeconds <= 1800;
        }

    }


    @Override
    public ResetPasswordTokenEntity getPasswordResetTokenEntityByToken(String recoveryToken) {
        return tokenRepository
                .findByToken(recoveryToken)
                .orElseThrow(() -> new RuntimeException("Token is expired or has already been used!"));
    }


    @Override
    public void removeInvalidPasswordRecoveryTokens() {

        List<ResetPasswordTokenEntity> invalidTokens = tokenRepository
                .getAllByCreatedOnBeforeOrExpiredIsTrue(Instant.now().minusSeconds(1800));

        tokenRepository.deleteAll(invalidTokens);
    }
}
