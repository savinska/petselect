package com.softuni.petselect.repository;

import com.softuni.petselect.model.entity.PetTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetTypeRepository extends JpaRepository<PetTypeEntity, Long> {
}
