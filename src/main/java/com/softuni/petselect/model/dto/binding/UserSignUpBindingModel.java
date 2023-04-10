package com.softuni.petselect.model.dto.binding;

import com.softuni.petselect.model.entity.enums.CountryNameEnum;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserSignUpBindingModel {
    @NotBlank(message = "Please provide first name!")
    @Size(min = 2, max = 20, message = "First name should be between 2 and 20 characters long!")
    private String firstName;
    @NotBlank(message = "Please provide last name!")
    @Size(min = 2, max = 20, message = "Last name should be between 2 and 20 characters long!")
    private String lastName;
    @NotBlank(message = "Please provide Email!")
    @Email
    private String email;
    @NotBlank(message = "Please type Password here!")
    @Size(min = 2, max = 10, message = "Password should be between 2 and 10 characters long!")
    private String password;
    @NotBlank(message = "Please retype Password here!")
    @Size(min = 2, max = 10, message = "Password should be between 2 and 10 characters long and should match the above password!")
    private String confirmPassword;
    @NotNull(message = "Please select a country")
    private CountryNameEnum country;

    public UserSignUpBindingModel() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public CountryNameEnum getCountry() {
        return country;
    }

    public void setCountry(CountryNameEnum country) {
        this.country = country;
    }
}
