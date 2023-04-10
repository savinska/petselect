package com.softuni.petselect.service;

import com.softuni.petselect.model.dto.service.UserServiceModel;
import com.softuni.petselect.model.entity.UserEntity;
import org.springframework.security.core.Authentication;

import java.util.function.Consumer;

public interface UserService {
    UserEntity findUserByEmail(String email);

    UserEntity signUpUser(UserServiceModel userServiceModel, Consumer<Authentication> successfulLoginProcessor);

    UserServiceModel findByEmailAndPassword(String email, String password);

}
