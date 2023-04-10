package com.softuni.petselect.model.dto.service;

import com.softuni.petselect.model.entity.RoleEntity;
import com.softuni.petselect.model.entity.enums.CountryNameEnum;
import jakarta.persistence.*;

import java.util.Set;

public class UserServiceModel {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private CountryNameEnum country;
    Set<RoleEntity> roles;

    public UserServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public CountryNameEnum getCountry() {
        return country;
    }

    public void setCountry(CountryNameEnum country) {
        this.country = country;
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }
}
