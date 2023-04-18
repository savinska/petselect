package com.softuni.petselect.service;

import com.softuni.petselect.model.dto.view.RoleViewModel;
import com.softuni.petselect.model.entity.RoleEntity;

import java.util.List;


public interface RoleService {
    RoleEntity findById(Long id);
    List<RoleViewModel> getAll();
    RoleEntity findRoleByName(String role);
}
