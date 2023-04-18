package com.softuni.petselect.repository;

import com.softuni.petselect.model.entity.RoleEntity;
import com.softuni.petselect.model.entity.enums.RoleTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findById(Long id);
    Optional<RoleEntity> findByRole(RoleTypeEnum role);
}
