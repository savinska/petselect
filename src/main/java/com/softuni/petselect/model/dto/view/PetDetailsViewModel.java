package com.softuni.petselect.model.dto.view;

import com.softuni.petselect.model.entity.UserEntity;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Set;

public class PetDetailsViewModel {
    private Long id;
    private String petType;

    private String gender;
    private String breed;

    private String furCoat;

    private String temper;

    private String location;

    private String responsibleOrganization;

    private String name;
    private int ageYears;
    private int ageMonths;

    private Integer sizeInKg;

    private LocalDate beenInShelterSince;

    private Boolean isToiletTrained;

    private Boolean isSpayed;

    private Boolean isVaccinated;

    private Boolean isChipped;

    private Boolean isSpecialNeeds;

    private Boolean isInDanger;

    private Boolean isGetAlongWithDogs;

    private Boolean isGetAlongWithCats;

    private Boolean isGetAlongWithKids;
    private String description;

    private Set<String> pictureUrls;

    private Instant registeredOn;

    private UserEntity author;

    private Set<String> addedToFavouritesBy;


    public PetDetailsViewModel() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getFurCoat() {
        return furCoat;
    }

    public void setFurCoat(String furCoat) {
        this.furCoat = furCoat;
    }

    public String getTemper() {
        return temper;
    }

    public void setTemper(String temper) {
        this.temper = temper;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getResponsibleOrganization() {
        return responsibleOrganization;
    }

    public void setResponsibleOrganization(String responsibleOrganization) {
        this.responsibleOrganization = responsibleOrganization;
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

    public Integer getSizeInKg() {
        return sizeInKg;
    }

    public void setSizeInKg(Integer sizeInKg) {
        this.sizeInKg = sizeInKg;
    }

    public LocalDate getBeenInShelterSince() {
        return beenInShelterSince;
    }

    public void setBeenInShelterSince(LocalDate beenInShelterSince) {
        this.beenInShelterSince = beenInShelterSince;
    }

    public Boolean getToiletTrained() {
        return isToiletTrained;
    }

    public void setToiletTrained(Boolean toiletTrained) {
        isToiletTrained = toiletTrained;
    }

    public Boolean getSpayedNeutered() {
        return isSpayed;
    }

    public void setSpayedNeutered(Boolean spayedNeutered) {
        isSpayed = spayedNeutered;
    }

    public Boolean getVaccinated() {
        return isVaccinated;
    }

    public void setVaccinated(Boolean vaccinated) {
        isVaccinated = vaccinated;
    }

    public Boolean getChipped() {
        return isChipped;
    }

    public void setChipped(Boolean chipped) {
        isChipped = chipped;
    }

    public Boolean getSpecialNeeds() {
        return isSpecialNeeds;
    }

    public void setSpecialNeeds(Boolean specialNeeds) {
        isSpecialNeeds = specialNeeds;
    }

    public Boolean getInDanger() {
        return isInDanger;
    }

    public void setInDanger(Boolean inDanger) {
        isInDanger = inDanger;
    }

    public Boolean getGetAlongWithDogs() {
        return isGetAlongWithDogs;
    }

    public void setGetAlongWithDogs(Boolean getAlongWithDogs) {
        isGetAlongWithDogs = getAlongWithDogs;
    }

    public Boolean getGetAlongWithCats() {
        return isGetAlongWithCats;
    }

    public void setGetAlongWithCats(Boolean getAlongWithCats) {
        isGetAlongWithCats = getAlongWithCats;
    }

    public Boolean getGetAlongWithKids() {
        return isGetAlongWithKids;
    }

    public void setGetAlongWithKids(Boolean getAlongWithKids) {
        isGetAlongWithKids = getAlongWithKids;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<String> getPictureUrls() {
        return pictureUrls;
    }

    public void setPictureUrls(Set<String> pictureUrls) {
        this.pictureUrls = pictureUrls;
    }

    public Instant getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(Instant registeredOn) {
        this.registeredOn = registeredOn;
    }

    public Boolean getSpayed() {
        return isSpayed;
    }

    public void setSpayed(Boolean spayed) {
        isSpayed = spayed;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    public Set<String> getAddedToFavouritesBy() {
        return addedToFavouritesBy;
    }

    public void setAddedToFavouritesBy(Set<String> addedToFavouritesBy) {
        this.addedToFavouritesBy = addedToFavouritesBy;
    }
}
