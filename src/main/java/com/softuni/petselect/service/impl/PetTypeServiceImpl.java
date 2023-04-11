package com.softuni.petselect.service.impl;

import com.softuni.petselect.model.entity.PetTypeEntity;
import com.softuni.petselect.model.entity.enums.PetTypeEnum;
import com.softuni.petselect.repository.PetTypeRepository;
import com.softuni.petselect.service.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class PetTypeServiceImpl implements PetTypeService {

    private  final PetTypeRepository petTypeRepository;

    public PetTypeServiceImpl(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public void initPetTypes() {
        if (petTypeRepository.count() != 0) {
            return;
        }

        Arrays.stream(PetTypeEnum.values()).forEach(petTypeEnum -> {
            PetTypeEntity petType = new PetTypeEntity();
            petType.setPetType(petTypeEnum);

            petTypeRepository.save(petType);
        });
    }

    @Override
    public PetTypeEntity findByPetTypeEnum(PetTypeEnum petType) {
        return petTypeRepository.findByPetType(petType)
                .orElseThrow();
    }
}
