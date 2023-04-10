package com.softuni.petselect.model.entity;

import com.softuni.petselect.model.entity.enums.PetTypeEnum;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

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
