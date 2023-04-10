package com.softuni.petselect.service;

import com.softuni.petselect.model.entity.PetTypeEntity;
import com.softuni.petselect.model.entity.enums.PetTypeEnum;

public interface PetTypeService {
    void initPetTypes();

    PetTypeEntity findByPetTypeEnum(PetTypeEnum petType);
}
