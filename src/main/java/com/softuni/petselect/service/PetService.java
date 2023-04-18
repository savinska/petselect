package com.softuni.petselect.service;

import com.softuni.petselect.model.dto.service.PetServiceModel;
import com.softuni.petselect.model.dto.view.PetDetailsViewModel;
import com.softuni.petselect.model.dto.view.PetViewModel;
import com.softuni.petselect.model.entity.PetEntity;
import com.softuni.petselect.model.entity.PetTypeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface PetService {
   Page<PetViewModel> getAllPetsOfType(PetTypeEntity petType, Pageable pageable);

    PetEntity addNewPet(PetServiceModel petServiceModel, MultipartFile imageFile) throws IOException;

    Optional<PetDetailsViewModel> getPetById(Long id);

}
