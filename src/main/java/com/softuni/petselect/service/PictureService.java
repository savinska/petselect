package com.softuni.petselect.service;

import com.softuni.petselect.model.entity.PetEntity;
import com.softuni.petselect.model.entity.PictureEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface PictureService {

    List<PictureEntity> getAllPictureEntitiesByPetId(Long id);

    void savePicture(PictureEntity picture);
}
