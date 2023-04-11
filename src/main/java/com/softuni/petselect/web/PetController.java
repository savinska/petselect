package com.softuni.petselect.web;

import com.softuni.petselect.exception.ObjectNotFoundException;
import com.softuni.petselect.model.dto.binding.PetAddBindingModel;

import com.softuni.petselect.model.dto.service.PetServiceModel;
import com.softuni.petselect.model.dto.view.PetDetailsViewModel;
import com.softuni.petselect.model.dto.view.PetViewModel;
import com.softuni.petselect.model.entity.PetTypeEntity;
import com.softuni.petselect.model.entity.PictureEntity;
import com.softuni.petselect.model.entity.enums.PetTypeEnum;
import com.softuni.petselect.service.PetService;
import com.softuni.petselect.service.PetTypeService;
import com.softuni.petselect.service.UserService;
import jakarta.validation.Valid;
import org.jetbrains.annotations.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.security.Principal;
import java.util.Set;


@Controller
@RequestMapping("/pets")
public class PetController {

    private final PetService petService;
    private final PetTypeService petTypeService;
    private final ModelMapper modelMapper;
    private final UserService userService;

    public PetController(PetService petService, PetTypeService petTypeService, ModelMapper modelMapper, UserService userService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @GetMapping("/all")
    public String viewAllPets() {

        return "pets-all";
    }


    @GetMapping("/cats")
    public String viewAllCats(Model model, @PageableDefault(
                sort = "id",
                size = 3
        ) Pageable pageable) {

        PetTypeEntity cat = petTypeService.findByPetTypeEnum(PetTypeEnum.CAT);

        Page<PetViewModel> allCats = petService.getAllPetsOfType(cat, pageable);


         model.addAttribute("cats", allCats);

        return "pets-cats";

    }

    @GetMapping("/dogs")
    public String viewAllDogs(Model model, @PageableDefault(
            sort = "id",
            size = 3
    ) Pageable pageable) {

        PetTypeEntity dog = petTypeService.findByPetTypeEnum(PetTypeEnum.DOG);

        Page<PetViewModel> allDogs = petService
                .getAllPetsOfType(dog, pageable);

        model.addAttribute("dogs", allDogs);

        return "pets-dogs";

    }

    @GetMapping("/add")
    public String addNewPet() {

        return "pets-add";
    }

    @ModelAttribute
    public PetAddBindingModel petAddBindingModel() {
        return new PetAddBindingModel();
    }

    @PostMapping("/add")
    public String confirmAdd(@Valid PetAddBindingModel petAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes, MultipartFile imageFile, Principal principal) throws IOException {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("petAddBindingModel", petAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.petAddBindingModel", bindingResult);

            return "redirect:add";
        }

        PetServiceModel petServiceModel = modelMapper
                .map(petAddBindingModel, PetServiceModel.class);
        petServiceModel.setAuthor(userService.findUserByEmail(principal.getName()));
        petService.addNewPet(petServiceModel, imageFile);

        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public String petsDetails(@PathVariable("id") Long id, @NotNull Model model){

        var pet = petService.getPetById(id).orElseThrow(() -> new ObjectNotFoundException("Pet with ID " +
                id + " is not found!"));

        model.addAttribute("pet", pet);

        return "pets-details";
    }

}
