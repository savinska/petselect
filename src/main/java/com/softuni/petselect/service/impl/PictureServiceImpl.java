package com.softuni.petselect.service.impl;

import com.softuni.petselect.model.dto.binding.PetAddBindingModel;
import com.softuni.petselect.model.dto.service.PetServiceModel;
import com.softuni.petselect.model.entity.PetEntity;
import com.softuni.petselect.model.entity.PictureEntity;
import com.softuni.petselect.repository.PictureRepository;
import com.softuni.petselect.service.CloudinaryService;
import com.softuni.petselect.service.PetService;
import com.softuni.petselect.service.PictureService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PictureServiceImpl implements PictureService {
    private final PictureRepository pictureRepository;

    private final PetService petService;
    private final ModelMapper modelMapper;

    public PictureServiceImpl(PictureRepository pictureRepository, PetService petService, ModelMapper modelMapper) {
        this.pictureRepository = pictureRepository;
        this.petService = petService;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PictureEntity> getAllPictureEntitiesByPetId(Long id) {
        return null;
    }

    @Override
    public void savePicture(PictureEntity picture) {
        pictureRepository.save(picture);
    }
}
