package com.softuni.petselect.service.impl;

import com.softuni.petselect.model.dto.view.RoleViewModel;
import com.softuni.petselect.model.entity.RoleEntity;
import com.softuni.petselect.model.entity.enums.RoleTypeEnum;
import com.softuni.petselect.repository.RoleRepository;
import com.softuni.petselect.service.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.NoSuchElementException;

@Order(0)
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    public RoleServiceImpl(RoleRepository roleRepository, ModelMapper modelMapper) {
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public RoleEntity findById(Long id) {
        return roleRepository.findById(id).orElseThrow();
    }

    @Override
    public List<RoleViewModel> getAll() {
        return this.roleRepository.findAll()
                .stream()
                .map(r -> modelMapper.map(r, RoleViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public RoleEntity findRoleByName(String role) {
        return roleRepository
                .findByRole(RoleTypeEnum.valueOf(role))
                .orElseThrow(NoSuchElementException::new);
    }
}
