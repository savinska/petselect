package com.softuni.petselect.service;

import com.softuni.petselect.model.entity.ResetPasswordTokenEntity;
import com.softuni.petselect.model.entity.UserEntity;

public interface TokenService {

    String getPasswordResetToken(UserEntity user);

    boolean isValidPasswordResetToken(String token);

    void removeInvalidPasswordRecoveryTokens();

    ResetPasswordTokenEntity getPasswordResetTokenEntityByToken(String recoveryToken);
}
