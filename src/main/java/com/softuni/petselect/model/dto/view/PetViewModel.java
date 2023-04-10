package com.softuni.petselect.model.dto.view;

import java.util.HashSet;
import java.util.Set;

public class PetViewModel {

    private Long id;
    private String name;
    private int ageYears;
    private int ageMonths;
    private String gender;
    private String description;
    private String thumbnailUrl;

    public PetViewModel() {
    }

    public PetViewModel(Long id, String name, int ageYears, int ageMonths, String gender, String description, String thumbnailUrl) {
        this.id = id;
        this.name = name;
        this.ageYears = ageYears;
        this.ageMonths = ageMonths;
        this.gender = gender;
        this.description = description;
        this.thumbnailUrl = thumbnailUrl;
    }

    public PetViewModel(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAgeYears() {
        return ageYears;
    }

    public void setAgeYears(int ageYears) {
        this.ageYears = ageYears;
    }

    public int getAgeMonths() {
        return ageMonths;
    }

    public void setAgeMonths(int ageMonths) {
        this.ageMonths = ageMonths;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}