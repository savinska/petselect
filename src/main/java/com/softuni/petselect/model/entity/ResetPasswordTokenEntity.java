package com.softuni.petselect.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.Instant;


@Entity
@Table(name = "reset_password_tokens")
public class ResetPasswordTokenEntity extends BaseEntity{
    private Instant createdOn;

    private String token;

    private boolean expired = false;
    @ManyToOne(fetch = FetchType.EAGER)
    private UserEntity user;

    public ResetPasswordTokenEntity() {
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
