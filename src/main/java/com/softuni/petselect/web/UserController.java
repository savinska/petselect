package com.softuni.petselect.web;

import com.softuni.petselect.model.dto.view.UserViewModel;
import com.softuni.petselect.model.entity.UserEntity;
import com.softuni.petselect.service.UserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public String profile(Principal principal, Model model){
        UserEntity user = userService.findUserByEmail(principal.getName());
        UserViewModel userViewModel = new UserViewModel(
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getCountry().name()
        );
        model.addAttribute("user", userViewModel);

        return "profile";
    }
}