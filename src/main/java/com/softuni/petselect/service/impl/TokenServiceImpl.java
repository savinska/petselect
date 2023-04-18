package com.softuni.petselect.service.impl;

import com.softuni.petselect.model.entity.ResetPasswordTokenEntity;
import com.softuni.petselect.repository.TokenRepository;
import com.softuni.petselect.service.TokenService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class TokenServiceImpl implements TokenService {

    private final TokenRepository tokenRepository;

    public TokenServiceImpl(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Override
    public void removeInvalidPasswordRecoveryTokens() {

        List<ResetPasswordTokenEntity> invalidTokens = tokenRepository
                .getAllByCreatedOnBeforeOrExpiredIsTrue(Instant.now().minusSeconds(1800));

        tokenRepository.deleteAll(invalidTokens);
    }

}
