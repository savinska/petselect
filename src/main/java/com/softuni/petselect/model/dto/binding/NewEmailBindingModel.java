package com.softuni.petselect.model.dto.binding;

import jakarta.validation.constraints.Email;

public class NewEmailBindingModel {
    @Email
    private String newEmail;
    private String currentPassword;

    public NewEmailBindingModel() {
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }
}
