package com.softuni.petselect.service.impl;

import com.softuni.petselect.model.dto.service.PetServiceModel;
import com.softuni.petselect.model.dto.view.PetDetailsViewModel;
import com.softuni.petselect.model.dto.view.PetViewModel;
import com.softuni.petselect.model.entity.PetEntity;
import com.softuni.petselect.model.entity.PetTypeEntity;
import com.softuni.petselect.model.entity.PictureEntity;
import com.softuni.petselect.repository.PetRepository;
import com.softuni.petselect.service.*;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.Instant;
import java.util.Collections;
import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;
    private final ModelMapper modelMapper;
    private final PetTypeService petTypeService;
    private final CloudinaryService cloudinaryService;

    public PetServiceImpl(PetRepository petRepository, ModelMapper modelMapper, PetTypeService petTypeService, CloudinaryService cloudinaryService) {
        this.petRepository = petRepository;
        this.modelMapper = modelMapper;
        this.petTypeService = petTypeService;
        this.cloudinaryService = cloudinaryService;
    }


    @Override
    public Page<PetViewModel> getAllPetsOfType(PetTypeEntity petType, Pageable pageable) {

        List<PetViewModel> petsList =  petRepository
                .findAllByPetType(petType)
                .stream()
                .map(petEntity -> {
                    PetViewModel petViewModel = modelMapper
                            .map(petEntity, PetViewModel.class);

                    petViewModel.setThumbnailUrl(petEntity
                            .getPictures()
                            .stream()
                            .findFirst()
                            .map(PictureEntity::getUrl)
                            .orElse("N/A"));

                    return petViewModel;
                })
                .collect(Collectors.toList());

        return new PageImpl<>(petsList);
    }

    @Override
    public PetEntity addNewPet(PetServiceModel petServiceModel, MultipartFile imageFile) throws IOException {

        PetEntity pet = modelMapper.map(petServiceModel, PetEntity.class);

        pet.setPetType(petTypeService.findByPetTypeEnum(petServiceModel.getPetType()));
        pet.setRegisteredOn(Instant.now());

        String pictureUrl = cloudinaryService.uploadImage(imageFile);
        PictureEntity picture = new PictureEntity();
        picture.setPet(pet);
        picture.setAuthor(pet.getAuthor());
        picture.setTitle(imageFile.getOriginalFilename());
        picture.setUrl(pictureUrl);

        pet.setPictures(Collections.singleton(picture));

        petRepository.save(pet);

        return pet;

    }


    @Override
    public Optional<PetDetailsViewModel> getPetById(Long id) {
        return petRepository
                .findById(id)
                .map(petEntity -> modelMapper.map(petEntity, PetDetailsViewModel.class));
    }
}
