package com.softuni.petselect.repository;

import com.softuni.petselect.model.entity.ResetPasswordTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface TokenRepository extends JpaRepository<ResetPasswordTokenEntity,Long> {

    ResetPasswordTokenEntity getPasswordResetTokenEntityByToken(String token);

    List<ResetPasswordTokenEntity> getAllByCreatedOnBeforeOrExpiredIsTrue(Instant timeInterval);
}
