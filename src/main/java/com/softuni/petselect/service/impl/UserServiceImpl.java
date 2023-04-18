package com.softuni.petselect.service.impl;

import com.softuni.petselect.model.dto.binding.EditRolesBindingModel;
import com.softuni.petselect.model.dto.binding.ForgotPasswordBindingModel;
import com.softuni.petselect.model.dto.binding.NewEmailBindingModel;
import com.softuni.petselect.model.dto.binding.ResetPasswordBindingModel;
import com.softuni.petselect.model.dto.service.NewPasswordServiceModel;
import com.softuni.petselect.model.entity.ResetPasswordTokenEntity;
import com.softuni.petselect.model.entity.enums.EditRolesEnum;
import com.softuni.petselect.model.entity.enums.RoleTypeEnum;
import com.softuni.petselect.repository.TokenRepository;
import com.softuni.petselect.service.exception.ObjectNotFoundException;
import com.softuni.petselect.model.dto.service.UserServiceModel;
import com.softuni.petselect.model.entity.UserEntity;
import com.softuni.petselect.repository.UserRepository;
import com.softuni.petselect.service.EmailService;
import com.softuni.petselect.service.RoleService;
import com.softuni.petselect.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


import javax.naming.AuthenticationException;
import java.security.SecureRandom;
import java.time.Duration;
import java.time.Instant;
import java.util.*;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;
    private final TokenRepository tokenRepository;


    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, RoleService roleService, PasswordEncoder passwordEncoder, EmailService emailService, TokenRepository tokenRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
        this.tokenRepository = tokenRepository;
    }

    @Override
    public UserEntity findUserByEmail(String email) {
        return userRepository
                .findByEmail(email)
                .orElse(null);
    }



    @Override
    public UserEntity signUpUser(UserServiceModel userServiceModel, Locale preferredLocale) {
        UserEntity user = modelMapper.map(userServiceModel, UserEntity.class);
        user.setPassword(passwordEncoder.encode(userServiceModel.getPassword()));
        user.setRoles(new ArrayList<>());
        user.getRoles().add(roleService.findById(3L));
        userRepository.save(user);

        emailService.sendRegistrationEmail(user.getEmail(), user.getFirstName(), preferredLocale);

        return user;
    }

    @Override
    public UserServiceModel findByEmailAndPassword(String email, String password) {

        return userRepository
                .findByEmailAndPassword(email, password)
                .map(userEntity -> modelMapper.map(userEntity, UserServiceModel.class))
                .orElseThrow();
    }


    @Override
    public void sendPasswordResetToken(ForgotPasswordBindingModel forgotPasswordBindingModel, Locale preferredLocale) {

        UserEntity user = userRepository.findByEmail(forgotPasswordBindingModel.getEmail()).orElse(null);

        if (user == null) {
            return;
        }

        String passwordResetToken = getPasswordResetToken(user);
        emailService.sendResetPasswordEmail(user.getEmail(), user.getFirstName(), "http://localhost:8080/users/password-reset/" + passwordResetToken, preferredLocale);
    }

    private String getPasswordResetToken(UserEntity user) {
        ResetPasswordTokenEntity passwordResetToken = new ResetPasswordTokenEntity();

        Random r = new SecureRandom();
        byte[] bytes = new byte[33];
        r.nextBytes(bytes);

        String token = Base64.getUrlEncoder().encodeToString(bytes);

        passwordResetToken.setToken(token);
        passwordResetToken.setCreatedOn(Instant.now());
        passwordResetToken.setUser(user);

        this.tokenRepository.save(passwordResetToken);

        return token;
    }

    @Override
    public boolean isValidPasswordResetToken(String token) {
        ResetPasswordTokenEntity passwordResetToken = tokenRepository.getPasswordResetTokenEntityByToken(token);

        if (passwordResetToken.isExpired()) {
            return false;
        }

        passwordResetToken.setExpired(true);
        ResetPasswordTokenEntity expiredToken = tokenRepository.save(passwordResetToken);

        long elapsedTimeSeconds = Duration.between(Instant.now(), expiredToken.getCreatedOn()).abs().toSeconds();

        return elapsedTimeSeconds <= 1800;
    }

    @Override
    public void changePassword(ResetPasswordBindingModel resetPasswordBindingModel) {
        ResetPasswordTokenEntity tokenEntity = tokenRepository.getPasswordResetTokenEntityByToken(resetPasswordBindingModel.getRecoveryToken());
        UserEntity user = tokenEntity.getUser();

        user.setPassword(passwordEncoder.encode(resetPasswordBindingModel.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void changePassword(NewPasswordServiceModel newPasswordServiceModel) throws AuthenticationException {
        UserEntity currentUser = getCurrentUser();
        if (currentUser == null) {
            throw new AuthenticationException("User does not exist!");
        }


        if (!passwordEncoder.matches(newPasswordServiceModel.getCurrentPassword(), currentUser.getPassword())) {
            throw new AuthenticationException("Invalid password");
        }

        currentUser.setPassword(passwordEncoder.encode(newPasswordServiceModel.getNewPassword()));
        userRepository.save(currentUser);
    }


    @Override
    public UserEntity getCurrentUser() {

        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();

        return userRepository
                .findByEmail(currentUsername)
                .orElse(null);
    }
@Override
    public void editEmail(NewEmailBindingModel newEmailBindingModel) throws AuthenticationException {

        UserEntity currentUser = getCurrentUser();

        if (currentUser == null) {
            throw new AuthenticationException("User does not exist!");
        }

        if (!passwordEncoder.matches(newEmailBindingModel.getCurrentPassword(), currentUser.getPassword())) {
            throw new AuthenticationException("Invalid password!");
        }

        if(userRepository.findByEmail(newEmailBindingModel.getNewEmail()).isPresent()){
            throw new RuntimeException("Email already taken!");
        } else {
            currentUser.setEmail(newEmailBindingModel.getNewEmail());
            this.userRepository.save(currentUser);
        }

    }
@Override
    public void editRoles(EditRolesBindingModel editRolesBindingModel){
        UserEntity userToUpdate = userRepository.findByEmail(editRolesBindingModel.getEmail()).orElse(null);

        if (userToUpdate == null) {
            throw new ObjectNotFoundException("User" + editRolesBindingModel.getEmail() + "does not exist!", getCurrentUser().getId());
        }

        EditRolesEnum editRoles;
        try {
            editRoles = EditRolesEnum.valueOf(editRolesBindingModel.getAction());
        } catch (Exception e) {
            throw new RuntimeException("Invalid action.");
        }


        switch (editRoles) {
            case ADD_MODERATOR -> userToUpdate.addRole(roleService.findRoleByName(RoleTypeEnum.MODERATOR.name()));
            case REMOVE_MODERATOR -> userToUpdate.removeRole(roleService.findRoleByName(RoleTypeEnum.MODERATOR.name()));
            case ADD_ADMIN -> userToUpdate.addRole(roleService.findRoleByName(RoleTypeEnum.ADMIN.name()));
            case REMOVE_ADMIN -> {
                UserEntity currentUser = getCurrentUser();
                if (currentUser.equals(userToUpdate)) {
                    throw new RuntimeException("You cannot remove yourself");
                }
                userToUpdate.removeRole(roleService.findRoleByName(RoleTypeEnum.ADMIN.name()));
            }
        }

        this.userRepository.save(userToUpdate);
    }


    @Override
    public UserEntity findById(Long id) {

        return userRepository
                .findById(id)
                .orElseThrow();
    }
}
