package com.softuni.petselect.model.entity;

import com.softuni.petselect.model.entity.enums.PetTypeEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "pet_types")
public class PetTypeEntity extends BaseEntity{
    @Enumerated(EnumType.STRING)
    private PetTypeEnum petType;


    public PetTypeEntity() {

    }

    public PetTypeEnum getPetType() {
        return petType;
    }

    public void setPetType(PetTypeEnum petType) {
        this.petType = petType;
    }
}
