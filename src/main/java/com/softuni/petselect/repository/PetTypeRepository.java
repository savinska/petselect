package com.softuni.petselect.repository;

import com.softuni.petselect.model.entity.PetTypeEntity;
import com.softuni.petselect.model.entity.enums.PetTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PetTypeRepository extends JpaRepository<PetTypeEntity, Long> {
    Optional<PetTypeEntity> findByPetType(PetTypeEnum petType);

}
