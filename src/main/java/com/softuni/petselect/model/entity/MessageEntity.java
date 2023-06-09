package com.softuni.petselect.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class MessageEntity extends BaseEntity{

    @Column(nullable = false)
    private Instant sentOn;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String textContent;
    @ManyToOne
    private UserEntity sender;
    @ManyToOne
    private UserEntity recipient;

    public MessageEntity() {
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
