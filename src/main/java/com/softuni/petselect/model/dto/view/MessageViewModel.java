package com.softuni.petselect.model.dto.view;

import com.softuni.petselect.model.entity.UserEntity;

import java.time.Instant;

public class MessageViewModel {

    private Long id;
    private Instant sentOn;
    private String textContent;
    private UserEntity sender;
    private UserEntity recipient;

    public MessageViewModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getSentOn() {
        return sentOn;
    }

    public void setSentOn(Instant sentOn) {
        this.sentOn = sentOn;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public UserEntity getSender() {
        return sender;
    }

    public void setSender(UserEntity sender) {
        this.sender = sender;
    }

    public UserEntity getRecipient() {
        return recipient;
    }

    public void setRecipient(UserEntity recipient) {
        this.recipient = recipient;
    }
}
