package com.softuni.petselect.repository;

import com.softuni.petselect.model.entity.BlockedIP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BlackListRepository extends JpaRepository<BlockedIP, Long> {

    Optional<BlockedIP> findByIp(String ip);
}
