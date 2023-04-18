package com.softuni.petselect.repository;

import com.softuni.petselect.model.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Long> {

    List<MessageEntity> findAllBySender_Id(Long senderId);
    List<MessageEntity> findAllByRecipient_Id(Long recipientId);
}
