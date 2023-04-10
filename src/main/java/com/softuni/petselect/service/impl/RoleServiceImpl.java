package com.softuni.petselect.service.impl;

import com.softuni.petselect.model.entity.RoleEntity;
import com.softuni.petselect.repository.RoleRepository;
import com.softuni.petselect.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public RoleEntity findById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }
}
