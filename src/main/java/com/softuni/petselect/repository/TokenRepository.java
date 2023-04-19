package com.softuni.petselect.repository;

import com.softuni.petselect.model.entity.ResetPasswordTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<ResetPasswordTokenEntity,Long> {

    Optional<ResetPasswordTokenEntity> findByToken(String token);

    List<ResetPasswordTokenEntity> getAllByCreatedOnBeforeOrExpiredIsTrue(Instant timeInterval);
}
