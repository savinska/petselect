package com.softuni.petselect.repository;

import com.softuni.petselect.model.entity.PetEntity;
 import com.softuni.petselect.model.entity.PictureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PictureRepository extends JpaRepository<PictureEntity, Long> {

    List<PictureEntity> findAllByPet(PetEntity pet);
}
