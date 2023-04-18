package com.softuni.petselect.scheduler;

import com.softuni.petselect.service.TokenService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ActivationTokenCleanUpScheduler {

    private final TokenService tokenService;

    public ActivationTokenCleanUpScheduler(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Scheduled(cron = "0 0 0 * * ?")
    public void cleanUpTokens(){
        tokenService.removeInvalidPasswordRecoveryTokens();
    }
}
