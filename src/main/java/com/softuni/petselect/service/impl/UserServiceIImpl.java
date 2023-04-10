package com.softuni.petselect.service.impl;

import com.softuni.petselect.model.dto.service.UserServiceModel;
import com.softuni.petselect.model.entity.UserEntity;
import com.softuni.petselect.repository.UserRepository;
import com.softuni.petselect.service.EmailService;
import com.softuni.petselect.service.RoleService;
import com.softuni.petselect.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.function.Consumer;

@Service
public class UserServiceIImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;
    private final EmailService emailService;


    public UserServiceIImpl(UserRepository userRepository, ModelMapper modelMapper, RoleService roleService, PasswordEncoder passwordEncoder, UserDetailsService userDetailsService, EmailService emailService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public UserEntity findUserByEmail(String email) {
        return userRepository
                .findByEmail(email)
                .orElse(null);
    }



    @Override
    public UserEntity signUpUser(UserServiceModel userServiceModel, Consumer<Authentication> successfulLoginProcessor) {
        UserEntity user = modelMapper.map(userServiceModel, UserEntity.class);
        user.setPassword(passwordEncoder.encode(userServiceModel.getPassword()));
        user.setRoles(new ArrayList<>());
        user.getRoles().add(roleService.findById(3L));
        userRepository.save(user);

        var userDetails = userDetailsService.loadUserByUsername(userServiceModel.getEmail());

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                userDetails,
                userDetails.getPassword(),
                userDetails.getAuthorities()
        );

        successfulLoginProcessor.accept(authentication);

        emailService.sendRegistrationEmail(user.getEmail(),
                user.getFirstName() + " " + user.getLastName());
        return user;
    }

    @Override
    public UserServiceModel findByEmailAndPassword(String email, String password) {

        return userRepository
                .findByEmailAndPassword(email, password)
                .map(userEntity -> modelMapper.map(userEntity, UserServiceModel.class))
                .orElse(null);
    }


}
