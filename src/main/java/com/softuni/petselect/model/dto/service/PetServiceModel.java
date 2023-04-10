package com.softuni.petselect.model.dto.service;

import com.softuni.petselect.model.entity.OrganizationEntity;
import com.softuni.petselect.model.entity.PetTypeEntity;
import com.softuni.petselect.model.entity.PictureEntity;
import com.softuni.petselect.model.entity.UserEntity;
import com.softuni.petselect.model.entity.enums.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

public class PetServiceModel {

    private Long id;
    private PetTypeEnum petType;

    private GenderEnum gender;
    private String breed;

    private FurCoatEnum furCoat;

    private TemperEnum temper;

    private LocationEnum location;

    private OrganizationEntity responsibleOrganization;

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

    private MultipartFile imageFile;

    private Instant registeredOn;

    private UserEntity author;

    private Set<UserEntity> addedToFavouritesBy;

    public PetServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PetTypeEnum getPetType() {
        return petType;
    }

    public void setPetType(PetTypeEnum petType) {
        this.petType = petType;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public FurCoatEnum getFurCoat() {
        return furCoat;
    }

    public void setFurCoat(FurCoatEnum furCoat) {
        this.furCoat = furCoat;
    }

    public TemperEnum getTemper() {
        return temper;
    }

    public void setTemper(TemperEnum temper) {
        this.temper = temper;
    }

    public LocationEnum getLocation() {
        return location;
    }

    public void setLocation(LocationEnum location) {
        this.location = location;
    }

    public OrganizationEntity getResponsibleOrganization() {
        return responsibleOrganization;
    }

    public void setResponsibleOrganization(OrganizationEntity responsibleOrganization) {
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

    public Boolean getSpayed() {
        return isSpayed;
    }

    public void setSpayed(Boolean spayed) {
        isSpayed = spayed;
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

    public MultipartFile getImageFile() {
        return imageFile;
    }

    public void setImageFile(MultipartFile imageFile) {
        this.imageFile = imageFile;
    }

    public Instant getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(Instant registeredOn) {
        this.registeredOn = registeredOn;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    public Set<UserEntity> getAddedToFavouritesBy() {
        return addedToFavouritesBy;
    }

    public void setAddedToFavouritesBy(Set<UserEntity> addedToFavouritesBy) {
        this.addedToFavouritesBy = addedToFavouritesBy;
    }
}
