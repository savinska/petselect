package com.softuni.petselect.service;

import com.softuni.petselect.model.entity.RoleEntity;
import com.softuni.petselect.model.entity.enums.RoleTypeEnum;

import java.util.Optional;

public interface RoleService {
    RoleEntity findById(Long id);
}
