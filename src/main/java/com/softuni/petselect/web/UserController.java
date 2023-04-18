package com.softuni.petselect.web;

import com.softuni.petselect.model.dto.binding.ForgotPasswordBindingModel;
import com.softuni.petselect.model.dto.binding.NewEmailBindingModel;
import com.softuni.petselect.model.dto.binding.ResetPasswordBindingModel;
import com.softuni.petselect.model.dto.service.NewPasswordServiceModel;
import com.softuni.petselect.model.dto.view.UserViewModel;
import com.softuni.petselect.model.entity.UserEntity;
import com.softuni.petselect.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.security.Principal;
import java.util.Locale;

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

    @ModelAttribute
    public ForgotPasswordBindingModel forgotPasswordBindingModel() {

        return new ForgotPasswordBindingModel();
    }

    @GetMapping("/forgot-password")
    public String signup() {

        return "forgot-password";
    }

    @PostMapping("/forgot-password")
    public String forgotPassword(ForgotPasswordBindingModel forgotPasswordBindingModel, Locale preferredLocale) {

        userService.sendPasswordResetToken(forgotPasswordBindingModel, preferredLocale);

        return "redirect:/login";
    }

    @PostMapping("/reset-password")
    public String resetPassword(@Valid ResetPasswordBindingModel resetPasswordBindingModel, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            throw new RuntimeException(bindingResult.getAllErrors().toString());
        }

        boolean isValidToken = userService.isValidPasswordResetToken(resetPasswordBindingModel.getRecoveryToken());

        if (!isValidToken) {
            throw new RuntimeException("Token is expired or has already been used");
        }

        this.userService.changePassword(resetPasswordBindingModel);

        return "redirect:/login";
    }


    @PostMapping("/change-password")
    public String changePassword(NewPasswordServiceModel newPasswordServiceModel) throws AuthenticationException {

            userService.changePassword(newPasswordServiceModel);

            return "redirect:/profile";
    }

    @PostMapping(path = "/edit-email")
    public String editEmail(NewEmailBindingModel newEmailBindingModel) throws AuthenticationException {

            userService.editEmail(newEmailBindingModel);

            return "redirect:/profile";

    }

}