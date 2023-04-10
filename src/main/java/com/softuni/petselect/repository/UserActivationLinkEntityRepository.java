package com.softuni.petselect.repository;

import com.softuni.petselect.model.entity.UserActivationLinkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserActivationLinkEntityRepository extends JpaRepository<UserActivationLinkEntity, Long> {

}
