package com.softuni.petselect.model.dto.binding;

import jakarta.validation.constraints.Email;

public class ForgotPasswordBindingModel {
    @Email
    private String email;

    public ForgotPasswordBindingModel() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
