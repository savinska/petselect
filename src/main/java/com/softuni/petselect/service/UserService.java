package com.softuni.petselect.service;

import com.softuni.petselect.model.dto.binding.EditRolesBindingModel;
import com.softuni.petselect.model.dto.binding.ForgotPasswordBindingModel;
import com.softuni.petselect.model.dto.binding.NewEmailBindingModel;
import com.softuni.petselect.model.dto.binding.ResetPasswordBindingModel;
import com.softuni.petselect.model.dto.service.NewPasswordServiceModel;
import com.softuni.petselect.model.dto.service.UserServiceModel;
import com.softuni.petselect.model.entity.UserEntity;
import org.springframework.security.core.Authentication;

import javax.naming.AuthenticationException;
import java.util.Locale;
import java.util.function.Consumer;

public interface UserService {
    UserEntity findUserByEmail(String email);

    UserEntity signUpUser(UserServiceModel userServiceModel, Locale preferredLocale);

    UserServiceModel findByEmailAndPassword(String email, String password);

    void sendPasswordResetToken(ForgotPasswordBindingModel forgotPasswordBindingModel, Locale preferredLocale);

    boolean isValidPasswordResetToken(String token);

    void changePassword(ResetPasswordBindingModel resetPasswordBindingModel);

    void changePassword(NewPasswordServiceModel newPasswordServiceModel) throws AuthenticationException;

    UserEntity getCurrentUser();

    void editEmail(NewEmailBindingModel newEmailBindingModel) throws AuthenticationException;

    void editRoles(EditRolesBindingModel editRolesBindingModel);

    UserEntity findById(Long id);
}
