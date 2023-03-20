package com.softuni.petselect.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "articles")
public class ArticleEntity extends BaseEntity{
    @Column(nullable = false, unique = true)
    private String title;
    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String textContent;
    @OneToMany
    private Set<PictureEntity> pictures;
    @Column(nullable = false)
    private LocalDateTime addedOn;
    @Column(nullable = false)
    private String author;

    public ArticleEntity() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public Set<PictureEntity> getPictures() {
        return pictures;
    }

    public void setPictures(Set<PictureEntity> pictures) {
        this.pictures = pictures;
    }

    public LocalDateTime getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(LocalDateTime addedOn) {
        this.addedOn = addedOn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
