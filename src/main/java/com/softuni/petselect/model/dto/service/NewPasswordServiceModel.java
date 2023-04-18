package com.softuni.petselect.model.dto.service;

public class NewPasswordServiceModel {

    private String newPassword;
    private String currentPassword;

    public NewPasswordServiceModel() {
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }
}
