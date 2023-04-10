package com.softuni.petselect.model.entity;

import com.softuni.petselect.model.entity.enums.*;
import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "pets")
public class PetEntity extends BaseEntity {
   @ManyToOne
    private PetTypeEntity petType;
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;
   @Column
    private String breed;
    @Enumerated(EnumType.STRING)
    private FurCoatEnum furCoat;
    @Enumerated(EnumType.STRING)
    private TemperEnum temper;
    @Enumerated(EnumType.STRING)
    private LocationEnum location;
    @ManyToOne
    private OrganizationEntity responsibleOrganization;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int ageYears;
    @Column(nullable = false)
    private int ageMonths;
    @Column(nullable = false)
    private Integer sizeInKg;
    @Column
    private LocalDate beenInShelterSince;
    @Column
    private Boolean isToiletTrained;
    @Column
    private Boolean isSpayed;
    @Column
    private Boolean isVaccinated;
    @Column
    private Boolean isChipped;
    @Column
    private Boolean isSpecialNeeds;
    @Column
    private Boolean isInDanger;
    @Column
    private Boolean isGetAlongWithDogs;
    @Column
    private Boolean isGetAlongWithCats;
    @Column
    private Boolean isGetAlongWithKids;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Instant registeredOn;
    @ManyToOne
    private UserEntity author;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<UserEntity> addedToFavouritesBy;

    @OneToMany(mappedBy = "pet", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<PictureEntity> pictures;

    public PetEntity() {
    }

    public PetTypeEntity getPetType() {
        return petType;
    }

    public void setPetType(PetTypeEntity petType) {
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

    public Set<PictureEntity> getPictures() {
        return pictures;
    }

    public void setPictures(Set<PictureEntity> pictures) {
        this.pictures = pictures;
    }
}
