package com.softuni.petselect.web;

import com.softuni.petselect.model.dto.binding.UserSignUpBindingModel;
import com.softuni.petselect.model.dto.service.UserServiceModel;
import com.softuni.petselect.service.EmailService;
import com.softuni.petselect.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/users")
public class SignupController {

    private final UserService userService;
    private final ModelMapper modelMapper;
    private final SecurityContextRepository securityContextRepository;


    public SignupController(UserService userService, ModelMapper modelMapper, SecurityContextRepository securityContextRepository) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.securityContextRepository = securityContextRepository;
    }

    @ModelAttribute
    public UserSignUpBindingModel userSignUpBindingModel() {

        return new UserSignUpBindingModel();
    }

    @GetMapping("/signup")
    public String signup() {

        return "signup";
    }


    @PostMapping("/signup")
    public String signupConfirm(@Valid UserSignUpBindingModel userSignUpBindingModel, BindingResult bindingResult, RedirectAttributes redirectAttributes, HttpServletRequest request, HttpServletResponse response) {

        if (bindingResult.hasErrors() || !userSignUpBindingModel.getPassword()
                .equals(userSignUpBindingModel.getConfirmPassword())) {

            redirectAttributes
                    .addFlashAttribute("userSignUpBindingModel", userSignUpBindingModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.userSignUpBindingModel", bindingResult);

            return "redirect:signup";
        }

        boolean isEmailOccupied = userService.findUserByEmail(userSignUpBindingModel.getEmail()) != null;

        if (isEmailOccupied){
            redirectAttributes
                    .addFlashAttribute("userSignUpBindingModel", userSignUpBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userSignUpBindingModel", bindingResult)
                    .addFlashAttribute("isEmailOccupied", true);

            return "redirect:signup";
        }
        UserServiceModel userServiceModel = modelMapper.map(userSignUpBindingModel, UserServiceModel.class);

        userService.signUpUser(userServiceModel, successfulAuth -> {

            SecurityContextHolderStrategy strategy = SecurityContextHolder.getContextHolderStrategy();

            SecurityContext context = strategy.createEmptyContext();
            context.setAuthentication(successfulAuth);

            strategy.setContext(context);

            securityContextRepository.saveContext(context, request, response);
        });

        return "redirect:/successful-signup";
    }

}
