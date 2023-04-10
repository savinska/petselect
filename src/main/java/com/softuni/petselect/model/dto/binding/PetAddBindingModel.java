package com.softuni.petselect.model.dto.binding;

import com.softuni.petselect.model.entity.*;
import com.softuni.petselect.model.entity.enums.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

public class PetAddBindingModel {
    @NotNull(message = "Please select pet type!")
    private PetTypeEnum petType;
    @NotNull(message = "Please select gender!")
    private GenderEnum gender;
    private String breed;
    @NotNull(message = "Please select fur coat!")
    private FurCoatEnum furCoat;
    @NotNull(message = "Please select temper!")
    private TemperEnum temper;
    @NotNull(message = "Please select location!")
    private LocationEnum location;

    private OrganizationEntity responsibleOrganization;
    @NotNull(message = "Please enter name!")
    @Size(min= 2, max = 20, message = "Pet name should be between 2 and 20 characters long!")
    private String name;
    @PositiveOrZero(message = "Years should be a positive number or zero!")
    @Max(value = 25, message = "Years should not exceed 25!")
    @Column(nullable = false)
    private int ageYears;
    @PositiveOrZero(message = "Months should be a positive number or zero!")
    @Max(value = 11, message = "Months should not exceed 11!")
    @Column(nullable = false)
    private int ageMonths;
    @Positive(message = "Kilos should be a positive number!")
    @Max(value = 100, message = "Kilos should not exceed 100!")
    private Integer sizeInKg;
    @PastOrPresent(message = "Date should be past or present!")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate beenInShelterSince;

    private Boolean isToiletTrained;

    private Boolean isSpayedNeutered;

    private Boolean isVaccinated;

    private Boolean isChipped;

    private Boolean isSpecialNeeds;

    private Boolean isInDanger;

    private Boolean isGetAlongWithDogs;

    private Boolean isGetAlongWithCats;

    private Boolean isGetAlongWithKids;
    @NotBlank(message = "Please provide short description!")
    private String description;
    @NotNull(message = "Please upload at least one picture!")
    private MultipartFile imageFile;

    public PetAddBindingModel() {
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

    public Boolean getSpayedNeutered() {
        return isSpayedNeutered;
    }

    public void setSpayedNeutered(Boolean spayedNeutered) {
        isSpayedNeutered = spayedNeutered;
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
}
