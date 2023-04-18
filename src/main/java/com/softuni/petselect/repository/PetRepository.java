package com.softuni.petselect.repository;

import com.softuni.petselect.model.entity.PetEntity;
import com.softuni.petselect.model.entity.PetTypeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<PetEntity, Long> {

    List<PetEntity> findAllByPetType(PetTypeEntity petType);
}
