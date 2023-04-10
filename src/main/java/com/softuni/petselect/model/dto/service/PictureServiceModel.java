package com.softuni.petselect.model.dto.service;

import com.softuni.petselect.model.entity.PetEntity;
import com.softuni.petselect.model.entity.UserEntity;


public class PictureServiceModel {

    private String title;

    private String url;

    private UserEntity author;

    private PetEntity pet;
    private String publicID;

    public PictureServiceModel() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    public PetEntity getPet() {
        return pet;
    }

    public void setPet(PetEntity pet) {
        this.pet = pet;
    }

    public String getPublicID() {
        return publicID;
    }

    public void setPublicID(String publicID) {
        this.publicID = publicID;
    }
}
