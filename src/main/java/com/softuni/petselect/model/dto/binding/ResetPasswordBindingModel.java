package com.softuni.petselect.model.dto.binding;

import com.softuni.petselect.model.entity.UserEntity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class ResetPasswordBindingModel {
    @NotEmpty(message = "Password cannot be empty.")
    @Size(min = 2, max = 20, message = "Password should be between 2 and 20 characters long!")
    private String password;

    @NotEmpty(message = "Password cannot be empty.")
    @Size(min = 2, max = 20, message = "Password should be between 2 and 20 characters long!")
    private String confirmPassword;

    @NotEmpty(message = "Recovery token cannot be blank.")
    private String recoveryToken;

    public ResetPasswordBindingModel() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getRecoveryToken() {
        return recoveryToken;
    }

    public void setRecoveryToken(String recoveryToken) {
        this.recoveryToken = recoveryToken;
    }
}
