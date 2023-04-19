package com.softuni.petselect.service;

import com.softuni.petselect.model.dto.binding.EditRolesBindingModel;
import com.softuni.petselect.model.dto.binding.ForgotPasswordBindingModel;
import com.softuni.petselect.model.dto.binding.NewEmailBindingModel;
import com.softuni.petselect.model.dto.binding.ResetPasswordBindingModel;
import com.softuni.petselect.model.dto.service.NewPasswordServiceModel;
import com.softuni.petselect.model.dto.service.UserServiceModel;
import com.softuni.petselect.model.entity.UserEntity;

import javax.naming.AuthenticationException;
import java.util.Locale;

public interface UserService {
    UserEntity findUserByEmail(String email);

    UserEntity signUpUser(UserServiceModel userServiceModel, Locale preferredLocale);

    UserServiceModel findByEmailAndPassword(String email, String password);

    void sendPasswordResetToken(ForgotPasswordBindingModel forgotPasswordBindingModel, Locale preferredLocale);


    void changePassword(ResetPasswordBindingModel resetPasswordBindingModel);

    UserEntity getCurrentUser();

    void editEmail(NewEmailBindingModel newEmailBindingModel);

    void editRoles(EditRolesBindingModel editRolesBindingModel);

    UserEntity findById(Long id);
}
